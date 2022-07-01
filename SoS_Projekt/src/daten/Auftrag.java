package daten;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import datenbankZugriff.DBAuftrag;



public class Auftrag extends DefaultTableModel{
	
	
	private Rechner rechner;
	private Kunde kunde;
	private String auftragsNummer;
	private String status;
	
	private static int nextNumber = 10000;
	
	private static ArrayList<Auftrag> auftraege = new ArrayList<Auftrag>();
	
	
	public static final String STATUS_ANGELEGT = "Angelegt";
	public static final String STATUS_ZUSAMMENBAU = "Zusammenbau";
	public static final String STATUS_BEREITABHOLUNG = "Bereit zur Abholung";
	public static final String STATUS_ABGESCHLOSSEN = "Abgeschlossen";
	public static final String STATUS_UNBEKANNT = "Unbekannt";
	
//	static String[] statusListe = {STATUS_ANGELEGT, STATUS_ZUSAMMENBAU, STATUS_BEREITABHOLUNG, 
//			STATUS_ABGESCHLOSSEN, STATUS_UNBEKANNT};
//	
	private static ArrayList<String> statusListe = new ArrayList<String>();
	
	public static void addStatus() {
		statusListe.add(STATUS_ABGESCHLOSSEN);
		statusListe.add(STATUS_ANGELEGT);
		statusListe.add(STATUS_BEREITABHOLUNG);
		statusListe.add(STATUS_UNBEKANNT);
		statusListe.add(STATUS_ZUSAMMENBAU);
	}
	
	
	
	
//	public static String[] getStatusListe() {
//		return statusListe;
//	}

	@Override
	public String toString() {
		return "Auftrag  mit der Auftragsnummer " + auftragsNummer + " für den Kunden " + kunde.getName();
	}




	public static ArrayList<String> getStatusListe() {
		return statusListe;
	}

	public static void clearAuftragsListe() {
		auftraege.clear();
	}


	public static void addAuftrag(Auftrag auftrag) {
		auftraege.add(auftrag);
	}
	
	public void addAuftragUpload(Auftrag auftrag) {
		auftraege.add(auftrag);
		fireTableDataChanged();
		DBAuftrag.uploadAuftrag(auftrag);
	}
	
	public String getColumnName(int column) {
		if (column == 0)
			return "Auftrags Nr.";
		if (column == 1)
			return "Kundennummer";
		if (column == 2)
			return "Kunde";
		if (column == 3)
			return "Rechner";
		if (column == 4)
			return "Status";
		throw new IllegalStateException();
	}

	@Override
	public int getColumnCount() {
		return 5;
	}

	public int getRowCount() {
		return auftraege.size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		Auftrag auftrag = auftraege.get(row);
		if (column == 0)
			return auftrag.getAuftragsNummer();
		if (column == 1)
			return auftrag.getKunde().getKundenNummer();
		if (column == 2)
			return auftrag.getKunde().getName();
		if (column == 3)
			return auftrag.getRechner().getId();
		if (column == 4)
			return auftrag.getStatus();
		throw new IllegalStateException();
	}

	public Auftrag(Rechner rechner, Kunde kunde, String auftragsNummer, String status) {
		this.rechner=rechner;
		this.kunde = kunde;
		this.auftragsNummer = auftragsNummer;
		if(!setStatus(status)) this.status = STATUS_ANGELEGT;
	}
	
	public Auftrag(Rechner rechner, Kunde kunde, String status) {
		this.rechner=rechner;
		this.kunde = kunde;
		this.auftragsNummer = "A" + nextNumber;
		nextNumber++;
		if(!setStatus(status)) this.status = STATUS_ANGELEGT;
	}

	public static ArrayList<Auftrag> getAuftraege() {
		return auftraege;
	}
	
	public static Auftrag getAuftrag(String auftragsNummer) {
		for(int i = 0; i < auftraege.size(); i++) {
			if(auftraege.get(i).getAuftragsNummer().equals(auftragsNummer)) {
				return auftraege.get(i);
			}
		}
		return null;
	}
	
	public String getAuftragsRechnung() {
		String rechnung = "Auftragsrechnung " + auftragsNummer + "\n\n";
		rechnung += kunde.getKundenRechnungsdaten();
		rechnung += "\n\n------------------------------------------\n\n\n";
		rechnung += rechner.getRchnerRechnung();
		return rechnung;
	}
	
	public void AuftragsRechnungSpeichern() {
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(auftragsNummer + ".txt")))) {
				writer.write(getAuftragsRechnung());
			
		} catch(IOException e) {
			System.out.println("Es gab einen Fehler beim speichern der Daten.\n");
		}
		//System.out.println("Das Speichern war erfolgreich!\n");
	}
	
	public String getKundeName() {
		return kunde.getName();
	}
	public void setKundeName(String name) {
		this.kunde.setName(name);;
	}
	
	public Kunde getKunde() {
		return kunde;
	}

	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}

	public String getAuftragsNummer() {
		return auftragsNummer;
	}
	
	
	public static int getNextNumber() {
		return nextNumber;
	}

	public static void setNextNumber(int nextNumber) {
		Auftrag.nextNumber = nextNumber;
		System.out.println("Auftrag NextNumber geändert zu: " + Auftrag.nextNumber);
	}




	public void setAuftragsNummer(String auftragsNummer) {
		this.auftragsNummer = auftragsNummer;
	}
	
	public String getStatus() {
		return status;
	}
	public boolean setStatus(String status) {
		
		if(status.equals(STATUS_ANGELEGT) || status.equals(STATUS_ZUSAMMENBAU) ||
				status.equals(STATUS_BEREITABHOLUNG) || status.equals(STATUS_ABGESCHLOSSEN)) {
			this.status = status;
			return true;
		}
		return false;
	}
	
	public Rechner getRechner() {
		return rechner;
	}

	public void setRechner(Rechner rechner) {
		this.rechner = rechner;
	}
	

}
