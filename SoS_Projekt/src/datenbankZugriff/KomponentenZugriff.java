package datenbankZugriff;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Properties;

import daten.Komponente;

public class KomponentenZugriff {

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
				
				daten.KomponentenListe.getKomponentenliste().add(k);
				//LinkedList<Komponente> komponentenliste = new LinkedList<>();

			}

			// Static int nextNumber laden und in Komponente speichern
			connect.close();
			System.out.println("\nDisconnected from database");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
