package taketengaming.tencore.energy;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.energy.CapabilityEnergy;
import taketengaming.tencore.tileentity.TileEntityBase;
import taketengaming.tencore.util.Energy;

/**
 * Created by Acid on 2/26/2017.
 */
public class EnergyStorage extends net.minecraftforge.energy.EnergyStorage
{
	public EnergyStorage ()
	{
		super ( Energy.CAPACITY, Energy.MAX_RECEIVE, Energy.MAX_SEND );
	}

	public boolean canReceive ( int amount )
	{
		if ( this.canReceive () )
		{
			if ( ( this.energy + amount ) <= this.getMaxEnergyStored () )
			{
				return true;
			}
		}

		return false;
	}

	@Override
	public boolean canReceive ()
	{
		if ( this.maxReceive > 0 )
		{
			if ( ( this.energy + this.maxReceive ) <= this.capacity )
			{
				return true;
			}
		}

		return false;
	}

	public boolean canReceiveAmountFrom ( int amount, TileEntityBase source )
	{
		if ( this.canReceive () )
		{
			if ( source.hasCapability ( CapabilityEnergy.ENERGY, null ) )
			{
				EnergyStorage power = ( EnergyStorage ) source.getCapability ( CapabilityEnergy.ENERGY, null );

				if ( power != null && power.canExtract () && power.getEnergyStored () >= amount )
				{
					return true;
				}
			}
		}

		return false;
	}

	public boolean canSendAmountTo ( int amount, TileEntityBase source )
	{
		if ( this.canExtract () )
		{
			if ( source.hasCapability ( CapabilityEnergy.ENERGY, null ) )
			{
				EnergyStorage power = ( EnergyStorage ) source.getCapability ( CapabilityEnergy.ENERGY, null );

				if ( power != null && power.canReceive () && ( power.getEnergyStored () + amount ) < power.getMaxEnergyStored () )
				{
					return true;
				}
			}
		}

		return false;
	}

	public int getMaxExtract ()
	{
		return this.maxExtract;
	}

	public int getMaxReceive ()
	{
		return this.maxReceive;
	}

	public EnergyStorage readFromNBT ( NBTTagCompound nbt )
	{
		if ( nbt.hasKey ( "energy" ) )
		{
			this.energy = nbt.getInteger ( "energy" );

			if ( this.energy > this.capacity )
			{
				this.energy = this.capacity;
			}
		}

		return this;
	}

	@Override
	public int receiveEnergy ( int maxReceive, boolean simulate )
	{
		if ( !this.canReceive () )
		{
			return 0;
		}

		int energyReceived = 0;
		if ( maxReceive > this.maxReceive )
		{
			int difference = maxReceive - this.maxReceive;
			int differenceRemainder = difference;
			int runRequirements = ( int ) Math.ceil ( ( difference / this.maxReceive ) );

			for ( int i = 0; i <= runRequirements; i++ )
			{
				if ( differenceRemainder == 0 )
				{
					return maxReceive;
				}

				int amountReceived = this.receiveEnergy ( difference, false );
				if ( amountReceived > 0 )
				{
					differenceRemainder = ( differenceRemainder - amountReceived );
				}
			}
		}
		else
		{
			energyReceived = Math.min ( this.capacity - this.energy, Math.min ( this.maxReceive, maxReceive ) );

			if ( !simulate )
			{
				this.energy += energyReceived;
			}
		}

		return energyReceived;
	}

	public void setEnergyStored ( int energy )
	{
		if ( energy > this.capacity )
		{
			energy = this.capacity;
		}

		this.energy = energy;
	}

	public NBTTagCompound writeToNBT ( NBTTagCompound nbt )
	{
		nbt.setInteger ( "energy", this.energy );
		return nbt;
	}
}
