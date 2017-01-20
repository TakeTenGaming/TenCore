package taketengaming.tencore.register;

import net.minecraftforge.common.MinecraftForge;
import taketengaming.tencore.event.PlayerTick;

/**
 * Created by Acid on 1/19/2017.
 */
public class Events
{
	private static PlayerTick playerTick = new PlayerTick ();

	public static void init ()
	{
		MinecraftForge.EVENT_BUS.register ( playerTick );
	}
}
