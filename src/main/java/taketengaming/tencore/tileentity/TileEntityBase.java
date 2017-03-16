package taketengaming.tencore.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import taketengaming.datmod.machine.generator.TileEntityGenerator;
import taketengaming.datmod.machine.powerbank.TileEntityPowerBank;
import taketengaming.tencore.energy.EnergyStorage;
import taketengaming.tencore.recipes.FurnaceRecipes;
import taketengaming.tencore.util.Machine;

import java.util.ArrayList;

/**
 * Created by Acid on 2/1/2017.
 */
public class TileEntityBase extends TileEntity
{
	public static final int SIZE = 3;

	public EnergyStorage energyStorageHandler = new EnergyStorage ();
	public ItemStackHandler itemStackHandler = new ItemStackHandler ( SIZE )
	{
		@Override
		public ItemStack insertItem ( int slot, ItemStack stack, boolean simulate )
		{
			if ( slot == 0 ) // Input
			{
				if ( !Machine.isItemValidFuel ( stack ) || FurnaceRecipes.getInstance ().getRecipe ( stack ) == null )
				{
					return null;
				}
			}
			else if ( slot == 1 ) // Output
			{
			}

			return super.insertItem ( slot, stack, simulate );
		}

		@Override
		protected void onContentsChanged ( int slot )
		{
			TileEntityBase.this.markDirty ();
		}
	};

	public boolean canInteractWith ( EntityPlayer playerIn )
	{
		return !this.isInvalid () && playerIn.getDistanceSq ( pos.add ( 0.5D, 0.5D, 0.5D ) ) <= 64D;
	}

	@SuppressWarnings( "unchecked" )
	@Override
	public < T > T getCapability ( Capability< T > capability, EnumFacing facing )
	{
		if ( capability == CapabilityEnergy.ENERGY )
		{
			return ( T ) this.energyStorageHandler;
		}
		else if ( capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY )
		{
			return ( T ) this.itemStackHandler;
		}

		return super.getCapability ( capability, facing );
	}

	public ArrayList< TileEntity > getSurroundingTiles ( BlockPos blockPos )
	{
		ArrayList< TileEntity > surroundingTiles = new ArrayList<> ();

		for ( EnumFacing facing : EnumFacing.values () )
		{
			BlockPos pos = blockPos.offset ( facing );
			TileEntity tileEntity = this.getWorld ().getTileEntity ( pos );

			if ( tileEntity != null && tileEntity instanceof TileEntityBase )
			{
				surroundingTiles.add ( tileEntity );
			}
		}

		return surroundingTiles;
	}

	public TileEntity getPowerSource ( BlockPos blockPos )
	{
		TileEntity powerSource = null;

		for ( EnumFacing facing : EnumFacing.values () )
		{
			if ( powerSource != null )
			{
				continue;
			}

			BlockPos blockPosTest = blockPos.offset ( facing );
			TileEntity tileEntity = this.getWorld ().getTileEntity ( blockPosTest );
			if ( tileEntity != null && ( tileEntity instanceof TileEntityPowerBank || tileEntity instanceof TileEntityGenerator ) )
			{
				powerSource = tileEntity;
			}
		}

		return powerSource;
	}

	@Override
	public NBTTagCompound getUpdateTag ()
	{
		NBTTagCompound compound = new NBTTagCompound ();
		this.writeToNBT ( compound );
		return compound;
	}

	/**
	 * Called when the chunk's TE update tag, gotten from {@link #getUpdateTag()}, is received on the client.
	 * <p>
	 * Used to handle this tag in a special way. By default this simply calls {@link #readFromNBT(NBTTagCompound)}.
	 *
	 * @param tag The {@link NBTTagCompound} sent from {@link #getUpdateTag()}
	 */
	@Override
	public void handleUpdateTag ( NBTTagCompound tag )
	{
		this.readFromNBT ( tag );
	}

	@Override
	public boolean hasCapability ( Capability< ? > capability, EnumFacing facing )
	{
		if ( capability == CapabilityEnergy.ENERGY )
		{
			return true;
		}
		else if ( capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY )
		{
			return true;
		}
		else
		{
			return super.hasCapability ( capability, facing );
		}
	}
}
