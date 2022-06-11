package datenbankZugriff;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import daten.Adresse;
import daten.Auftrag;
import daten.Kunde;
import daten.Rechner;

/**
 * Diese Klasse ist für Datenbankzugriffe mit der Klasse @Auftrag zuständig.
 * @author julianraubald
 *
 */
public class DBAuftrag {
	
	/**
	 * Lädt alle @Auftrag Objekte aus der Datenbank herunter und fügt der @Daten.Auftrag.auftraege Liste hinzu.
	 */
public static void loadAuftraege() {
		
		Connection connect = null;

		try {
			
			//Properties-Datei einlesen
			File propertiesFile = new File("props.properties");	
			FileInputStream in = new FileInputStream(propertiesFile);
			Properties properties = new Properties();
			properties.load(in);
			in.close();
			
			//Properties übertragen 
			String url = properties.getProperty("db.url");
			String dbName = properties.getProperty("db.dbName");
			String userName = properties.getProperty("db.userName");
			String driver = properties.getProperty("db.driver");
			String password = properties.getProperty("db.password");
			
			//mysql-connector-java-8.0.19.jar über Project —> Properties —> Java Build Spatz —> Libaries —> Add External Jars einbinden
			Class.forName(driver);
			connect = DriverManager.getConnection(url + dbName, userName, password);
			System.out.println("Connected to the database\n");
			
			Statement stm = connect.createStatement();
			ResultSet result;
			result = stm.executeQuery("SELECT rechner, kunde, auftragsNummer, status FROM auftraege");
			
			while(result.next()) {
				
				String auftragsNummer = result.getString("auftragsNummer");
				Kunde kunde = Kunde.getKunde(result.getString("kunde"));
				Rechner rechner = Rechner.getRechner(result.getString("rechner"));
				//System.out.println("Rechner im Auftrag:" + rechner);
				String status = result.getString("status");
				
				Auftrag auftrag = new Auftrag(rechner, kunde, auftragsNummer, status);
				System.out.println("Auftrag: " + auftrag.getAuftragsNummer());
				Auftrag.addAuftrag(auftrag);
			}
			
			connect.close();
			System.out.println("\nDisconnected from database");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

/**
 * Lädt das @Auftrag Objekt in die Datenbank table auftraege hoch.
 * @param @Auftrag auftrag
 */
public static void uploadAuftrag(Auftrag auftrag) {
	
	Connection connect = null;

	try {
		
		//Properties-Datei einlesen
		File propertiesFile = new File("props.properties");	
		FileInputStream in = new FileInputStream(propertiesFile);
		Properties properties = new Properties();
		properties.load(in);
		in.close();
		
		//Properties übertragen 
		String url = properties.getProperty("db.url");
		String dbName = properties.getProperty("db.dbName");
		String userName = properties.getProperty("db.userName");
		String driver = properties.getProperty("db.driver");
		String password = properties.getProperty("db.password");
		
		//mysql-connector-java-8.0.19.jar über Project —> Properties —> Java Build Spatz —> Libaries —> Add External Jars einbinden
		Class.forName(driver);
		connect = DriverManager.getConnection(url + dbName, userName, password);
		System.out.println("Connected to the database\n");
		
		Statement stm = connect.createStatement();

		String query = "INSERT INTO auftraege (rechner, kunde, auftragsNummer, status) VALUES ('"
				+ auftrag.getRechner().getId() + "','" + auftrag.getKunde().getKundenNummer() + "','" + auftrag.getAuftragsNummer() + "','" + auftrag.getStatus() + "')";
		
		stm.execute(query);
		stm.close();
		connect.close();
		DBProperties.uploadAuftragNextNumber();
		System.out.println("\nDisconnected from database");
	}catch (Exception e) {
		e.printStackTrace();
	}
}
}
