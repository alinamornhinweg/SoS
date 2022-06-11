package layout;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableRowSorter;

import daten.Adresse;
import daten.Auftrag;
import daten.Komponente;
import daten.Kunde;
import daten.Rechner;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Auftragsliste extends JFrame {

	private JPanel contentPane;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void startAuftragsListe(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Auftragsliste frame = new Auftragsliste();
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
	public Auftragsliste() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lbl_auftrag = new JLabel("Aufträge");
		lbl_auftrag.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btn_zurueck = new JButton("Zurück");
		btn_zurueck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hauptmenu menu = new Hauptmenu();
				menu.setVisible(true);
				//frame.setVisible(false);
				dispose();
			}
		});
		
		JButton btn_ansicht = new JButton("Ansicht");
		
		JButton btn_bearbeiten = new JButton("Bearbeiten");
		btn_bearbeiten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AuftragAnlegen auftraege = new AuftragAnlegen();
				auftraege.setVisible(true);
				dispose();
				
			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lbl_auftrag))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(26)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 591, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btn_zurueck)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btn_bearbeiten)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btn_ansicht)))))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lbl_auftrag)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_zurueck)
						.addComponent(btn_ansicht)
						.addComponent(btn_bearbeiten))
					.addGap(23))
		);
		
		
		
		
		/*
		Rechner rechner = new Rechner();
		rechner.getKomponenten().add(new Komponente("ARTNR", 1, "WINDOWS", "MICROSOFT", "", 99.99));
		Adresse adr = new Adresse("strasse", "ort", "plz", "10");
		Kunde kunde = new Kunde("K1000", "Hans", "Hans@mail.de", "+491761234", "Rechnung", "04011994", adr);
		
		Auftrag test = new Auftrag(rechner, kunde ,"A100000", "Angefangen");
		Auftrag.addAuftrag1(test);*/
		
		Auftrag probeAuftraege = Auftrag.getAuftraege().get(0) ;
		TableRowSorter<Auftrag> myTableRowSorter = new TableRowSorter<Auftrag>(probeAuftraege);
		table = new JTable();
		table.setFont(new Font("ITF Devanagari", Font.PLAIN, 12));
		table.setModel(probeAuftraege);
		table.setRowSorter(myTableRowSorter);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		
	}
	
	
	public static String getSelectedKunde() {
		String kundennummer = (String) table.getValueAt(table.getSelectedRow(), 1);
		return kundennummer;
	}
	public static String getSelectedRechner() {
		String rechnernummer = (String) table.getValueAt(table.getSelectedRow(), 3);
		return rechnernummer;
	}
	public static String getSelectedStatus() {
		String status = (String) table.getValueAt(table.getSelectedRow(), 4);
		return status;
	}
	public static String getSelectedAuftragsnummer() {
		String auftragsnummer = (String) table.getValueAt(table.getSelectedRow(), 0);
		return auftragsnummer;
	}
}

