package daten;

import java.util.ArrayList;

public class Rechner {

	public ArrayList<Komponente> rechner = new ArrayList<>();

	public Rechner(Komponente... rechner) {

		for (Komponente komponent : rechner) {
			this.rechner.add(komponent);
		}

	}}


