package taketengaming.tencore.item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import taketengaming.tencore.NameUtil;

/**
 * Created by Acid on 11/20/2016.
 */
public class ItemArmor extends net.minecraft.item.ItemArmor
{
	public ItemArmor ( ArmorMaterial material, EntityEquipmentSlot equipmentSlot, String name )
	{
		super ( material, 0, equipmentSlot );

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

	public ResourceLocation getResourceLocation ()
	{
		return this.getRegistryName ();
	}

	@Override
	public boolean hasOverlay ( ItemStack stack )
	{
		return false;
	}
}