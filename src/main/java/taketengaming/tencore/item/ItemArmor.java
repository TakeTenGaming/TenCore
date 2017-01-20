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

	public ResourceLocation getResourceLocation ()
	{
		return getRegistryName ();
	}

	@Override
	public boolean hasOverlay ( ItemStack stack )
	{
		return false;
	}
}