package taketengaming.tencore.util;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;

/**
 * Created by Acid on 2/1/2017.
 */
public class Machine
{
	/**
	 * Determines how much power a specified ItemStack will give
	 *
	 * @param itemStack
	 *
	 * @return int
	 */
	public static int getItemPowerValue ( ItemStack itemStack )
	{
		return getItemPowerValue ( itemStack.getItem () );
	}

	/**
	 * Determines how much power a specified Item will give
	 *
	 * @param item
	 *
	 * @return
	 */
	public static int getItemPowerValue ( Item item )
	{
		int returnValue = 50;
		ArrayList powerItems = getValidPowerItems ();

		for ( Object powerItem : powerItems )
		{
			if ( powerItem.equals ( Blocks.COAL_BLOCK ) )
			{
				returnValue = ( 200 * 9 );
			}
			else if ( powerItem.equals ( Items.COAL ) )
			{
				returnValue = 200;
			}
		}

		return returnValue;
	}

	/**
	 * Determines how long an ItemStack takes to be processed in a machine
	 *
	 * @param itemStack
	 *
	 * @return int
	 */
	public static int getItemProcessingTime ( ItemStack itemStack )
	{
		return getItemProcessingTime ( itemStack.getItem () );
	}

	/**
	 * Determines how long an Item takes to be processed in a machine
	 *
	 * @param item
	 *
	 * @return
	 */
	@SuppressWarnings( "EqualsBetweenInconvertibleTypes" )
	public static int getItemProcessingTime ( Item item )
	{
		if ( item.equals ( Blocks.DIAMOND_ORE ) )
		{
			return 500;
		}
		else if ( item.equals ( taketengaming.datmod.register.Blocks.diamondiumOre ) )
		{
			return 600;
		}
		else if ( item.equals ( Blocks.IRON_ORE ) )
		{
			return 300;
		}
		else if ( item.equals ( taketengaming.datmod.register.Blocks.ironiumOre ) )
		{
			return 400;
		}
		else if ( item.equals ( Blocks.GOLD_ORE ) )
		{
			return 450;
		}
		else if ( item.equals ( taketengaming.datmod.register.Blocks.goldiriteOre ) )
		{
			return 480;
		}
		else if ( item.equals ( Blocks.EMERALD_ORE ) )
		{
			return 500;
		}
		else if ( item.equals ( taketengaming.datmod.register.Blocks.emeraldiOre ) )
		{
			return 550;
		}
		else
		{
			return 200;
		}
	}

	/**
	 * Gets an ArrayList of blocks/items that are valid as power sources
	 *
	 * @return ArrayList
	 */
	public static ArrayList getValidPowerItems ()
	{
		ArrayList values = new ArrayList ();

		// Blocks
		values.add ( Blocks.COAL_BLOCK );
		values.add ( Blocks.ACACIA_DOOR );
		values.add ( Blocks.ACACIA_FENCE );
		values.add ( Blocks.ACACIA_FENCE_GATE );
		values.add ( Blocks.WOOL );

		// Items
		values.add ( Items.COAL );
		values.add ( Items.WOODEN_AXE );
		values.add ( Items.WOODEN_HOE );
		values.add ( Items.WOODEN_PICKAXE );
		values.add ( Items.WOODEN_SHOVEL );
		values.add ( Items.WOODEN_SWORD );

		return values;
	}

	/**
	 * Checks if the specified ItemStack is a valid fuel source
	 *
	 * @param itemStack
	 *
	 * @return boolean
	 */
	public static boolean isItemValidFuel ( ItemStack itemStack )
	{
		return getValidPowerItems ().contains ( itemStack.getItem () );
	}

	/**
	 * Checks if the specified Block is a valid fuel source
	 *
	 * @param item
	 *
	 * @return
	 */
	public static boolean isItemValidFuel ( Block item )
	{
		return getValidPowerItems ().contains ( new ItemStack ( item ) );
	}

	/**
	 * Checks if the specified Item is a valid fuel source
	 *
	 * @param item
	 *
	 * @return
	 */
	public static boolean isItemValidFuel ( Item item )
	{
		return getValidPowerItems ().contains ( new ItemStack ( item ) );
	}
}
