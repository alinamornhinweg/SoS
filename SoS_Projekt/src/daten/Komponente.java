package daten;

public class Komponente {
	
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
	
	public Komponente(String artikelnummer, String art, int anzahl, String name, String hersteller, String beschreibung, double preis) {
		this.artikelnummer = artikelnummer;
		this.art = art;
		this.anzahl = anzahl;
		this.name = name;
		this.hersteller = hersteller;
		this.beschreibung = beschreibung;
		this.preis = preis;
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
	
	
	private static int nextNum = 1000;
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
			
			
		}else if (art.equals("RAM")) {
			artikelnummer = "20" + nextNum;
		}else if(art.equals("SSD")) {
			artikelnummer = "30" + nextNum;

		}else if(art.equals("HDD")) {
			artikelnummer = "40" + nextNum;

		}else if(art.equals("Grafikkarte")) {
			artikelnummer = "50" + nextNum;

		}else if(art.equals("Prozesslüfter")) {
			artikelnummer = "60" + nextNum;

		}else if(art.equals("Netzteil")) {
			artikelnummer = "70" + nextNum;

		}else if(art.equals("Gehäuse")) {
			artikelnummer = "80" + nextNum;
		}else {
			artikelnummer = "90" + nextNum;
		}
		nextNum++;
		return artikelnummer;
		
	}
	

	
	

}
