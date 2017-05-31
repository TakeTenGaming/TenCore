package taketengaming.tencore.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemStackHandler;
import taketengaming.tencore.NameUtil;
import taketengaming.tencore.tileentity.TileEntityBase;

/**
 * Created by Acid on 10/26/2016.
 */
public class Block extends net.minecraft.block.Block
{
	public Block ( Material materialIn, String name )
	{
		super ( materialIn );

		name = NameUtil.getName ( name );
		this.setRegistryName ( name );
		this.setUnlocalizedName ( name );

		this.setHardness ( 1.5f );
		this.setHarvestLevel ( "pickaxe", 1 );
		this.setResistance ( 10.0f );
		this.setSoundType ( SoundType.STONE );
	}

	public Block ( Material materialIn )
	{
		super ( materialIn );

		this.setHardness ( 1.5F );
		this.setHarvestLevel ( "pickaxe", 1 );
		this.setResistance ( 10.0f );
		this.setSoundType ( SoundType.STONE );
	}

	public Block ( String name )
	{
		super ( Material.ROCK );

		name = NameUtil.getName ( name );
		this.setRegistryName ( name );
		this.setUnlocalizedName ( name );

		this.setHardness ( 1.5f );
		this.setHarvestLevel ( "pickaxe", 1 );
		this.setResistance ( 10.0f );
		this.setSoundType ( SoundType.STONE );
	}

	/**
	 * Called serverside after this block is replaced with another in Chunk, but before the Tile Entity is updated
	 *
	 * @param worldIn
	 * @param pos
	 * @param state
	 */
	@Override
	public void breakBlock ( World worldIn, BlockPos pos, IBlockState state )
	{
		TileEntity tileEntity = worldIn.getTileEntity ( pos );

		if ( tileEntity instanceof TileEntityBase )
		{
			ItemStackHandler inventory = ( ( TileEntityBase ) tileEntity ).itemStackHandler;

			for ( int i = 0; i < inventory.getSlots (); ++i )
			{
				ItemStack itemstack = inventory.getStackInSlot ( i );
				if ( itemstack.isEmpty () )
				{
					continue;
				}

				InventoryHelper.spawnItemStack ( worldIn, pos.getX (), pos.getY (), pos.getZ (), itemstack );
			}

			worldIn.updateComparatorOutputLevel ( pos, this );
		}

		super.breakBlock ( worldIn, pos, state );
	}

	@SuppressWarnings( "ConstantConditions" )
	public ModelResourceLocation getModelResourceLocation ()
	{
		return new ModelResourceLocation ( this.getRegistryName (), "inventory" );
	}

	public ModelResourceLocation getModelResourceLocation ( int metadata )
	{
		return new ModelResourceLocation ( this.getRegistryName () + "_" + metadata, "inventory" );
	}

	public ResourceLocation getResourceLocation ()
	{
		return this.getRegistryName ();
	}
}