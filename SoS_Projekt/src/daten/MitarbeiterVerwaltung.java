package daten;

import java.util.ArrayList;
import java.util.List;

/**
 * Diese Klasse verwaltet alle Mitarbeiter-Objekte.
 * @author julianraubald
 *
 */
public class MitarbeiterVerwaltung {
	
	private static List<Mitarbeiter> mitarbeiterListe = new ArrayList<Mitarbeiter>();

	/**
	 * Fügt einen Mitarbeiter der Mitarbeiterliste hinzu (lokal)
	 * @param mitarbeiter
	 */
	public static void addMitarbeiter(Mitarbeiter mitarbeiter) {
		mitarbeiterListe.add(mitarbeiter);
	}
	
	/**
	 * 
	 * @return List<Mitarbeiter> aller Mitarbeiter
	 */
	public static List<Mitarbeiter> getMitarbeiterListe() {
		return mitarbeiterListe;
	}
	
	/**
	 * Sortiert alle Mitarbeiter entweder nach 'id', 'vorname', oder 'nachname'.
	 * @param sortMethode 'id', 'vorname', oder 'nachname'
	 * @return @mitarbeiterListe im sortierten Zustand
	 */
	public static List<Mitarbeiter> sortMitarbeiterListe(String sortMethode){
		
		switch(sortMethode) {
		
		case "id": mitarbeiterListe.sort((a,b) -> a.getId() - b.getId());
			break;
			
		case "vorname": mitarbeiterListe.sort((a,b) -> a.getVorname().compareTo(b.getVorname()));
			break;
			
		case "nachname": mitarbeiterListe.sort((a,b) -> a.getNachname().compareTo(b.getNachname()));
			break;
		}
		
		return mitarbeiterListe;
	}
	
	/**
	 * Gibt an ob der Login erfolgreich ist
	 * @param id Eingabefeld id im Login-Bildschirm
	 * @param pw Eingabefeld passwort im Ligin-Bildschirm
	 * @return @true wenn die Login-Daten korrekt sind. @false wenn Login-Daten nicht korrekt sind.
	 */
	public static boolean isLoginSuccesfull(int id, String pw) {
		
		for(int i = 0; i < mitarbeiterListe.size(); i++) {
			if(mitarbeiterListe.get(i).getId() == id) {
				if(mitarbeiterListe.get(i).isPasswortCorrect(pw)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private static Mitarbeiter eingeloggterMA = new Mitarbeiter(0000,"Nicht Angemeldet" , "" , "pwtest");
	
	public static Mitarbeiter getEingeloggterMA() {
		return eingeloggterMA;
	}

	public static Mitarbeiter setEingeloggterMA(int id) {
		for(int i = 0; i < mitarbeiterListe.size(); i++) {
			if(mitarbeiterListe.get(i).getId() == id) {
				eingeloggterMA = mitarbeiterListe.get(i);
			}
		}
		return eingeloggterMA;
	}
	
	
	

}
