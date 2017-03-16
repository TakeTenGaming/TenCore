package taketengaming.tencore.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;

/**
 * Created by Acid on 2/1/2017.
 */
public class PulverizerRecipes extends BaseRecipeHandler
{
	public static final PulverizerRecipes instance = new PulverizerRecipes ();

	public PulverizerRecipes ()
	{
		// Minecraft
		this.addRecipe ( Blocks.COAL_ORE, Items.COAL );
		this.addRecipe ( Blocks.IRON_ORE, Items.IRON_INGOT );
		this.addRecipe ( Blocks.GOLD_ORE, Items.GOLD_INGOT );
		this.addRecipe ( Blocks.REDSTONE_ORE, Items.REDSTONE );
		this.addRecipe ( Blocks.DIAMOND_ORE, Items.DIAMOND );
		this.addRecipe ( Blocks.EMERALD_ORE, Items.EMERALD );
		this.addRecipe ( Blocks.LAPIS_ORE, new ItemStack ( Items.DYE, 1, EnumDyeColor.BLUE.getDyeDamage () ) );
		this.addRecipe ( Blocks.QUARTZ_ORE, Items.QUARTZ );

		// DatMod
		this.addRecipe ( taketengaming.datmod.register.Blocks.diamondiumOre, taketengaming.datmod.register.Items.diamondium );
		this.addRecipe ( taketengaming.datmod.register.Blocks.emeraldiOre, taketengaming.datmod.register.Items.emeraldi );
		this.addRecipe ( taketengaming.datmod.register.Blocks.goldiriteOre, taketengaming.datmod.register.Items.goldiriteDust );
		this.addRecipe ( taketengaming.datmod.register.Blocks.ironiumOre, taketengaming.datmod.register.Items.ironiumDust );
	}

	public static PulverizerRecipes getInstance ()
	{
		return instance;
	}
}
