package taketengaming.tencore.block;

import net.minecraft.block.material.MapColor;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import taketengaming.tencore.NameUtil;

/**
 * Created by Acid on 10/28/2016.
 */
public class BlockOre extends net.minecraft.block.BlockOre
{
	public BlockOre ( MapColor color, String name )
	{
		super ( color );

		name = NameUtil.getNameLegacy ( name );
		this.setRegistryName ( name );
		this.setUnlocalizedName ( name );

		this.setHardness ( 2.5f );
		this.setHarvestLevel ( "pickaxe", 4 );
	}

	public BlockOre ( String name )
	{
		super ();

		name = NameUtil.getNameLegacy ( name );
		this.setRegistryName ( name );
		this.setUnlocalizedName ( name );

		this.setHardness ( 2.5f );
		this.setHarvestLevel ( "pickaxe", 4 );
	}

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
