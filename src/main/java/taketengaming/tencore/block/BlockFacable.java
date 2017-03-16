package taketengaming.tencore.block;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Created by Acid on 2/11/2017.
 */
public class BlockFacable extends Block
{
	public static final PropertyDirection FACING = BlockHorizontal.FACING;

	public BlockFacable ( Material materialIn, String name )
	{
		super ( materialIn, name );

		this.setDefaultState ( this.blockState.getBaseState ().withProperty ( FACING, EnumFacing.NORTH ) );
	}

	public BlockFacable ( Material materialIn )
	{
		super ( materialIn );

		this.setDefaultState ( this.blockState.getBaseState ().withProperty ( FACING, EnumFacing.NORTH ) );
	}

	public BlockFacable ( String name )
	{
		super ( name );

		this.setDefaultState ( this.blockState.getBaseState ().withProperty ( FACING, EnumFacing.NORTH ) );
	}

	@Override
	protected BlockStateContainer createBlockState ()
	{
		return new BlockStateContainer ( this, FACING );
	}

	/**
	 * Convert the BlockState into the correct metadata value
	 *
	 * @param state
	 */
	@Override
	public int getMetaFromState ( IBlockState state )
	{
		return state.getValue ( FACING ).getIndex ();
	}

	/**
	 * Convert the given metadata into a BlockState for this Block
	 *
	 * @param meta
	 */
	@SuppressWarnings( "deprecation" )
	@Override
	public IBlockState getStateFromMeta ( int meta )
	{
		EnumFacing enumfacing = EnumFacing.getFront ( meta );

		if ( enumfacing.getAxis () == EnumFacing.Axis.Y )
		{
			enumfacing = EnumFacing.NORTH;
		}

		return this.getDefaultState ().withProperty ( FACING, enumfacing );
	}

	/**
	 * Called after the block is set in the Chunk data, but before the Tile Entity is set
	 *
	 * @param worldIn
	 * @param pos
	 * @param state
	 */
	@Override
	public void onBlockAdded ( World worldIn, BlockPos pos, IBlockState state )
	{
		if ( worldIn.isRemote )
		{
			return;
		}

		IBlockState iblockstate = worldIn.getBlockState ( pos.north () );
		IBlockState iblockstate1 = worldIn.getBlockState ( pos.south () );
		IBlockState iblockstate2 = worldIn.getBlockState ( pos.west () );
		IBlockState iblockstate3 = worldIn.getBlockState ( pos.east () );
		EnumFacing enumfacing = state.getValue ( FACING );

		if ( enumfacing == EnumFacing.NORTH && iblockstate.isFullBlock () && !iblockstate1.isFullBlock () )
		{
			enumfacing = EnumFacing.SOUTH;
		}
		else if ( enumfacing == EnumFacing.SOUTH && iblockstate1.isFullBlock () && !iblockstate.isFullBlock () )
		{
			enumfacing = EnumFacing.NORTH;
		}
		else if ( enumfacing == EnumFacing.WEST && iblockstate2.isFullBlock () && !iblockstate3.isFullBlock () )
		{
			enumfacing = EnumFacing.EAST;
		}
		else if ( enumfacing == EnumFacing.EAST && iblockstate3.isFullBlock () && !iblockstate2.isFullBlock () )
		{
			enumfacing = EnumFacing.WEST;
		}

		worldIn.setBlockState ( pos, state.withProperty ( FACING, enumfacing ), 2 );
	}

	/**
	 * Called by ItemBlocks just before a block is actually set in the world, to allow for adjustments to the
	 * IBlockstate
	 *
	 * @param worldIn
	 * @param pos
	 * @param facing
	 * @param hitX
	 * @param hitY
	 * @param hitZ
	 * @param meta
	 * @param placer
	 */
	public IBlockState onBlockPlaced ( World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer )
	{
		return this.getDefaultState ().withProperty ( FACING, placer.getHorizontalFacing ().getOpposite () );
	}

	/**
	 * Called by ItemBlocks after a block is set in the world, to allow post-place logic
	 *
	 * @param worldIn
	 * @param pos
	 * @param state
	 * @param placer
	 * @param stack
	 */
	@Override
	public void onBlockPlacedBy ( World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack )
	{
		worldIn.setBlockState ( pos, state.withProperty ( FACING, placer.getHorizontalFacing ().getOpposite () ), 2 );
	}

	/**
	 * Returns the blockstate with the given mirror of the passed blockstate. If inapplicable, returns the passed
	 * blockstate.
	 *
	 * @param state
	 * @param mirrorIn
	 */
	@SuppressWarnings( "deprecation" )
	@Override
	public IBlockState withMirror ( IBlockState state, Mirror mirrorIn )
	{
		return state.withRotation ( mirrorIn.toRotation ( state.getValue ( FACING ) ) );
	}

	/**
	 * Returns the blockstate with the given rotation from the passed blockstate. If inapplicable, returns the passed
	 * blockstate.
	 *
	 * @param state
	 * @param rot
	 */
	@SuppressWarnings( "deprecation" )
	@Override
	public IBlockState withRotation ( IBlockState state, Rotation rot )
	{
		return state.withProperty ( FACING, rot.rotate ( state.getValue ( FACING ) ) );
	}
}
