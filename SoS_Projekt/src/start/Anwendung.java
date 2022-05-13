package start;

import datenbankZugriff.DBZugriff;
import layout.LogIn;

public class Anwendung {

	public static void main(String[] args) {
		
		DBZugriff.loadMitarbeiter();
		LogIn.startLogInScreen();
	}
	
}
