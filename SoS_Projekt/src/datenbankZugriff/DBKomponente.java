package datenbankZugriff;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Properties;

import daten.Auftrag;
import daten.Komponente;

public class DBKomponente {

	public static void loadKomponenten() {

		Connection connect = null;

		try {

			// Properties-Datei einlesen
			File propertiesFile = new File("props.properties");
			FileInputStream in = new FileInputStream(propertiesFile);
			Properties properties = new Properties();
			properties.load(in);
			in.close();

			// Properties übertragen
			String url = properties.getProperty("db.url");
			String dbName = properties.getProperty("db.dbName");
			String userName = properties.getProperty("db.userName");
			String driver = properties.getProperty("db.driver");
			String password = properties.getProperty("db.password");

			Class.forName(driver);
			connect = DriverManager.getConnection(url + dbName, userName, password);
			System.out.println("Connected to the database\n");

			Statement stm = connect.createStatement();
			ResultSet result;
			result = stm.executeQuery(
					"SELECT artikelnummer, name, hersteller, preis, art, anzahl, beschreibung FROM komponenten");

			while (result.next()) {
				String artikelnummer = result.getString("artikelnummer");
				String name = result.getString("name");
				String hersteller = result.getString("hersteller");
				double preis = result.getDouble("preis");
				String art = result.getString("art");
				int anzahl = result.getInt("anzahl");
				String beschreibung = result.getString("beschreibung");

				Komponente k = new Komponente(artikelnummer, art, anzahl, name, hersteller, beschreibung, preis);
				//Komponente.artikelnummerGenerate(k);
				
				daten.KomponentenListe.addKomponente(k);;
				//LinkedList<Komponente> komponentenliste = new LinkedList<>();

			}

			// Static int nextNumber laden und in Komponente speichern
			connect.close();
			System.out.println("\nDisconnected from database");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void uploadKomponente(Komponente komponente) {
		
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

			String query = "INSERT INTO komponenten (artikelnummer, name, hersteller, preis, art, anzahl, beschreibung) VALUES ('"
					+ komponente.getArtikelnummer() + "','" 
					+ komponente.getName() + "','" 
					+ komponente.getHersteller() + "','" 
					+ komponente.getPreis() + "','" 
					+ komponente.getArt() + "','" 
					+ komponente.getAnzahl() + "','" 
					+ komponente.getBeschreibung() + "')";
			
			stm.execute(query);
			stm.close();
			connect.close();
			System.out.println("\nDisconnected from database");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteKomponente(String artikelnummer ) throws SQLException, ClassNotFoundException, IOException {

		// Properties-Datei einlesen
		File propertiesFile = new File("props.properties");
		FileInputStream in = new FileInputStream(propertiesFile);
		Properties properties = new Properties();
		properties.load(in);
		in.close();

		// Properties übertragen
		String url = properties.getProperty("db.url");
		String dbName = properties.getProperty("db.dbName");
		String userName = properties.getProperty("db.userName");
		String driver = properties.getProperty("db.driver");
		String password = properties.getProperty("db.password");

		Class.forName(driver);
		Connection verbindung = DriverManager.getConnection(url + dbName, userName, password);
		System.out.println("Connected to the database!\n");
		Statement abfrageAnweisung = verbindung.createStatement();

		String loeschen = "DELETE FROM komponenten WHERE artikelnummer=" + artikelnummer;
		System.out.println(abfrageAnweisung.executeUpdate(loeschen));
		System.out.println(artikelnummer);
		abfrageAnweisung.close();
		
		
		
	}
}
