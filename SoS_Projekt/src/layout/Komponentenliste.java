package layout;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import daten.Komponente;
import daten.KomponentenVerwaltung;
import datenbankZugriff.DBKomponente;

import javax.swing.event.ListSelectionEvent;

import java.awt.Color;
import javax.swing.JTable;
import java.awt.SystemColor;

public class Komponentenliste extends JPanel {
	private static JTable table;
	
	static ArrayList<Komponente> komponentenListe = (ArrayList<Komponente>) KomponentenVerwaltung.getKomponentenListe();

	public static void startKomponentenliste(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Komponentenliste frame = new Komponentenliste();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Komponentenliste() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 423);
//		contentPane = new JPanel();
		setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
		
		JLabel lbl_auftrag = new JLabel("Komponeten");
		lbl_auftrag.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnLoeschen = new JButton("L\u00f6schen");
		btnLoeschen.addActionListener(e -> {
			
				System.out.println("TEST");
				if(table.getSelectionModel().isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Sie haben keine Komponente ausgew??hlt.");
					return;
				}
				
				String artikelnummer =
				(String) table.getValueAt(table.getSelectedRow(), 0);
				
				if(!komponentenListe.isEmpty()) {
					System.out.println("Anfang:" + komponentenListe.size());
						try {
							for(Komponente komponente : komponentenListe) {
								if(komponente.getArtikelnummer().equals(artikelnummer)) {
									System.out.println("Artikelnummer:" + artikelnummer);
									System.out.println("Komponen Artikelnummer:" + komponente.getArtikelnummer());
									komponente.removeKomponente(artikelnummer);									//komponente.removeRow(table.getSelectedRow());
									System.out.println("Ende:" + komponentenListe.size());
									System.out.println(table.getRowCount());
									table.removeRowSelectionInterval(table.getRowCount() -1, table.getRowCount() -1);
									break;
								}
								
							}
//							daten.Komponente.removeKomponente(artikelnummer);
//							daten.Komponente.removeRow(table.getSelectedRow());
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}else {
					JOptionPane.showMessageDialog(null, "Die ausgew\u00e4hlte Komponente existiert nicht.");
				}
				
				DBKomponente.loadKomponenten();
				
				
				
			}
		);
		
		JButton btnHinzufuegen = new JButton("Hinzuf\u00fcgen");
		btnHinzufuegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KomponenteAnlegen komponenteAnlegen = new KomponenteAnlegen();
				komponenteAnlegen.setVisible(true);
				//frame.setVisible(false);
//				dispose();
			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(this);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lbl_auftrag))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(26)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 591, GroupLayout.PREFERRED_SIZE)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(btnHinzufuegen)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnLoeschen)))))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lbl_auftrag)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLoeschen)
						.addComponent(btnHinzufuegen))
					.addGap(23))
		);
		
	
		Komponente Komponente = new Komponente();
		TableRowSorter myTableRowSorter2 = new TableRowSorter(Komponente);
		table = new JTable();
		table.setFont(new Font("ITF Devanagari", Font.PLAIN, 12));
		table.setModel((TableModel) Komponente);
		table.setRowSorter(myTableRowSorter2);
		scrollPane.setViewportView(table);
		setLayout(gl_contentPane);
		
		
	}
	
	public static JTable getTable() {
		return table;
	}
}

