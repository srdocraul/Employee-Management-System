package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import controller.LoginController;
import security.EncryptPassword;
import security.PasswordValidator;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PromjenaSifreVoditelja {

	LoginController loginController = new LoginController();

	private JFrame frmPromjenaSifre;
	private JPasswordField trenutnaSifra;
	private JPasswordField novaSifra;
	private JPasswordField ponoviSifra;
	private JLabel idVoditeljPromjenaSifra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PromjenaSifreVoditelja window = new PromjenaSifreVoditelja();
					window.getFrame().setVisible(true);
					window.getFrame().setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PromjenaSifreVoditelja() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().getContentPane().setBackground(new Color(255, 255, 204));
		getFrame().getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("Trenutna \u0161ifra");
		lblNewLabel.setBounds(10, 31, 92, 14);
		getFrame().getContentPane().add(lblNewLabel);

		trenutnaSifra = new JPasswordField();
		trenutnaSifra.setBounds(112, 28, 213, 20);
		getFrame().getContentPane().add(trenutnaSifra);

		JLabel lblNewLabel_1 = new JLabel("Nova \u0161ifra");
		lblNewLabel_1.setBounds(10, 69, 92, 14);
		getFrame().getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Ponovi \u0161ifru");
		lblNewLabel_2.setBounds(10, 116, 92, 14);
		getFrame().getContentPane().add(lblNewLabel_2);

		novaSifra = new JPasswordField();
		novaSifra.setBounds(112, 66, 213, 20);
		getFrame().getContentPane().add(novaSifra);

		ponoviSifra = new JPasswordField();
		ponoviSifra.setBounds(112, 113, 213, 20);
		getFrame().getContentPane().add(ponoviSifra);

		JButton btnNewButton = new JButton("POTVRDI");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginController lc = new LoginController();
				EncryptPassword encryptPassword = new EncryptPassword();
				String labelText = idVoditeljPromjenaSifra.getText();
				Integer idVoditelj = Integer.valueOf(labelText);

				char[] trenutniP = trenutnaSifra.getPassword();
				String trenutniPassword = new String(trenutniP);
				boolean checkPassword = lc.checkPassword(trenutniPassword);

				if (!checkPassword)
					trenutnaSifra.setText("");
				else {
					char[] noviP = novaSifra.getPassword();
					String noviPasword = new String(noviP);
					char[] ponoviP = ponoviSifra.getPassword();
					String ponoviPasword = new String(ponoviP);

					if (!PasswordValidator.isValid(noviPasword))
						JOptionPane.showMessageDialog(null,
								"The password must contain at least one lowercase character, one uppercase character, "
										+ "one digit, one special character, and a length between 8 to 20.");
					else {
						if (!noviPasword.equals(ponoviPasword))
							JOptionPane.showMessageDialog(null,
									"Nova sifra mora odgovarati sifri u polju za ponovni upis");
						else {
							String upisNovogPassword = encryptPassword.encrypt(noviPasword);
							JOptionPane.showMessageDialog(null, "Uspjesna promjena sifre");
							loginController.updatePassword(idVoditelj, upisNovogPassword);
							
							frmPromjenaSifre.dispose();
							Login window = new Login();
							window.getFrmEmployeeManagementSystem().setVisible(true);
						}

					}
				}

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(236, 194, 89, 23);
		getFrame().getContentPane().add(btnNewButton);

		idVoditeljPromjenaSifra = new JLabel("New label");
		idVoditeljPromjenaSifra.setVisible(false);
		idVoditeljPromjenaSifra.setBounds(378, 11, 46, 14);
		frmPromjenaSifre.getContentPane().add(idVoditeljPromjenaSifra);
		getFrame().setBounds(100, 100, 450, 300);
	}

	public JFrame getFrame() {
		return frmPromjenaSifre;
	}

	public void setFrame(JFrame frame) {
		this.frmPromjenaSifre = frame;
		frmPromjenaSifre.setTitle("Promjena sifre");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JLabel getIdVoditeljPromjenaSifra() {
		return idVoditeljPromjenaSifra;
	}
}
