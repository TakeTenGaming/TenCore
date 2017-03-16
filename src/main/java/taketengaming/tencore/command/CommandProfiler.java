package taketengaming.tencore.command;

import net.minecraft.block.Block;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

import java.util.Objects;

/**
 * Created by Acid on 11/18/2016.
 */
public class CommandProfiler extends CommandBase
{
	public CommandProfiler ()
	{
		super ( "profiler" );
	}

	/**
	 * Gets the usage string for the command.
	 *
	 * @param sender The ICommandSender who is requesting usage details
	 */
	@Override
	public String getUsage ( ICommandSender sender )
	{
		return "/" + this.getName () + " <block ID/Item ID>";
	}

	/**
	 * Callback for when the command is executed
	 *
	 * @param server The server instance
	 * @param sender The sender who executed the command
	 * @param args   The arguments that were passed
	 */
	@Override
	public void execute ( MinecraftServer server, ICommandSender sender, String[] args ) throws CommandException
	{
		if ( args.length == 0 )
		{
			sender.sendMessage ( new TextComponentString ( "No arguments provided! Expected syntax: " + this.getUsage ( sender ) ) );
			return;
		}

		String block = getBlockByText ( sender, args[ 0 ] ).toString ();

		int blocksSearched = 0;
		int oreFound = 0;

		BlockPos position = sender.getPosition ();
		int posX = position.getX ();
		int posXMax = posX + 15;
		int posY = position.getY ();
		int posZ = position.getZ ();
		int posZMax = posZ + 15;

		for ( int iX = posX; iX < posXMax; iX++ )
		{
			int newPosX = posX + iX;

			for ( int iY = 1; iY < posY; iY++ )
			{
				int newPosY = posY - iY;
				BlockPos newPosition = new BlockPos ( posX, newPosY, newPosX );
				Block newBlock = sender.getEntityWorld ().getBlockState ( newPosition ).getBlock ();

				if ( newBlock == Blocks.AIR || newBlock == Blocks.BEDROCK || newBlock == Blocks.WATER || newBlock == Blocks.LAVA )
				{
					continue;
				}

				blocksSearched++;
				if ( Objects.equals ( block, newBlock.toString () ) )
				{
					oreFound++;
				}
			}
		}

		for ( int iZ = posZ; iZ < posZMax; iZ++ )
		{
			int newPosZ = posZ + iZ;

			for ( int iY = 1; iY < posY; iY++ )
			{
				blocksSearched++;

				int newPosY = posY - iY;
				BlockPos newPosition = new BlockPos ( posX, newPosY, newPosZ );
				Block newBlock = sender.getEntityWorld ().getBlockState ( newPosition ).getBlock ();

				if ( Objects.equals ( block, newBlock.toString () ) )
				{
					oreFound++;
				}
			}
		}

		Style baseStyle = new Style ().setBold ( false ).setColor ( TextFormatting.GRAY );
		String messageSubstitute = "Searched " + TextFormatting.GOLD + blocksSearched + TextFormatting.GRAY + " blocks, found " + TextFormatting.GOLD + oreFound + TextFormatting.GRAY +
				" of " + TextFormatting.GOLD + args[ 0 ];
		ITextComponent message = new TextComponentString ( messageSubstitute ).setStyle ( baseStyle );
		sender.sendMessage ( message );
	}
}