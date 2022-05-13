package datenbankZugriff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBKunde {

	public static void main(String[] args) {

		String url = "jdbc:mysql://3.69.96.96:3306/";
		String dbName = "db3";
		String userName = "db3";
		String driver = "com.mysql.cj.jdbc.Driver";
		String password = "!db3.winf22?";

		try {
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

}
