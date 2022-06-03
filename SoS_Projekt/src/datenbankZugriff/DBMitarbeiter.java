package datenbankZugriff;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import daten.Mitarbeiter;
import daten.MitarbeiterVerwaltung;

public class DBMitarbeiter {
	
	
public static void loadMitarbeiter() {
		
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
			result = stm.executeQuery("SELECT id, vorname, nachname, passwort FROM mitarbeiter");
			
			while(result.next()) {
				
				int id = result.getInt("id");
				String nachname = result.getString("nachname");
				String vorname = result.getString("vorname");
				String passwort = result.getString("passwort");
				
				Mitarbeiter ma = new Mitarbeiter(id, vorname, nachname, passwort);
				System.out.println(ma);
				MitarbeiterVerwaltung.addMitarbeiter(ma);
			}
			
			connect.close();
			System.out.println("\nDisconnected from database");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
