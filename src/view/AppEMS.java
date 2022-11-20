package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Cursor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import controller.RadnoMjestoController;
import controller.RadnoMjestoToVoditeljController;
import controller.RadnoMjestoToZaposlenikController;
import controller.VoditeljController;
import controller.ZaposlenikController;
import security.EncryptPassword;
import security.PasswordValidator;

import javax.swing.JComboBox;
import javax.swing.JPasswordField;

public class AppEMS {

	private final ZaposlenikController zaposlenikController;
	private final RadnoMjestoController radnoMjestoController;
	private final RadnoMjestoToZaposlenikController radnoMjestoToZaposlenikController;
	private final VoditeljController voditeljController;
	private final RadnoMjestoToVoditeljController radnoMjestoToVoditeljController;
	private final EncryptPassword encryptPassword;
	private final PasswordValidator passwordValidator;

	private JFrame frame;
	private JTextField dohvatiIme;
	private JTextField ime;
	private JTextField prezime;
	private JTable zaposleniciTable;
	private JTextField godinaRodenja;
	private JTable radnoMjestoTable;
	private JTextField radnoMjesto;
	private JTable radnoMjestoToZaposlenikTable;
	private JTable voditeljTable;
	private JTextField imeVoditelj;
	private JTextField prezimeVoditelj;
	private JTextField korisnickoImeVoditelj;
	private JPasswordField passwordVoditelj;
	private JTable radnoMjestoToVoditeljTable;
	private JTable mojProfilTable;
	private JLabel IdVoditelj;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppEMS window = new AppEMS();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppEMS() {
		this.zaposlenikController = new ZaposlenikController();
		this.radnoMjestoController = new RadnoMjestoController();
		this.radnoMjestoToZaposlenikController = new RadnoMjestoToZaposlenikController();
		this.voditeljController = new VoditeljController();
		this.radnoMjestoToVoditeljController = new RadnoMjestoToVoditeljController();
		this.encryptPassword = new EncryptPassword();
		this.passwordValidator = new PasswordValidator();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void initialize() {
		setFrame(new JFrame());
		getFrame().setTitle("EMS");
		getFrame().getContentPane().setBackground(new Color(255, 255, 204));
		getFrame().getContentPane().setLayout(null);

		JPanel radnoMjestoToVoditeljPanel = new JPanel();
		radnoMjestoToVoditeljPanel.setVisible(false);

		final JPanel radnoMjestoPanel = new JPanel();
		radnoMjestoPanel.setVisible(false);

		JPanel radnoMjestoToZaposlenikPanel = new JPanel();
		radnoMjestoToZaposlenikPanel.setVisible(false);

		final JPanel zaposleniciPanel = new JPanel();
		zaposleniciPanel.setVisible(false);

		JPanel mojProfilPanel = new JPanel();
		mojProfilPanel.setVisible(false);

		JPanel voditeljiPanel = new JPanel();
		voditeljiPanel.setBackground(new Color(255, 255, 153));
		voditeljiPanel.setVisible(false);
		voditeljiPanel.setBounds(10, 111, 948, 299);
		frame.getContentPane().add(voditeljiPanel);
		voditeljiPanel.setLayout(null);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 139, 928, 149);
		voditeljiPanel.add(scrollPane_2);

		voditeljTable = new JTable();
		scrollPane_2.setViewportView(voditeljTable);
		voditeljTable.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Id", "Ime", "Prezime", "Korisnicko Ime" }));

		JLabel lblNewLabel_5 = new JLabel("Ime");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(10, 11, 132, 14);
		voditeljiPanel.add(lblNewLabel_5);

		imeVoditelj = new JTextField();
		imeVoditelj.setFont(new Font("Tahoma", Font.BOLD, 10));
		imeVoditelj.setBounds(152, 11, 153, 20);
		voditeljiPanel.add(imeVoditelj);
		imeVoditelj.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Prezime");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(10, 41, 132, 14);
		voditeljiPanel.add(lblNewLabel_6);

		prezimeVoditelj = new JTextField();
		prezimeVoditelj.setFont(new Font("Tahoma", Font.BOLD, 10));
		prezimeVoditelj.setBounds(152, 45, 153, 20);
		voditeljiPanel.add(prezimeVoditelj);
		prezimeVoditelj.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Korisnicko Ime");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(10, 79, 132, 14);
		voditeljiPanel.add(lblNewLabel_7);

		korisnickoImeVoditelj = new JTextField();
		korisnickoImeVoditelj.setFont(new Font("Tahoma", Font.BOLD, 10));
		korisnickoImeVoditelj.setBounds(152, 76, 153, 20);
		voditeljiPanel.add(korisnickoImeVoditelj);
		korisnickoImeVoditelj.setColumns(10);

		JLabel lblNewLabel_10 = new JLabel("Password");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setBounds(10, 114, 132, 14);
		voditeljiPanel.add(lblNewLabel_10);

		passwordVoditelj = new JPasswordField();
		passwordVoditelj.setFont(new Font("Tahoma", Font.BOLD, 10));
		passwordVoditelj.setBounds(152, 111, 153, 20);
		voditeljiPanel.add(passwordVoditelj);

		JButton btnNewButton_4 = new JButton("UNESI");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addVoditelj();
				refreshTableVoditelji();
			}
		});
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.setBounds(355, 110, 89, 23);
		voditeljiPanel.add(btnNewButton_4);
		mojProfilPanel.setBackground(new Color(255, 255, 153));
		mojProfilPanel.setBounds(10, 111, 948, 299);
		frame.getContentPane().add(mojProfilPanel);
		mojProfilPanel.setLayout(null);

		JLabel lblNewLabel_13 = new JLabel("MOJ PROFIL");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_13.setBounds(390, 11, 182, 44);
		mojProfilPanel.add(lblNewLabel_13);

		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(10, 118, 928, 52);
		mojProfilPanel.add(scrollPane_5);

		mojProfilTable = new JTable();
		scrollPane_5.setViewportView(mojProfilTable);
		mojProfilTable.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Ime", "Prezime", "Korisnicko Ime" }));

		JButton btnNewButton_14 = new JButton("A\u017DURIRAJ");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateMojProfil();
				refreshTableMojProfil();
			}
		});
		btnNewButton_14.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_14.setBackground(Color.WHITE);
		btnNewButton_14.setBounds(549, 82, 102, 23);
		mojProfilPanel.add(btnNewButton_14);

		JButton btnNewButton_16 = new JButton("IZBRI\u0160I");
		btnNewButton_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteMojProfil();
			}
		});
		btnNewButton_16.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_16.setBackground(Color.WHITE);
		btnNewButton_16.setBounds(661, 82, 89, 23);
		mojProfilPanel.add(btnNewButton_16);

		JButton btnNewButton_17 = new JButton("PROMJENA \u0160IFRE");
		btnNewButton_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				String labelText = IdVoditelj.getText();
				PromjenaSifreVoditelja window = new PromjenaSifreVoditelja();
				window.getIdVoditeljPromjenaSifra().setText(labelText);
				window.getFrame().setLocationRelativeTo(null);
				window.getFrame().setVisible(true);
			}
		});
		btnNewButton_17.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_17.setBackground(Color.WHITE);
		btnNewButton_17.setBounds(760, 82, 166, 23);
		mojProfilPanel.add(btnNewButton_17);
		zaposleniciPanel.setBackground(new Color(255, 255, 153));
		zaposleniciPanel.setBounds(10, 111, 948, 300);
		frame.getContentPane().add(zaposleniciPanel);
		zaposleniciPanel.setLayout(null);

		ime = new JTextField();
		ime.setFont(new Font("Tahoma", Font.BOLD, 10));
		ime.setBounds(10, 24, 86, 20);
		zaposleniciPanel.add(ime);
		ime.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Ime");
		lblNewLabel_1.setBounds(110, 27, 46, 14);
		zaposleniciPanel.add(lblNewLabel_1);

		prezime = new JTextField();
		prezime.setFont(new Font("Tahoma", Font.BOLD, 10));
		prezime.setBounds(10, 55, 86, 20);
		zaposleniciPanel.add(prezime);
		prezime.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Prezime");
		lblNewLabel_2.setBounds(110, 58, 56, 14);
		zaposleniciPanel.add(lblNewLabel_2);

		JLabel lblNewLabel_4 = new JLabel("Godina rodenja (yyyy-mm-dd)");
		lblNewLabel_4.setBounds(110, 89, 184, 14);
		zaposleniciPanel.add(lblNewLabel_4);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 114, 928, 186);
		zaposleniciPanel.add(scrollPane);

		zaposleniciTable = new JTable();
		zaposleniciTable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		zaposleniciTable.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Ime", "Prezime", "Godina rodenja" }));
		scrollPane.setViewportView(zaposleniciTable);

		JButton btnNewButton_5 = new JButton("DODAJ");
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addZaposlenik();
				refreshTableZaposlenik();
			}
		});
		btnNewButton_5.setBackground(Color.WHITE);
		btnNewButton_5.setBounds(304, 85, 89, 23);
		zaposleniciPanel.add(btnNewButton_5);

		godinaRodenja = new JTextField();
		godinaRodenja.setFont(new Font("Tahoma", Font.BOLD, 10));
		godinaRodenja.setBounds(10, 86, 86, 20);
		zaposleniciPanel.add(godinaRodenja);
		godinaRodenja.setColumns(10);

		JButton btnNewButton_6 = new JButton("A\u017DURIRAJ");
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_6.setBackground(Color.WHITE);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateZaposlenik();
				refreshTableZaposlenik();
			}
		});
		btnNewButton_6.setBounds(403, 85, 103, 23);
		zaposleniciPanel.add(btnNewButton_6);

		JButton btnNewButton_7 = new JButton("IZBRI\u0160I");
		btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteZaposlenik();
				refreshTableZaposlenik();
			}
		});
		btnNewButton_7.setBackground(Color.WHITE);
		btnNewButton_7.setBounds(516, 85, 89, 23);
		zaposleniciPanel.add(btnNewButton_7);
		radnoMjestoToZaposlenikPanel.setBackground(new Color(255, 255, 153));
		radnoMjestoToZaposlenikPanel.setBounds(10, 111, 948, 299);
		frame.getContentPane().add(radnoMjestoToZaposlenikPanel);
		radnoMjestoToZaposlenikPanel.setLayout(null);

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(10, 86, 928, 202);
		radnoMjestoToZaposlenikPanel.add(scrollPane_4);

		radnoMjestoToZaposlenikTable = new JTable();
		scrollPane_4.setViewportView(radnoMjestoToZaposlenikTable);
		radnoMjestoToZaposlenikTable
				.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Zaposlenik", "Radno Mjesto" }));

		JLabel lblNewLabel_8 = new JLabel("Zaposlenik");
		lblNewLabel_8.setBounds(10, 15, 96, 14);
		radnoMjestoToZaposlenikPanel.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Radno Mjesto");
		lblNewLabel_9.setBounds(10, 61, 96, 14);
		radnoMjestoToZaposlenikPanel.add(lblNewLabel_9);

		JComboBox zaposlenikComboBox = new JComboBox();
		zaposlenikComboBox.setFont(new Font("Tahoma", Font.BOLD, 10));
		zaposlenikComboBox.setBackground(Color.WHITE);
		zaposlenikComboBox.setBounds(116, 7, 160, 22);
		radnoMjestoToZaposlenikPanel.add(zaposlenikComboBox);

		JComboBox radnoMjestoComboBox = new JComboBox();
		radnoMjestoComboBox.setFont(new Font("Tahoma", Font.BOLD, 10));
		radnoMjestoComboBox.setBackground(Color.WHITE);
		radnoMjestoComboBox.setBounds(116, 53, 160, 22);
		radnoMjestoToZaposlenikPanel.add(radnoMjestoComboBox);

		JButton btnNewButton_15 = new JButton("DODIJELI");
		btnNewButton_15.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_15.setBackground(Color.WHITE);
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] zaposlenik = zaposlenikComboBox.getSelectedItem().toString().split(" ");
				String[] radnoMjesto = radnoMjestoComboBox.getSelectedItem().toString().split(" ");
				boolean dodijeljen = radnoMjestoToZaposlenikController.assignRadnoMjestoToZaposlenik(
						Integer.parseInt(radnoMjesto[0]), Integer.parseInt(zaposlenik[0]));

				if (!dodijeljen)
					JOptionPane.showMessageDialog(null, "Neuspjesno dodijeljivanje!");
				else
					JOptionPane.showMessageDialog(null, "Uspjesno dodijeljivanje!");

				refreshTableRadnoMjestoToZaposlenik();
			}
		});
		btnNewButton_15.setBounds(325, 52, 89, 23);
		radnoMjestoToZaposlenikPanel.add(btnNewButton_15);
		radnoMjestoPanel.setBackground(new Color(255, 255, 153));
		radnoMjestoPanel.setBounds(10, 111, 948, 299);
		frame.getContentPane().add(radnoMjestoPanel);
		radnoMjestoPanel.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 85, 928, 203);
		radnoMjestoPanel.add(scrollPane_1);

		radnoMjestoTable = new JTable();
		radnoMjestoTable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		radnoMjestoTable.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Radno Mjesto" }));
		radnoMjestoTable.getColumnModel().getColumn(1).setPreferredWidth(152);
		scrollPane_1.setViewportView(radnoMjestoTable);

		JLabel lblNewLabel_3 = new JLabel("Naziv radnog mjesta");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 28, 207, 14);
		radnoMjestoPanel.add(lblNewLabel_3);

		radnoMjesto = new JTextField();
		radnoMjesto.setFont(new Font("Tahoma", Font.BOLD, 10));
		radnoMjesto.setBounds(20, 54, 197, 20);
		radnoMjestoPanel.add(radnoMjesto);
		radnoMjesto.setColumns(10);

		JButton btnNewButton_8 = new JButton("DODAJ");
		btnNewButton_8.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addRadnoMjesto();
				refreshTableRadnoMjesto();
			}
		});
		btnNewButton_8.setBackground(Color.WHITE);
		btnNewButton_8.setBounds(259, 54, 89, 23);
		radnoMjestoPanel.add(btnNewButton_8);

		JButton btnNewButton_9 = new JButton("A\u017DURIRAJ");
		btnNewButton_9.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateRadnoMjesto();
				refreshTableRadnoMjesto();
			}
		});
		btnNewButton_9.setBackground(Color.WHITE);
		btnNewButton_9.setBounds(358, 53, 103, 23);
		radnoMjestoPanel.add(btnNewButton_9);

		JButton btnNewButton_10 = new JButton("IZBRI\u0160I");
		btnNewButton_10.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteRadnoMjesto();
				refreshTableRadnoMjesto();
			}
		});
		btnNewButton_10.setBackground(Color.WHITE);
		btnNewButton_10.setBounds(471, 53, 89, 23);
		radnoMjestoPanel.add(btnNewButton_10);
		radnoMjestoToVoditeljPanel.setBackground(new Color(255, 255, 153));
		radnoMjestoToVoditeljPanel.setBounds(10, 111, 948, 299);
		frame.getContentPane().add(radnoMjestoToVoditeljPanel);
		radnoMjestoToVoditeljPanel.setLayout(null);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 89, 928, 199);
		radnoMjestoToVoditeljPanel.add(scrollPane_3);

		radnoMjestoToVoditeljTable = new JTable();
		radnoMjestoToVoditeljTable.setFont(new Font("Tahoma", Font.BOLD, 10));
		scrollPane_3.setViewportView(radnoMjestoToVoditeljTable);
		radnoMjestoToVoditeljTable.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Voditelj", "Radno Mjesto", "Broj zaposlenih na radnom mjestu" }));

		JLabel lblNewLabel_11 = new JLabel("Voditelj");
		lblNewLabel_11.setBounds(10, 15, 90, 14);
		radnoMjestoToVoditeljPanel.add(lblNewLabel_11);

		JLabel lblNewLabel_12 = new JLabel("Radno Mjesto");
		lblNewLabel_12.setBounds(10, 64, 90, 14);
		radnoMjestoToVoditeljPanel.add(lblNewLabel_12);

		JComboBox voditeljComboBox = new JComboBox();
		voditeljComboBox.setFont(new Font("Tahoma", Font.BOLD, 10));
		voditeljComboBox.setBackground(Color.WHITE);
		voditeljComboBox.setBounds(110, 11, 169, 22);
		radnoMjestoToVoditeljPanel.add(voditeljComboBox);

		JComboBox radnoMjestoComboBox1 = new JComboBox();
		radnoMjestoComboBox1.setFont(new Font("Tahoma", Font.BOLD, 10));
		radnoMjestoComboBox1.setBackground(Color.WHITE);
		radnoMjestoComboBox1.setBounds(110, 60, 169, 22);
		radnoMjestoToVoditeljPanel.add(radnoMjestoComboBox1);

		JButton btnNewButton_12 = new JButton("DODIJELI");
		btnNewButton_12.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_12.setBackground(Color.WHITE);
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] voditelj = voditeljComboBox.getSelectedItem().toString().split(" ");
				String[] radnoMjesto = radnoMjestoComboBox1.getSelectedItem().toString().split(" ");
				boolean dodijeljen = radnoMjestoToVoditeljController
						.assignRadnoMjestoToVoditelj(Integer.parseInt(radnoMjesto[0]), Integer.parseInt(voditelj[0]));

				if (!dodijeljen)
					JOptionPane.showMessageDialog(null, "Neuspjesno dodijeljivanje!");
				else
					JOptionPane.showMessageDialog(null, "Uspjesno dodijeljivanje!");

				refreshTableRadnoMjestoToVoditelj();
			}
		});
		btnNewButton_12.setBounds(325, 60, 89, 23);
		radnoMjestoToVoditeljPanel.add(btnNewButton_12);

		JPanel izbornik = new JPanel();
		izbornik.setBackground(new Color(255, 255, 153));
		izbornik.setBounds(10, 11, 948, 89);
		frame.getContentPane().add(izbornik);
		izbornik.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(715, 0, 233, 89);
		izbornik.add(panel);
		panel.setBorder(null);
		panel.setBackground(new Color(255, 255, 153));
		panel.setLayout(null);

		JButton btnNewButton = new JButton("Zaposlenici");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zaposleniciPanel.setVisible(true);
				radnoMjestoToZaposlenikPanel.setVisible(false);
				radnoMjestoPanel.setVisible(false);
				voditeljiPanel.setVisible(false);
				radnoMjestoToVoditeljPanel.setVisible(false);
				mojProfilPanel.setVisible(false);
				refreshTableZaposlenik();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(147, 21, 127, 23);
		izbornik.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Radna Mjesta");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zaposleniciPanel.setVisible(false);
				mojProfilPanel.setVisible(false);
				radnoMjestoToZaposlenikPanel.setVisible(false);
				radnoMjestoPanel.setVisible(true);
				voditeljiPanel.setVisible(false);
				radnoMjestoToVoditeljPanel.setVisible(false);
				refreshTableRadnoMjesto();
			}

		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(284, 21, 127, 23);
		izbornik.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Voditelji");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zaposleniciPanel.setVisible(false);
				mojProfilPanel.setVisible(false);
				radnoMjestoPanel.setVisible(false);
				radnoMjestoToZaposlenikPanel.setVisible(false);
				voditeljiPanel.setVisible(true);
				radnoMjestoToVoditeljPanel.setVisible(false);
				refreshTableVoditelji();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(10, 21, 127, 23);
		izbornik.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Dodijeli radno mjesto zaposleniku");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mojProfilPanel.setVisible(false);
				zaposleniciPanel.setVisible(false);
				radnoMjestoPanel.setVisible(false);
				voditeljiPanel.setVisible(false);
				radnoMjestoToVoditeljPanel.setVisible(false);
				radnoMjestoToZaposlenikPanel.setVisible(true);

				StringBuilder sb = new StringBuilder();
				zaposlenikController.getZaposlenikIdImePrezime().forEach(t -> sb.append(t + ","));
				String zaposlenik = sb.toString();
				String[] listaZaposlenik = zaposlenik.split(",");
				zaposlenikComboBox.setModel(new DefaultComboBoxModel(listaZaposlenik));

				StringBuilder sb2 = new StringBuilder();
				radnoMjestoController.getRadnoMjestoIdAndName().forEach(t -> sb2.append(t + ","));
				String radnoMjesto = sb2.toString();
				String[] listaRadnoMjesto = radnoMjesto.split(",");
				radnoMjestoComboBox.setModel(new DefaultComboBoxModel(listaRadnoMjesto));

				refreshTableRadnoMjestoToZaposlenik();
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setBounds(421, 21, 204, 23);
		izbornik.add(btnNewButton_3);

		JLabel lblNewLabel = new JLabel("Trenutno prijavljen voditelj:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 5, 213, 14);
		panel.add(lblNewLabel);

		dohvatiIme = new JTextField();
		dohvatiIme.setFont(new Font("Tahoma", Font.BOLD, 13));
		dohvatiIme.setBorder(null);
		dohvatiIme.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		dohvatiIme.setFocusable(false);
		dohvatiIme.setEditable(false);
		dohvatiIme.setBackground(new Color(255, 255, 153));
		dohvatiIme.setHorizontalAlignment(SwingConstants.CENTER);
		dohvatiIme.setBounds(20, 30, 203, 20);
		panel.add(dohvatiIme);
		dohvatiIme.setColumns(10);

		JButton btnNewButton_13 = new JButton("Moj Profil");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zaposleniciPanel.setVisible(false);
				radnoMjestoPanel.setVisible(false);
				voditeljiPanel.setVisible(false);
				radnoMjestoToZaposlenikPanel.setVisible(false);
				radnoMjestoToVoditeljPanel.setVisible(false);
				mojProfilPanel.setVisible(true);
				refreshTableMojProfil();
			}
		});
		btnNewButton_13.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_13.setBackground(Color.WHITE);
		btnNewButton_13.setBounds(76, 55, 89, 23);
		panel.add(btnNewButton_13);

		IdVoditelj = new JLabel("New label");
		IdVoditelj.setVisible(false);
		IdVoditelj.setBounds(177, 59, 46, 14);
		panel.add(IdVoditelj);

		JButton btnNewButton_11 = new JButton("Dodijeli radno mjesto voditelju");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zaposleniciPanel.setVisible(false);
				radnoMjestoPanel.setVisible(false);
				voditeljiPanel.setVisible(false);
				radnoMjestoToZaposlenikPanel.setVisible(false);
				mojProfilPanel.setVisible(false);
				radnoMjestoToVoditeljPanel.setVisible(true);

				StringBuilder sb = new StringBuilder();
				voditeljController.getVoditeljIdImePrezime().forEach(t -> sb.append(t + ","));
				String voditelj = sb.toString();
				String[] listaVoditelj = voditelj.split(",");
				voditeljComboBox.setModel(new DefaultComboBoxModel(listaVoditelj));

				StringBuilder sb2 = new StringBuilder();
				radnoMjestoController.getRadnoMjestoIdAndName().forEach(t -> sb2.append(t + ","));
				String radnoMjesto = sb2.toString();
				String[] listaRadnoMjesto = radnoMjesto.split(",");
				radnoMjestoComboBox1.setModel(new DefaultComboBoxModel(listaRadnoMjesto));

				refreshTableRadnoMjestoToVoditelj();
			}
		});
		btnNewButton_11.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_11.setBackground(Color.WHITE);
		btnNewButton_11.setBounds(421, 55, 204, 23);
		izbornik.add(btnNewButton_11);
		getFrame().setBounds(100, 100, 984, 460);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().setLocationRelativeTo(null);

	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
		frame.setResizable(false);
	}

	public JTextField getDohvatiIme() {
		return dohvatiIme;
	}

	private void addVoditelj() {
		String ime = imeVoditelj.getText();
		String prezime = prezimeVoditelj.getText();
		String korisnickoIme = korisnickoImeVoditelj.getText().toLowerCase();
		char[] passwordChar = passwordVoditelj.getPassword();
		String password = new String(passwordChar);
		String encryptedPassword;
		boolean voditeljIsAdded = false;

		if (ime.isEmpty() || prezime.isEmpty() || korisnickoIme.isEmpty())
			JOptionPane.showMessageDialog(null, "Sva polja su obavezna!");
		else {
			if (!passwordValidator.isValid(password))
				JOptionPane.showMessageDialog(null,
						"The password must contain at least one lowercase character, one uppercase character, "
								+ "one digit, one special character, and a length between 8 to 20.");
			else {
				JOptionPane.showMessageDialog(null, "Uspjesno dodavanje!");
				encryptedPassword = encryptPassword.encrypt(password);

				voditeljIsAdded = voditeljController.addVoditelj(ime, prezime, korisnickoIme, encryptedPassword);

				if (!voditeljIsAdded)
					JOptionPane.showMessageDialog(null, "Neuspje�no dodavanje!");

				imeVoditelj.setText("");
				prezimeVoditelj.setText("");
				korisnickoImeVoditelj.setText("");
				passwordVoditelj.setText("");
			}
		}
	}

	private void updateMojProfil() {
		boolean updateVoditelj = false;
		int selectedRow = mojProfilTable.getSelectedRow();

		if (selectedRow == -1)
			JOptionPane.showMessageDialog(null, "Prvo uredite polje tablice");
		else {
			Integer idVoditelj = Integer
					.parseInt((String) mojProfilTable.getModel().getValueAt(mojProfilTable.getSelectedRow(), 0));
			String imeVoditelja = (String) mojProfilTable.getModel().getValueAt(mojProfilTable.getSelectedRow(), 1);
			String prezimeVoditelja = (String) mojProfilTable.getModel().getValueAt(mojProfilTable.getSelectedRow(), 2);
			String korisnickoImeVoditelja = (String) mojProfilTable.getModel()
					.getValueAt(mojProfilTable.getSelectedRow(), 3);

			updateVoditelj = voditeljController.updateVoditelj(idVoditelj, imeVoditelja, prezimeVoditelja,
					korisnickoImeVoditelja);

			if (!updateVoditelj)
				JOptionPane.showMessageDialog(null, "Voditelj nije azuriran");
			else
				JOptionPane.showMessageDialog(null, "Voditelj je azuriran!");
		}
	}

	final JLabel label = new JLabel();

	private void deleteMojProfil() {
		int selectedRow = mojProfilTable.getSelectedRow();
		boolean deletedVoditelj = false;

		if (selectedRow == -1)
			JOptionPane.showMessageDialog(null, "Prvo izaberite polje tablice");
		else {
			int result = JOptionPane.showConfirmDialog(frame, "Jeste li sigurni?", "Brisanje profila",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (result == JOptionPane.YES_OPTION) {
				int idVoditelj = Integer
						.parseInt((String) mojProfilTable.getModel().getValueAt(mojProfilTable.getSelectedRow(), 0));
				deletedVoditelj = voditeljController.deleteVoditelj(idVoditelj);
			} else if (result == JOptionPane.NO_OPTION) {
				label.setText("Odabrali ste: NE");
			} else {
				label.setText("Nista oznaceno");
			}

			if (deletedVoditelj) {
				JOptionPane.showMessageDialog(null, "Profil je obrisan!");
				frame.dispose();
				Login window = new Login();
				window.getFrmEmployeeManagementSystem().setVisible(true);
			}
		}
	}

	private void addZaposlenik() {
		String imes = ime.getText();
		String prezimes = prezime.getText();
		String datumR = godinaRodenja.getText();
		Boolean zaposlenikIsAdded = false;
		Date dateDR = null;

		if (imes.isEmpty() || prezimes.isEmpty() || datumR.isEmpty())
			JOptionPane.showMessageDialog(null, "Sva polja su obavezna!");
		else {
			if (!isValid(datumR))
				JOptionPane.showMessageDialog(null, "Datum nije u pravilnom formatu (yyyy-mm-dd)");
			else {
				JOptionPane.showMessageDialog(null, "Uspjesno dodavanje");

				imes = imes.substring(0, 1).toUpperCase() + imes.substring(1).toLowerCase();
				prezimes = prezimes.substring(0, 1).toUpperCase() + prezimes.substring(1).toLowerCase();

				try {
					dateDR = new SimpleDateFormat("yyyy-MM-dd").parse(datumR);
				} catch (ParseException e1) {
					e1.getMessage();
				}

				java.sql.Date dateFormatted = new java.sql.Date(dateDR.getTime());
				zaposlenikIsAdded = zaposlenikController.addZaposlenik(imes, prezimes, dateFormatted);

				if (!zaposlenikIsAdded)
					JOptionPane.showMessageDialog(null, "Neuspjesno upisivanje zaposlenika");
				ime.setText("");
				prezime.setText("");
				godinaRodenja.setText("");
			}
		}
	}

	private void updateZaposlenik() {
		boolean updateZaposlenika = false;
		int selectedRow = zaposleniciTable.getSelectedRow();
		Date dateDR = null;

		if (selectedRow == -1)
			JOptionPane.showMessageDialog(null, "Prvo uredite polje tablice");
		else {
			int idZaposlenika = Integer
					.parseInt((String) zaposleniciTable.getModel().getValueAt(zaposleniciTable.getSelectedRow(), 0));
			String imeZaposlenika = (String) zaposleniciTable.getModel().getValueAt(zaposleniciTable.getSelectedRow(),
					1);
			String prezimeZaposlenika = (String) zaposleniciTable.getModel()
					.getValueAt(zaposleniciTable.getSelectedRow(), 2);
			String datumRodenjaZaposlenika = (String) zaposleniciTable.getModel()
					.getValueAt(zaposleniciTable.getSelectedRow(), 3);

			try {
				dateDR = new SimpleDateFormat("yyyy-MM-dd").parse(datumRodenjaZaposlenika);
			} catch (ParseException e1) {
				e1.getMessage();
			}
			java.sql.Date dateFormatted = new java.sql.Date(dateDR.getTime());

			updateZaposlenika = zaposlenikController.updateZaposlenik(idZaposlenika, imeZaposlenika, prezimeZaposlenika,
					dateFormatted);

			if (!updateZaposlenika)
				JOptionPane.showMessageDialog(null, "Zaposlenik nije azuriran");
			else
				JOptionPane.showMessageDialog(null, "Zaposlenik je azuriran!");
		}
	}

	private void deleteZaposlenik() {
		int selectedRow = zaposleniciTable.getSelectedRow();
		boolean deletedZaposlenik = false;
		if (selectedRow == -1)
			JOptionPane.showMessageDialog(null, "Prvo uredite polje tablice");
		else {
			int idZaposlenika = Integer
					.parseInt((String) zaposleniciTable.getModel().getValueAt(zaposleniciTable.getSelectedRow(), 0));
			deletedZaposlenik = zaposlenikController.deleteZaposlenik(idZaposlenika);

			if (!deletedZaposlenik)
				JOptionPane.showMessageDialog(null, "Zaposlenik nije obrisan");
			else
				JOptionPane.showMessageDialog(null, "Zaposlenik je obrisan!");
		}
	}

	private void addRadnoMjesto() {
		boolean addRadnoMjesto = false;
		String radnoMjestos = radnoMjesto.getText();

		if (radnoMjestos.isEmpty())
			JOptionPane.showMessageDialog(null, "Polje 'naziv radnog mjesta' je obavezno!");
		else {
			radnoMjestos = radnoMjestos.substring(0, 1).toUpperCase() + radnoMjestos.substring(1).toLowerCase();
			addRadnoMjesto = radnoMjestoController.addRadnoMjesto(radnoMjestos);
		}
		if (!addRadnoMjesto)
			JOptionPane.showMessageDialog(null, "Neuspjesno upisivanje radnog mjesta");
		else {
			JOptionPane.showMessageDialog(null, "Uspjesno upisivanje radnog mjesta");
			radnoMjesto.setText("");
		}
	}

	private void updateRadnoMjesto() {
		boolean updateRadnoMjesto = false;
		int selectedRow = radnoMjestoTable.getSelectedRow();

		if (selectedRow == -1)
			JOptionPane.showMessageDialog(null, "Prvo uredite polje tablice");
		else {
			int idRadnoMjesto = Integer
					.parseInt((String) radnoMjestoTable.getModel().getValueAt(radnoMjestoTable.getSelectedRow(), 0));
			String nazivRadnogMjesta = (String) radnoMjestoTable.getModel()
					.getValueAt(radnoMjestoTable.getSelectedRow(), 1);

			updateRadnoMjesto = radnoMjestoController.updateRadnoMjesto(idRadnoMjesto, nazivRadnogMjesta);

			if (!updateRadnoMjesto)
				JOptionPane.showMessageDialog(null, "Radno mjesto nije azurirano");
			else
				JOptionPane.showMessageDialog(null, "Radno mjesto je azurirano!");
		}
	}

	private void deleteRadnoMjesto() {
		int selectedRow = radnoMjestoTable.getSelectedRow();
		boolean deletedRadnoMjesto = false;

		if (selectedRow == -1)
			JOptionPane.showMessageDialog(null, "Prvo uredite polje tablice");
		else {
			int idRadnoMjesto = Integer
					.parseInt((String) radnoMjestoTable.getModel().getValueAt(radnoMjestoTable.getSelectedRow(), 0));
			deletedRadnoMjesto = radnoMjestoController.deleteRadnoMjesto(idRadnoMjesto);

			if (!deletedRadnoMjesto)
				JOptionPane.showMessageDialog(null, "Radno mjesto nije obrisano");
			else
				JOptionPane.showMessageDialog(null, "Radno mjesto je obrisano!");
		}
	}

	private static boolean isValid(final String date) {
		boolean valid = false;

		try {
			LocalDate.parse(date, DateTimeFormatter.ofPattern("uuuu-M-d").withResolverStyle(ResolverStyle.STRICT));
			valid = true;
		} catch (DateTimeParseException e) {
			e.getMessage();
			valid = false;
		}
		return valid;
	}

	private void refreshTableZaposlenik() {
		String[] spliter;
		List<String> listaZaposlenik = zaposlenikController.getAllZaposlenik();
		DefaultTableModel tables = (DefaultTableModel) zaposleniciTable.getModel();

		if (listaZaposlenik.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nema upisanih zaposlenika.");
		} else {
			tables.setRowCount(0);
			for (String zaposlenik : listaZaposlenik) {
				spliter = zaposlenik.split(", ");
				tables.addRow(spliter);
			}
		}
	}

	private void refreshTableVoditelji() {
		String[] spliter;
		List<String> listaVoditelj = voditeljController.getAllVoditelj();
		DefaultTableModel tables = (DefaultTableModel) voditeljTable.getModel();

		if (listaVoditelj.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nema upisanih voditelja.");
		} else {
			tables.setRowCount(0);
			for (String voditelj : listaVoditelj) {
				spliter = voditelj.split(", ");
				tables.addRow(spliter);
			}
		}
	}

	private void refreshTableMojProfil() {
		String labelText = IdVoditelj.getText();
		Integer idVoditelj = Integer.valueOf(labelText);
		String[] spliter;
		List<String> listaVoditelj = voditeljController.findVoditeljById(idVoditelj);
		DefaultTableModel tables = (DefaultTableModel) mojProfilTable.getModel();

		if (listaVoditelj.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nema upisanih voditelja.");
		} else {
			tables.setRowCount(0);
			for (String voditelj : listaVoditelj) {
				spliter = voditelj.split(", ");
				tables.addRow(spliter);
			}
		}
	}

	private void refreshTableRadnoMjesto() {
		String[] spliter;
		List<String> listaRadnoMjesto = radnoMjestoController.getAllRadnoMjesto();
		DefaultTableModel tables = (DefaultTableModel) radnoMjestoTable.getModel();

		if (listaRadnoMjesto.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nema upisanih zaposlenika.");
		} else {
			tables.setRowCount(0);
			for (String zaposlenik : listaRadnoMjesto) {
				spliter = zaposlenik.split(", ");
				tables.addRow(spliter);
			}
		}
	}

	private void refreshTableRadnoMjestoToZaposlenik() {
		String[] spliter;
		List<String> listaRadnoMjestoToZaposlenik = radnoMjestoToZaposlenikController.getAllRadnoMjestoToZaposlenik();
		DefaultTableModel tables = (DefaultTableModel) radnoMjestoToZaposlenikTable.getModel();

		if (listaRadnoMjestoToZaposlenik.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nema upisanih podataka.");
		} else {
			tables.setRowCount(0);
			for (String radnoMjestoToZaposlenik : listaRadnoMjestoToZaposlenik) {
				spliter = radnoMjestoToZaposlenik.split(", ");
				tables.addRow(spliter);
			}
		}
	}

	private void refreshTableRadnoMjestoToVoditelj() {
		String[] spliter;
		List<String> listaRadnoMjestoToVoditelj = radnoMjestoToVoditeljController.getAllRadnoMjestoToZaposlenik();
		DefaultTableModel tables = (DefaultTableModel) radnoMjestoToVoditeljTable.getModel();

		if (listaRadnoMjestoToVoditelj.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nema upisanih podataka.");
		} else {
			tables.setRowCount(0);
			for (String radnoMjestoToVoditelj : listaRadnoMjestoToVoditelj) {
				spliter = radnoMjestoToVoditelj.split(", ");
				tables.addRow(spliter);
			}
		}
	}

	public JLabel getIdVoditelj() {
		return IdVoditelj;
	}
}
