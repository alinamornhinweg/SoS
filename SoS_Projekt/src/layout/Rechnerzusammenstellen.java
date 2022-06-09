package layout;

import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import daten.Komponente;
import daten.KomponentenListe;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.awt.GridBagConstraints;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Font;

public class Rechnerzusammenstellen extends JFrame {

//	public ArrayList<Komponente> rechner = new ArrayList<>();
//
//	public Rechnerzusammenstellen(Komponente... rechner) {
//
//		for (Komponente komponent : rechner) {
//			this.rechner.add(komponent);
//		}
//
//	}

	private JPanel contentPane;
	
	JLabel GehausePreisLabel;
	
	JLabel NetzteilPreisLabel;
	
	JLabel ProzesslufterPreisLabel;
	
	JLabel GrafikkartePreisLabel;
	
	JLabel HddPreisLabel;
	
	JLabel SsdPreisLabel;
	
	JLabel RamPreisLabel;
	
	JLabel CpuPreisLabel;
	
	JLabel RechnungLabel;

	/**
	 * Launch the application.
	 */
	public static void startRechnerzusammenstellen(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rechnerzusammenstellen frame = new Rechnerzusammenstellen();
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
	public Rechnerzusammenstellen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel Labeluberschrift = new JLabel("Rechner zusammenstellen");
		Labeluberschrift.setFont(new Font("Tahoma", Font.BOLD, 12));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(
				gl_panel.createSequentialGroup().addContainerGap().addComponent(Labeluberschrift).addGap(375)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(6).addComponent(Labeluberschrift)));
		panel.setLayout(gl_panel);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Komponenten", null, panel_1, null);

		JLabel LabelCPU = new JLabel("CPU");

		JLabel LabelRAM = new JLabel("RAM");

		JLabel LabelSSD = new JLabel("Festplatte1");

		JLabel LabelHDD = new JLabel("Festplatte 2");

		JLabel LabelGrafikkarte = new JLabel("Grafikkarte");

		JLabel LabelProzessluefter = new JLabel("Kühlung");

		JLabel LabelNetzteil = new JLabel("Netzteil");

		JLabel LabelGeheuse = new JLabel("Geh\u00E4use");

		JComboBox ramBox = new JComboBox();

		JComboBox ssdBox = new JComboBox();

		JComboBox hddBox = new JComboBox();

		JComboBox grafikkarteBox = new JComboBox();

		JComboBox prozesslufterBox = new JComboBox();

		JComboBox netzteilBox = new JComboBox();

		JComboBox gehauseBox = new JComboBox();

		JButton buttonSpeichern = new JButton("Speichern");

		JComboBox cpuBox = new JComboBox();
		
		JButton btnZurueck = new JButton("Zurueck");
		btnZurueck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hauptmenu menu = new Hauptmenu();
				menu.setVisible(true);
				//frame.setVisible(false);
				dispose();
			}
		});

		
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(btnZurueck)
							.addPreferredGap(ComponentPlacement.RELATED, 330, Short.MAX_VALUE)
							.addComponent(buttonSpeichern))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(LabelCPU)
								.addComponent(LabelRAM)
								.addComponent(LabelSSD)
								.addComponent(LabelHDD)
								.addComponent(LabelGrafikkarte)
								.addComponent(LabelProzessluefter)
								.addComponent(LabelNetzteil)
								.addComponent(LabelGeheuse))
							.addGap(10)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(cpuBox, 0, 460, Short.MAX_VALUE)
								.addComponent(hddBox, 0, 460, Short.MAX_VALUE)
								.addComponent(ssdBox, 0, 460, Short.MAX_VALUE)
								.addComponent(ramBox, 0, 460, Short.MAX_VALUE)
								.addComponent(grafikkarteBox, 0, 460, Short.MAX_VALUE)
								.addComponent(prozesslufterBox, 0, 460, Short.MAX_VALUE)
								.addComponent(netzteilBox, 0, 460, Short.MAX_VALUE)
								.addComponent(gehauseBox, 0, 460, Short.MAX_VALUE))))
					.addGap(21))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(4)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(LabelCPU)
						.addComponent(cpuBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(LabelRAM)
						.addComponent(ramBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(LabelSSD)
						.addComponent(ssdBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(hddBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(LabelHDD))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(grafikkarteBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(LabelGrafikkarte))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(prozesslufterBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(LabelProzessluefter))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(netzteilBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(LabelNetzteil))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(gehauseBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(LabelGeheuse))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(buttonSpeichern)
						.addComponent(btnZurueck))
					.addContainerGap())
		);


//TEST

		
		panel_1.setLayout(gl_panel_1);
		String Schriftyp = "Courier New"; 
		int Schrifgr = 50;

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Rechnung", null, panel_2, null);
		
		
		
		JLabel LabelRechnung = new JLabel("Rechnung");
		
		JLabel CPULabel = new JLabel("CPU :");
		
		JLabel RAMLabel = new JLabel("RAM :");
		
		JLabel SSDLabel = new JLabel("Festplatte 1:");
		
		JLabel HDDLabel = new JLabel("Festplatte 2:");
		
		JLabel GrafikkarteLabel = new JLabel("Grafikkarte :");
		
		JLabel ProzesslufterLabel = new JLabel("K\u00FChlung :");
		
		JLabel NetzteilLabel = new JLabel("Netzteil :");
		
		JLabel GehauseLabel = new JLabel("Geh\u00E4use :");
		
		JLabel ProzesslufterWahlLabel = new JLabel("");
		
		JLabel NetzteilWahlLabel = new JLabel("");
		
		JLabel GehauseWahlLabel = new JLabel("");
		
		JLabel GrafikkarteWahlLabel = new JLabel("");
		
		JLabel HddWahlLabel = new JLabel("");
		
		JLabel SsdWahlLabel = new JLabel("");
		
		JLabel RamWahlLabel = new JLabel("");
		
		JLabel CpuWahlLabel = new JLabel("");

		
		 GehausePreisLabel = new JLabel("");
		
		 NetzteilPreisLabel = new JLabel("");
		
		 ProzesslufterPreisLabel = new JLabel("");
		
		 GrafikkartePreisLabel = new JLabel("");
		
		 HddPreisLabel = new JLabel("");
		
		 SsdPreisLabel = new JLabel("");
		
		 RamPreisLabel = new JLabel("");
		
		 CpuPreisLabel = new JLabel("");
		
		 RechnungLabel = new JLabel("€");
		
		

		
		JLabel SummeLabel = new JLabel("Summe :");
		
		JButton btnAuftragAnlegen = new JButton("Auftrag anlegen");
		btnAuftragAnlegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JButton btnZurueck2 = new JButton("Zurueck");
		btnZurueck2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hauptmenu menu = new Hauptmenu();
				menu.setVisible(true);
				//frame.setVisible(false);
				dispose();
			}
		});
		
		
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel_2.createSequentialGroup()
									.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
										.addComponent(ProzesslufterLabel)
										.addComponent(NetzteilLabel)
										.addComponent(GehauseLabel)
										.addComponent(GrafikkarteLabel)
										.addComponent(HDDLabel)
										.addComponent(SSDLabel)
										.addComponent(RAMLabel)
										.addComponent(CPULabel))
									.addGap(28)
									.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
										.addComponent(GehauseWahlLabel)
										.addComponent(CpuWahlLabel)
										.addComponent(RamWahlLabel)
										.addComponent(SsdWahlLabel)
										.addComponent(HddWahlLabel)
										.addComponent(GrafikkarteWahlLabel)
										.addComponent(NetzteilWahlLabel)
										.addComponent(ProzesslufterWahlLabel))
									.addPreferredGap(ComponentPlacement.RELATED, 355, Short.MAX_VALUE))
								.addGroup(gl_panel_2.createSequentialGroup()
									.addComponent(SummeLabel)
									.addGap(107)))
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(GehausePreisLabel)
								.addComponent(NetzteilPreisLabel)
								.addComponent(ProzesslufterPreisLabel)
								.addComponent(GrafikkartePreisLabel)
								.addComponent(HddPreisLabel)
								.addComponent(SsdPreisLabel)
								.addComponent(RamPreisLabel)
								.addComponent(CpuPreisLabel)
								.addComponent(RechnungLabel))
							.addContainerGap(99, Short.MAX_VALUE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(LabelRechnung)
							.addContainerGap(511, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
							.addComponent(btnZurueck2)
							.addPreferredGap(ComponentPlacement.RELATED, 333, Short.MAX_VALUE)
							.addComponent(btnAuftragAnlegen)
							.addContainerGap())))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(LabelRechnung)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(CPULabel)
						.addComponent(CpuWahlLabel)
						.addComponent(CpuPreisLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(RAMLabel)
						.addComponent(RamWahlLabel)
						.addComponent(RamPreisLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(SSDLabel)
						.addComponent(SsdWahlLabel)
						.addComponent(SsdPreisLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(HDDLabel)
						.addComponent(HddWahlLabel)
						.addComponent(HddPreisLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(GrafikkarteLabel)
						.addComponent(GrafikkarteWahlLabel)
						.addComponent(GrafikkartePreisLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(ProzesslufterLabel)
						.addComponent(ProzesslufterWahlLabel)
						.addComponent(ProzesslufterPreisLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(NetzteilLabel)
						.addComponent(NetzteilWahlLabel)
						.addComponent(NetzteilPreisLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(GehauseLabel)
						.addComponent(GehauseWahlLabel)
						.addComponent(GehausePreisLabel))
					.addGap(18)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(RechnungLabel)
						.addComponent(SummeLabel))
					.addPreferredGap(ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAuftragAnlegen)
						.addComponent(btnZurueck2))
					.addContainerGap())
		);
		
//		Komponente.getKomponentenliste().add(new Komponente("CPU", 12, "Ryzon 12", "12ram", "Gut", 12.2));
//
//		Komponente.getKomponentenliste().add(new Komponente("CPU", 12, "Apple 04", "12ram", "Gut", 22.2));
//
//		Komponente.getKomponentenliste().add(new Komponente("RAM", 12, "Apple 444", "12ram", "Gut", 32.2));

		for (int i = 0, b = 0; i < KomponentenListe.getKomponentenListe().size(); i++) {
			if (KomponentenListe.getKomponentenListe().get(i).getArt().equals(Komponente.ART_CPU)) {
				cpuBox.insertItemAt(KomponentenListe.getKomponentenListe().get(i).getName(), b);
				b++;
				
				cpuBox.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						if (e.getStateChange() == ItemEvent.SELECTED) {
							if(!cpuBox.getSelectedItem().toString().equals("")) {
								CpuWahlLabel.setText(cpuBox.getSelectedItem().toString());
								for (int i = 0, b = 0; i < KomponentenListe.getKomponentenListe().size(); i++) {
									if(KomponentenListe.getKomponentenListe().get(i).getName().equals(cpuBox.getSelectedItem().toString())) {
										CpuPreisLabel.setText( Double.toString(KomponentenListe.getKomponentenListe().get(i).getPreis()));
									}
								}
								
								
								
							}
						}
					}
				});
				
			}
		}

		for (int i = 0, b = 0; i < KomponentenListe.getKomponentenListe().size(); i++) {
			if (KomponentenListe.getKomponentenListe().get(i).getArt().equals(Komponente.ART_RAM)) {
				ramBox.insertItemAt(KomponentenListe.getKomponentenListe().get(i).getName(), b);
				b++;
				
				ramBox.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						if (e.getStateChange() == ItemEvent.SELECTED) {
							if(!ramBox.getSelectedItem().toString().equals("")) {
								RamWahlLabel.setText(ramBox.getSelectedItem().toString());
								for (int i = 0, b = 0; i < KomponentenListe.getKomponentenListe().size(); i++) {
									if(KomponentenListe.getKomponentenListe().get(i).getName().equals(ramBox.getSelectedItem().toString())) {
										RamPreisLabel.setText( Double.toString(KomponentenListe.getKomponentenListe().get(i).getPreis()));
									}
								}
							}
						}
					}
				});
			}
		}
		
		for (int i = 0 , b = 0; i < KomponentenListe.getKomponentenListe().size(); i++) {
			if (KomponentenListe.getKomponentenListe().get(i).getArt().equals(Komponente.ART_SSD)) {
				ssdBox.insertItemAt(KomponentenListe.getKomponentenListe().get(i).getName(), b);
				b++;
				
				ssdBox.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						if (e.getStateChange() == ItemEvent.SELECTED) {
							if(!ssdBox.getSelectedItem().toString().equals("")) {
								SsdWahlLabel.setText(ssdBox.getSelectedItem().toString());
								for (int i = 0, b = 0; i < KomponentenListe.getKomponentenListe().size(); i++) {
									if(KomponentenListe.getKomponentenListe().get(i).getName().equals(ssdBox.getSelectedItem().toString())) {
										SsdPreisLabel.setText( Double.toString(KomponentenListe.getKomponentenListe().get(i).getPreis()));
									}
								}
							}
						}
					}
				});
			}
		}
		
		for (int i = 0, b = 0; i < KomponentenListe.getKomponentenListe().size(); i++) {
			if (KomponentenListe.getKomponentenListe().get(i).getArt().equals(Komponente.ART_HDD)) {
				hddBox.insertItemAt(KomponentenListe.getKomponentenListe().get(i).getName(), b);
				b++;
				
				hddBox.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						if (e.getStateChange() == ItemEvent.SELECTED) {
							if(!hddBox.getSelectedItem().toString().equals("")) {
								HddWahlLabel.setText(hddBox.getSelectedItem().toString());
								for (int i = 0, b = 0; i < KomponentenListe.getKomponentenListe().size(); i++) {
									if(KomponentenListe.getKomponentenListe().get(i).getName().equals(hddBox.getSelectedItem().toString())) {
										HddPreisLabel.setText( Double.toString(KomponentenListe.getKomponentenListe().get(i).getPreis()));
									}
								}
							}
						}
					}
				});
			}
		}
		
		for (int i = 0, b = 0; i < KomponentenListe.getKomponentenListe().size(); i++) {
			if (KomponentenListe.getKomponentenListe().get(i).getArt().equals(Komponente.ART_GRAFIKKARTE)) {
				grafikkarteBox.insertItemAt(KomponentenListe.getKomponentenListe().get(i).getName(), b);
				b++;
				
				grafikkarteBox.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						if (e.getStateChange() == ItemEvent.SELECTED) {
							if(!grafikkarteBox.getSelectedItem().toString().equals("")) {
								GrafikkarteWahlLabel.setText(grafikkarteBox.getSelectedItem().toString());
								for (int i = 0, b = 0; i < KomponentenListe.getKomponentenListe().size(); i++) {
									if(KomponentenListe.getKomponentenListe().get(i).getName().equals(grafikkarteBox.getSelectedItem().toString())) {
										GrafikkartePreisLabel.setText( Double.toString(KomponentenListe.getKomponentenListe().get(i).getPreis()));
									}
								}
								
							}
						}
					}
				});
				
			}
		}
		
		for (int i = 0, b = 0; i < KomponentenListe.getKomponentenListe().size(); i++) {
			if (KomponentenListe.getKomponentenListe().get(i).getArt().equals(Komponente.ART_KUEHLER)) {
				prozesslufterBox.insertItemAt(KomponentenListe.getKomponentenListe().get(i).getName(), b);
				b++;
				
				prozesslufterBox.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						if (e.getStateChange() == ItemEvent.SELECTED) {
							if(!prozesslufterBox.getSelectedItem().toString().equals("")) {
								ProzesslufterWahlLabel.setText(prozesslufterBox.getSelectedItem().toString());
								for (int i = 0, b = 0; i < KomponentenListe.getKomponentenListe().size(); i++) {
									if(KomponentenListe.getKomponentenListe().get(i).getName().equals(prozesslufterBox.getSelectedItem().toString())) {
										ProzesslufterPreisLabel.setText( Double.toString(KomponentenListe.getKomponentenListe().get(i).getPreis()));
									}
								}
							}
						}
					}
				});
			}
		}
		
		for (int i = 0, b = 0; i < KomponentenListe.getKomponentenListe().size(); i++) {
			if (KomponentenListe.getKomponentenListe().get(i).getArt().equals(Komponente.ART_NETZTEIL)) {
				netzteilBox.insertItemAt(KomponentenListe.getKomponentenListe().get(i).getName(), b);
				b++;
				
				netzteilBox.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						if (e.getStateChange() == ItemEvent.SELECTED) {
							if(!netzteilBox.getSelectedItem().toString().equals("")) {
								NetzteilWahlLabel.setText(netzteilBox.getSelectedItem().toString());
								for (int i = 0, b = 0; i < KomponentenListe.getKomponentenListe().size(); i++) {
									if(KomponentenListe.getKomponentenListe().get(i).getName().equals(netzteilBox.getSelectedItem().toString())) {
										NetzteilPreisLabel.setText( Double.toString(KomponentenListe.getKomponentenListe().get(i).getPreis()));
									}
								}
							}
						}
					}
				});
			}
		}
		
		for (int i = 0, b = 0; i < KomponentenListe.getKomponentenListe().size(); i++) {
			if (KomponentenListe.getKomponentenListe().get(i).getArt().equals(Komponente.ART_GEHAEUSE)) {
				gehauseBox.insertItemAt(KomponentenListe.getKomponentenListe().get(i).getName(), b);
				b++;
				
				gehauseBox.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						if (e.getStateChange() == ItemEvent.SELECTED) {
							if(!gehauseBox.getSelectedItem().toString().equals("")) {
								GehauseWahlLabel.setText(gehauseBox.getSelectedItem().toString());
								for (int i = 0, b = 0; i < KomponentenListe.getKomponentenListe().size(); i++) {
									if(KomponentenListe.getKomponentenListe().get(i).getName().equals(gehauseBox.getSelectedItem().toString())) {
										GehausePreisLabel.setText( Double.toString(KomponentenListe.getKomponentenListe().get(i).getPreis()));
									}
								}
							}
						}
					}
				});
			}
		}
		buttonSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				berechnePreis();
			}
		});

		
		panel_2.setLayout(gl_panel_2);
	}
	
	private void berechnePreis() {
		try {
			//Komponente kom = new Komponente(cpuBox.getSelectedItem().toString(), ALLBITS, getName(), getWarningString(), getName(), ABORT);

			
				double cpu,ram, fp1, fp2, grafikkarte, kuehler, netzteil, gehaeuse; 
				cpu = ram = fp1 = fp2 = grafikkarte = kuehler = netzteil = gehaeuse = 0.0;
				
				cpu = setPrice(CpuPreisLabel.getText());
				ram = setPrice(RamPreisLabel.getText());
				fp1 = setPrice(SsdPreisLabel.getText());
				fp2 = setPrice(HddPreisLabel.getText());
				grafikkarte = setPrice(GrafikkartePreisLabel.getText());
				kuehler = setPrice(ProzesslufterPreisLabel.getText());
				netzteil = setPrice(NetzteilPreisLabel.getText());
				gehaeuse = setPrice(GehausePreisLabel.getText());
				
				double summe = cpu + ram + fp1 + fp2 + grafikkarte + kuehler + netzteil + gehaeuse;
				String s = String.valueOf(summe);
				
				RechnungLabel.setText(s);
//			------------------------------------	
			
		}catch(NullPointerException e1) {
			JOptionPane.showMessageDialog(null, "Ein oder mehr Felder wurden nicht ausgewählt.\nBitte wählen Sie alle Felder aus.");
		}
	}
	
	private double setPrice(String textPrice) {
		if(textPrice != null && !textPrice.isEmpty()) 
		{return Double.parseDouble(textPrice);}
		else {
			return 0.0;
		}
	}
}

