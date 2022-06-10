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
	private String bezahlmethode, telefon, kundennummmer;
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
		this.kundennummmer = kundennummer;
		this.geburtstag = geburtstag;

	}

	public Kunde(String name, String email, String telefon, String bezahlmethode, String geburtstag, Adresse adresse) {

		this.name = name;
		this.email = email;
		this.telefon = telefon;
		this.adresse = adresse;
		this.bezahlmethode = bezahlmethode;
		this.geburtstag = geburtstag;
		kundennummmer = this.nextKundenNummer;
		this.nextKundenNummer = kundenummer(this.nextKundenNummer);
	}

	public static void kundencheck(Kunde neuerKunde) {
		boolean vorhanden = true;
		if (kunden.size() != 0) {
			for (Kunde kunde : kunden) {
				if (kunde.getKundenNummer().equals(neuerKunde.getKundenNummer())) {
					vorhanden = false;
					System.out.println("Warnung: Doppelter Kunde angelegt!");
				}

			}
			if (vorhanden) {
				kunden.add(neuerKunde);
			}
		} else {
			kunden.add(neuerKunde);
		}

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
		String kundenNr = kunde.kundennummmer;
		String geburtstag = kunde.getGeburtstag();
		kunden.add(new Kunde(name, email, telefon, bezahlmethode, geburtstag, adresse));

		dbKunde.kundeanlegen(kundenNr, name, email, telefon, bezahlmethode, geburtstag, adresse);

	}

	public void kundenEdit(Kunde kunde) throws ClassNotFoundException, SQLException, IOException {

		dbKunde.kundenEdit(kunde);

	}
	
	

	@Override
	public String toString() {
		return kundennummmer + ", " + name;
	}

	public static ArrayList<Kunde> getKunden() {
		return kunden;
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
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getGeburtstag() {
		return geburtstag;
	}

	public String getKundenNummer() {
		return this.kundennummmer;
	}

	public void setKundenNummer(String KundenNummer) {
		this.kundennummmer = nextKundenNummer;
	}

	public static void setNextKundenNummer(String nextKundenNummer) {
		Kunde.nextKundenNummer = nextKundenNummer;
	}

	public static Kunde getKunde(String kundenNummer) {

		for (int i = 0; i < kunden.size(); i++) {
			if (kunden.get(i).getKundenNummer().equals(kundenNummer)) {
				return kunden.get(i);
			}
		}
		return null;
	}

	public static String kundenummer(String kennzahl) {

		String[] kennzahlenSplit = kennzahl.split("K");
		String regex = "\\d+";
		int result = 0;
		for (int i = 0; i < kennzahlenSplit.length; i++) {
			if (kennzahlenSplit[i].matches(regex)) {
				result = Integer.parseInt(kennzahlenSplit[i]) + 1;
			}

		}

		return "K" + Integer.toString(result);

	}

}
