package taketengaming.tencore;

import org.apache.commons.io.IOUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by Acid on 1/19/2017.
 */
public class VersionChecker implements Runnable
{
	private String currentVersion;
	private boolean isLatestVersion = false;
	private String latestVersion;
	private Logger logger = new Logger ( TenCore.NAME + " VersionChecker" );
	private String modId;
	private String status;
	private String versionUrl;

	public VersionChecker ( String modId, String currentVersion, String versionUrl )
	{
		this.setModId ( modId );
		this.setCurrentVersion ( currentVersion );
		this.setVersionUrl ( versionUrl );
	}

	public String getCurrentVersion ()
	{
		return this.currentVersion;
	}

	public String getLatestVersion ()
	{
		return this.latestVersion;
	}

	public String getModId ()
	{
		return this.modId;
	}

	public String getStatus ()
	{
		return this.status;
	}

	public String getVersionUrl ()
	{
		return this.versionUrl;
	}

	public boolean isLatestVersion ()
	{
		return this.isLatestVersion;
	}

	@Override
	public void run ()
	{
		logger.info ( "Beginning version check.." );

		InputStream in;

		if ( this.getVersionUrl ().equals ( "" ) )
		{
			logger.info ( "No version URL specified for " + this.getModId () );
			return;
		}

		try
		{
			in = new URL ( this.getVersionUrl () ).openStream ();
			this.setLatestVersion ( IOUtils.readLines ( in ).get ( 0 ) );
			this.setIsLatestVersion ( this.getCurrentVersion ().equals ( this.getLatestVersion () ) );

			if ( this.isLatestVersion () )
			{
				logger.info ( this.getModId () + " is up to date!" );
			}
			else
			{
				logger.info ( "Current version: " + this.getCurrentVersion () );
				logger.info ( "Latest version: " + this.getLatestVersion () );

				int strippedCurrentVersion = Integer.parseInt ( this.getCurrentVersion ().replace ( ".", "" ) );
				int strippedLatestVersion = Integer.parseInt ( this.getLatestVersion ().replace ( ".", "" ) );

				if ( strippedCurrentVersion > strippedLatestVersion )
				{
					this.setStatus ( "AHEAD" );
				}
				else
				{
					this.setStatus ( "BEHIND" );
				}

				logger.info ( "Status: " + this.getStatus () );
			}
		}
		catch ( FileNotFoundException exception )
		{
			logger.error ( "The specified version file could not be found: " + this.getVersionUrl () );
		}
		catch ( IOException exception )
		{
			logger.error ( "An error occurred:" );
			exception.printStackTrace ();
		}
	}

	private void setCurrentVersion ( String currentVersion )
	{
		this.currentVersion = currentVersion;
	}

	private void setIsLatestVersion ( boolean isLatestVersion )
	{
		this.isLatestVersion = isLatestVersion;
	}

	private void setLatestVersion ( String latestVersion )
	{
		this.latestVersion = latestVersion;
	}

	private void setModId ( String modId )
	{
		this.modId = modId;
	}

	private void setStatus ( String status )
	{
		this.status = status;
	}

	private void setVersionUrl ( String versionUrl )
	{
		this.versionUrl = versionUrl;
	}
}