package datenbankZugriff;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import daten.Adresse;
import daten.Kunde;

public class DBKunde {

	Connection connect = null;
	
	public static void loadKunden() {
		
		
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
			
			Class.forName(driver);
			Connection verbindung = null;
			verbindung = DriverManager.getConnection(url + dbName, userName, password);
			System.out.println("Connected to the database!\n");
			Statement abfrageAnweisung = null;

			abfrageAnweisung = verbindung.createStatement();

			ResultSet ergebnis;
			ergebnis = abfrageAnweisung.executeQuery(
					"SELECT KundenNummer, Name, Email, Telefon, Strasse, Nr, Ort, Geburtstag,plz, BezahlOption FROM kunden");

			while (ergebnis.next()) {

				int kundenNummer = ergebnis.getInt("KundenNummer");
				String name = ergebnis.getString("Name");
				String e_Mail = ergebnis.getString("Email");
				int telefon = ergebnis.getInt("Telefon");
				String strase = ergebnis.getString("Strasse");
				int nr = ergebnis.getInt("Nr");
				String ort = ergebnis.getString("Ort");
				String geburtstag = ergebnis.getString("Geburtstag");
				int plz = ergebnis.getInt("plz");
				String bezahlmethode = ergebnis.getString("BezahlOption");
				int bezahlmethodeInt = 0;

				if (bezahlmethode.equals("Paypal")) {
					bezahlmethodeInt = 1;
				} else if (bezahlmethode.equals("Rechnung")) {
					bezahlmethodeInt = 2;
				} else if (bezahlmethode.equals("Lastschrift")) {
					bezahlmethodeInt = 3;
				}

				// Kunde kunde = new Kunde(kundenNummer, name, e_Mail , telefon,
				// bezahlmethodeInt, geburtstag,new Adresse(stra e, ort, plz, nr));

				System.out.println("KundenNummer." + kundenNummer + " Name: " + name + ", Email: " + e_Mail
						+ ", Telefon" + telefon + ", strasse " + strase + " " + nr + ", plz" + plz + ", geburtstag : "
						+ geburtstag + ", bezahlmethode " + bezahlmethodeInt);
			}

			verbindung.close();
			System.out.println("\nDisconnected from database!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Fehler bei der Verbindung!");
		}
	}
	public void kundenEdit(Kunde kunde) throws ClassNotFoundException, SQLException, IOException {
		
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

		Class.forName(driver);
		Connection verbindung = DriverManager.getConnection(url + dbName, userName, password);
		System.out.println("Connected to the database!\n");
		Statement abfrageAnweisung = verbindung.createStatement();

		String update = "UPDATE kunden SET Name='" + kunde.getName() + "' ,Email= '" + kunde.getEmail() + "' ,Telefon='" + kunde.getTelefon()
				+ "' ,Strasse='" + kunde.getAdresse().getStrasse() + "' ,Nr='" + kunde.getAdresse().getNr() + "' ,Ort='" + kunde.getAdresse().getOrt()
				+ "' ,Geburtstag='" + kunde.getGeburtstag() + "' ,plz='" + kunde.getAdresse().getPlz() + "' ,BezahlOption='" + kunde.getBezahlmethode()+"'" 
				+ " WHERE KundenNummer=" + kunde.getKundennummer();
		abfrageAnweisung.execute(update);
		abfrageAnweisung.close();
	}
	
	public void kundeanlegen(String kundenNr, String name, String email, String telefon, String bezahlmethode, String geburtstag,
			Adresse adresse) throws SQLException, ClassNotFoundException, IOException {

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
				
		Class.forName(driver);
		Connection verbindung = DriverManager.getConnection(url + dbName, userName, password);
		System.out.println("Connected to the database!\n");
		Statement abfrageAnweisung = verbindung.createStatement();

		
		String query = "INSERT INTO kunden (KundenNummer, Name, Email, Telefon, Strasse, Nr, Ort, Geburtstag,plz, BezahlOption) VALUES ('"
				+ kundenNr + "','" + name + "','" + email + "','" + telefon + "','" + adresse.getStrasse() + "','"
				+ adresse.getNr() + "','" + adresse.getOrt() + "','" + geburtstag + "','" + adresse.getPlz() + "','"
				+ bezahlmethode + "')";
		abfrageAnweisung.execute(query);
		abfrageAnweisung.close();
	}
	
	public void kundeloeschen(String kundenummer) throws SQLException, ClassNotFoundException, IOException {
		
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
		
		
		Class.forName(driver);
		Connection verbindung = DriverManager.getConnection(url + dbName, userName, password);
		System.out.println("Connected to the database!\n");
		Statement abfrageAnweisung = verbindung.createStatement();

		String loeschen = "DELETE FROM kunden WHERE KundenNummer=" + kundenummer;
		abfrageAnweisung.execute(loeschen);
		abfrageAnweisung.close();
	}

}
