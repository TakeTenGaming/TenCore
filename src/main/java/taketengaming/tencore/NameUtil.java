package taketengaming.tencore;

/**
 * Created by Acid on 1/19/2017.
 */
public class NameUtil
{
	/**
	 * Get the name of something in Minecraft 1.10
	 *
	 * @param name
	 *
	 * @return string
	 */
	public static String getNameLegacy ( String name )
	{
		return name.toLowerCase ().replace ( " ", "" );
	}

	/**
	 * Get the name of something in Minecraft 1.11
	 *
	 * @param name
	 *
	 * @return string
	 */
	public static String getName ( String name )
	{
		return name.toLowerCase ().replace ( " ", "_" );
	}
}
