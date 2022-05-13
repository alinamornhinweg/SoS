package daten;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Kunde {

	private String name, email, geburtstag;
	private Adresse adresse;
	private int bezahlmethode, kundennummer, telefon;
//	private static ArrayList<Kunde> kunden = new ArrayList<Kunde>();
//	DB datenBank = new DB();
//
//	public Kunde(int kundennummer, String name, String email, int telefon, int bezahlmethode, String geburtstag,
//			Adresse adresse) {
//		this.name = name;
//		this.email = email;
//		this.telefon = telefon;
//		this.adresse = adresse;
//		this.bezahlmethode = bezahlmethode;
//		this.kundennummer = kundennummer;
//		this.geburtstag = geburtstag;
//		kundenCheck(this);
//
//	}
//
//	public void kundenCheck(Kunde kunde) {
//
//		boolean pr fen = true;
//
//		for (Kunde einzelnerKunde : kunden) {
//			if (kunde.kundennummer == einzelnerKunde.kundennummer) {
//				pr fen = false;
//			}
//		}
//		if (pr fen) {
//			kunden.add(kunde);
//		}
//	}

	public void kundeloeschen(int kundenummer) throws SQLException, ClassNotFoundException {
		
		
		String url = "jdbc:mysql://3.69.96.96:3306/";
		String dbName = "db3";
		String userName = "db3";
		String driver = "com.mysql.cj.jdbc.Driver";
		String password = "!db3.winf22?";

		
			Class.forName(driver);
			Connection verbindung = null;
			verbindung = DriverManager.getConnection(url + dbName, userName, password);
			System.out.println("Connected to the database!\n");
			Statement abfrageAnweisung =verbindung.createStatement();

//		for (Kunde einzelnerKunde : kunden) {
//			if (kundennummer == einzelnerKunde.kundennummer) {
//				kunden.remove(einzelnerKunde);
//			}
//		}

		String loeschen = "DELETE FROM kunden WHERE KundenNummer=" + kundenummer;
		abfrageAnweisung.execute(loeschen);
		abfrageAnweisung.close();

	}

	public void kundeanlegen(int kundenNr, String name, String email, int telefon, int bezahlmethode, String geburtstag,
			Adresse adresse) throws SQLException, ClassNotFoundException {
		
		
		String url = "jdbc:mysql://3.69.96.96:3306/";
		String dbName = "db3";
		String userName = "db3";
		String driver = "com.mysql.cj.jdbc.Driver";
		String password = "!db3.winf22?";

		
			Class.forName(driver);
			Connection verbindung = null;
			verbindung = DriverManager.getConnection(url + dbName, userName, password);
			System.out.println("Connected to the database!\n");
			Statement abfrageAnweisung =verbindung.createStatement();


			String bezahlmethodeString = null;
			
		if (bezahlmethode == 1) {
			bezahlmethodeString = "Paypal";
		} else if (bezahlmethode == 2) {
			bezahlmethodeString = "Rechnung";
		} else if (bezahlmethode == 3) {
			bezahlmethodeString = "Lastschrift";

		}
		String query = "INSERT INTO kunden (KundenNummer, Name, Email, Telefon, Strasse, Nr, Ort, Geburtstag,plz, BezahlOption) VALUES ('"
				+ kundenNr + "','" + name + "','" + email + "','" + telefon + "','" + adresse.getStrasse() + "','"
				+ adresse.getNr() + "','" + adresse.getOrt() + "','" + geburtstag + "','" + adresse.getPlz() + "','"
				+ bezahlmethodeString + "')";
		abfrageAnweisung.execute(query);
		abfrageAnweisung.close();
	}

	
	
	public void kundenEdit(int auswahl, int Kundennummer) throws ClassNotFoundException, SQLException {	
		String url = "jdbc:mysql://3.69.96.96:3306/";
		String dbName = "db3";
		String userName = "db3";
		String driver = "com.mysql.cj.jdbc.Driver";
		String password = "!db3.winf22?";

		
			Class.forName(driver);
			Connection verbindung = null;
			verbindung = DriverManager.getConnection(url + dbName, userName, password);
			System.out.println("Connected to the database!\n");
			Statement abfrageAnweisung =verbindung.createStatement();
		
	
			
			
			String update = "UPDATE kunden SET spalte1=wert1, spalte2=wert2 WHERE id=wert";
			abfrageAnweisung.execute(update);
			abfrageAnweisung.close();
		
		
	}
	
	
	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefon() {
		return telefon;
	}

	public void setTelefon(int telefon) {
		this.telefon = telefon;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public int getBezahlmethode() {
		return bezahlmethode;
	}

	public void setBezahlmethode(int bezahlmethode) {
		this.bezahlmethode = bezahlmethode;
	}

	public int getKundennummer() {
		return kundennummer;
	}

	public void setKundennummer(int kundennummer) {
		this.kundennummer = kundennummer;
	}

//	public static ArrayList<Kunde> getKunden() {
//		return kunden;
//	}

}
