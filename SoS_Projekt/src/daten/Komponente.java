package daten;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import datenbankZugriff.DBKomponente;
import datenbankZugriff.DBProperties;

public class Komponente extends AbstractTableModel{
	
	static ArrayList<Komponente> komponentenListe= (ArrayList<Komponente>) KomponentenListe.getKomponentenListe();
	

	private String artikelnummer;
	private String art;
	private int anzahl;
	private String name;
	private String hersteller;
	private String beschreibung;
	private double preis;

	public Komponente(String art, int anzahl, String name, String hersteller, String beschreibung, double preis) {
		this.artikelnummer = artikelnummerGenerate(art);
		this.art = art;
		this.anzahl = anzahl;
		this.name = name;
		this.hersteller = hersteller;
		this.beschreibung = beschreibung;
		this.preis = preis;
	}

	public Komponente(String artikelnummer, String art, int anzahl, String name, String hersteller, String beschreibung,
			double preis) {
		this.artikelnummer = artikelnummer;
		this.art = art;
		this.anzahl = anzahl;
		this.name = name;
		this.hersteller = hersteller;
		this.beschreibung = beschreibung;
		this.preis = preis;
	}

	public Komponente() {
		// TODO Auto-generated constructor stub
	}

	public String getArtikelnummer() {
		return artikelnummer;
	}

	public void setArtikelnummer(String artikelnummer) {
		this.artikelnummer = artikelnummer;
	}

	public String getArt() {
		return art;
	}

	public void setArt(String art) {
		this.art = art;
	}

	public int getAnzahl() {
		return anzahl;
	}

	public void setAnzahl(int anzahl) {
		this.anzahl = anzahl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHersteller() {
		return hersteller;
	}

	public void setHersteller(String hersteller) {
		this.hersteller = hersteller;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}

	@Override
	public String toString() {
		return "Komponente [artikelnummer=" + artikelnummer + ", art=" + art + ", anzahl=" + anzahl + ", name=" + name
				+ ", beschreibung=" + beschreibung + ", preis=" + preis + "]";
	}

	private static int nextNum;

	public static int getNextNum() {
		return nextNum;
	}

	public static void setNextNum(int nextNum) {
		Komponente.nextNum = nextNum;
	}

	public static String artikelnummerGenerate(String art) {

		String artikelnummer = "";

		if (art.equals("CPU")) {
			artikelnummer = "10" + nextNum;

		} else if (art.equals("RAM")) {
			artikelnummer = "20" + nextNum;
		} else if (art.equals("SSD")) {
			artikelnummer = "30" + nextNum;

		} else if (art.equals("HDD")) {
			artikelnummer = "40" + nextNum;

		} else if (art.equals("Grafikkarte")) {
			artikelnummer = "50" + nextNum;

		} else if (art.equals("Prozesslüfter")) {
			artikelnummer = "60" + nextNum;

		} else if (art.equals("Netzteil")) {
			artikelnummer = "70" + nextNum;

		} else if (art.equals("Gehäuse")) {
			artikelnummer = "80" + nextNum;
		} else {
			artikelnummer = "90" + nextNum;
		}
		nextNum++;
		DBProperties.uploadKomponteNextNumber();
		return artikelnummer;
		
	

	}
	

	

//	void probeKomponenten() {
//		probekomponenten.add(new Komponente("10002", "Rechner", 10, "TEST4", "Hans", "sehr gutes Produkt", 300));
//		probekomponenten.add(new Komponente( "10003", "Rechner", 3, "TEST", "Peter", "macht was es soll", 400));
//	
//	}
	
	public String getColumnName (int column) {
		if (column == 0) return "Arikel Nr.";
		if (column == 1) return "Art";
		if (column == 2) return "Anzahl";
		if (column == 3) return "Name";
		if (column == 4) return "Hersteller";
		if (column == 5) return "Beschreibung";
		if (column == 6) return "Preis";
		throw new IllegalStateException();
	}
	

	public int getColumnCount() {
		return 6;
	}
	

	public int getRowCount() {
		return KomponentenListe.getKomponentenListe().size();
	}
	
	public static void removeRow(int row) {
		KomponentenListe.getKomponentenListe().remove(row);
	}


	public Object getValueAt(int row, int column) {
		Komponente kom = KomponentenListe.getKomponentenListe().get(row);
		if (column == 0) return kom.getArtikelnummer();
		if (column == 1) return kom.getArt();
		if (column == 2) return kom.getAnzahl();
		if (column == 3) return kom.getName();
		if (column == 4) return kom.getHersteller();
		if (column == 5) return kom.getBeschreibung();
		if (column == 6) return kom.getPreis();
		throw new IllegalStateException();
	}
	
	public void addKomponente(Komponente kom) {
		KomponentenListe.getKomponentenListe().add(kom);
		fireTableDataChanged();
		DBKomponente.uploadKomponente(kom);
	}
	
	public static void removeKomponente(String artikelnummer) throws ClassNotFoundException, SQLException, IOException {
		for(int i = 0; i < komponentenListe.size(); i++) {
			if(komponentenListe.get(i).getArtikelnummer().equals(artikelnummer)) {
				komponentenListe.remove(i);
			}
		}
		DBKomponente.deleteKomponente(artikelnummer);
	}

	
	

}
