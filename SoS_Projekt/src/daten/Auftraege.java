package daten;



import java.util.ArrayList;



public class Auftraege{
	
	
	ArrayList<Komponente> rechner;
	private String kunde;
	private int auftragsNummer;
	private String status;
	
	
	

	public Auftraege(ArrayList<Komponente> rechner, Kunde kunde, int auftragsNummer, String status) {
		this.rechner=rechner;
		this.kunde = kunde.getname();
		this.auftragsNummer = auftragsNummer;
		this.status = status;
	}

	public String getKunde() {
		return kunde;
	}
	public void setKunde(String kunde) {
		this.kunde = kunde;
	}
	public int getAuftragsNummer() {
		return auftragsNummer;
	}
	public void setAuftragsNummer(int auftragsNummer) {
		this.auftragsNummer = auftragsNummer;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}