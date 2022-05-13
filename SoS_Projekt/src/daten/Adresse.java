package daten;

public class Adresse {

	private String strasse, ort;
	private int plz, nr;

	public Adresse(String strasse, String ort, int plz, int nr) {
		this.strasse = strasse;
		this.ort = ort;
		this.plz = plz;
		this.nr = nr;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public int getPlz() {
		return plz;
	}

	public void setPlz(int plz) {
		this.plz = plz;
	}

	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

}
