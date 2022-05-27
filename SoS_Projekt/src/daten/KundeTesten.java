package daten;

import java.io.IOException;
import java.sql.SQLException;

public class KundeTesten {
	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		Kunde kunde = new Kunde("500072", "TestPerson", "Test@hft.com", "0123456", "1", "1999-08.08", new Adresse("Hausstr", "Stuttgart", "12340", "10"));
		kunde.kundeanlegen("500072", "TestPerson", "Test@hft.com", "0123456", "1", "1999-08.08", new Adresse("Hausstr", "Stuttgart", "12340", "10"));

		kunde=new Kunde("500072", "TestPersonNeu", "Test@hft.com", "0123456", "2", "1999-08.08", new Adresse("Hausstr", "Stuttgart", "12340", "10"));
		kunde.kundenEdit(kunde);
		
		kunde.kundeloeschen(kunde.getNextKundenNummer());
	}

}
