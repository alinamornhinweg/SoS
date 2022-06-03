package datenbankZugriff;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import daten.Komponente;
import daten.KomponentenListe;
import daten.Rechner;


public class DBRechner {
	
	public static void loadRechner() {

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
			result = stm.executeQuery("SELECT id, cpu, ram, festplatte1, festplatte2, grafikkarte, kuehlung, netzteil, gehaeuse FROM rechner");

			while (result.next()) {
				
				boolean isFestplatte2 = result.getString("festplatte2") != null || result.getString("festplatte2").isEmpty();
				
				String id = result.getString("id");
				Komponente cpu = KomponentenListe.getKomponente(result.getString("cpu"));
				Komponente ram = KomponentenListe.getKomponente(result.getString("ram"));
				Komponente festplatte1 = KomponentenListe.getKomponente(result.getString("festplatte1"));
				Komponente festplatte2;
				Komponente grafikkarte = KomponentenListe.getKomponente(result.getString("grafikkarte"));
				Komponente kuehlung = KomponentenListe.getKomponente(result.getString("kuehlung"));
				Komponente netzteil = KomponentenListe.getKomponente(result.getString("netzteil"));
				Komponente gehaeuse = KomponentenListe.getKomponente(result.getString("gehaeuse"));
				
				Rechner rechner;
				
				if(isFestplatte2) {
					festplatte2 = KomponentenListe.getKomponente(result.getString("festplatte2"));
					rechner = new Rechner(id, cpu, ram, festplatte1, festplatte2, grafikkarte, kuehlung, netzteil, gehaeuse);
				}else {
					rechner = new Rechner(id, cpu, ram, festplatte1, grafikkarte, kuehlung, netzteil, gehaeuse);
				}
				
				Rechner.addRechner(rechner);
			}

			// Static int nextNumber laden und in Komponente speichern
			connect.close();
			System.out.println("\nDisconnected from database");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	public static void uploadRechner(Rechner rechner) {

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
					"SELECT id, cpu, ram, festplatte1, festplatte2, grafikkarte, kuehlung, netzteil, gehaeuse * FROM rechner");

			while (result.next()) {
				
				boolean isFestplatte2 = result.getString("festplatte2") != null || result.getString("festplatte2").isEmpty();
				
				String id = result.getString("id");
				Komponente cpu = KomponentenListe.getKomponente(result.getString("cpu"));
				Komponente ram = KomponentenListe.getKomponente(result.getString("ram"));
				Komponente festplatte1 = KomponentenListe.getKomponente(result.getString("festplatte1"));
				Komponente festplatte2;
				Komponente grafikkarte = KomponentenListe.getKomponente(result.getString("grafikkarte"));
				Komponente kuehlung = KomponentenListe.getKomponente(result.getString("kuehlung"));
				Komponente netzteil = KomponentenListe.getKomponente(result.getString("netzteil"));
				Komponente gehaeuse = KomponentenListe.getKomponente(result.getString("gehaeuse"));
				
				Rechner rechner;
				
				if(isFestplatte2) {
					festplatte2 = KomponentenListe.getKomponente(result.getString("festplatte2"));
					rechner = new Rechner(id, cpu, ram, festplatte1, festplatte2, grafikkarte, kuehlung, netzteil, gehaeuse);
				}else {
					rechner = new Rechner(id, cpu, ram, festplatte1, grafikkarte, kuehlung, netzteil, gehaeuse);
				}
				
				Rechner.addRechner(rechner);
			}

			// Static int nextNumber laden und in Komponente speichern
			connect.close();
			System.out.println("\nDisconnected from database");
		} catch (Exception e) {
			e.printStackTrace();
		}
}*/
}
