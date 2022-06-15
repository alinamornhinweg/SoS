package layout;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LogIn extends JFrame {

	private JPanel contentPane;
	private JTextField idTextFeld;
	private JLabel lblAnmeldung;
	private JPasswordField passwortTextFeld;
	private JLabel logo;
	static LogIn frame = new LogIn();

	/**
	 * Launch the application.
	 */
	public static void startLogInScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new LogIn();
					frame.setTitle("Anmeldung");
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
	public LogIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		idTextFeld = new JTextField();
		idTextFeld.setColumns(10);

		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));

		JLabel lblPasswort = new JLabel("Passwort:");
		lblPasswort.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));

		lblAnmeldung = new JLabel("Anmeldung");
		lblAnmeldung.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));

		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(e -> logInButton());

		passwortTextFeld = new JPasswordField();
		passwortTextFeld.addActionListener(e -> logInButton());

		logo = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/transparent.png")).getImage().getScaledInstance(140,140, Image.SCALE_AREA_AVERAGING);

		logo.setIcon(new ImageIcon(img));
		logo.setBounds(417, 6, 337, 435);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblAnmeldung, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
							.addComponent(logo, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPasswort, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
							.addGap(77)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(passwortTextFeld, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
								.addComponent(idTextFeld, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
								.addComponent(btnNewButton, Alignment.TRAILING))
							.addGap(20))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblAnmeldung, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addGap(141))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(logo, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(idTextFeld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(31)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPasswort, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwortTextFeld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnNewButton)
					.addGap(19))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void logInButton() {
		if (idTextFeld.getText().matches("[+-]?[0-9]+") && idTextFeld.getText().length() != 0
				&& passwortTextFeld.getPassword().length != 0) {

			if (daten.MitarbeiterVerwaltung.isLoginSuccesfull(Integer.parseInt(idTextFeld.getText()), String.valueOf(passwortTextFeld.getPassword()))) {
				//JOptionPane.showMessageDialog(null, "Anmeldung erfolgreich.", "Anmeldung", JOptionPane.INFORMATION_MESSAGE);
				Hauptmenu menu = new Hauptmenu();
				menu.setVisible(true);
				dispose();
				return;
			}
		}
			JOptionPane.showMessageDialog(null, "Die eingegebenen Daten sind ung\u00fcltig. Bitte versuchen Sie es noch einmal.", "Anmeldung", JOptionPane.ERROR_MESSAGE);
		
	}
}
