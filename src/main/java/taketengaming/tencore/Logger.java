package taketengaming.tencore;

import org.apache.logging.log4j.LogManager;

/**
 * Created by Acid on 1/13/2017.
 */
public class Logger
{
	private org.apache.logging.log4j.Logger logger;

	public Logger ()
	{
		this.logger = LogManager.getLogger ( "Logger" );
	}

	public Logger ( String name )
	{
		this.logger = LogManager.getLogger ( name );
	}

	public void debug ( String message )
	{
		if ( System.getProperty ( "debug" ) != null )
		{
			this.logger.debug ( message );
		}
	}

	public void error ( String message )
	{
		this.logger.error ( message );
	}

	public void info ( String message )
	{
		this.logger.info ( message );
	}

	public void warn ( String message )
	{
		this.logger.warn ( message );
	}
}
