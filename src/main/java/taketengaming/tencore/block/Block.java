package taketengaming.tencore.block;

import net.minecraft.block.SoundType;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.Explosion;
import taketengaming.tencore.NameUtil;
import taketengaming.tencore.TenCore;

/**
 * Created by Acid on 10/26/2016.
 */
public class Block extends net.minecraft.block.Block
{
	public Block ( net.minecraft.block.material.Material materialIn, String name )
	{
		super ( materialIn );

		name = name.toLowerCase ().replace ( " ", "" );
		setRegistryName ( name );
		setUnlocalizedName ( name );

		setHardness ( 1.5f );
		setHarvestLevel ( "pickaxe", 2 );
		setResistance ( 10.0f );
		setSoundType ( SoundType.STONE );
	}

	public Block ( String name )
	{
		super ( net.minecraft.block.material.Material.ROCK );

		name = NameUtil.getNameLegacy ( name );
		setRegistryName ( name );
		setUnlocalizedName ( name );

		setHardness ( 1.5f );
		setHarvestLevel ( "pickaxe", 2 );
		setResistance ( 10.0f );
		setSoundType ( SoundType.STONE );
	}

	@Override
	public boolean canDropFromExplosion ( Explosion explosion )
	{
		return false;
	}

	public ModelResourceLocation getModelResourceLocation ()
	{
		TenCore.logger.info ( "[Block] Model Resource: " + new ModelResourceLocation ( getRegistryName (), "inventory" ) );
		return new ModelResourceLocation ( getRegistryName (), "inventory" );
	}

	public ModelResourceLocation getModelResourceLocation ( int metadata )
	{
		TenCore.logger.info ( "[Block] Model Resource (#" + metadata + "): " + new ModelResourceLocation ( getRegistryName () + "_" + metadata, "inventory" ) );
		return new ModelResourceLocation ( getRegistryName () + "_" + metadata, "inventory" );
	}

	public ResourceLocation getResourceLocation ()
	{
		return getRegistryName ();
	}
}