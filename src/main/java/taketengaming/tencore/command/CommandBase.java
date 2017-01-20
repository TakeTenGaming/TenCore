package taketengaming.tencore.command;

import net.minecraft.command.ICommandSender;

/**
 * Created by Acid on 11/18/2016.
 */
public abstract class CommandBase extends net.minecraft.command.CommandBase
{
	protected String name;

	/**
	 * Gets the name of the command
	 */
	@Override
	public String getName ()
	{
		return this.name;
	}

	/**
	 * Gets the usage string for the command.
	 *
	 * @param sender The ICommandSender who is requesting usage details
	 */
	@Override
	public String getUsage ( ICommandSender sender )
	{
		return "/" + this.getName ();
	}
}
