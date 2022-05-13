package daten;

public class Mitarbeiter implements Comparable<Mitarbeiter>{

	private int id;
	private String vorname;
	private String nachname;
	private String passwort;
	
	
	
	public Mitarbeiter(int id, String vorname, String nachname, String passwort) {
		super();
		this.id = id;
		this.vorname = vorname;
		this.nachname = nachname;
		this.passwort = passwort;
	}
	
	public boolean isPasswortCorrect(String passwort) {
		if(passwort.equals(this.passwort)) 
		{return true;}
		else return false;
	}
	
	@Override
	public String toString() {
		return "Mitarbeiter: " + id + " " + vorname + ", " + nachname;
	}
	
	@Override
	public int compareTo(Mitarbeiter m) {
		return m.getId() - this.getId();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}


}
