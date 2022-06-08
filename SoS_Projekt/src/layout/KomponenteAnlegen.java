package layout;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JTable;
import java.awt.GridBagConstraints;
import javax.swing.table.DefaultTableModel;

import daten.Komponente;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class KomponenteAnlegen extends JFrame {

	private JPanel contentPane;
	private JLabel lblName;
	private JLabel lblHersteller;
	private JLabel lblArt;
	private JLabel lblPreis;
	private JLabel lblAnzahl;
	private JLabel lblBeschreibung;
	private JTextField txtName;
	private JTextField txtHersteller;
	private JTextField txtPreis;
	private JTextField txtAnzahl;
	private JTextField txtBeschreibung;
	
	DefaultTableModel model;
	
	public final String ART_CPU = "CPU";
	public final String ART_RAM = "RAM";
	public final String ART_FESTPLATTE1 = "Festplatte 1";
	public final String ART_FESTPLATTE2 = "Festplatte 2";
	public final String ART_GRAFIKKARTE = "Grafikkarte";
	public final String ART_KUEHLUNG = "Kühlung";
	public final String ART_NETZTEIL = "Netzteil";
	public final String ART_GEHAEUSE = "Gehäuse";
	
	String[] arten = {ART_CPU, ART_RAM, ART_FESTPLATTE1, ART_FESTPLATTE2, 
			ART_GRAFIKKARTE, ART_KUEHLUNG, ART_NETZTEIL, ART_GEHAEUSE};

	List<Komponente> komponentenliste = daten.KomponentenListe.getKomponentenListe();
	
	static KomponenteAnlegen frame = new KomponenteAnlegen();
	private JPanel panel_1;
	private JButton btnApply;
	private JButton btnBack;
	private JComboBox dropArt;
	private JLabel lblEUR;

	/**
	 * Launch the application.
	 */
	public static void startKomponenteAnlegen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KomponenteAnlegen frame = new KomponenteAnlegen();
					frame.setTitle("Komponenten hinzufügen");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public KomponenteAnlegen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 231);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{385, 0};
		gbl_contentPane.rowHeights = new int[]{0, 127, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 5.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridheight = 2;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		contentPane.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{50, 50, 50, 50, 50, 50, 50, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		lblName = new JLabel("Name:");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 1;
		panel_2.add(lblName, gbc_lblName);
		
		txtName = new JTextField();
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.gridwidth = 2;
		gbc_txtName.insets = new Insets(0, 0, 5, 5);
		gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtName.gridx = 1;
		gbc_txtName.gridy = 1;
		panel_2.add(txtName, gbc_txtName);
		txtName.setColumns(10);
		
		lblPreis = new JLabel("Preis:");
		GridBagConstraints gbc_lblPreis = new GridBagConstraints();
		gbc_lblPreis.anchor = GridBagConstraints.WEST;
		gbc_lblPreis.insets = new Insets(0, 0, 5, 5);
		gbc_lblPreis.gridx = 4;
		gbc_lblPreis.gridy = 1;
		panel_2.add(lblPreis, gbc_lblPreis);
		
		txtAnzahl = new JTextField();
		GridBagConstraints gbc_txtAnzahl = new GridBagConstraints();
		gbc_txtAnzahl.insets = new Insets(0, 0, 5, 5);
		gbc_txtAnzahl.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAnzahl.gridx = 5;
		gbc_txtAnzahl.gridy = 1;
		panel_2.add(txtAnzahl, gbc_txtAnzahl);
		txtAnzahl.setColumns(10);
		
		lblEUR = new JLabel("EUR");
		GridBagConstraints gbc_lblEUR = new GridBagConstraints();
		gbc_lblEUR.anchor = GridBagConstraints.WEST;
		gbc_lblEUR.insets = new Insets(0, 0, 5, 0);
		gbc_lblEUR.gridx = 6;
		gbc_lblEUR.gridy = 1;
		panel_2.add(lblEUR, gbc_lblEUR);
		
		lblHersteller = new JLabel("Hersteller:");
		GridBagConstraints gbc_lblHersteller = new GridBagConstraints();
		gbc_lblHersteller.anchor = GridBagConstraints.WEST;
		gbc_lblHersteller.insets = new Insets(0, 0, 5, 5);
		gbc_lblHersteller.gridx = 0;
		gbc_lblHersteller.gridy = 2;
		panel_2.add(lblHersteller, gbc_lblHersteller);
		
		txtHersteller = new JTextField();
		GridBagConstraints gbc_txtHersteller = new GridBagConstraints();
		gbc_txtHersteller.gridwidth = 2;
		gbc_txtHersteller.insets = new Insets(0, 0, 5, 5);
		gbc_txtHersteller.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHersteller.gridx = 1;
		gbc_txtHersteller.gridy = 2;
		panel_2.add(txtHersteller, gbc_txtHersteller);
		txtHersteller.setColumns(10);
		
		lblAnzahl = new JLabel("Anzahl:");
		GridBagConstraints gbc_lblAnzahl = new GridBagConstraints();
		gbc_lblAnzahl.anchor = GridBagConstraints.WEST;
		gbc_lblAnzahl.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnzahl.gridx = 4;
		gbc_lblAnzahl.gridy = 2;
		panel_2.add(lblAnzahl, gbc_lblAnzahl);
		
		txtPreis = new JTextField();
		GridBagConstraints gbc_txtPreis = new GridBagConstraints();
		gbc_txtPreis.insets = new Insets(0, 0, 5, 5);
		gbc_txtPreis.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPreis.gridx = 5;
		gbc_txtPreis.gridy = 2;
		panel_2.add(txtPreis, gbc_txtPreis);
		txtPreis.setColumns(10);
		
		lblArt = new JLabel("Art:");
		GridBagConstraints gbc_lblArt = new GridBagConstraints();
		gbc_lblArt.anchor = GridBagConstraints.WEST;
		gbc_lblArt.insets = new Insets(0, 0, 5, 5);
		gbc_lblArt.gridx = 0;
		gbc_lblArt.gridy = 3;
		panel_2.add(lblArt, gbc_lblArt);
		
		dropArt = new JComboBox(arten);
		GridBagConstraints gbc_dropArt = new GridBagConstraints();
		gbc_dropArt.gridwidth = 2;
		gbc_dropArt.insets = new Insets(0, 0, 5, 5);
		gbc_dropArt.fill = GridBagConstraints.HORIZONTAL;
		gbc_dropArt.gridx = 1;
		gbc_dropArt.gridy = 3;
		panel_2.add(dropArt, gbc_dropArt);
		
		
		lblBeschreibung = new JLabel("Beschreibung:");
		GridBagConstraints gbc_lblBeschreibung = new GridBagConstraints();
		gbc_lblBeschreibung.anchor = GridBagConstraints.WEST;
		gbc_lblBeschreibung.insets = new Insets(0, 0, 5, 5);
		gbc_lblBeschreibung.gridx = 4;
		gbc_lblBeschreibung.gridy = 3;
		panel_2.add(lblBeschreibung, gbc_lblBeschreibung);
		
		txtBeschreibung = new JTextField();
		GridBagConstraints gbc_txtBeschreibung = new GridBagConstraints();
		gbc_txtBeschreibung.insets = new Insets(0, 0, 5, 5);
		gbc_txtBeschreibung.anchor = GridBagConstraints.NORTH;
		gbc_txtBeschreibung.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBeschreibung.gridx = 5;
		gbc_txtBeschreibung.gridy = 3;
		panel_2.add(txtBeschreibung, gbc_txtBeschreibung);
		txtBeschreibung.setColumns(10);
		model = new DefaultTableModel();
		Object[] column = {" "," "," "," "," "," "," "};
		final Object [] row = new Object[7];
		model.setColumnIdentifiers(column);
		
		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		btnBack = new JButton("Zurück");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Komponentenliste kL = new Komponentenliste();
				kL.setVisible(true);
				//frame.setVisible(false);
				dispose();
			}
		});
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.gridwidth = 2;
		gbc_btnBack.insets = new Insets(0, 0, 0, 5);
		gbc_btnBack.gridx = 1;
		gbc_btnBack.gridy = 0;
		panel_1.add(btnBack, gbc_btnBack);
		
		btnApply = new JButton("Hinzufügen");
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = txtName.getText();
				String hersteller = txtHersteller.getText();
				String art = (String) dropArt.getSelectedItem();
				Double preis = Double.parseDouble(txtPreis.getText());
				Integer anzahl = Integer.parseInt(txtAnzahl.getText());
				String beschreibung = txtBeschreibung.getText();
				
				Komponente kom = new Komponente(art, anzahl, name, hersteller, beschreibung, preis);
				kom.addKomponente(kom);
				
			}
		});
		GridBagConstraints gbc_btnApply = new GridBagConstraints();
		gbc_btnApply.anchor = GridBagConstraints.EAST;
		gbc_btnApply.insets = new Insets(0, 0, 0, 5);
		gbc_btnApply.gridx = 9;
		gbc_btnApply.gridy = 0;
		panel_1.add(btnApply, gbc_btnApply);
		
	}

}
