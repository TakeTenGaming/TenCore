package taketengaming.tencore.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;

/**
 * Created by Acid on 2/1/2017.
 */
public class FurnaceRecipes extends BaseRecipeHandler
{
	public static final FurnaceRecipes instance = new FurnaceRecipes ();

	public FurnaceRecipes ()
	{
		// Minecraft
		this.addRecipe ( Blocks.CACTUS, new ItemStack ( Items.DYE, 1, EnumDyeColor.GREEN.getDyeDamage () ) );
		this.addRecipe ( Blocks.CLAY, Blocks.HARDENED_CLAY );
		this.addRecipe ( Blocks.COAL_ORE, Items.COAL );
		this.addRecipe ( Blocks.COBBLESTONE, Blocks.COBBLESTONE );
		this.addRecipe ( Blocks.DIAMOND_ORE, Items.DIAMOND );
		this.addRecipe ( Blocks.EMERALD_ORE, Items.EMERALD );
		this.addRecipe ( Blocks.GOLD_ORE, Items.GOLD_INGOT );
		this.addRecipe ( Blocks.IRON_ORE, Items.IRON_INGOT );
		this.addRecipe ( Blocks.LAPIS_ORE, new ItemStack ( Items.DYE, 1, EnumDyeColor.BLUE.getDyeDamage () ) );
		this.addRecipe ( Blocks.LOG, new ItemStack ( Items.COAL, 1, 1 ) );
		this.addRecipe ( Blocks.NETHERRACK, Items.NETHERBRICK );
		this.addRecipe ( Blocks.QUARTZ_ORE, Items.QUARTZ );
		this.addRecipe ( Blocks.REDSTONE_ORE, Items.REDSTONE );
		this.addRecipe ( Blocks.SAND, Blocks.GLASS );
		this.addRecipe ( Items.BEEF, Items.COOKED_BEEF );
		this.addRecipe ( Items.CHICKEN, Items.COOKED_CHICKEN );
		this.addRecipe ( Items.CLAY_BALL, Items.BRICK );
		this.addRecipe ( Items.FISH, Items.FISH );
		this.addRecipe ( Items.MUTTON, Items.COOKED_MUTTON );
		this.addRecipe ( Items.PORKCHOP, Items.COOKED_PORKCHOP );
		this.addRecipe ( Items.POTATO, Items.BAKED_POTATO );
		this.addRecipe ( Items.RABBIT, Items.COOKED_RABBIT );

		// DatMod
		this.addRecipe ( taketengaming.datmod.register.Blocks.diamondiumOre, taketengaming.datmod.register.Items.diamondium );
		this.addRecipe ( taketengaming.datmod.register.Blocks.emeraldiOre, taketengaming.datmod.register.Items.emeraldi );
		this.addRecipe ( taketengaming.datmod.register.Blocks.goldiriteOre, taketengaming.datmod.register.Items.goldiriteIngot );
		this.addRecipe ( taketengaming.datmod.register.Blocks.ironiumOre, taketengaming.datmod.register.Items.ironiumIngot );
		this.addRecipe ( taketengaming.datmod.register.Items.goldiriteDust, taketengaming.datmod.register.Items.goldiriteIngot );
		this.addRecipe ( taketengaming.datmod.register.Items.ironiumDust, taketengaming.datmod.register.Items.ironiumIngot );

		// EnderIO
	}

	public static FurnaceRecipes getInstance ()
	{
		return instance;
	}
}
