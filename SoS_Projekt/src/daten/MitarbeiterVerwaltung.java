package daten;

import java.util.ArrayList;
import java.util.List;

public class MitarbeiterVerwaltung {
	
	private static List<Mitarbeiter> mitarbeiterListe = new ArrayList<Mitarbeiter>();

	public static void addMitarbeiter(Mitarbeiter mitarbeiter) {
		mitarbeiterListe.add(mitarbeiter);
	}
	
	public static List<Mitarbeiter> getMitarbeiterListe() {
		return mitarbeiterListe;
	}
	
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
	
	
	

}
