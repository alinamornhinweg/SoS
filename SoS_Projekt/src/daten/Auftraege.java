package daten;



import java.util.ArrayList;



public class Auftraege{
	
	
	private ArrayList<Komponente> rechner;
	private String kunde;
	private String auftragsNummer;
	private String status;
	
	
	

	public Auftraege(ArrayList<Komponente> rechner, Kunde kunde, String auftragsNummer, String status) {
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
	public String getAuftragsNummer() {
		return auftragsNummer;
	}
	public void setAuftragsNummer(String auftragsNummer) {
		this.auftragsNummer = auftragsNummer;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public ArrayList<Komponente> getRechner() {
		return rechner;
	}

	public void setRechner(ArrayList<Komponente> rechner) {
		this.rechner = rechner;
	}
	

}
