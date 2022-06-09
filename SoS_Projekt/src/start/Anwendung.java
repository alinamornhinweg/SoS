package start;

import datenbankZugriff.DBAuftrag;
import datenbankZugriff.DBKunde;
import datenbankZugriff.DBProperties;
import datenbankZugriff.DBRechner;
import datenbankZugriff.DBMitarbeiter;
import datenbankZugriff.DBKomponente;
import layout.Hauptmenu;
import layout.LogIn;

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
