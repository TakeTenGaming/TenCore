package taketengaming.tencore;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by Acid on 1/13/2017.
 */
public class CreativeTab extends CreativeTabs
{
	protected Item item;

	public CreativeTab ( String label, Item item )
	{
		super ( getNextID (), label );

		this.setItem ( item );
	}

	private Item getItem ()
	{
		return this.item;
	}

	@Override
	public ItemStack getTabIconItem ()
	{
		return new ItemStack ( this.getItem () );
	}

	private void setItem ( Item item )
	{
		this.item = item;
	}
}
