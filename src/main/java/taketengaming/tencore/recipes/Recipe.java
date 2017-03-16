package taketengaming.tencore.recipes;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by Acid on 2/1/2017.
 */
public class Recipe
{
	public ItemStack input;
	public ItemStack output;
	public int xp;

	public Recipe ( ItemStack input, ItemStack output, int xp )
	{
		this.setInput ( input );
		this.setOutput ( output );
		this.setXp ( xp );
	}

	public Recipe ( ItemStack input, ItemStack output )
	{
		this.setInput ( input );
		this.setOutput ( output );
	}

	public Recipe ( Block input, Block output, int xp )
	{
		this.setInput ( new ItemStack ( input ) );
		this.setOutput ( new ItemStack ( output ) );
		this.setXp ( xp );
	}

	public Recipe ( Block input, Block output )
	{
		this.setInput ( new ItemStack ( input ) );
		this.setOutput ( new ItemStack ( output ) );
	}

	public Recipe ( Block input, ItemStack output, int xp )
	{
		this.setInput ( new ItemStack ( input ) );
		this.setOutput ( output );
		this.setXp ( xp );
	}

	public Recipe ( Block input, ItemStack output )
	{
		this.setInput ( new ItemStack ( input ) );
		this.setOutput ( output );
	}

	public Recipe ( Block input, Item output, int xp )
	{
		this.setInput ( new ItemStack ( input ) );
		this.setOutput ( new ItemStack ( output ) );
		this.setXp ( xp );
	}

	public Recipe ( Block input, Item output )
	{
		this.setInput ( new ItemStack ( input ) );
		this.setOutput ( new ItemStack ( output ) );
	}

	public Recipe ( Item input, Item output, int xp )
	{
		this.setInput ( new ItemStack ( input ) );
		this.setOutput ( new ItemStack ( output ) );
		this.setXp ( xp );
	}

	public Recipe ( Item input, Item output )
	{
		this.setInput ( new ItemStack ( input ) );
		this.setOutput ( new ItemStack ( output ) );
	}

	public Recipe ()
	{
	}

	public ItemStack getInput ()
	{
		return this.input;
	}

	public ItemStack getOutput ()
	{
		return this.output;
	}

	public int getXp ()
	{
		return this.xp;
	}

	public void setInput ( ItemStack input )
	{
		this.input = input;
	}

	public void setInput ( Block input )
	{
		this.setInput ( new ItemStack ( input, 1 ) );
	}

	public void setInput ( Item input )
	{
		this.setInput ( new ItemStack ( input, 1 ) );
	}

	public void setOutput ( ItemStack output )
	{
		this.output = output;
	}

	public void setOutput ( Block output )
	{
		this.setOutput ( new ItemStack ( output, 1 ) );
	}

	public void setOutput ( Item output )
	{
		this.setOutput ( new ItemStack ( output, 1 ) );
	}

	public void setXp ( int xp )
	{
		this.xp = xp;
	}
}
