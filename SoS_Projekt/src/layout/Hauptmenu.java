package layout;
import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

/**
 * Hauptmenü in dem zwischen den einzelnen Bereichen der GUI navigiert werden kann.
 * @author julianraubald
 *
 */
public class Hauptmenu extends JFrame {

	private JPanel contentPane;
	JLabel bild;
	Icon icon1;
	static Hauptmenu frame = new Hauptmenu();
	

	/**
	 * Launch the application.
	 */
	public static void startHauptmenu(){
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
		setBackground(new Color(204, 204, 153));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 410);
		//setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 153));
		contentPane.setBorder(new LineBorder(new Color(204, 204, 153), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(269, 0, 531, 382);
		contentPane.add(panel);
		
		JPanel Kunden_panel = new JPanel();
		Kunden_panel.setBorder(new LineBorder(Color.WHITE));
		Kunden_panel.setBackground(new Color(204, 204, 153));
		Kunden_panel.setBounds(0, 143, 271, 35);
		contentPane.add(Kunden_panel);
		
		JButton KundenButton = new JButton("Kunden");
		KundenButton.setBackground(Color.ORANGE);
		KundenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KundeAnlegen kA= new KundeAnlegen();
				kA.startKundeAnlegen();
				setVisible(false);
				
			}
		});
		Kunden_panel.add(KundenButton);
		
		JPanel AuftreagePanel = new JPanel();
		AuftreagePanel.setBorder(new LineBorder(Color.WHITE));
		AuftreagePanel.setBackground(new Color(204, 204, 153));
		AuftreagePanel.setBounds(0, 183, 271, 35);
		contentPane.add(AuftreagePanel);
		
		JButton AuftreageButton = new JButton("Auftreage");
		AuftreageButton.setBackground(Color.ORANGE);
		AuftreagePanel.add(AuftreageButton);
		AuftreageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Auftragsliste auftragsListe = new Auftragsliste();
				auftragsListe.setVisible(true);
				//frame.setVisible(false);
				dispose();
			}
		});
		
		JPanel Komponenten_panel = new JPanel();
		Komponenten_panel.setBorder(new LineBorder(Color.WHITE));
		Komponenten_panel.setBackground(new Color(204, 204, 153));
		Komponenten_panel.setBounds(0, 262, 271, 35);
		contentPane.add(Komponenten_panel);
		
		JButton KomponentenButton = new JButton("Komponenten");
		KomponentenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Komponentenliste komponentenListe = new Komponentenliste();
				komponentenListe.setVisible(true);
				//frame.setVisible(false);
				dispose();
			}
		});
		KomponentenButton.setBackground(Color.ORANGE);
		Komponenten_panel.add(KomponentenButton);
		
		JPanel RechnerZusammenstellen_panel = new JPanel();
		RechnerZusammenstellen_panel.setBorder(new LineBorder(Color.WHITE));
		RechnerZusammenstellen_panel.setBackground(new Color(204, 204, 153));
		RechnerZusammenstellen_panel.setBounds(0, 224, 271, 35);
		contentPane.add(RechnerZusammenstellen_panel);
		
		JButton RechnerZusammenstellenButton = new JButton("Rechner Konfigurieren");
		RechnerZusammenstellen_panel.add(RechnerZusammenstellenButton);
		RechnerZusammenstellenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rechnerzusammenstellen rechnerzusammenstellen = new Rechnerzusammenstellen();
				rechnerzusammenstellen.setVisible(true);
				//frame.setVisible(false);
				dispose();
			}
		});
		KomponentenButton.setBackground(Color.ORANGE);
		Komponenten_panel.add(KomponentenButton);
		
		JPanel Abmelden_panel = new JPanel();
		Abmelden_panel.setBorder(new LineBorder(Color.WHITE));
		Abmelden_panel.setBackground(new Color(204, 204, 153));
		Abmelden_panel.setBounds(0, 299, 271, 35);
		contentPane.add(Abmelden_panel);
		
		JButton AbmeldenButton = new JButton("Abmelden");
		AbmeldenButton.setBackground(Color.ORANGE);
		AbmeldenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogIn login = new LogIn();
				setVisible(false);
				LogIn.startLogInScreen();
				

			}
		});
		Abmelden_panel.add(AbmeldenButton);
		
		Image img = new ImageIcon(this.getClass().getResource("/transparent.png")).getImage().getScaledInstance(140,140, Image.SCALE_AREA_AVERAGING);
		
		JLabel lblNewLabel_5 = new JLabel("Eingeloggt:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(6, 360, 65, 16);
		contentPane.add(lblNewLabel_5);
		
		JLabel logoNew = new JLabel("");
		logoNew.setBounds(10, 22, 249, 126);
		logoNew.setIcon(new ImageIcon(img));
		contentPane.add(logoNew);
		
		JLabel eingeloggtLabel = new JLabel("");
		eingeloggtLabel.setForeground(Color.WHITE);
		eingeloggtLabel.setBounds(81, 363, 105, 13);
		contentPane.add(eingeloggtLabel);
		
		eingeloggtLabel.setText("----------");
		
		
		
		
		
		
		
	}
}
