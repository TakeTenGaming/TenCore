package taketengaming.tencore.recipes;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Acid on 2/1/2017.
 */
public class BaseRecipeHandler
{
	private ArrayList< Recipe > recipes = new ArrayList<> ();

	public void addRecipe ( ItemStack input, ItemStack output )
	{
		this.recipes.add ( new Recipe ( input, output ) );
	}

	public void addRecipe ( Block input, Block output )
	{
		this.recipes.add ( new Recipe ( input, output ) );
	}

	public void addRecipe ( Block input, Item output )
	{
		this.recipes.add ( new Recipe ( input, output ) );
	}

	public void addRecipe ( Block input, ItemStack output )
	{
		this.recipes.add ( new Recipe ( input, output ) );
	}

	public void addRecipe ( Item input, Item output )
	{
		this.recipes.add ( new Recipe ( input, output ) );
	}

	public void addRecipes ( Collection recipes )
	{
		this.recipes.addAll ( recipes );
	}

	protected boolean compareItemStacks ( ItemStack stack1, ItemStack stack2 )
	{
		return stack2.getItem () == stack1.getItem () && ( stack2.getMetadata () == 32767 || stack2.getMetadata () == stack1.getMetadata () );
	}

	public boolean containsRecipe ( Recipe recipe )
	{
		return this.recipes.contains ( recipe );
	}

	public Recipe getRecipe ( ItemStack itemStack )
	{
		for ( Recipe recipe : this.getRecipes () )
		{
			if ( this.compareItemStacks ( itemStack, recipe.getInput () ) )
			{
				return recipe;
			}
		}

		return null;
	}

	public ArrayList< Recipe > getRecipes ()
	{
		return this.recipes;
	}

	public void removeRecipe ( Recipe recipe )
	{
		if ( !this.containsRecipe ( recipe ) )
		{
			return;
		}

		this.recipes.remove ( this.recipes.indexOf ( recipe ) );
	}
}
