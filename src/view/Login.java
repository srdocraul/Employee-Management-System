package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import controller.LoginController;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;


public class Login {

	private JFrame frmEmployeeManagementSystem;
	private JTextField korisnickoImeF;
	private JPasswordField passwordF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.getFrmEmployeeManagementSystem().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrmEmployeeManagementSystem(new JFrame());
		getFrmEmployeeManagementSystem().setTitle("Employee Management System");
		getFrmEmployeeManagementSystem().getContentPane().setBackground(new Color(255, 255, 204));
		getFrmEmployeeManagementSystem().setBackground(new Color(255, 204, 204));
		getFrmEmployeeManagementSystem().setForeground(Color.WHITE);
		getFrmEmployeeManagementSystem().setBounds(100, 100, 450, 300);
		getFrmEmployeeManagementSystem().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrmEmployeeManagementSystem().getContentPane().setLayout(null);
		getFrmEmployeeManagementSystem().setLocationRelativeTo(null);

		JLabel lblNewLabel = new JLabel("Korisnicko ime");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(151, 99, 119, 14);
		getFrmEmployeeManagementSystem().getContentPane().add(lblNewLabel);

		korisnickoImeF = new JTextField();
		korisnickoImeF.setHorizontalAlignment(SwingConstants.CENTER);
		korisnickoImeF.setBounds(151, 68, 119, 20);
		getFrmEmployeeManagementSystem().getContentPane().add(korisnickoImeF);
		korisnickoImeF.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Zaporka");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(151, 172, 119, 14);
		getFrmEmployeeManagementSystem().getContentPane().add(lblNewLabel_1);

		// Prijava u app
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginController lc = new LoginController();
				String korisnickoImes = korisnickoImeF.getText();
				char[] passwords = passwordF.getPassword();
				String pass = new String(passwords);
				boolean checkLoginCredentials = lc.checkLogin(korisnickoImes, pass);
				
				if (checkLoginCredentials) {
					String idVoditelj = String.valueOf(lc.getIdFromVoditelj());
					System.out.println(idVoditelj);
					getFrmEmployeeManagementSystem().dispose();
					AppEMS app = new AppEMS();
					app.getFrame().setVisible(true);
					app.getDohvatiIme().setText(korisnickoImes);
					app.getIdVoditelj().setText(idVoditelj);
				}
			}
		});
		btnNewButton.setBounds(168, 215, 89, 23);
		getFrmEmployeeManagementSystem().getContentPane().add(btnNewButton);

		passwordF = new JPasswordField();
		passwordF.setHorizontalAlignment(SwingConstants.CENTER);
		passwordF.setBounds(151, 140, 119, 20);
		getFrmEmployeeManagementSystem().getContentPane().add(passwordF);

		JLabel lblNewLabel_2 = new JLabel("LOGIN");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(151, 26, 119, 14);
		getFrmEmployeeManagementSystem().getContentPane().add(lblNewLabel_2);
	}

	public JFrame getFrmEmployeeManagementSystem() {
		return frmEmployeeManagementSystem;
	}

	public void setFrmEmployeeManagementSystem(JFrame frmEmployeeManagementSystem) {
		this.frmEmployeeManagementSystem = frmEmployeeManagementSystem;
	}
}
