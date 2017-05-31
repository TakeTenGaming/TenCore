package taketengaming.tencore.recipes;

import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Map;

/**
 * Created by Acid on 2/1/2017.
 */
public class BaseRecipeHandler
{
	public static final BaseRecipeHandler instance = new BaseRecipeHandler ();
	public Map< ItemStack, ItemStack > recipes = Maps.newHashMap ();

	public void addRecipe ( ItemStack input, ItemStack output )
	{
		this.recipes.put ( input, output );
	}

	public void addRecipe ( Block input, Block output )
	{
		this.recipes.put ( new ItemStack ( input ), new ItemStack ( output ) );
	}

	public void addRecipe ( Block input, Item output )
	{
		this.recipes.put ( new ItemStack ( input ), new ItemStack ( output ) );
	}

	public void addRecipe ( Block input, ItemStack output )
	{
		this.recipes.put ( new ItemStack ( input ), output );
	}

	public void addRecipe ( Item input, Item output )
	{
		this.recipes.put ( new ItemStack ( input ), new ItemStack ( output ) );
	}

	public void addRecipes ( Map< ItemStack, ItemStack > recipes )
	{
		this.recipes.putAll ( recipes );
	}

	public static BaseRecipeHandler getInstance ()
	{
		return instance;
	}

	public ItemStack getRecipe ( ItemStack itemStack )
	{
		ItemStack testStack = itemStack.copy ();

		for ( Map.Entry< ItemStack, ItemStack > entry : this.recipes.entrySet () )
		{
			if ( itemStack.getCount () > entry.getKey ().getCount () )
			{
				testStack.setCount ( entry.getKey ().getCount () );
			}

			if ( ItemStack.areItemsEqual ( testStack, entry.getKey () ) )
			{
				return entry.getValue ();
			}
		}

		return ItemStack.EMPTY;
	}

	public Map< ItemStack, ItemStack > getRecipes ()
	{
		return this.recipes;
	}

	public boolean hasRecipe ( ItemStack itemStack )
	{
		return this.recipes.containsKey ( itemStack );
	}

	public void removeRecipe ( ItemStack itemStack )
	{
		this.recipes.remove ( itemStack );
	}
}
