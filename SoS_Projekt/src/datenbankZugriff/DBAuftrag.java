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


public class DBAuftrag {
	
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
