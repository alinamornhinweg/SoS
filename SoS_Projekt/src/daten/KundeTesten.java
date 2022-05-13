package daten;

import java.sql.SQLException;

public class KundeTesten {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Kunde kunde = new Kunde();
		kunde.kundeanlegen(500072, "TestPerson", "Test@hft.com", 0123456, 1, "1999-08.08", new Adresse("Hausstr", "Stuttgart", 12340, 10));

		
		kunde.kundeloeschen(500072);
	}

}
