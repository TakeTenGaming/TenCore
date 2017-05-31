package taketengaming.tencore.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by Acid on 2/1/2017.
 */
public class PulverizerRecipes extends BaseRecipeHandler
{
	public PulverizerRecipes ()
	{
		// Minecraft
		this.addRecipe ( Blocks.COAL_ORE, Items.COAL );

		boolean useIronDust = false;
		boolean useGoldDust = false;
		if ( OreDictionary.getOres ( "dustIron" ).size () > 0 )
		{
			useIronDust = true;
		}

		if ( OreDictionary.getOres ( "dustGold" ).size () > 0 )
		{
			useGoldDust = true;
		}

		if ( !useIronDust )
		{
			this.addRecipe ( Blocks.IRON_ORE, Items.IRON_INGOT );
		}

		if ( !useGoldDust )
		{
			this.addRecipe ( Blocks.GOLD_ORE, Items.GOLD_INGOT );
		}

		this.addRecipe ( Blocks.REDSTONE_ORE, Items.REDSTONE );
		this.addRecipe ( Blocks.DIAMOND_ORE, Items.DIAMOND );
		this.addRecipe ( Blocks.EMERALD_ORE, Items.EMERALD );
		this.addRecipe ( Blocks.LAPIS_ORE, new ItemStack ( Items.DYE, 1, EnumDyeColor.BLUE.getDyeDamage () ) );
		this.addRecipe ( Blocks.QUARTZ_ORE, Items.QUARTZ );
	}
}
