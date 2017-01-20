package taketengaming.tencore.event;

import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import taketengaming.tencore.TenCore;
import taketengaming.tencore.VersionChecker;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Acid on 1/19/2017.
 */
public class PlayerTick
{
	@SubscribeEvent( priority = EventPriority.NORMAL, receiveCanceled = true )
	public void onEvent ( TickEvent.PlayerTickEvent event )
	{
		if ( TenCore.versionCheckWarned )
		{
			return;
		}

		ArrayList< String > outdatedMods = new ArrayList<> ();
		int outdatedVersions = 0;

		if ( TenCore.versionCheckers.isEmpty () )
		{
			return;
		}

		for ( VersionChecker versionChecker : TenCore.versionCheckers )
		{
			if ( versionChecker.getLatestVersion () == null )
			{
				continue;
			}

			if ( Objects.equals ( versionChecker.getStatus (), "BEHIND" ) )
			{
				outdatedMods.add ( versionChecker.getModId () + ": " + versionChecker.getLatestVersion () );
				outdatedVersions++;
			}
		}

		if ( outdatedVersions > 0 )
		{
			TextComponentString warningMessage = new TextComponentString ( outdatedVersions + " mods are out of date: " );

			for ( String outdatedMod : outdatedMods )
			{
				warningMessage.appendSibling ( new TextComponentString ( "\n" + outdatedMod ) );
			}

			event.player.sendMessage ( warningMessage );
		}

		TenCore.versionCheckWarned = true;
	}
}
