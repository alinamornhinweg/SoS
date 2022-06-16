package layout;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import daten.Adresse;
import daten.Kunde;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;

/**
 * Diese Klasse enthält die GUI um einen neuen Kunden anzulegen.
 * @author julianraubald
 *
 */
public class KundeAnlegen extends JPanel {

	private JFormattedTextField textFieldVorname;
	private JFormattedTextField textFieldNachname;
	private JLabel lblAdresse;
	private JLabel lblStrasse;
	private JLabel lblPLZ;
	private JLabel lblGeburtstag;
	private JFormattedTextField textFieldGeburtstag;
	private JFormattedTextField textFieldStrasse;
	private JFormattedTextField textFieldPLZ;
	private JLabel lblOrt;
	private JFormattedTextField textFieldOrt;
	private JLabel lblNr;
	private JFormattedTextField textFieldNr;
	private JLabel lblEmail;
	private JLabel lblTelefon;
	private JLabel lblBezahloption;
	private JFormattedTextField textFieldEmail;
	private JFormattedTextField textFieldTelefon;
	private JRadioButton rdbtnLastschrift;
	private JRadioButton rdbtnPaypal;
	private JRadioButton rdbtnRechnung;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnAbbruch;
	private JButton btnSpeichern;

	/**
	 * Launch the application.
	 */

	static KundeAnlegen frame = new KundeAnlegen();

	public static void startKundeAnlegen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new KundeAnlegen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws ParseException
	 */
	public KundeAnlegen() {

//		setTitle("Kunde anlegen");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 329);
//		contentPane = new JPanel();
		setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 95, 84, 65, 39, 44, 42, 0, 0, 163, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gbl_contentPane);

		MaskFormatter mfBuchstaben;
		try {
			mfBuchstaben = new MaskFormatter("????????????");
			mfBuchstaben.setPlaceholder(" ");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JLabel lblVorname = new JLabel("Vorname:");
		GridBagConstraints gbc_lblVorname = new GridBagConstraints();
		gbc_lblVorname.anchor = GridBagConstraints.EAST;
		gbc_lblVorname.insets = new Insets(0, 0, 5, 5);
		gbc_lblVorname.gridx = 0;
		gbc_lblVorname.gridy = 1;
		add(lblVorname, gbc_lblVorname);

		textFieldVorname = new JFormattedTextField();
		GridBagConstraints gbc_textFieldVorname = new GridBagConstraints();
		gbc_textFieldVorname.gridwidth = 4;
		gbc_textFieldVorname.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldVorname.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldVorname.gridx = 1;
		gbc_textFieldVorname.gridy = 1;
		add(textFieldVorname, gbc_textFieldVorname);
		textFieldVorname.setColumns(10);

		lblEmail = new JLabel("Email:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 7;
		gbc_lblEmail.gridy = 1;
		add(lblEmail, gbc_lblEmail);

		textFieldEmail = new JFormattedTextField();
		GridBagConstraints gbc_textFieldEmail = new GridBagConstraints();
		gbc_textFieldEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEmail.gridx = 8;
		gbc_textFieldEmail.gridy = 1;
		add(textFieldEmail, gbc_textFieldEmail);
		textFieldEmail.setColumns(10);

		JLabel lblNachname = new JLabel("Nachname:");
		GridBagConstraints gbc_lblNachname = new GridBagConstraints();
		gbc_lblNachname.anchor = GridBagConstraints.EAST;
		gbc_lblNachname.insets = new Insets(0, 0, 5, 5);
		gbc_lblNachname.gridx = 0;
		gbc_lblNachname.gridy = 2;
		add(lblNachname, gbc_lblNachname);

		textFieldNachname = new JFormattedTextField();
		GridBagConstraints gbc_textFieldNachname = new GridBagConstraints();
		gbc_textFieldNachname.gridwidth = 4;
		gbc_textFieldNachname.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNachname.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNachname.gridx = 1;
		gbc_textFieldNachname.gridy = 2;
		add(textFieldNachname, gbc_textFieldNachname);
		textFieldNachname.setColumns(10);

		lblTelefon = new JLabel("Telefon:");
		GridBagConstraints gbc_lblTelefon = new GridBagConstraints();
		gbc_lblTelefon.anchor = GridBagConstraints.EAST;
		gbc_lblTelefon.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefon.gridx = 7;
		gbc_lblTelefon.gridy = 2;
		add(lblTelefon, gbc_lblTelefon);

		textFieldTelefon = new JFormattedTextField();
		GridBagConstraints gbc_textFieldTelefon = new GridBagConstraints();
		gbc_textFieldTelefon.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldTelefon.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTelefon.gridx = 8;
		gbc_textFieldTelefon.gridy = 2;
		add(textFieldTelefon, gbc_textFieldTelefon);
		textFieldTelefon.setColumns(10);

		lblAdresse = new JLabel("Adresse");
		GridBagConstraints gbc_lblAdresse = new GridBagConstraints();
		gbc_lblAdresse.anchor = GridBagConstraints.EAST;
		gbc_lblAdresse.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdresse.gridx = 0;
		gbc_lblAdresse.gridy = 4;
		add(lblAdresse, gbc_lblAdresse);

		lblBezahloption = new JLabel("Bezahloption:");
		GridBagConstraints gbc_lblBezahloption = new GridBagConstraints();
		gbc_lblBezahloption.anchor = GridBagConstraints.EAST;
		gbc_lblBezahloption.insets = new Insets(0, 0, 5, 5);
		gbc_lblBezahloption.gridx = 7;
		gbc_lblBezahloption.gridy = 4;
		add(lblBezahloption, gbc_lblBezahloption);

		rdbtnLastschrift = new JRadioButton("Lastschrift");
		rdbtnLastschrift.setSelected(true);
		buttonGroup.add(rdbtnLastschrift);
		GridBagConstraints gbc_rdbtnLastschrift = new GridBagConstraints();
		gbc_rdbtnLastschrift.anchor = GridBagConstraints.WEST;
		gbc_rdbtnLastschrift.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnLastschrift.gridx = 8;
		gbc_rdbtnLastschrift.gridy = 4;
		add(rdbtnLastschrift, gbc_rdbtnLastschrift);

		lblStrasse = new JLabel("Strasse:");
		GridBagConstraints gbc_lblStrasse = new GridBagConstraints();
		gbc_lblStrasse.fill = GridBagConstraints.VERTICAL;
		gbc_lblStrasse.anchor = GridBagConstraints.EAST;
		gbc_lblStrasse.insets = new Insets(0, 0, 5, 5);
		gbc_lblStrasse.gridx = 0;
		gbc_lblStrasse.gridy = 5;
		add(lblStrasse, gbc_lblStrasse);

		textFieldStrasse = new JFormattedTextField();
		GridBagConstraints gbc_textFieldStrasse = new GridBagConstraints();
		gbc_textFieldStrasse.gridwidth = 2;
		gbc_textFieldStrasse.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldStrasse.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldStrasse.gridx = 1;
		gbc_textFieldStrasse.gridy = 5;
		add(textFieldStrasse, gbc_textFieldStrasse);
		textFieldStrasse.setColumns(10);

		lblNr = new JLabel("Nr.:");
		GridBagConstraints gbc_lblNr = new GridBagConstraints();
		gbc_lblNr.anchor = GridBagConstraints.EAST;
		gbc_lblNr.insets = new Insets(0, 0, 5, 5);
		gbc_lblNr.gridx = 3;
		gbc_lblNr.gridy = 5;
		add(lblNr, gbc_lblNr);

		textFieldNr = new JFormattedTextField();
		GridBagConstraints gbc_textFieldNr = new GridBagConstraints();
		gbc_textFieldNr.gridwidth = 2;
		gbc_textFieldNr.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNr.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNr.gridx = 4;
		gbc_textFieldNr.gridy = 5;
		add(textFieldNr, gbc_textFieldNr);
		textFieldNr.setColumns(10);

		rdbtnPaypal = new JRadioButton("Paypal");
		buttonGroup.add(rdbtnPaypal);
		GridBagConstraints gbc_rdbtnPaypal = new GridBagConstraints();
		gbc_rdbtnPaypal.anchor = GridBagConstraints.WEST;
		gbc_rdbtnPaypal.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnPaypal.gridx = 8;
		gbc_rdbtnPaypal.gridy = 5;
		add(rdbtnPaypal, gbc_rdbtnPaypal);

		lblPLZ = new JLabel("PLZ:");
		GridBagConstraints gbc_lblPLZ = new GridBagConstraints();
		gbc_lblPLZ.fill = GridBagConstraints.VERTICAL;
		gbc_lblPLZ.anchor = GridBagConstraints.EAST;
		gbc_lblPLZ.insets = new Insets(0, 0, 5, 5);
		gbc_lblPLZ.gridx = 0;
		gbc_lblPLZ.gridy = 6;
		add(lblPLZ, gbc_lblPLZ);

		textFieldPLZ = new JFormattedTextField();
		GridBagConstraints gbc_textFieldPLZ = new GridBagConstraints();
		gbc_textFieldPLZ.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPLZ.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPLZ.gridx = 1;
		gbc_textFieldPLZ.gridy = 6;
		add(textFieldPLZ, gbc_textFieldPLZ);
		textFieldPLZ.setColumns(10);

		lblOrt = new JLabel("Ort:");
		GridBagConstraints gbc_lblOrt = new GridBagConstraints();
		gbc_lblOrt.anchor = GridBagConstraints.EAST;
		gbc_lblOrt.insets = new Insets(0, 0, 5, 5);
		gbc_lblOrt.gridx = 3;
		gbc_lblOrt.gridy = 6;
		add(lblOrt, gbc_lblOrt);

		textFieldOrt = new JFormattedTextField();
		GridBagConstraints gbc_textFieldOrt = new GridBagConstraints();
		gbc_textFieldOrt.gridwidth = 2;
		gbc_textFieldOrt.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldOrt.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldOrt.gridx = 4;
		gbc_textFieldOrt.gridy = 6;
		add(textFieldOrt, gbc_textFieldOrt);
		textFieldOrt.setColumns(10);

		rdbtnRechnung = new JRadioButton("Rechnung");
		buttonGroup.add(rdbtnRechnung);
		GridBagConstraints gbc_rdbtnRechnung = new GridBagConstraints();
		gbc_rdbtnRechnung.anchor = GridBagConstraints.WEST;
		gbc_rdbtnRechnung.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnRechnung.gridx = 8;
		gbc_rdbtnRechnung.gridy = 6;
		add(rdbtnRechnung, gbc_rdbtnRechnung);

		lblGeburtstag = new JLabel("Geburtstag:");
		GridBagConstraints gbc_lblGeburtstag = new GridBagConstraints();
		gbc_lblGeburtstag.anchor = GridBagConstraints.EAST;
		gbc_lblGeburtstag.insets = new Insets(0, 0, 5, 5);
		gbc_lblGeburtstag.gridx = 0;
		gbc_lblGeburtstag.gridy = 7;
		add(lblGeburtstag, gbc_lblGeburtstag);

		textFieldGeburtstag = new JFormattedTextField();
		textFieldGeburtstag.setText("yyyy-mm-dd");
		textFieldGeburtstag.setToolTipText("yyyy-mm-dd");
		GridBagConstraints gbc_textFieldGeburtstag = new GridBagConstraints();
		gbc_textFieldGeburtstag.gridwidth = 2;
		gbc_textFieldGeburtstag.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldGeburtstag.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldGeburtstag.gridx = 1;
		gbc_textFieldGeburtstag.gridy = 7;
		add(textFieldGeburtstag, gbc_textFieldGeburtstag);
		textFieldGeburtstag.setColumns(10);

		btnAbbruch = new JButton("Zur\u00fcck");
		btnAbbruch.addActionListener(e -> onButtonZurueck());
		GridBagConstraints gbc_btnAbbruch = new GridBagConstraints();
		gbc_btnAbbruch.insets = new Insets(0, 0, 5, 5);
		gbc_btnAbbruch.gridx = 7;
		gbc_btnAbbruch.gridy = 9;
		add(btnAbbruch, gbc_btnAbbruch);

		btnAbbruch.addActionListener(e -> onButtonZurueck());

		btnSpeichern = new JButton("Speichern");
		GridBagConstraints gbc_btnSpeichern = new GridBagConstraints();
		gbc_btnSpeichern.insets = new Insets(0, 0, 5, 5);
		gbc_btnSpeichern.gridx = 8;
		gbc_btnSpeichern.gridy = 9;
		add(btnSpeichern, gbc_btnSpeichern);

		btnSpeichern.addActionListener(e -> onButtonSpeichern());
	}

	private void onButtonZurueck() {
		System.out.println("Kunde Anlegen -> Abbruch");

		zumHauptmenu();
	}

	/**
	 * Prüft die Eingaben auf korrektheit und erstellt einen neuen Kunden (Lokal und DB) falls alle Eingaben gültig sind.
	 */
	private void onButtonSpeichern() {
		System.out.println("Kunde Anlegen -> Speichern");
		String fehlerFeld = "";
		// FhlerFeld wird nach jeder Zeile geändert damit bei einem fehler der letzte
		// Stand gezeigt wird und der User sofort sehen kann in welchem feld es Probleme
		// gab

		

		try {
			fehlerFeld = "Vorname";
			String vorname = textFieldVorname.getText();
			if (vorname.isEmpty() || !vorname.matches("[a-zA-Z -]+"))
				return;

			fehlerFeld = "Nachname";
			String nachname = textFieldNachname.getText();
			if (nachname.isEmpty() || !nachname.matches("[a-zA-Z -]+"))
				return;

			fehlerFeld = "EMail";
			String mail = textFieldEmail.getText();
			if (!mail.contains("@") || !mail.matches("[a-zA-Z -_.@0-9]+"))
				return;

			fehlerFeld = "Telefon";
			String telefon = textFieldTelefon.getText();
			if (telefon.isEmpty() || (!telefon.matches("[0-9]+")))
				return;

			fehlerFeld = "Strasse";
			String strasse = textFieldStrasse.getText();
			if (strasse.isEmpty() || !strasse.matches("[a-zA-Z -]+"))
				return;

			fehlerFeld = "Nr";
			String nr = String.valueOf(textFieldNr.getText());
			if (textFieldNr.getText().isEmpty() || !textFieldNr.getText().matches("[0-9a-z/-]+"))
				return;

			fehlerFeld = "Postleitzahl";
			int plzN = Integer.valueOf(textFieldPLZ.getText());
			String plz = String.valueOf(plzN);
			if (textFieldPLZ.getText().length() != 5 && !plz.matches("[0-9]+"))
				return;

			fehlerFeld = "Ort";
			String ort = textFieldOrt.getText();
			if (ort.isEmpty() || !ort.matches("[a-zA-Z -]+"))
				return;

			fehlerFeld = "Geburtstag";

			
			String geburtstag = textFieldGeburtstag.getText();
			if (geburtstag.isEmpty() || geburtstag.length() > 10)
				return;

			fehlerFeld = "";

			Adresse adresse = new Adresse(strasse, ort, plz, nr);

			String bezahloption = "";
			if (rdbtnLastschrift.isSelected()) {
				bezahloption = "Lastschrift";
			} else if (rdbtnPaypal.isSelected()) {
				bezahloption = "Paypal";
			} else {
				bezahloption = "Rechnung";
			}

			Kunde kunde = new Kunde(vorname + " " + nachname, mail, telefon, bezahloption, geburtstag, adresse);
			kunde.kundeanlegen(kunde);
			

			// Kunde in entsprechender Klasse anlegen

		} catch (InputMismatchException | NumberFormatException | PatternSyntaxException e) {
			System.err.println("Wrong format with input");

			// JOptionPane.showMessageDialog(null, "Das Feld " + fehlerFeld + " wurde nicht
			// richtig befüllt.");
			return;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (!fehlerFeld.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Das Feld " + fehlerFeld + " wurde nicht richtig befüllt.");
				// return;
			}
		}
		zumHauptmenu();
	}

	/**
	 * Anwendung kerht zum Hauptmenü zurück.
	 */
	private void zumHauptmenu() {

		System.out.println("Schliesse das Fenster und starte Hauptmenu");
		Hauptmenu menu = new Hauptmenu();
		menu.setVisible(true);
		// frame.setVisible(false);
//		dispose();
	}

}
