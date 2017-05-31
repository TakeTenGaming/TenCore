package taketengaming.tencore.item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import taketengaming.tencore.NameUtil;

/**
 * Created by Acid on 11/1/2016.
 */
public class ItemAxe extends net.minecraft.item.ItemAxe
{
	public ItemAxe ( ToolMaterial material, String name )
	{
		super ( material, material.getDamageVsEntity (), material.getEfficiencyOnProperMaterial () );

		name = NameUtil.getName ( name );
		this.setRegistryName ( name );
		this.setUnlocalizedName ( name );
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
}