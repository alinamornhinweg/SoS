package daten;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import datenbankZugriff.DBKunde;
import datenbankZugriff.DBProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Diese Klasse verwaltet alle Kunden-Objekte.
 * @author emreekinci
 *
 */
public class Kunde {

	private String name, email, geburtstag;
	private Adresse adresse;
	private String bezahlmethode, telefon, kundennummmer;
	DBKunde dbKunde = new DBKunde();
	private static String nextKundenNummer = "1000";
	
	/**
	 * 
	 * @return ID des nächsten Kunden das erstellt wird
	 */

	public static String getNextKundenNummer() {
		return nextKundenNummer;
	}

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
		kundennummmer =  "K" +this.nextKundenNummer;
		this.nextKundenNummer = kundenummer(this.nextKundenNummer);
	}
	
	/**Prüft ob der Kunde ein neuer Kunde ist und speichert ihn ab Validierung ab
	 * @param neuerKunde
	 * 
	 */

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
	/**
	 * verweist auf Methode in DBKunde.java um den Kunden zu löschen
	 * 
	 * @param kundenummer
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */

	public void kundeloeschen(String kundenummer) throws SQLException, ClassNotFoundException, IOException {

		dbKunde.kundeloeschen(kundenummer);
	}
	
	/**
	 * 
	 * verweist auf Methode in DBKunde.java um den Kunden mittels einzelne Parameter anzulegen
	 * 
	 * @param kundenNr
	 * @param name
	 * @param email
	 * @param telefon
	 * @param bezahlmethode
	 * @param geburtstag
	 * @param adresse
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */

	public void kundeanlegen(String kundenNr, String name, String email, String telefon, String bezahlmethode,
			String geburtstag, Adresse adresse) throws SQLException, ClassNotFoundException, IOException {
		kunden.add(new Kunde(name, email, telefon, bezahlmethode, geburtstag, adresse));

		dbKunde.kundeanlegen(kundenNr, name, email, telefon, bezahlmethode, geburtstag, adresse);

	}
	
	/**
	 *  verweist auf Methode in DBKunde.java um den Kunden mittels eines Kunden Parameter anzulegen
	 * 
	 * @param kunde
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */

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
	
	/**
	 * verweist auf Methode in DBKunde.java um den Kunden zu editieren
	 * 
	 * @param kunde
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */

	public void kundenEdit(Kunde kunde) throws ClassNotFoundException, SQLException, IOException {

		dbKunde.kundenEdit(kunde);

	}
	
	

	@Override
	public String toString() {
		return kundennummmer + ", " + name;
	}
	
	/**
	 * 
	 * @return liste von Kunden
	 */

	public static ArrayList<Kunde> getKunden() {
		return kunden;
	}
	
	/**
	 * 
	 * @return email des Kunden
	 */

	public String getEmail() {
		return email;
	}
	
	/**
	 * Setzt eine Email für den Kunden fest
	 * @param email
	 */

	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * 
	 * @return Telefonnummer des Kunden
	 */

	public String getTelefon() {
		return telefon;
	}

	/**
	 * Setzt eine Telefonnummer für den Kunden fest
	 * @param telefon
	 */
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	/**
	 * 
	 * @return Adresse des Kunden
	 */
	
	public Adresse getAdresse() {
		return adresse;
	}
	
	/**
	 * Setzt eine Adresse für den Kunden fest
	 * @param adresse
	 */

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	/**
	 * 
	 * @return Bezahlmethode des Kunden
	 */

	public String getBezahlmethode() {
		return bezahlmethode;
	}
	/**
	 * Setzt eine Bezahlmethode für den Kunden fest
	 * @param bezahlmethode
	 */

	public void setBezahlmethode(String bezahlmethode) {
		this.bezahlmethode = bezahlmethode;
	}
	
	/**
	 * Setzt eine Name für den Kunden fest
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @return Name des Kunden
	 */

	public String getName() {
		return name;
	}
	/**
	 * 
	 * @return Geburtstag des Kunden
	 */

	public String getGeburtstag() {
		return geburtstag;
	}
	
	/**
	 * 
	 * @return Kundennummer des Kunden
	 */

	public String getKundenNummer() {
		return this.kundennummmer;
	}
	

	/**
	 * Setzt eine Kundennumer für den nächsten Kunden fest
	 * @param nextKundenNummer
	 */

	public static void setNextKundenNummer(String nextKundenNummer) {
		Kunde.nextKundenNummer = nextKundenNummer;
	}
	
	/**
	 * 
	 * @param kundenNummer
	 * @return Kunde
	 */

	public static Kunde getKunde(String kundenNummer) {

		for (int i = 0; i < kunden.size(); i++) {
			if (kunden.get(i).getKundenNummer().equals(kundenNummer)) {
				return kunden.get(i);
			}
		}
		return null;
	}
	/**
	 * Kundennummer wird hier hochgezählt und in die DatenBank hochgeladen
	 * @param kennzahl
	 * @return kundenummer
	 */

	public static String kundenummer(String kennzahl) {
		
		int result =Integer.parseInt(Kunde.nextKundenNummer) +1;
		DBProperties.uploadKundeNextNumber();
		return Integer.toString(result);

	

	}

}
