package daten;



import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;



public class Auftrag extends AbstractTableModel{
	
	
	private Rechner rechner;
	private Kunde kunde;
	private String auftragsNummer;
	private String status;
	
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

	public static ArrayList<String> getStatusListe() {
		return statusListe;
	}




	public static void addAuftrag1(Auftrag auftrag) {
		auftraege.add(auftrag);
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

	void addAuftrag(Auftrag auftrag) {
		auftraege.add(auftrag);
		fireTableDataChanged();
	}
	
	public Auftrag() {};

	public Auftrag(Rechner rechner, Kunde kunde, String auftragsNummer, String status) {
		this.rechner=rechner;
		this.kunde = kunde;
		this.auftragsNummer = auftragsNummer;
		if(!setStatus(status)) this.status = STATUS_ANGELEGT;
	}
	
	public Auftrag(Rechner rechner, Kunde kunde, String status) {
		this.rechner=rechner;
		this.kunde = kunde;
		
		if(!setStatus(status)) this.status = STATUS_ANGELEGT;
	}

	public ArrayList<Auftrag> getAuftrag() {
		return auftraege;

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
