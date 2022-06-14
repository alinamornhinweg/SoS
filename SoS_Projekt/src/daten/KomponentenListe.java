package daten;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class KomponentenListe {
	
	private static List<Komponente> komponentenListe = new ArrayList<Komponente>();

	public static void addKomponente(Komponente komponente) {
		komponentenListe.add(komponente);
	}
	
	public static List<Komponente> getKomponentenListe() {
		return komponentenListe;
	}
	
	public static Komponente getKomponente(String artikelNummer) {
		
		for(int i = 0; i < komponentenListe.size(); i++) {
			if(komponentenListe.get(i).getArtikelnummer().equals(artikelNummer)) {
				return komponentenListe.get(i);
			}
		}
		return null;
	}	
	
	public static void clearKomponentenListe() {
		komponentenListe.clear();
	}
}
