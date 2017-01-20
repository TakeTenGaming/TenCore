package taketengaming.tencore;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import taketengaming.tencore.register.Events;

import java.util.ArrayList;

@Mod( acceptedMinecraftVersions = "[1.10,1.10.2,1.11,1.11.2]", modid = TenCore.MODID, name = TenCore.NAME, version = TenCore.VERSION )
public class TenCore
{
	public static final String MODID = "tencore";
	public static final String NAME = "TenCore";
	public static final String UPDATEURL = "https://raw.githubusercontent.com/TakeTenGaming/TenCore/master/VERSION.md";
	public static final String VERSION = "1.0.0";

	@Mod.Instance
	public static TenCore instance;

	public static Logger logger = new Logger ( "TenCore" );

	public static boolean versionCheckWarned = false;
	public static ArrayList< VersionChecker > versionCheckers = new ArrayList<> ();

	public static void addVersionChecker ( VersionChecker versionChecker )
	{
		versionCheckers.add ( versionChecker );
	}

	@EventHandler
	public void init ( FMLInitializationEvent event )
	{
		Events.init ();

		addVersionChecker ( new VersionChecker ( TenCore.NAME, TenCore.VERSION, TenCore.UPDATEURL ) );

		logger.info ( "Hellooooo Minecraft!" );
	}

	@EventHandler
	public void postInit ( FMLPostInitializationEvent event )
	{
		for ( VersionChecker versionChecker : versionCheckers )
		{
			Thread versionCheckThread = new Thread ( versionChecker, versionChecker.getModId () + " Version Check" );
			versionCheckThread.start ();
		}
	}
}
