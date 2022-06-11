package daten;


/**
 * 
 * Diese Klasse enthält alle wichtigen Informationen zu den Mitarbeitern.
 * Diese werden für den Log In benötigt.
 * 
 * @author julianraubald
 *
 */

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
	
	/**
	 * Prüft ob der String das korrekte Passwort ist
	 * @param passwort
	 * @return @true wenn das Passwort korrekt ist, @false wenn das Passwort falsch ist.
	 */
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

	/**
	 * 
	 * @return id des Mitarbeiters
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setzt eine id für den Mitarbeiter fest.
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * 
	 * @return vorname des Mitarbeiters
	 */
	public String getVorname() {
		return vorname;
	}
	/**
	 * Setzt Vorname des Mitarbeiters
	 * @param vorname neuer Vorname 
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	/**
	 * 
	 * @return nachname des Mitarbeiters
	 */
	public String getNachname() {
		return nachname;
	}
	/**
	 * Setzt neuen Nachname für den Mitarbeiter
	 * @param nachname
	 */
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	/**
	 * Setzt ein neues Passwort für den Mitarbeiter
	 * @param passwort
	 */
	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}
	
}
