package daten;

public class Adresse {

	@Override
	public String toString() {
		return strasse + " " + nr + "\n" + plz + " " + ort;
	}

	private String strasse, ort,plz, nr;

	public Adresse(String strasse, String ort, String plz, String nr) {
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

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public String getNr() {
		return nr;
	}

	public void setNr(String nr) {
		this.nr = nr;
	}

}
