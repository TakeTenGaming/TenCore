package taketengaming.tencore.machine;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.energy.CapabilityEnergy;
import taketengaming.datmod.machine.generator.TileEntityGenerator;
import taketengaming.tencore.energy.EnergyStorage;
import taketengaming.tencore.tileentity.TileEntityBase;

import java.util.HashMap;

/**
 * Created by Acid on 3/12/2017.
 */
public class PowerSender
{
	private HashMap< BlockPos, TileEntityBase > receivers = new HashMap<> ();

	private void getReceivers ( TileEntityBase tileEntity, BlockPos blockPos )
	{
		if ( !this.receivers.isEmpty () )
		{
			this.receivers.clear ();
		}

		for ( EnumFacing facing : EnumFacing.values () )
		{
			BlockPos pos = blockPos.offset ( facing );
			TileEntity tileEntity1 = tileEntity.getWorld ().getTileEntity ( pos );

			if ( tileEntity1 != null && tileEntity1 instanceof TileEntityBase && !( tileEntity1 instanceof TileEntityGenerator ) )
			{
				this.receivers.put ( tileEntity1.getPos (), ( TileEntityBase ) tileEntity1 );
			}
		}
	}

	public void process ( TileEntityBase tileEntity )
	{
		EnergyStorage tileEnergy = ( EnergyStorage ) tileEntity.getCapability ( CapabilityEnergy.ENERGY, null );
		if ( tileEnergy == null )
		{
			return;
		}

		if ( !tileEnergy.canExtract () )
		{
			return;
		}

		if ( this.receivers.isEmpty () )
		{
			this.getReceivers ( tileEntity, tileEntity.getPos () );
		}

		for ( TileEntityBase receivingTile : this.receivers.values () )
		{
			if ( tileEntity.getWorld ().getTileEntity ( receivingTile.getPos () ) == null )
			{
				this.getReceivers ( tileEntity, tileEntity.getPos () );
				continue;
			}

			EnergyStorage receivingTileEnergy = ( EnergyStorage ) receivingTile.getCapability ( CapabilityEnergy.ENERGY, null );
			if ( receivingTileEnergy == null )
			{
				continue;
			}

			int energyExtract = receivingTileEnergy.getMaxExtract ();
			int energyReceive = receivingTileEnergy.getMaxReceive ();
			int energyTransfer;
			if ( energyExtract > energyReceive )
			{
				energyTransfer = energyExtract;
			}
			else
			{
				energyTransfer = energyReceive;
			}

			if ( tileEnergy.getEnergyStored () == 0 || !tileEnergy.canExtract () || !receivingTileEnergy.canReceive ( energyTransfer ) )
			{
				continue;
			}

			tileEnergy.extractEnergy ( energyTransfer, false );
			receivingTileEnergy.receiveEnergy ( energyTransfer, false );
		}
	}
}
