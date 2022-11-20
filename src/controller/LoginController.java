package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import model.Database;
import model.Voditelj;
import security.EncryptPassword;

public class LoginController {
	Voditelj voditelj = new Voditelj();

	public boolean checkLogin(String korisnickoIme, String password) {
		EncryptPassword encryptPassword = new EncryptPassword();
		voditelj.setKorisnickoIme(korisnickoIme);
		voditelj.setPassword(password);

		String query = "select korisnicko_ime, id FROM voditelj WHERE korisnicko_ime=?";

		try {
			Connection conn = Database.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, voditelj.getKorisnickoIme());

			ResultSet rs = stmt.executeQuery();

			if (!rs.next())
				JOptionPane.showMessageDialog(null, "Korsinik ne postoji u bazi!");
			else {
				Integer requestedId = rs.getInt(2);
				voditelj.setId(requestedId);

				String upit2 = "select password from voditelj where id=?";

				PreparedStatement ps1 = conn.prepareStatement(upit2);
				ps1.setInt(1, requestedId);

				ResultSet rs1 = ps1.executeQuery();
				try (Statement stmt1 = conn.createStatement()) {
				}

				if (rs1.next()) {
					String passwordIzUpita = rs1.getString(1);
					String passwordCheck = encryptPassword.encrypt(voditelj.getPassword());

					if (!passwordCheck.equals(passwordIzUpita))
						JOptionPane.showMessageDialog(null, "Password nije točno upisan!");
					else {
						JOptionPane.showMessageDialog(null, "Dobrodosli!");
						return true;
					}
				}
			}
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
		}
		return false;
	}

	public boolean checkPassword(String password) {
		EncryptPassword encryptPassword = new EncryptPassword();
		voditelj.setPassword(password);

		String query = "select password from voditelj where password=?";

		try {
			String passwordCheck = encryptPassword.encrypt(voditelj.getPassword());

			Connection conn = Database.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, passwordCheck);

			ResultSet rs = stmt.executeQuery();

			if (!rs.next())
				JOptionPane.showMessageDialog(null, "Upisana šifra nije valjana");
			else
				return true;
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
		}
		return false;
	}
	
	public boolean updatePassword(Integer id, String password) {
		voditelj.setPassword(password);
		voditelj.setId(id);
		
		String query = "update rsrdoc.voditelj set password =? WHERE id =?";
		
		try {
			Connection conn = Database.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, voditelj.getPassword());
			stmt.setInt(2, voditelj.getId());
			stmt.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return false;
	}

	public Integer getIdFromVoditelj() {
		return voditelj.getId();
	}
}
