package taketengaming.tencore.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import taketengaming.tencore.TenCore;
import taketengaming.tencore.tileentity.TileEntityBase;

/**
 * Created by Acid on 4/29/2017.
 */
public class Container extends net.minecraft.inventory.Container
{
	public int guiBaseHeight = 84;
	protected boolean showsPlayerInventory = true;
	protected TileEntityBase tileEntity;

	public Container ( TileEntityBase tileEntity, boolean showsPlayerInventory )
	{
		this.showsPlayerInventory = showsPlayerInventory;
		this.tileEntity = tileEntity;
	}

	public Container ( TileEntityBase tileEntity )
	{
		this.tileEntity = tileEntity;
	}

	public void addOwnSlot ( int index, int x, int y )
	{
		if ( !this.tileEntity.hasCapability ( CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null ) )
		{
			TenCore.logger.info ( this.getTileEntity ().getClass () + " has no Item Handler Capability.." );
			return;
		}

		IItemHandler itemHandler = this.tileEntity.getCapability ( CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null );
		this.addSlotToContainer ( new SlotItemHandler ( itemHandler, index, x, y ) );
	}

	public void addOwnSlots ( int[][] slots )
	{
		if ( !this.tileEntity.hasCapability ( CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null ) )
		{
			TenCore.logger.info ( this.getTileEntity ().getClass () + " has no Item Handler Capability.." );
			return;
		}

		for ( int i = 0; i < slots.length; i++ )
		{
			this.addOwnSlot ( i, slots[ i ][ 0 ], slots[ i ][ 1 ] );
		}
	}

	protected void addPlayerSlots ( IInventory inventory )
	{
		if ( !this.showsPlayerInventory () )
		{
			return;
		}

		// Main Inventory
		for ( int row = 0; row < 3; row++ )
		{
			for ( int col = 0; col < 9; col++ )
			{
				this.addSlotToContainer ( new Slot ( inventory, col + row * 9 + 9, 8 + col * 18, this.guiBaseHeight + row * 18 ) );
			}
		}

		// Hotbar
		for ( int row = 0; row < 9; row++ )
		{
			this.addSlotToContainer ( new Slot ( inventory, row, 8 + row * 18, this.guiBaseHeight + 58 ) );
		}
	}

	/**
	 * Determines whether supplied player can use this container
	 *
	 * @param playerIn
	 */
	@Override
	public boolean canInteractWith ( EntityPlayer playerIn )
	{
		return this.tileEntity.canInteractWith ( playerIn );
	}

	protected int getGuiBaseHeight ()
	{
		return this.guiBaseHeight;
	}

	protected TileEntityBase getTileEntity ()
	{
		return this.tileEntity;
	}

	protected void setGuiBaseHeight ( int guiBaseHeight )
	{
		this.guiBaseHeight = guiBaseHeight;
	}

	protected void setShowsPlayerInventory ( boolean showsPlayerInventory )
	{
		this.showsPlayerInventory = showsPlayerInventory;
	}

	protected boolean showsPlayerInventory ()
	{
		return this.showsPlayerInventory;
	}

	/**
	 * Handle when the stack in slot {@code index} is shift-clicked. Normally this moves the stack between the player
	 * inventory and the other inventory(s).
	 *
	 * @param playerIn Player that interacted with this {@code Container}.
	 * @param index    Index of the {@link Slot}. This index is relative to the list of slots in this {@code Container},
	 *                 {@link #inventorySlots}.
	 */
	@Override
	public ItemStack transferStackInSlot ( EntityPlayer playerIn, int index )
	{
		ItemStack itemStack;
		Slot slot = this.inventorySlots.get ( index );

		if ( slot == null || !slot.getHasStack () )
		{
			return ItemStack.EMPTY;
		}

		ItemStack itemStack1 = slot.getStack ();
		itemStack = itemStack1.copy ();

		// TODO: Find a proper fix for this, if possible..
		try
		{
			if ( index < this.tileEntity.SIZE )
			{
				if ( !this.mergeItemStack ( itemStack1, this.tileEntity.SIZE, this.inventorySlots.size (), true ) )
				{
					return ItemStack.EMPTY;
				}
			}
			else if ( !this.mergeItemStack ( itemStack1, 0, this.tileEntity.SIZE, false ) )
			{
				return ItemStack.EMPTY;
			}
		}
		catch ( Exception exception )
		{
			FMLLog.info ( "Exception caught: " + exception.getMessage () );
		}

		if ( itemStack1.isEmpty () )
		{
			slot.putStack ( ItemStack.EMPTY );
		}
		else
		{
			slot.onSlotChanged ();
		}

		return itemStack;
	}
}
