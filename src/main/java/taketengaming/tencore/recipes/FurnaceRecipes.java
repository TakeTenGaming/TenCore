package taketengaming.tencore.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by Acid on 2/1/2017.
 */
public class FurnaceRecipes extends BaseRecipeHandler
{
	public FurnaceRecipes ()
	{
		// Minecraft
		this.addRecipe ( Blocks.CACTUS, new ItemStack ( Items.DYE, 1, EnumDyeColor.GREEN.getDyeDamage () ) );
		this.addRecipe ( Blocks.CLAY, Blocks.HARDENED_CLAY );
		this.addRecipe ( Blocks.COAL_ORE, Items.COAL );
		this.addRecipe ( Blocks.COBBLESTONE, Blocks.COBBLESTONE );
		this.addRecipe ( Blocks.DIAMOND_ORE, Items.DIAMOND );
		this.addRecipe ( Blocks.EMERALD_ORE, Items.EMERALD );

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

		this.addRecipe ( Blocks.LAPIS_ORE, new ItemStack ( Items.DYE, 1, EnumDyeColor.BLUE.getDyeDamage () ) );

		NonNullList< ItemStack > oreDictionaryLogs = OreDictionary.getOres ( "log" );
		for ( int i = 0; i < oreDictionaryLogs.size (); i++ )
		{
			this.addRecipe ( oreDictionaryLogs.get ( i ), new ItemStack ( Items.COAL, 1, 1 ) );
		}
		// TODO: Uncomment the following if the above isn't needed
		//this.addRecipe ( Blocks.LOG, new ItemStack ( Items.COAL, 1, 1 ) );

		this.addRecipe ( Blocks.NETHERRACK, Items.NETHERBRICK );
		this.addRecipe ( Blocks.QUARTZ_ORE, Items.QUARTZ );
		this.addRecipe ( Blocks.REDSTONE_ORE, Items.REDSTONE );
		this.addRecipe ( Blocks.SAND, Blocks.GLASS );
		this.addRecipe ( Items.BEEF, Items.COOKED_BEEF );
		this.addRecipe ( Items.CHICKEN, Items.COOKED_CHICKEN );
		this.addRecipe ( Items.CLAY_BALL, Items.BRICK );

		// TODO: Loop through all fish and add their recipe to the furnace
		this.addRecipe ( Items.FISH, Items.FISH );

		this.addRecipe ( Items.MUTTON, Items.COOKED_MUTTON );
		this.addRecipe ( Items.PORKCHOP, Items.COOKED_PORKCHOP );
		this.addRecipe ( Items.POTATO, Items.BAKED_POTATO );
		this.addRecipe ( Items.RABBIT, Items.COOKED_RABBIT );
	}
}
