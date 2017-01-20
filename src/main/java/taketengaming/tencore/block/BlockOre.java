package taketengaming.tencore.block;

import net.minecraft.block.material.MapColor;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import taketengaming.tencore.NameUtil;
import taketengaming.tencore.TenCore;

/**
 * Created by Acid on 10/28/2016.
 */
public class BlockOre extends net.minecraft.block.BlockOre
{
	public BlockOre ( MapColor color, String name )
	{
		super ( color );

		name = NameUtil.getNameLegacy ( name );
		setRegistryName ( name );
		setUnlocalizedName ( name );

		setHardness ( 2.5f );
		setHarvestLevel ( "pickaxe", 4 );
	}

	public BlockOre ( String name )
	{
		super ();

		name = NameUtil.getNameLegacy ( name );
		setRegistryName ( name );
		setUnlocalizedName ( name );

		setHardness ( 2.5f );
		setHarvestLevel ( "pickaxe", 4 );
	}

	public ModelResourceLocation getModelResourceLocation ()
	{
		TenCore.logger.info ( "[BlockOre] Model Resource: " + new ModelResourceLocation ( getRegistryName (), "inventory" ) );
		return new ModelResourceLocation ( getRegistryName (), "inventory" );
	}

	public ModelResourceLocation getModelResourceLocation ( int metadata )
	{
		TenCore.logger.info ( "[BlockOre] Model Resource (#" + metadata + "): " + new ModelResourceLocation ( getRegistryName () + "_" + metadata, "inventory" ) );
		return new ModelResourceLocation ( getRegistryName () + "_" + metadata, "inventory" );
	}

	public ResourceLocation getResourceLocation ()
	{
		return getRegistryName ();
	}
}
