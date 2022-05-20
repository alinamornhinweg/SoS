package daten;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Kunde {

	private String name, email, geburtstag;
	private Adresse adresse;
	private String bezahlmethode, kundennummer, telefon;
	private final String url = "jdbc:mysql://3.69.96.96:3306/";
	private final String dbName = "db3";
	private final String userName = "db3";
	private final String driver = "com.mysql.cj.jdbc.Driver";
	private final String password = "!db3.winf22?";

//	private static ArrayList<Kunde> kunden = new ArrayList<Kunde>();
//	DB datenBank = new DB();
//
	public Kunde(String kundennummer, String name, String email, String telefon, String bezahlmethode, String geburtstag,
			Adresse adresse) {
		this.name = name;
		this.email = email;
		this.telefon = telefon;
		this.adresse = adresse;
		this.bezahlmethode = bezahlmethode;
		this.kundennummer = kundennummer;
		this.geburtstag = geburtstag;
//		kundenCheck(this);
	}

//	public void kundenCheck(Kunde kunde) {
//
//		boolean pruefen = true;
//
//		for (Kunde einzelnerKunde : kunden) {
//			if (kunde.kundennummer == einzelnerKunde.kundennummer) {
//				pr fen = false;
//			}
//		}
//		if (pruefen) {
//			kunden.add(kunde);
//		}
//	}



	public void kundeloeschen(String kundenummer) throws SQLException, ClassNotFoundException {
		Class.forName(driver);
		Connection verbindung = null;
		verbindung = DriverManager.getConnection(url + dbName, userName, password);
		System.out.println("Connected to the database!\n");
		Statement abfrageAnweisung = verbindung.createStatement();

//		for (Kunde einzelnerKunde : kunden) {
//			if (kundennummer == einzelnerKunde.kundennummer) {
//				kunden.remove(einzelnerKunde);
//			}
//		}

		String loeschen = "DELETE FROM kunden WHERE KundenNummer=" + kundenummer;
		abfrageAnweisung.execute(loeschen);
		abfrageAnweisung.close();

	}

	public void kundeanlegen(String kundenNr, String name, String email, String telefon, String bezahlmethode, String geburtstag,
			Adresse adresse) throws SQLException, ClassNotFoundException {

		Class.forName(driver);
		Connection verbindung = null;
		verbindung = DriverManager.getConnection(url + dbName, userName, password);
		System.out.println("Connected to the database!\n");
		Statement abfrageAnweisung = verbindung.createStatement();

		String bezahlmethodeString = null;

		this.bezahlmethode = bezahlmethode;
		
		String query = "INSERT INTO kunden (KundenNummer, Name, Email, Telefon, Strasse, Nr, Ort, Geburtstag,plz, BezahlOption) VALUES ('"
				+ kundenNr + "','" + name + "','" + email + "','" + telefon + "','" + adresse.getStrasse() + "','"
				+ adresse.getNr() + "','" + adresse.getOrt() + "','" + geburtstag + "','" + adresse.getPlz() + "','"
				+ bezahlmethodeString + "')";
		abfrageAnweisung.execute(query);
		abfrageAnweisung.close();
	}

	public void kundenEdit(Kunde kunde) throws ClassNotFoundException, SQLException {

		Class.forName(driver);
		Connection verbindung = null;
		verbindung = DriverManager.getConnection(url + dbName, userName, password);
		System.out.println("Connected to the database!\n");
		Statement abfrageAnweisung = verbindung.createStatement();

		String update = "UPDATE kunden SET Name='" + kunde.name + "' ,Email= '" + kunde.email + "' ,Telefon='" + telefon
				+ "' ,Strasse='" + kunde.adresse.getStrasse() + "' ,Nr='" + kunde.adresse.getNr() + "' ,Ort='" + kunde.adresse.getOrt()
				+ "' ,Geburtstag='" + kunde.geburtstag + "' ,plz='" + kunde.adresse.getPlz() + "' ,BezahlOption='" + kunde.bezahlmethode+"'" 
				+ " WHERE KundenNummer=" + kunde.kundennummer;
		abfrageAnweisung.execute(update);
		abfrageAnweisung.close();

	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public String getBezahlmethode() {
		return bezahlmethode;
	}

	public void setBezahlmethode(String bezahlmethode) {
		this.bezahlmethode = bezahlmethode;
	}

	public String getKundennummer() {
		return kundennummer;
	}

	public void setKundennummer(String kundennummer) {
		this.kundennummer = kundennummer;
	}

//	public static ArrayList<Kunde> getKunden() {
//		return kunden;
//	}

}
