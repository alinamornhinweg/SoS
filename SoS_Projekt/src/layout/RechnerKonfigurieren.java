package layout;

import java.util.ArrayList;
import java.util.List;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import daten.Auftrag;
import daten.Komponente;
import daten.KomponentenListe;
import daten.Kunde;
import daten.Rechner;
import datenbankZugriff.DBRechner;

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
import java.text.NumberFormat;
import java.awt.event.ItemEvent;
import java.awt.Font;

/**
 * Diese Klasse enthält die GUI in der man einen @Rechner mithilfe der @Komponente erstellt.
 * Nach Auswahl des @Kunde kann man einen @Auftrag im System anlegen.
 * @author munirarami & julianraubald
 *
 */
public class RechnerKonfigurieren extends JPanel {

	private List<Kunde> kunden = daten.Kunde.getKunden();
	
	JLabel GehausePreisLabel;
	
	JLabel NetzteilPreisLabel;
	
	JLabel ProzesslufterPreisLabel;
	
	JLabel GrafikkartePreisLabel;
	
	JLabel HddPreisLabel;
	
	JLabel SsdPreisLabel;
	
	JLabel RamPreisLabel;
	
	JLabel CpuPreisLabel;
	
	JLabel RechnungLabel;
	
	JComboBox<String> kundeBox;

	/**
	 * Launch the application.
	 */
	public static void startRechnerzusammenstellen(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RechnerKonfigurieren frame = new RechnerKonfigurieren();
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
	public RechnerKonfigurieren() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 438);
//		contentPane = new JPanel();
		setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);

		JLabel Labeluberschrift = new JLabel("Rechner zusammenstellen");
		Labeluberschrift.setFont(new Font("Tahoma", Font.BOLD, 12));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(
				gl_panel.createSequentialGroup().addContainerGap().addComponent(Labeluberschrift).addGap(375)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(6).addComponent(Labeluberschrift)));
		panel.setLayout(gl_panel);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, BorderLayout.CENTER);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Komponenten", null, panel_1, null);

		JLabel LabelCPU = new JLabel("CPU");

		JLabel LabelRAM = new JLabel("RAM");

		JLabel LabelSSD = new JLabel("Festplatte1");

		JLabel LabelHDD = new JLabel("Festplatte 2");

		JLabel LabelGrafikkarte = new JLabel("Grafikkarte");

		JLabel LabelProzessluefter = new JLabel("K\u00fchlung");

		JLabel LabelNetzteil = new JLabel("Netzteil");

		JLabel LabelGeheuse = new JLabel("Geh\u00e4use");

		JComboBox ramBox = new JComboBox();

		JComboBox fp1Box = new JComboBox();

		JComboBox fp2Box = new JComboBox();

		JComboBox grafikkarteBox = new JComboBox();

		JComboBox kuehlerBox = new JComboBox();

		JComboBox netzteilBox = new JComboBox();

		JComboBox gehauseBox = new JComboBox();

		JButton buttonWeiter = new JButton("Weiter");

		JComboBox cpuBox = new JComboBox();
		
		kundeBox = new JComboBox();
		
		JLabel lblKunde = new JLabel("Kunde:");

		
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(buttonWeiter)
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
								.addComponent(cpuBox, 0, 497, Short.MAX_VALUE)
								.addComponent(fp2Box, 0, 497, Short.MAX_VALUE)
								.addComponent(fp1Box, 0, 497, Short.MAX_VALUE)
								.addComponent(ramBox, 0, 497, Short.MAX_VALUE)
								.addComponent(grafikkarteBox, 0, 497, Short.MAX_VALUE)
								.addComponent(kuehlerBox, 0, 497, Short.MAX_VALUE)
								.addComponent(netzteilBox, 0, 497, Short.MAX_VALUE)
								.addComponent(gehauseBox, 0, 497, Short.MAX_VALUE))))
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
						.addComponent(fp1Box, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(fp2Box, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(LabelHDD))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(grafikkarteBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(LabelGrafikkarte))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(kuehlerBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(LabelProzessluefter))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(netzteilBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(LabelNetzteil))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(gehauseBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(LabelGeheuse))
					.addPreferredGap(ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
					.addComponent(buttonWeiter)
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
		
		JLabel ProzesslufterLabel = new JLabel("K\u00fchlung :");
		
		JLabel NetzteilLabel = new JLabel("Netzteil :");
		
		JLabel GehauseLabel = new JLabel("Geh\u00e4use :"); 
		
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
		
		 RechnungLabel = new JLabel("0.00");
		
		

		
		JLabel SummeLabel = new JLabel("Summe :");
		
		JButton btnAuftragAnlegen = new JButton("Auftrag anlegen");
		btnAuftragAnlegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				auftragAnlegen();
			}
		});
		
		JButton btnZurueck2 = new JButton("Zur\u00fcck");
		btnZurueck2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex (0);
			}
		});
		

		
		
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel_2.createSequentialGroup()
									.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
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
												.addComponent(ProzesslufterWahlLabel)))
										.addGroup(gl_panel_2.createSequentialGroup()
											.addComponent(lblKunde)
											.addGap(18)
											.addComponent(kundeBox, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.RELATED, 178, Short.MAX_VALUE))
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
							.addContainerGap(108, Short.MAX_VALUE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(LabelRechnung)
							.addContainerGap(540, Short.MAX_VALUE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(btnZurueck2)
							.addPreferredGap(ComponentPlacement.RELATED, 407, Short.MAX_VALUE)
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
					.addPreferredGap(ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(kundeBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblKunde))
					.addGap(18)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAuftragAnlegen)
						.addComponent(btnZurueck2))
					.addContainerGap())
		);

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
										CpuPreisLabel.setText(setPreisText(i));
										cpu = KomponentenListe.getKomponentenListe().get(i);
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
										RamPreisLabel.setText(setPreisText(i));
										ram = KomponentenListe.getKomponentenListe().get(i);
									}
								}
							}
						}
					}
				});
			}
		}
		
		for (int i = 0 , b = 0; i < KomponentenListe.getKomponentenListe().size(); i++) {
			if (KomponentenListe.getKomponentenListe().get(i).getArt().equals(Komponente.ART_SSD) || KomponentenListe.getKomponentenListe().get(i).getArt().equals(Komponente.ART_HDD)) {
				fp1Box.insertItemAt(KomponentenListe.getKomponentenListe().get(i).getName(), b);
				b++;
				
				fp1Box.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						if (e.getStateChange() == ItemEvent.SELECTED) {
							if(!fp1Box.getSelectedItem().toString().equals("")) {
								SsdWahlLabel.setText(fp1Box.getSelectedItem().toString());
								for (int i = 0, b = 0; i < KomponentenListe.getKomponentenListe().size(); i++) {
									if(KomponentenListe.getKomponentenListe().get(i).getName().equals(fp1Box.getSelectedItem().toString())) {
										SsdPreisLabel.setText(setPreisText(i));
										fp1 = KomponentenListe.getKomponentenListe().get(i);
									}
								}
							}
						}
					}
				});
			}
		}
		
		for (int i = 0, b = 0; i < KomponentenListe.getKomponentenListe().size(); i++) {
			if (KomponentenListe.getKomponentenListe().get(i).getArt().equals(Komponente.ART_HDD) 
					|| KomponentenListe.getKomponentenListe().get(i).getArt().equals(Komponente.ART_SSD)
					|| KomponentenListe.getKomponentenListe().get(i).getArt().equals(Komponente.ART_KEINEAUSWAHL)) {
				fp2Box.insertItemAt(KomponentenListe.getKomponentenListe().get(i).getName(), b);
				b++;
				
				fp2Box.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						if (e.getStateChange() == ItemEvent.SELECTED) {
							if(!fp2Box.getSelectedItem().toString().equals("")) {
								HddWahlLabel.setText(fp2Box.getSelectedItem().toString());
								for (int i = 0, b = 0; i < KomponentenListe.getKomponentenListe().size(); i++) {
									if(KomponentenListe.getKomponentenListe().get(i).getName().equals(fp2Box.getSelectedItem().toString())) {
										HddPreisLabel.setText(setPreisText(i));
										fp2 = KomponentenListe.getKomponentenListe().get(i);
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
										GrafikkartePreisLabel.setText(setPreisText(i));
										grafikkarte = KomponentenListe.getKomponentenListe().get(i);
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
				kuehlerBox.insertItemAt(KomponentenListe.getKomponentenListe().get(i).getName(), b);
				b++;
				
				kuehlerBox.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						if (e.getStateChange() == ItemEvent.SELECTED) {
							if(!kuehlerBox.getSelectedItem().toString().equals("")) {
								ProzesslufterWahlLabel.setText(kuehlerBox.getSelectedItem().toString());
								for (int i = 0, b = 0; i < KomponentenListe.getKomponentenListe().size(); i++) {
									if(KomponentenListe.getKomponentenListe().get(i).getName().equals(kuehlerBox.getSelectedItem().toString())) {
										ProzesslufterPreisLabel.setText(setPreisText(i));
										kuehler = KomponentenListe.getKomponentenListe().get(i);
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
										NetzteilPreisLabel.setText(setPreisText(i));
										netzteil = KomponentenListe.getKomponentenListe().get(i);
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
										GehausePreisLabel.setText(setPreisText(i));
										gehaeuse = KomponentenListe.getKomponentenListe().get(i);
									}
								}
							}
						}
					}
				});
			}
		}
		
		if(!kunden.isEmpty()) {
			for(int i = 0; i < kunden.size(); i++) {
				kundeBox.insertItemAt(kunden.get(i).toString(), i);
			}
		}
		
		kundeBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				kundennummer = Kunde.getKunden().get(kundeBox.getSelectedIndex()).getKundenNummer();
				
			}
		});
		
		buttonWeiter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex (1);
			}
		});
		panel_2.setLayout(gl_panel_2);
	}
	
	Komponente cpu,ram, fp1, fp2, grafikkarte, kuehler, netzteil, gehaeuse; 
	String kundennummer = "";
	
	/**
	 * Legt einen neuen Auftrag an, falls @istInputKorrekt = @true ist.
	 */
	private void auftragAnlegen() {
		
		if(!istInputKorrekt()) 
		{
			JOptionPane.showMessageDialog(null, "Ein oder mehr Felder wurden nicht ausgew\u00e4hlt.\nBitte wählen Sie alle Felder aus.");
			return;
		}
		
		Rechner rechner = new Rechner(cpu,ram, fp1, fp2, grafikkarte, kuehler, netzteil, gehaeuse);
		
		/*
		if(fp2 != null || !fp2.getArtikelnummer().equals("000000")) {
			rechner = new Rechner(cpu,ram, fp1, fp2, grafikkarte, kuehler, netzteil, gehaeuse);
		}else {
			rechner = new Rechner(cpu,ram, fp1, grafikkarte, kuehler, netzteil, gehaeuse);
		}*/
		
		DBRechner.uploadRechner(rechner);
		
		Kunde kunde = Kunde.getKunde(kundennummer);
		
		Auftrag auftrag = new Auftrag(rechner, kunde, Auftrag.STATUS_ANGELEGT);
		
		auftrag.addAuftragUpload(auftrag);
		
		JOptionPane.showMessageDialog(null, "Der " + auftrag + " wurde erstellt");
		
		//TODO: Popup Auftrag wurde angelegt und zurück
	}
	
	/**
	 * Gibt an ob die ausgewählten @Komponente und der @Kunde korrekt sind
	 * @return @true falls alle Angaben korrekt sind, sonst @false
	 */
	private boolean istInputKorrekt() {
		if(cpu == null || ram == null || fp1 == null || fp2 == null || grafikkarte == null || kuehler == null || netzteil == null || gehaeuse == null 
				|| kundennummer.isBlank() || kundennummer == null) 
		{return false;}
		else return true;
	}
	
	/**
	 * Setzt die Auswahl der @Komponente in den Dropdowns zurück.
	 */
	private void resetKomponenten() {
		cpu = ram = fp1 = fp2 = grafikkarte = kuehler = netzteil = gehaeuse = null;
	}
	
	/**
	 * Berechnet den Gesamtpreis des @Rechner und gibt diesen über ein Label aus.
	 */
	private void berechnePreis() {
		try {
			//Komponente kom = new Komponente(cpuBox.getSelectedItem().toString(), ALLBITS, getName(), getWarningString(), getName(), ABORT);

			
				double cpu,ram, fp1, fp2, grafikkarte, kuehler, netzteil, gehaeuse; 
				cpu = ram = fp1 = fp2 = grafikkarte = kuehler = netzteil = gehaeuse = 0.0;
				
				NumberFormat formatter = NumberFormat.getCurrencyInstance();
				
				cpu = setPrice(CpuPreisLabel.getText());
				ram = setPrice(RamPreisLabel.getText());
				fp1 = setPrice(SsdPreisLabel.getText());
				fp2 = setPrice(HddPreisLabel.getText());
				grafikkarte = setPrice(GrafikkartePreisLabel.getText());
				kuehler = setPrice(ProzesslufterPreisLabel.getText());
				netzteil = setPrice(NetzteilPreisLabel.getText());
				gehaeuse = setPrice(GehausePreisLabel.getText());
				
				double summe = cpu + ram + fp1 + fp2 + grafikkarte + kuehler + netzteil + gehaeuse;
				//String s = String.valueOf(summe);
			    
			    //System.out.println("Summe: " + formatter.format(summe));
			    ;
				RechnungLabel.setText(formatter.format(summe));
//			------------------------------------	
			
		}catch(NullPointerException e1) {
			JOptionPane.showMessageDialog(null, "Ein oder mehr Felder wurden nicht ausgew\u00e4hlt.\nBitte wählen Sie alle Felder aus.");
			
		}
	}
	
	private String setPreisText(int i) {
		String s = Double.toString(KomponentenListe.getKomponentenListe().get(i).getPreis());
		berechnePreis();
		return s;
	}
	
	private double setPrice(String textPrice) {
		if(textPrice != null && !textPrice.isEmpty()) 
		{return Double.parseDouble(textPrice);}
		else {
			return 0.0;
		}
	}
}

