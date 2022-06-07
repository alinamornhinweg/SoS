package layout;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JSpinner;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AuftragAnlegen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void startAuftragAnlegen(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AuftragAnlegen frame = new AuftragAnlegen();
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
	public AuftragAnlegen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{79, 174, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblKunde = new JLabel("Kundennummer");
		GridBagConstraints gbc_lblKunde = new GridBagConstraints();
		gbc_lblKunde.anchor = GridBagConstraints.EAST;
		gbc_lblKunde.insets = new Insets(0, 0, 5, 5);
		gbc_lblKunde.gridx = 0;
		gbc_lblKunde.gridy = 1;
		contentPane.add(lblKunde, gbc_lblKunde);
		
		JComboBox dropKunde = new JComboBox();
		GridBagConstraints gbc_dropKunde = new GridBagConstraints();
		gbc_dropKunde.insets = new Insets(0, 0, 5, 5);
		gbc_dropKunde.fill = GridBagConstraints.HORIZONTAL;
		gbc_dropKunde.gridx = 1;
		gbc_dropKunde.gridy = 1;
		contentPane.add(dropKunde, gbc_dropKunde);
		
		JLabel lblRechner = new JLabel("Rechner");
		GridBagConstraints gbc_lblRechner = new GridBagConstraints();
		gbc_lblRechner.anchor = GridBagConstraints.EAST;
		gbc_lblRechner.insets = new Insets(0, 0, 5, 5);
		gbc_lblRechner.gridx = 0;
		gbc_lblRechner.gridy = 3;
		contentPane.add(lblRechner, gbc_lblRechner);
		
		JComboBox dropRechner = new JComboBox();
		GridBagConstraints gbc_dropRechner = new GridBagConstraints();
		gbc_dropRechner.insets = new Insets(0, 0, 5, 5);
		gbc_dropRechner.fill = GridBagConstraints.HORIZONTAL;
		gbc_dropRechner.gridx = 1;
		gbc_dropRechner.gridy = 3;
		contentPane.add(dropRechner, gbc_dropRechner);
		
		JLabel lblStatus = new JLabel("Status");
		GridBagConstraints gbc_lblStatus = new GridBagConstraints();
		gbc_lblStatus.anchor = GridBagConstraints.EAST;
		gbc_lblStatus.insets = new Insets(0, 0, 5, 5);
		gbc_lblStatus.gridx = 0;
		gbc_lblStatus.gridy = 5;
		contentPane.add(lblStatus, gbc_lblStatus);
		
		JComboBox dropStatus = new JComboBox();
		GridBagConstraints gbc_dropStatus = new GridBagConstraints();
		gbc_dropStatus.insets = new Insets(0, 0, 5, 5);
		gbc_dropStatus.fill = GridBagConstraints.HORIZONTAL;
		gbc_dropStatus.gridx = 1;
		gbc_dropStatus.gridy = 5;
		contentPane.add(dropStatus, gbc_dropStatus);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 7;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnBack = new JButton("Zurück");
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(0, 0, 0, 5);
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 1;
		panel.add(btnBack, gbc_btnBack);
		
		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnSpeichern = new GridBagConstraints();
		gbc_btnSpeichern.gridx = 10;
		gbc_btnSpeichern.gridy = 1;
		panel.add(btnSpeichern, gbc_btnSpeichern);
	}

}
