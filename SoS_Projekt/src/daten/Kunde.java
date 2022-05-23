package daten;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import datenbankZugriff.DBKunde;

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
	
	public Kunde(String name, String email, String telefon, String bezahlmethode, String geburtstag,
			Adresse adresse) {
		this.name = name;
		this.email = email;
		this.telefon = telefon;
		this.adresse = adresse;
		this.bezahlmethode = bezahlmethode;
		//this.kundennummer = kundennummer;
		this.geburtstag = geburtstag;
//		kundenCheck(this);
	}

//	public void kundenCheck(Kunde kunde) {
//
//		boolean pruefen = true;
//
//		for (Kunde einzelnerKunde : kunden) {
//			if (kunde.kundennummer == einzelnerKunde.kundennummer) {
//				pruefen = false;
//			}
//		}
//		if (pruefen) {
//			kunden.add(kunde);
//		}
//	}



	public void kundeloeschen(String kundenummer) throws SQLException, ClassNotFoundException, IOException {
		
		DBKunde dbKunde = new DBKunde();
		dbKunde.kundeloeschen(kundenummer);
	}

	public void kundeanlegen(String kundenNr, String name, String email, String telefon, String bezahlmethode, String geburtstag,
			Adresse adresse) throws SQLException, ClassNotFoundException, IOException {

		DBKunde dbKunde = new DBKunde();
		dbKunde.kundeanlegen(kundenNr, name, email, telefon, bezahlmethode, geburtstag, adresse);
		
	}

	public void kundenEdit(Kunde kunde) throws ClassNotFoundException, SQLException, IOException {

		DBKunde dbKunde = new DBKunde();
		dbKunde.kundenEdit(kunde);

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

	public String getName() {
		return name;
	}

	public String getGeburtstag() {
		return geburtstag;
	}
	
	

//	public static ArrayList<Kunde> getKunden() {
//		return kunden;
//	}

}
