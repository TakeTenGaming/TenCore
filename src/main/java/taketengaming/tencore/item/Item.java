package taketengaming.tencore.item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import taketengaming.tencore.NameUtil;

/**
 * Created by Acid on 11/1/2016.
 */
public class Item extends net.minecraft.item.Item
{
	public Item ( String name )
	{
		super ();

		name = NameUtil.getNameLegacy ( name );
		setRegistryName ( name );
		setUnlocalizedName ( name );
	}

	public ModelResourceLocation getModelResourceLocation ()
	{
		return new ModelResourceLocation ( getRegistryName (), "inventory" );
	}

	public ModelResourceLocation getModelResourceLocation ( int metadata )
	{
		return new ModelResourceLocation ( getRegistryName () + "_" + metadata, "inventory" );
	}

	public String getName ()
	{
		return this.toString ().toLowerCase ();
	}


}