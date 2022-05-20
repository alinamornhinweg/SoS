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


public class Hauptmenu extends JFrame {

	private JPanel contentPane;
	JLabel bild;
	Icon icon1;
	private JLabel logo;
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
		Kunden_panel.setBounds(0, 184, 271, 35);
		contentPane.add(Kunden_panel);
		
		JButton btnKunden = new JButton("Kunden");
		btnKunden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KundeAnlegen kA;
				kA = new KundeAnlegen();
				kA.setVisible(true);
				frame.dispose();
				
			}
		});
		Kunden_panel.add(btnKunden);
		
		JPanel Aufträge_panel = new JPanel();
		Aufträge_panel.setBorder(new LineBorder(Color.WHITE));
		Aufträge_panel.setBackground(new Color(204, 204, 153));
		Aufträge_panel.setBounds(0, 219, 271, 35);
		contentPane.add(Aufträge_panel);
		
		JLabel lblNewLabel_1 = new JLabel("Aufträge");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		Aufträge_panel.add(lblNewLabel_1);
		
		JPanel Komponenten_panel = new JPanel();
		Komponenten_panel.setBorder(new LineBorder(Color.WHITE));
		Komponenten_panel.setBackground(new Color(204, 204, 153));
		Komponenten_panel.setBounds(0, 254, 271, 35);
		contentPane.add(Komponenten_panel);
		
		JLabel lblNewLabel_2 = new JLabel("Komponenten");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		Komponenten_panel.add(lblNewLabel_2);
		
		JPanel Abmelden_panel = new JPanel();
		Abmelden_panel.setBorder(new LineBorder(Color.WHITE));
		Abmelden_panel.setBackground(new Color(204, 204, 153));
		Abmelden_panel.setBounds(0, 289, 271, 35);
		contentPane.add(Abmelden_panel);
		
		JButton btnAbmelden = new JButton("Abmelden");
		btnAbmelden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogIn login = new LogIn();
				LogIn.startLogInScreen();
				frame.setVisible(false);

			}
		});
		Abmelden_panel.add(btnAbmelden);
		
		JLabel lblNewLabel_4 = new JLabel("Logo");
		lblNewLabel_4.setIcon(new ImageIcon("\transparent.png"));
		lblNewLabel_4.setBounds(37, 16, 199, 156);
		contentPane.add(lblNewLabel_4);
		
		/*logo = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/transparent.png")).getImage().getScaledInstance(140,140, Image.SCALE_AREA_AVERAGING);

		logo.setIcon(new ImageIcon(img));
		logo.setBounds(417, 6, 337, 435);*/
		
		JLabel lblNewLabel_5 = new JLabel("Eingeloggt: Mitarbeiter1");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(6, 360, 165, 16);
		contentPane.add(lblNewLabel_5);
		
		//icon1= new ImageIcon(getClass().getResource("transparent.png"));
		
		
		
		
		
		
		
	}
}
