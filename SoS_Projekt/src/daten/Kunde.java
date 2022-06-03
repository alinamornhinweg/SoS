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
	private String bezahlmethode, telefon,Kundennummmer;
	DBKunde dbKunde = new DBKunde();
	private static String nextKundenNummer = "K1000";
	

	private static ArrayList<Kunde> kunden = new ArrayList<Kunde>();

	public Kunde(String kundennummer, String name, String email, String telefon, String bezahlmethode,
			String geburtstag, Adresse adresse) {
		this.name = name;
		this.email = email;
		this.telefon = telefon;
		this.adresse = adresse;
		this.bezahlmethode = bezahlmethode;
		this.nextKundenNummer = kundennummer;
		this.geburtstag = geburtstag;
		
	}

	public Kunde(String name, String email, String telefon, String bezahlmethode, String geburtstag, Adresse adresse) {
		
		this.name = name;
		this.email = email;
		this.telefon = telefon;
		this.adresse = adresse;
		this.bezahlmethode = bezahlmethode;
		this.geburtstag = geburtstag;
		Kundennummmer=this.nextKundenNummer;
		this.nextKundenNummer = kundenummer(this.nextKundenNummer);

	}


	public void kundeloeschen(String kundenummer) throws SQLException, ClassNotFoundException, IOException {

		dbKunde.kundeloeschen(kundenummer);
	}

	public void kundeanlegen(String kundenNr, String name, String email, String telefon, String bezahlmethode,
			String geburtstag, Adresse adresse) throws SQLException, ClassNotFoundException, IOException {
		kunden.add(new Kunde(name, email, telefon, bezahlmethode, geburtstag, adresse));

		dbKunde.kundeanlegen(kundenNr, name, email, telefon, bezahlmethode, geburtstag, adresse);

	}

	public void kundeanlegen(Kunde kunde) throws SQLException, ClassNotFoundException, IOException {

		String name = kunde.getName();
		String email = kunde.getEmail();
		String telefon = kunde.getTelefon();
		Adresse adresse = kunde.getAdresse();
		String bezahlmethode = kunde.getBezahlmethode();
		String kundenNr = kunde.Kundennummmer;
		String geburtstag = kunde.getGeburtstag();
		kunden.add(new Kunde(name, email, telefon, bezahlmethode, geburtstag, adresse));

		dbKunde.kundeanlegen(kundenNr, name, email, telefon, bezahlmethode, geburtstag, adresse);

	}

	public void kundenEdit(Kunde kunde) throws ClassNotFoundException, SQLException, IOException {

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

	public String getName() {
		return name;
	}

	public String getGeburtstag() {
		return geburtstag;
	}

	public String getKundenNummer() {
		return this.Kundennummmer ;
	}

	public void setKundenNummer(String KundenNummer) {
		this.Kundennummmer = nextKundenNummer;
	}
	public static void setNextKundenNummer(String nextKundenNummer) {
		Kunde.nextKundenNummer= nextKundenNummer;
	}

//	public static ArrayList<Kunde> getKunden() {
//		return kunden;
//	}

	public static String kundenummer(String kennzahl) {

		String[] kennzahlenSplit = kennzahl.split("K");

		int result = Integer.parseInt(kennzahlenSplit[1]) + 1;

		return "K" + Integer.toString(result);

	}

	public static void main(String[] args) {

	

		ArrayList<Kunde> kundeTest = new ArrayList<Kunde>();
		kundeTest.add(new Kunde("Test2", "", "", "", "", new Adresse("strase", "", "", "")));
		kundeTest.add(new Kunde("Test3", "", "", "", "", new Adresse("strase", "", "", "")));
		kundeTest.add(new Kunde("Test4", "", "", "", "", new Adresse("strase", "", "", "")));

		kundeTest.stream().forEach(s -> System.out.println(s.getKundenNummer()));

	}

}
