package start;

import datenbankZugriff.DBKunde;
import datenbankZugriff.DBMetaDaten;
import datenbankZugriff.DBZugriff;
import datenbankZugriff.KomponentenZugriff;
import layout.LogIn;

public class Anwendung {

	public static void main(String[] args) {
		
		DBMetaDaten.loadMetaDaten();
		DBZugriff.loadMitarbeiter();
		KomponentenZugriff.loadKomponenten();
		DBKunde.loadKunden();
		LogIn.startLogInScreen();
		
	}
	
}
