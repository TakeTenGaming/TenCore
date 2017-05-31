package taketengaming.tencore.item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import taketengaming.tencore.NameUtil;

/**
 * Created by Acid on 11/1/2016.
 */
public class ItemSword extends net.minecraft.item.ItemSword
{
	public ItemSword ( ToolMaterial material, String name )
	{
		super ( material );

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