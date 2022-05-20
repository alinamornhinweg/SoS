package datenbankZugriff;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Properties;

public class DBMetaDaten {
	
public static void loadMetaDaten() {
		
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
			result = stm.executeQuery("SELECT * FROM metadaten");
			
			while(result.next()) {
				
				String key = result.getString("key");
				String pValue = result.getString("pValue");
				
				try {
					
				switch(key) {
				case "KomponenteNextNumber": daten.Komponente.setNextNum(Integer.valueOf(pValue) );
					break;
				}
				} catch(InputMismatchException | NumberFormatException e) {
					System.out.println(e);
				}
				
				System.out.println("loaded key:" + key + ", -> " + pValue);
			}
			
			connect.close();
			System.out.println("\nDisconnected from database");
		}catch (Exception e) {
			e.printStackTrace();
		}
}

public static void uploadKomponteNextNumber(int nextNumber) {
	//Hier Code
	
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
		
		//Upload
		/*
		 * 		
		Class.forName(driver);
		Connection verbindung = null;
		verbindung = DriverManager.getConnection(url + dbName, userName, password);
		System.out.println("Connected to the database!\n");
		Statement abfrageAnweisung = verbindung.createStatement();

		// (KundenNummer, Name, Email, Telefon, Strasse, Nr, Ort, Geburtstag,plz,
		// BezahlOption)

		String update = "UPDATE kunden SET Name='" + name + "' ,Email= '" + email + "' ,Telefon='" + telefon
				+ "' ,Strasse='" + adresse.getStrasse() + "' ,Nr='" + adresse.getNr() + "' ,Ort='" + adresse.getOrt()
				+ "' ,Geburtstag='" + geburtstag + "' ,plz='" + adresse.getPlz() + "' ,BezahlOption='" + bezahlmethodeString+"'" 
				+ " WHERE KundenNummer=" + kundenNr;
		abfrageAnweisung.execute(update);
		abfrageAnweisung.close();
		 */
		
		Statement stm = connect.createStatement();
		ResultSet result;
		result = stm.executeQuery("SELECT * FROM metadaten");
		
		while(result.next()) {
			
			String key = result.getString("key");
			String pValue = result.getString("pValue");
			
			try {
				
			switch(key) {
			case "KomponenteNextNumber": daten.Komponente.setNextNum(Integer.valueOf(pValue) );
				break;
			}
			} catch(InputMismatchException | NumberFormatException e) {
				System.out.println(e);
			}
			
			System.out.println("loaded key:" + key + ", -> " + pValue);
		}
		
		connect.close();
		System.out.println("\nDisconnected from database");
	}catch (Exception e) {
		e.printStackTrace();
	}
}
}