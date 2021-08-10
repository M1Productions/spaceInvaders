import java.sql.*;
import java.io.*;
import java.util.*;
//org.hsqldb.jdbc.JDBCPool

/**
 * Connection-Pool
 * Verwaltet saemtliche im System verwendeten Connection-Objekte
 */
public class Connections
{
	private static Connection conn       = null;
	private static Properties properties = null;

	private  static void initProperties()
	{


		File propertiesFile = new File("data/Properties.txt");
		properties = new Properties();

		try
		{
			BufferedInputStream bis =
				new BufferedInputStream(
					new FileInputStream(propertiesFile)) ;
			properties.load(bis);
			bis.close();
		} catch (Exception ex) {
			System.err.println("Fehler: Propertiedatei nicht gefunden");
			System.err.println("Das bedeutet, dass die Datei <Properties.txt> v");
			System.err.println("im Arbeitsordner vorhanden sein muss.");
			System.exit(8);
		}
		//System.out.println(properties.getProperty("USER"));
	}



	public static void initConnections()
	{
		initProperties();
		String url    = properties.getProperty("URL")      ;
		String driver = properties.getProperty("DRIVER")   ;
		String user   = properties.getProperty("USER")     ;
		String pwd    = properties.getProperty("PASSWORD") ;

		// Datenbank Connection oeffnen
		try
		{
			Class.forName(driver);
		}
		catch(ClassNotFoundException exc)
		{
			System.err.println("Fehler: Treiber nicht gefunden");
			System.err.println("Das bedeutet, dass die Datei <hsqldb.jar> ");
			System.err.println("nicht im Klassenpfad gefunden wird.");
			System.err.println("Entweder muss der Aufruf angepasst werden oder ");
			System.err.println("die Datei <hsqldb.jar> muss 'erreichbar' in  den  ");
			System.err.println("Systempfad gelegt werden.  ");
			System.exit(1);
		}

		try
		{
			conn = DriverManager.getConnection(url,user,pwd);
		}
		catch(SQLException exc)
		{
			System.err.println("Fehler: Datenbankverbindung konnte nicht aufgebaut werden.");
			System.err.println("Bei Standalone: Es muessen alle anderen Anwendungen gesch lossen werden.");
			System.err.println("Bei Client/Server: Es muss ein Server gestartet werden.");
			System.err.println("Testen Sie den Dateizugriff mit dem Programm 'DatabeseManagerSwing'");
			System.err.println("und uebernehmen Sie ggf. die dort eingetragenen Werte.");
			System.exit(2);
		}
	}

	/**
	 * Connection-Objekt abfragen
	 */
	public static Connection getConnection()
	{
		Connection erg =  conn;
		conn = null;
		return erg;
	}

   /**
    * Connection-Objekt zuruecklegen
	*/
	public static void putConnection(Connection conn)
	{
		Connections.conn = conn;
	}



}
