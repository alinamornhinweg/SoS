package start;

import datenbankZugriff.DBKunde;
import datenbankZugriff.DBMetaDaten;
import datenbankZugriff.DBZugriff;
import datenbankZugriff.KomponentenZugriff;
import layout.Hauptmenu;
import layout.LogIn;

public class Anwendung {
	
	private static boolean skipLogin = true;

	public static void main(String[] args) {
		
		DBMetaDaten.loadMetaDaten();
		DBZugriff.loadMitarbeiter();
		KomponentenZugriff.loadKomponenten();
		DBKunde.loadKunden();
		
		if(skipLogin) {
			Hauptmenu.startHauptmenu();
		}else {
			LogIn.startLogInScreen();
		}
		
		
	}
	
}
