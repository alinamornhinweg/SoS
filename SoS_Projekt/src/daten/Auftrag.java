package daten;



import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;



public class Auftrag extends AbstractTableModel{
	
	
	private Rechner rechner;
	private Kunde kunde;
	private String auftragsNummer;
	private String status;
	
	private static ArrayList<Auftrag> auftraege = new ArrayList<Auftrag>();
	
	
	public final String STATUS_ANGELEGT = "Angelegt";
	public final String STATUS_ZUSAMMENBAU = "Zusammenbau";
	public final String STATUS_BEREITABHOLUNG = "Bereit zur Abholung";
	public final String STATUS_ABGESCHLOSSEN = "Abgeschlossen";
	public final String STATUS_UNBEKANNT = "Unbekannt";
	
	public static void addAuftrag1(Auftrag auftrag) {
		auftraege.add(auftrag);
	}
	
	public String getColumnName(int column) {
		if (column == 0)
			return "Auftrags Nr.";
		if (column == 1)
			return "Kunde";
		if (column == 2)
			return "Rechner";
		if (column == 3)
			return "Status";
		throw new IllegalStateException();
	}

	@Override
	public int getColumnCount() {
		return 4;
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
			return auftrag.getKunde().getName();
		if (column == 2)
			return auftrag.getRechner().getId();
		if (column == 3)
			return auftrag.getStatus();
		throw new IllegalStateException();
	}

	void addAuftrag(Auftrag auftrag) {
		auftraege.add(auftrag);
		fireTableDataChanged();
	}

	public Auftrag(Rechner rechner, Kunde kunde, String auftragsNummer, String status) {
		this.rechner=rechner;
		this.kunde = kunde;
		this.auftragsNummer = auftragsNummer;
		if(!setStatus(status)) this.status = STATUS_ANGELEGT;
	}

	public Auftrag() {
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
