package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Database;
import model.Voditelj;

public class VoditeljController {

	Voditelj voditelj = new Voditelj();

	public boolean addVoditelj(String ime, String prezime, String korisnickoIme, String password) {
		voditelj.setIme(ime);
		voditelj.setPrezime(prezime);
		voditelj.setKorisnickoIme(korisnickoIme);
		voditelj.setPassword(password);

		String query = "insert into voditelj(ime, prezime, korisnicko_ime, password) values (?,?,?,?)";

		try {
			Connection conn = Database.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, voditelj.getIme());
			stmt.setString(2, voditelj.getPrezime());
			stmt.setString(3, voditelj.getKorisnickoIme());
			stmt.setString(4, voditelj.getPassword());
			stmt.execute();
			return true;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;

	}

	public List<String> getAllVoditelj() {
		List<String> listaVoditelja = new ArrayList<String>();

		String query = "select * from voditelj";

		try {
			Connection conn = Database.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);

			try {
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					voditelj.setId(rs.getInt(1));
					voditelj.setIme(rs.getString(2));
					voditelj.setPrezime(rs.getString(3));
					voditelj.setKorisnickoIme(rs.getString(4));
					listaVoditelja.add(voditelj.getId() + ", " + voditelj.getIme() + ", " + voditelj.getPrezime() + ", "
							+ voditelj.getKorisnickoIme());
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			return listaVoditelja;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		listaVoditelja = null;
		return listaVoditelja;

	}

	public boolean updateVoditelj(Integer id, String ime, String prezime, String korisnickoIme) {
		voditelj.setIme(ime);
		voditelj.setId(id);
		voditelj.setPrezime(prezime);
		voditelj.setKorisnickoIme(korisnickoIme);

		String query = "update rsrdoc.voditelj set ime =?, prezime =?, korisnicko_ime =? WHERE id =?";

		try {
			Connection conn = Database.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, voditelj.getIme());
			stmt.setString(2, voditelj.getPrezime());
			stmt.setString(3, voditelj.getKorisnickoIme());
			stmt.setInt(4, voditelj.getId());
			stmt.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return false;
	}

	public boolean deleteVoditelj(int id) {
		voditelj.setId(id);

		String query = "delete from voditelj where id=?";

		try {
			Connection conn = Database.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, voditelj.getId());
			ps.execute();

			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return false;
	}

	public List<String> getVoditeljIdImePrezime() {
		List<String> zaposlenikList = new ArrayList<String>();

		String query = "select id, ime, prezime from rsrdoc.voditelj";

		try {
			Connection conn = Database.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);
			try {
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					voditelj.setId(rs.getInt(1));
					voditelj.setIme(rs.getString(2));
					voditelj.setPrezime(rs.getString(3));
					zaposlenikList.add(voditelj.getId() + " " + voditelj.getIme() + " " + voditelj.getPrezime());
				}

			} catch (SQLException e1) {
				System.out.println(e1);
			}

			return zaposlenikList;

		} catch (SQLException e) {
			zaposlenikList = null;
			return zaposlenikList;
		}
	}

	public List<String> findVoditeljById(Integer id) {
		List<String> voditeljList = new ArrayList<String>();
		voditelj.setId(id);

		String query = "select id, ime, prezime, korisnicko_ime from rsrdoc.voditelj where id=?";

		try {
			Connection conn = Database.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, voditelj.getId());

			try {
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					voditelj.setId(rs.getInt(1));
					voditelj.setIme(rs.getString(2));
					voditelj.setPrezime(rs.getString(3));
					voditelj.setKorisnickoIme(rs.getString(4));
					voditeljList.add(
							voditelj.getId() + ", " + voditelj.getIme() + ", " + voditelj.getPrezime() + ", " + voditelj.getKorisnickoIme());
				}

			} catch (SQLException e1) {
				System.out.println(e1);
			}

			return voditeljList;

		} catch (SQLException e) {
			voditeljList = null;
			return voditeljList;
		}
	}
}
