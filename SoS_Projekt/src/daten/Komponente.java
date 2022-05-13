package daten;

public class Komponente {
	
	private int artikelnummer; 
	private String art; 
	private int anzahl;
	private String name;
	private String beschreibung; 
	private double preis;
	
	public Komponente(int artikelnummer, String art, int anzahl, String name, String beschreibung, double preis) {
		this.artikelnummer = artikelnummer;
		this.art = art;
		this.anzahl = anzahl;
		this.name = name;
		this.beschreibung = beschreibung;
		this.preis = preis;
	}

	public int getArtikelnummer() {
		return artikelnummer;
	}

	public void setArtikelnummer(int artikelnummer) {
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
	
	

	
	

}
