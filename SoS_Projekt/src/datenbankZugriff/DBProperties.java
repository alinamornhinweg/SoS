package datenbankZugriff;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Properties;

/**
 * Diese Klasse ist für Datenbankzugriffe mit der properties table zuständig.
 * Hier werden wichtige Informationen abgespeichert, welche keine eigenen Tabellen in der DB besitzen.
 * @author julianraubald
 *
 */
public class DBProperties {

	/**
	 * Lädt alle properties als key value paare herunter und fügt sie an den entsprechenden Stellen ein.
	 */
	public static void loadMetaDaten() {

		Connection connect = null;

		try {

			// Properties-Datei einlesen
			File propertiesFile = new File("props.properties");
			FileInputStream in = new FileInputStream(propertiesFile);
			Properties properties = new Properties();
			properties.load(in);
			in.close();

			// Properties uebertragen
			String url = properties.getProperty("db.url");
			String dbName = properties.getProperty("db.dbName");
			String userName = properties.getProperty("db.userName");
			String driver = properties.getProperty("db.driver");
			String password = properties.getProperty("db.password");

			// mysql-connector-java-8.0.19.jar ueber Project —> Properties —> Java Build
			// Spatz —> Libaries —> Add External Jars einbinden
			Class.forName(driver);
			connect = DriverManager.getConnection(url + dbName, userName, password);
			System.out.println("Connected to the database\n");

			Statement stm = connect.createStatement();
			ResultSet result;
			result = stm.executeQuery("SELECT * FROM properties");

			while (result.next()) {

				String key = result.getString("key");
				String pValue = result.getString("pValue");

				try {

					switch (key) {
					case "KomponenteNextNumber":
						daten.Komponente.setNextNum(Integer.valueOf(pValue));
						break;
					case "KundenNextNumber":
						daten.Kunde.setNextKundenNummer(String.valueOf(pValue));
						break;
					case "rechnerNextNumber":
						daten.Rechner.setRechnerNextNumber(Integer.valueOf(pValue));
						break;
					case "AuftragNextNumber":
						daten.Auftrag.setNextNumber(Integer.valueOf(pValue));
						break;
					}
				} catch (InputMismatchException | NumberFormatException e) {
					System.out.println(e);
				}

				System.out.println("loaded key:" + key + ", -> " + pValue);
			}

			connect.close();
			System.out.println("\nDisconnected from database");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Lädt die @Daten.Komponenten.NextNumber in die properties table hoch.
	 */
	public static void uploadKomponteNextNumber() {
		// Hier Code

		Connection connect = null;

		try {

			// Properties-Datei einlesen
			File propertiesFile = new File("props.properties");
			FileInputStream in = new FileInputStream(propertiesFile);
			Properties properties = new Properties();
			properties.load(in);
			in.close();

			// Properties uebertragen
			String url = properties.getProperty("db.url");
			String dbName = properties.getProperty("db.dbName");
			String userName = properties.getProperty("db.userName");
			String driver = properties.getProperty("db.driver");
			String password = properties.getProperty("db.password");

			// mysql-connector-java-8.0.19.jar über Project —> Properties —> Java Build
			// Spatz —> Libaries —> Add External Jars einbinden
			Class.forName(driver);
			connect = DriverManager.getConnection(url + dbName, userName, password);
			System.out.println("Connected to the database\n");

			// Upload
			Statement stm = connect.createStatement();
			
			String update = "UPDATE `db3`.`properties` SET `pValue` = '" + daten.Komponente.getNextNum() +"' WHERE (`key` = 'KomponenteNextNumber')";
			stm.execute(update);

			connect.close();
			System.out.println("\nDisconnected from database");
		} catch (Exception e) {
			e.printStackTrace();
		}}
		
	/**
	 * Lädt die @Daten.Rechner.NextNumber in die properties table hoch.
	 */
		public static void uploadRechnerNextNumber() {
			// Hier Code

			Connection connect = null;

			try {

				// Properties-Datei einlesen
				File propertiesFile = new File("props.properties");
				FileInputStream in = new FileInputStream(propertiesFile);
				Properties properties = new Properties();
				properties.load(in);
				in.close();

				// Properties uebertragen
				String url = properties.getProperty("db.url");
				String dbName = properties.getProperty("db.dbName");
				String userName = properties.getProperty("db.userName");
				String driver = properties.getProperty("db.driver");
				String password = properties.getProperty("db.password");

				// mysql-connector-java-8.0.19.jar über Project —> Properties —> Java Build
				// Spatz —> Libaries —> Add External Jars einbinden
				Class.forName(driver);
				connect = DriverManager.getConnection(url + dbName, userName, password);
				System.out.println("Connected to the database\n");

				// Upload
				Statement stm = connect.createStatement();
				String update = "UPDATE `db3`.`properties` SET `pValue` = '" + daten.Rechner.getRechnerNextNumber() +"' WHERE (`key` = 'RechnerNextNumber')";
				stm.execute(update);

				connect.close();
				System.out.println("\nDisconnected from database");
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
		
		/**
		 * Lädt die @Daten.Auftrag.NextNumber in die properties table hoch.
		 */
		public static void uploadAuftragNextNumber() {
			// Hier Code

			Connection connect = null;

			try {

				// Properties-Datei einlesen
				File propertiesFile = new File("props.properties");
				FileInputStream in = new FileInputStream(propertiesFile);
				Properties properties = new Properties();
				properties.load(in);
				in.close();

				// Properties uebertragen
				String url = properties.getProperty("db.url");
				String dbName = properties.getProperty("db.dbName");
				String userName = properties.getProperty("db.userName");
				String driver = properties.getProperty("db.driver");
				String password = properties.getProperty("db.password");

				// mysql-connector-java-8.0.19.jar über Project —> Properties —> Java Build
				// Spatz —> Libaries —> Add External Jars einbinden
				Class.forName(driver);
				connect = DriverManager.getConnection(url + dbName, userName, password);
				System.out.println("Connected to the database\n");

				// Upload
				Statement stm = connect.createStatement();

				String update = "UPDATE `db3`.`properties` SET `pValue` = '" + daten.Auftrag.getNextNumber() +"' WHERE (`key` = 'AuftragNextNumber')";
				stm.execute(update);

				connect.close();
				System.out.println("\nDisconnected from database");
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
		public static void uploadKundeNextNumber() {
			// Hier Code

			Connection connect = null;

			try {

				// Properties-Datei einlesen
				File propertiesFile = new File("props.properties");
				FileInputStream in = new FileInputStream(propertiesFile);
				Properties properties = new Properties();
				properties.load(in);
				in.close();

				// Properties uebertragen
				String url = properties.getProperty("db.url");
				String dbName = properties.getProperty("db.dbName");
				String userName = properties.getProperty("db.userName");
				String driver = properties.getProperty("db.driver");
				String password = properties.getProperty("db.password");

				// mysql-connector-java-8.0.19.jar über Project —> Properties —> Java Build
				// Spatz —> Libaries —> Add External Jars einbinden
				Class.forName(driver);
				connect = DriverManager.getConnection(url + dbName, userName, password);
				System.out.println("Connected to the database\n");

				// Upload
				Statement stm = connect.createStatement();

				String update = "UPDATE `db3`.`properties` SET `pValue` = '" + daten.Kunde.getNextKundenNummer() +"' WHERE (`key` = 'KundenNextNumber')";
				stm.execute(update);

				connect.close();
				System.out.println("\nDisconnected from database");
			} catch (Exception e) {
				e.printStackTrace();
			}}
	
	
}
