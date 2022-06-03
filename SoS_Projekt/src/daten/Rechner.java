package daten;

import java.util.ArrayList;
import java.util.List;

public class Rechner {
	
	private String id;
	private static int rechnerNextNumber = 10001;
	
	private Komponente cpu;
	private Komponente ram;
	private Komponente festplatte1;
	private Komponente festplatte2;
	private Komponente grafikkarte;
	private Komponente kuehlung;
	private Komponente netzteil;
	private Komponente gehaeuse;

	public Rechner(String id, Komponente cpu, Komponente ram, Komponente festplatte1, Komponente festplatte2,
			Komponente grafikkarte, Komponente kuehlung, Komponente netzteil, Komponente gehaeuse) {
		super();
		this.id = id;
		this.cpu = cpu;
		this.ram = ram;
		this.festplatte1 = festplatte1;
		this.festplatte2 = festplatte2;
		this.grafikkarte = grafikkarte;
		this.kuehlung = kuehlung;
		this.netzteil = netzteil;
		this.gehaeuse = gehaeuse;
	}
	
	public Rechner(Komponente cpu, Komponente ram, Komponente festplatte1, Komponente festplatte2,
			Komponente grafikkarte, Komponente kuehlung, Komponente netzteil, Komponente gehaeuse) {
		super();
		this.id = "R" + rechnerNextNumber;
		rechnerNextNumber++;
		this.cpu = cpu;
		this.ram = ram;
		this.festplatte1 = festplatte1;
		this.festplatte2 = festplatte2;
		this.grafikkarte = grafikkarte;
		this.kuehlung = kuehlung;
		this.netzteil = netzteil;
		this.gehaeuse = gehaeuse;
	}
	

	public Rechner(String id, Komponente cpu, Komponente ram, Komponente festplatte1,
			Komponente grafikkarte, Komponente kuehlung, Komponente netzteil, Komponente gehaeuse) {
		super();
		this.id = id;
		this.cpu = cpu;
		this.ram = ram;
		this.festplatte1 = festplatte1;
		this.grafikkarte = grafikkarte;
		this.kuehlung = kuehlung;
		this.netzteil = netzteil;
		this.gehaeuse = gehaeuse;
	}
	
	public Rechner(Komponente cpu, Komponente ram, Komponente festplatte1,
			Komponente grafikkarte, Komponente kuehlung, Komponente netzteil, Komponente gehaeuse) {
		super();
		this.id = "R" + rechnerNextNumber;
		rechnerNextNumber++;
		this.cpu = cpu;
		this.ram = ram;
		this.festplatte1 = festplatte1;
		this.grafikkarte = grafikkarte;
		this.kuehlung = kuehlung;
		this.netzteil = netzteil;
		this.gehaeuse = gehaeuse;
	}
	
	private static List<Rechner> rechnerListe = new ArrayList<Rechner>();
	
	public static Rechner getRechner(String id) {
		
		for(int i = 0; i < rechnerListe.size(); i++) {
			if(rechnerListe.get(i).getId().equals(id)) {
				return rechnerListe.get(i);
			}
		}
		return null;
	}	
	
	public static int getRechnerNextNumber() {
		return rechnerNextNumber;
	}

	public static void setRechnerNextNumber(int rechnerNextNumber) {
		Rechner.rechnerNextNumber = rechnerNextNumber;
	}

	public String getId() {
		return id;
	}

	public static List<Rechner> getRechnerListe() {
		return rechnerListe;
	}
	
	public static Rechner addRechner(Rechner rechner) {
		rechnerListe.add(rechner);
		return rechner;
	}

	public Komponente getCpu() {
		return cpu;
	}

	public void setCpu(Komponente cpu) {
		this.cpu = cpu;
	}

	public Komponente getRam() {
		return ram;
	}

	public void setRam(Komponente ram) {
		this.ram = ram;
	}

	public Komponente getFestplatte1() {
		return festplatte1;
	}

	public void setFestplatte1(Komponente festplatte1) {
		this.festplatte1 = festplatte1;
	}

	public Komponente getFestplatte2() {
		return festplatte2;
	}

	public void setFestplatte2(Komponente festplatte2) {
		this.festplatte2 = festplatte2;
	}

	public Komponente getGrafikkarte() {
		return grafikkarte;
	}

	public void setGrafikkarte(Komponente grafikkarte) {
		this.grafikkarte = grafikkarte;
	}

	public Komponente getKuehlung() {
		return kuehlung;
	}

	public void setKuehlung(Komponente kuehlung) {
		this.kuehlung = kuehlung;
	}

	public Komponente getNetzteil() {
		return netzteil;
	}

	public void setNetzteil(Komponente netzteil) {
		this.netzteil = netzteil;
	}

	public Komponente getGehaeuse() {
		return gehaeuse;
	}

	public void setGehaeuse(Komponente gehaeuse) {
		this.gehaeuse = gehaeuse;
	}

	public String getName() {
		return id;
	}

	public void setName(String name) {
		this.id = name;
	}
	
/*
	private ArrayList<Komponente> komponenten = new ArrayList<>();

	public ArrayList<Komponente> getKomponenten() {
		return komponenten;
	}

	public void setKomponenten(ArrayList<Komponente> komponenten) {
		this.komponenten = komponenten;
	}

	
	public Rechner(Komponente... komponenten) {

		for (Komponente komponent : komponenten) {
			this.komponenten.add(komponent);
		}
		
		

	}*/
	}


