package taketengaming.tencore.item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import taketengaming.tencore.NameUtil;

/**
 * Created by Acid on 11/20/2016.
 */
public class ItemHoe extends net.minecraft.item.ItemHoe
{
	public ItemHoe ( ToolMaterial material, String name )
	{
		super ( material );

		name = NameUtil.getNameLegacy ( name );
		this.setRegistryName ( name );
		this.setUnlocalizedName ( name );
	}

	public ModelResourceLocation getModelResourceLocation ()
	{
		return new ModelResourceLocation ( this.getRegistryName (), "inventory" );
	}

	public ModelResourceLocation getModelResourceLocation ( int metadata )
	{
		return new ModelResourceLocation ( this.getRegistryName () + "_" + metadata, "inventory" );
	}
}
