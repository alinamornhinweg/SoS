package start;

import datenbankZugriff.DBAuftrag;
import datenbankZugriff.DBKunde;
import datenbankZugriff.DBProperties;
import datenbankZugriff.DBRechner;
import datenbankZugriff.DBMitarbeiter;
import datenbankZugriff.DBKomponente;
import layout.Hauptmenu;
import layout.LogIn;

/**
 * Hier startet die Anwendung. Erst werden alle Informationen aus der Datenbank geladen und 
 * anschliessend wird entweder der LogIn Screen aufgerufen wenn @skipLogin = @false oder direkt das
 * Hauptmenü falls @skipLogin = @false ist.
 * @author julianraubald
 *
 */
public class Anwendung {
	
	private static boolean skipLogin = true;

	public static void main(String[] args) {
		
		DBProperties.loadMetaDaten();
		DBMitarbeiter.loadMitarbeiter();
		DBKunde.loadKunden();
		DBKomponente.loadKomponenten();
		DBRechner.loadRechner();
		daten.Auftrag.addStatus();
		DBAuftrag.loadAuftraege();
		
		if(skipLogin) {
			Hauptmenu.startHauptmenu();
		}else {
			LogIn.startLogInScreen();
		}
	}
	
}
