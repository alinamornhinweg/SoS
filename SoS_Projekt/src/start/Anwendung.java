package start;

import datenbankZugriff.DBZugriff;
import datenbankZugriff.KomponentenZugriff;
import layout.LogIn;

public class Anwendung {

	public static void main(String[] args) {
		
		DBZugriff.loadMitarbeiter();
		KomponentenZugriff.loadKomponenten();
		LogIn.startLogInScreen();
	}
	
}
