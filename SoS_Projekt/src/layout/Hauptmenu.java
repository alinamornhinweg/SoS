package layout;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

import daten.MitarbeiterVerwaltung;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

/**
 * Hauptmenü in dem zwischen den einzelnen Bereichen der GUI navigiert werden
 * kann.
 * 
 * @author julianraubald
 *
 */
public class Hauptmenu extends JFrame {

	private JPanel contentPane;
	JLabel bild;
	Icon icon1;
	static Hauptmenu frame = new Hauptmenu();
	public static JPanel auftragslistePanel, rechnerkonfigPanel, kundeAnlegenPanel, komponentePanel,start;
	
	
	
//	Image imgStart = new ImageIcon(this.getClass().getResource("/transparent.png")).getImage().getScaledInstance(300,
//			300, Image.SCALE_AREA_AVERAGING);

	/**
	 * Launch the application.
	 */
	public static void startHauptmenu() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Hauptmenu();
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
	public Hauptmenu() {
		Image imgStart3 = new ImageIcon(this.getClass().getResource("/Logo_start.jpeg")).getImage().getScaledInstance(400,
			400, Image.SCALE_AREA_AVERAGING);
		setIconImage(imgStart3);
		
		setResizable(false);
		
		
		
		setBackground(new Color(204, 204, 153));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 918, 472);
		// setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 153));
		contentPane.setBorder(new LineBorder(new Color(204, 204, 153), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBounds(269, 0, 635, 435);
		contentPane.add(mainPanel);

		JPanel Kunden_panel = new JPanel();
		Kunden_panel.setBorder(new LineBorder(Color.WHITE));
		Kunden_panel.setBackground(new Color(204, 204, 153));
		Kunden_panel.setBounds(0, 143, 271, 35);
		contentPane.add(Kunden_panel);

		JButton KundenButton = new JButton("Kunden");
		KundenButton.setBackground(Color.WHITE);
		KundenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				closePanel();
				kundeAnlegenPanel.setVisible(true);
				
//				KundeAnlegen kA= new KundeAnlegen();
//				kA.startKundeAnlegen();
//				setVisible(false);
			}
		});
		Kunden_panel.add(KundenButton);

		JPanel AuftreagePanel = new JPanel();
		AuftreagePanel.setBorder(new LineBorder(Color.WHITE));
		AuftreagePanel.setBackground(new Color(204, 204, 153));
		AuftreagePanel.setBounds(0, 183, 271, 35);
		contentPane.add(AuftreagePanel);

		JButton AuftreageButton = new JButton("Auftreage");
		AuftreageButton.setBackground(Color.WHITE);
		AuftreagePanel.add(AuftreageButton);
		AuftreageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				closePanel();
				auftragslistePanel.setVisible(true);
				

//				Auftragsliste auftragsListe = new Auftragsliste();
//				auftragsListe.setVisible(true);
//				frame.setVisible(false);
//				dispose();
			}
		});

		JPanel Komponenten_panel = new JPanel();
		Komponenten_panel.setBorder(new LineBorder(Color.WHITE));
		Komponenten_panel.setBackground(new Color(204, 204, 153));
		Komponenten_panel.setBounds(0, 262, 271, 35);
		contentPane.add(Komponenten_panel);

		JPanel RechnerZusammenstellen_panel = new JPanel();
		RechnerZusammenstellen_panel.setBorder(new LineBorder(Color.WHITE));
		RechnerZusammenstellen_panel.setBackground(new Color(204, 204, 153));
		RechnerZusammenstellen_panel.setBounds(0, 224, 271, 35);
		contentPane.add(RechnerZusammenstellen_panel);

		JButton RechnerZusammenstellenButton = new JButton("Rechner Konfigurieren");
		RechnerZusammenstellenButton.setBackground(Color.WHITE);
		RechnerZusammenstellen_panel.add(RechnerZusammenstellenButton);
		RechnerZusammenstellenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				closePanel();
				rechnerkonfigPanel.setVisible(true);;
				
				

//				RechnerKonfigurieren rechnerzusammenstellen = new RechnerKonfigurieren();
//				rechnerzusammenstellen.setVisible(true);
//				frame.setVisible(false);
//				dispose();
			}
		});
		
		JButton KomponentenButton1 = new JButton("Komponenten");
		KomponentenButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				closePanel();
				komponentePanel.setVisible(true);

//				Komponentenliste komponentenListe = new Komponentenliste();
//				komponentenListe.setVisible(true);
//				frame.setVisible(false);
//				dispose();
			}
		});
		KomponentenButton1.setBackground(Color.WHITE);
		Komponenten_panel.add(KomponentenButton1);

		JPanel Abmelden_panel = new JPanel();
		Abmelden_panel.setBorder(new LineBorder(Color.WHITE));
		Abmelden_panel.setBackground(new Color(204, 204, 153));
		Abmelden_panel.setBounds(0, 299, 271, 35);
		contentPane.add(Abmelden_panel);

		JButton AbmeldenButton = new JButton("Abmelden");
		AbmeldenButton.setBackground(Color.WHITE);
		AbmeldenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				LogIn login = new LogIn();
				setVisible(false);
				LogIn.startLogInScreen();
			}
		});
		Abmelden_panel.add(AbmeldenButton);

		Image img = new ImageIcon(this.getClass().getResource("/transparent.png")).getImage().getScaledInstance(140,
				140, Image.SCALE_AREA_AVERAGING);

		JLabel lblNewLabel_5 = new JLabel("Eingeloggt:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(16, 360, 65, 16);
		contentPane.add(lblNewLabel_5);

		JLabel logoNew = new JLabel("");
		logoNew.setBounds(57, 10, 160, 126);
		logoNew.setIcon(new ImageIcon(img));
		contentPane.add(logoNew);

		JLabel eingeloggtLabel = new JLabel("");
		eingeloggtLabel.setForeground(Color.WHITE);
		eingeloggtLabel.setBounds(16, 388, 241, 13);
		contentPane.add(eingeloggtLabel);

		eingeloggtLabel.setText(MitarbeiterVerwaltung.getEingeloggterMA().toString());
		mainPanel.setLayout(new CardLayout(0, 0));

		auftragslistePanel = new Auftragsliste();
		
		rechnerkonfigPanel = new RechnerKonfigurieren();
		
		komponentePanel = new Komponentenliste();
		
		kundeAnlegenPanel = new KundeAnlegen();
		
		
		start = new JPanel();
		
		
		
		
		JLabel SoSPic = new JLabel("");
		GroupLayout gl_start = new GroupLayout(start);
		gl_start.setHorizontalGroup(
			gl_start.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_start.createSequentialGroup()
					.addContainerGap(162, Short.MAX_VALUE)
					.addComponent(SoSPic, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE)
					.addGap(135))
		);
		gl_start.setVerticalGroup(
			gl_start.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_start.createSequentialGroup()
					.addGap(76)
					.addComponent(SoSPic, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(90, Short.MAX_VALUE))
		);
		start.setLayout(gl_start);
		Image imgStart = new ImageIcon(this.getClass().getResource("/transparent.png")).getImage().getScaledInstance(300,
				300, Image.SCALE_AREA_AVERAGING);
		SoSPic.setIcon(new ImageIcon(imgStart));
		
		mainPanel.add(start);
		mainPanel.add(auftragslistePanel);
		mainPanel.add(rechnerkonfigPanel);
		mainPanel.add(komponentePanel);
		mainPanel.add(kundeAnlegenPanel);
	}
	
	public void closePanel() {
		auftragslistePanel.setVisible(false);
		rechnerkonfigPanel.setVisible(false);
		kundeAnlegenPanel.setVisible(false);
		komponentePanel.setVisible(false);
		start.setVisible(false);
		
		
		
		
	}
}
