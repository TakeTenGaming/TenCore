package taketengaming.tencore;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by Acid on 11/29/2016.
 */
public class Achievement extends net.minecraft.stats.Achievement
{
	public Achievement ( String statIdIn, String name, int column, int row, ItemStack stack, net.minecraft.stats.Achievement parent )
	{
		super ( statIdIn, name, column, row, stack, parent );
	}

	private static Achievement init ( String name, int column, int row, ItemStack stack, net.minecraft.stats.Achievement parent )
	{
		Achievement achievement = new Achievement ( name, name, column, row, stack, parent );
		achievement.registerStat ();

		return achievement;
	}

	public static Achievement init ( String name, int column, int row, Block block, Achievement parent )
	{
		return init ( name, column, row, new ItemStack ( block ), parent );
	}

	public static Achievement init ( String name, int column, int row, Item item, Achievement parent )
	{
		return init ( name, column, row, new ItemStack ( item ), parent );
	}
}
