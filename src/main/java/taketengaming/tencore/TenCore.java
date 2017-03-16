package taketengaming.tencore;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import taketengaming.tencore.register.Commands;

@Mod( acceptedMinecraftVersions = "[1.10,]", modid = TenCore.MODID, name = TenCore.NAME, version = TenCore.VERSION, updateJSON = TenCore.UPDATEURL )
public class TenCore
{
	public static final String MODID = "tencore";
	public static final String NAME = "TenCore";
	public static final String UPDATEURL = "https://raw.githubusercontent.com/TakeTenGaming/TenCore/master/versions.json";
	public static final String VERSION = "1.1.0";

	@Mod.Instance
	public static TenCore instance;

	public static Logger logger = new Logger ( "TenCore" );

	@EventHandler
	public void init ( FMLInitializationEvent event )
	{
		logger.debug ( "Heeeelllooo Minecraft!" );
	}

	@EventHandler
	public void serverStarting ( FMLServerStartingEvent event )
	{
		logger.debug ( "Server starting.." );
		Commands.serverStarting ( event );
	}
}