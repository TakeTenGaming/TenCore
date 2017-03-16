package taketengaming.tencore.register;

import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import taketengaming.tencore.command.CommandProfiler;

/**
 * Created by Acid on 1/25/2017.
 */
public class Commands
{
	private static CommandProfiler commandProfiler = new CommandProfiler ();

	public static void serverStarting ( FMLServerStartingEvent event )
	{
		event.registerServerCommand ( commandProfiler );
	}
}
