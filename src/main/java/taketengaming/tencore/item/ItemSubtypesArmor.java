package taketengaming.tencore.item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import taketengaming.tencore.NameUtil;
import taketengaming.tencore.TenCore;

import java.util.Objects;

/**
 * Created by Acid on 1/14/2017.
 */
public class ItemSubtypesArmor extends ItemArmor
{
	private String[] subTypeNames;

	public ItemSubtypesArmor ( ArmorMaterial armorMaterial, EntityEquipmentSlot equipmentSlot, String name, String[] subTypeNames )
	{
		super ( armorMaterial, equipmentSlot, name );

		switch ( equipmentSlot )
		{
			case CHEST:
				name += "_chestplate";
				break;

			case FEET:
				name += "_boots";
				break;

			case HEAD:
				name += "_helmet";
				break;

			case LEGS:
				name += "_leggings";
				break;
		}

		name = NameUtil.getNameLegacy ( name );
		setRegistryName ( name );
		setUnlocalizedName ( name );

		this.setHasSubtypes ( true );
		this.setSubTypeNames ( subTypeNames );
	}

	public ModelResourceLocation getModelResourceLocation ()
	{
		return new ModelResourceLocation ( getRegistryName (), "inventory" );
	}

	public ModelResourceLocation getModelResourceLocation ( int metadata )
	{
		return new ModelResourceLocation ( getRegistryName () + "_" + metadata, "inventory" );
	}

	/**
	 * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
	 *
	 * @param item
	 * @param creativeTab
	 * @param subItems
	 */
	@Override
	public void getSubItems ( Item item, CreativeTabs creativeTab, NonNullList< ItemStack > subItems )
	{
		for ( int i = 0; i <= this.getSubTypeCount (); i++ )
		{
			subItems.add ( new ItemStack ( item, 1, i ) );
		}
	}

	public int getSubTypeCount ()
	{
		return this.subTypeNames.length;
	}

	public String getSubTypeName ( int subType )
	{
		return this.subTypeNames[ subType ];
	}

	public String[] getSubTypeNames ()
	{
		return this.subTypeNames;
	}

	/**
	 * Returns the unlocalized name of this item. This version accepts an ItemStack so different stacks can have
	 * different names based on their damage or NBT.
	 *
	 * @param itemStack
	 */
	@Override
	public String getUnlocalizedName ( ItemStack itemStack )
	{
		String name = this.getSubTypeName ( itemStack.getItemDamage () );
		if ( Objects.equals ( name, "" ) )
		{
			TenCore.logger.error ( "Unknown item: " + itemStack );
		}

		String fullName = "item." + name.replace ( " ", "_" ) + "_" + super.getUnlocalizedName ().replace ( "item.", "" );
		return fullName;
	}

	public String getUnlocalizedName ( int metadata )
	{
		String name = this.getSubTypeName ( metadata );
		if ( Objects.equals ( name, "" ) )
		{
			TenCore.logger.error ( "Unknown item: " + name );
		}

		return name;
	}

	private void setSubTypeNames ( String[] subTypeNames )
	{
		this.subTypeNames = subTypeNames;
	}
}