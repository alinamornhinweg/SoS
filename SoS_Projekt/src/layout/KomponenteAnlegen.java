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
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KomponenteAnlegen extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblName;
	private JLabel lblHersteller;
	private JLabel lblArt;
	private JLabel lblPreis;
	private JLabel lblAnzahl;
	private JLabel lblBeschreibung;
	private JTextField txtName;
	private JTextField txtHersteller;
	private JTextField txtArt;
	private JTextField txtPreis;
	private JTextField txtAnzahl;
	private JTextField txtBeschreibung;
	private JTable table;
	private JScrollPane scrollPane;
	
	DefaultTableModel model;
	
	LinkedList<Komponente> komponentenliste = daten.KomponentenListe.getKomponentenliste();
	
	static KomponenteAnlegen frame = new KomponenteAnlegen();
	private JPanel panel_1;
	private JButton btnApply;
	private JButton btnDelete;
	private JButton btnBearbeiten;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void startKomponenteAnlegen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KomponenteAnlegen frame = new KomponenteAnlegen();
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
		setBounds(100, 100, 539, 345);
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
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		contentPane.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{50, 50, 50, 50, 50, 50, 50, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblArtikelnummer = new JLabel("Artikelnummer");
		lblArtikelnummer.setBackground(new Color(240, 255, 240));
		GridBagConstraints gbc_lblArtikelnummer = new GridBagConstraints();
		gbc_lblArtikelnummer.insets = new Insets(0, 0, 5, 5);
		gbc_lblArtikelnummer.gridx = 0;
		gbc_lblArtikelnummer.gridy = 0;
		panel_2.add(lblArtikelnummer, gbc_lblArtikelnummer);
		
		lblName = new JLabel("Name");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 0;
		panel_2.add(lblName, gbc_lblName);
		
		lblHersteller = new JLabel("Hersteller");
		GridBagConstraints gbc_lblHersteller = new GridBagConstraints();
		gbc_lblHersteller.insets = new Insets(0, 0, 5, 5);
		gbc_lblHersteller.gridx = 2;
		gbc_lblHersteller.gridy = 0;
		panel_2.add(lblHersteller, gbc_lblHersteller);
		
		lblArt = new JLabel("Art");
		GridBagConstraints gbc_lblArt = new GridBagConstraints();
		gbc_lblArt.insets = new Insets(0, 0, 5, 5);
		gbc_lblArt.gridx = 3;
		gbc_lblArt.gridy = 0;
		panel_2.add(lblArt, gbc_lblArt);
		
		lblPreis = new JLabel("Preis");
		GridBagConstraints gbc_lblPreis = new GridBagConstraints();
		gbc_lblPreis.insets = new Insets(0, 0, 5, 5);
		gbc_lblPreis.gridx = 4;
		gbc_lblPreis.gridy = 0;
		panel_2.add(lblPreis, gbc_lblPreis);
		
		lblAnzahl = new JLabel("Anzahl");
		GridBagConstraints gbc_lblAnzahl = new GridBagConstraints();
		gbc_lblAnzahl.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnzahl.gridx = 5;
		gbc_lblAnzahl.gridy = 0;
		panel_2.add(lblAnzahl, gbc_lblAnzahl);
		
		lblBeschreibung = new JLabel("Beschreibung");
		GridBagConstraints gbc_lblBeschreibung = new GridBagConstraints();
		gbc_lblBeschreibung.insets = new Insets(0, 0, 5, 0);
		gbc_lblBeschreibung.gridx = 6;
		gbc_lblBeschreibung.gridy = 0;
		panel_2.add(lblBeschreibung, gbc_lblBeschreibung);
		
		txtName = new JTextField();
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.insets = new Insets(0, 0, 0, 5);
		gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtName.gridx = 1;
		gbc_txtName.gridy = 1;
		panel_2.add(txtName, gbc_txtName);
		txtName.setColumns(10);
		
		txtHersteller = new JTextField();
		GridBagConstraints gbc_txtHersteller = new GridBagConstraints();
		gbc_txtHersteller.insets = new Insets(0, 0, 0, 5);
		gbc_txtHersteller.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHersteller.gridx = 2;
		gbc_txtHersteller.gridy = 1;
		panel_2.add(txtHersteller, gbc_txtHersteller);
		txtHersteller.setColumns(10);
		
		txtArt = new JTextField();
		GridBagConstraints gbc_txtArt = new GridBagConstraints();
		gbc_txtArt.insets = new Insets(0, 0, 0, 5);
		gbc_txtArt.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtArt.gridx = 3;
		gbc_txtArt.gridy = 1;
		panel_2.add(txtArt, gbc_txtArt);
		txtArt.setColumns(10);
		
		txtPreis = new JTextField();
		GridBagConstraints gbc_txtPreis = new GridBagConstraints();
		gbc_txtPreis.insets = new Insets(0, 0, 0, 5);
		gbc_txtPreis.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPreis.gridx = 4;
		gbc_txtPreis.gridy = 1;
		panel_2.add(txtPreis, gbc_txtPreis);
		txtPreis.setColumns(10);
		
		txtAnzahl = new JTextField();
		GridBagConstraints gbc_txtAnzahl = new GridBagConstraints();
		gbc_txtAnzahl.insets = new Insets(0, 0, 0, 5);
		gbc_txtAnzahl.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAnzahl.gridx = 5;
		gbc_txtAnzahl.gridy = 1;
		panel_2.add(txtAnzahl, gbc_txtAnzahl);
		txtAnzahl.setColumns(10);
		
		txtBeschreibung = new JTextField();
		GridBagConstraints gbc_txtBeschreibung = new GridBagConstraints();
		gbc_txtBeschreibung.anchor = GridBagConstraints.NORTH;
		gbc_txtBeschreibung.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBeschreibung.gridx = 6;
		gbc_txtBeschreibung.gridy = 1;
		panel_2.add(txtBeschreibung, gbc_txtBeschreibung);
		txtBeschreibung.setColumns(10);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		model = new DefaultTableModel();
		Object[] column = {" "," "," "," "," "," "," "};
		final Object [] row = new Object[7];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
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
		
		btnApply = new JButton("Hinzufügen");
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				row[0] = txtName.getText(); 
				row[1] = txtName.getText();
				row[2] = txtHersteller.getText();
				row[3] = txtArt.getText();
				row[4] = txtPreis.getText();
				row[5] = txtAnzahl.getText();
				row[6] = txtBeschreibung.getText();
				model.addRow(row);
			}
		});
		
		btnBearbeiten = new JButton("Bearbeiten");
		GridBagConstraints gbc_btnBearbeiten = new GridBagConstraints();
		gbc_btnBearbeiten.anchor = GridBagConstraints.WEST;
		gbc_btnBearbeiten.insets = new Insets(0, 0, 0, 5);
		gbc_btnBearbeiten.gridx = 3;
		gbc_btnBearbeiten.gridy = 0;
		panel_1.add(btnBearbeiten, gbc_btnBearbeiten);
		
		btnBack = new JButton("Zurück");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hauptmenu menu = new Hauptmenu();
				menu.setVisible(true);
				//frame.setVisible(false);
				dispose();
			}
		});
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(0, 0, 0, 5);
		gbc_btnBack.gridx = 5;
		gbc_btnBack.gridy = 0;
		panel_1.add(btnBack, gbc_btnBack);
		GridBagConstraints gbc_btnApply = new GridBagConstraints();
		gbc_btnApply.anchor = GridBagConstraints.EAST;
		gbc_btnApply.insets = new Insets(0, 0, 0, 5);
		gbc_btnApply.gridx = 8;
		gbc_btnApply.gridy = 0;
		panel_1.add(btnApply, gbc_btnApply);
		
		btnDelete = new JButton("Löschen");
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.anchor = GridBagConstraints.EAST;
		gbc_btnDelete.insets = new Insets(0, 0, 0, 5);
		gbc_btnDelete.gridx = 9;
		gbc_btnDelete.gridy = 0;
		panel_1.add(btnDelete, gbc_btnDelete);
		
	}

}
