package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Database;
import model.Zaposlenik;

public class ZaposlenikController {
	Zaposlenik zaposlenik = new Zaposlenik();

	public boolean addZaposlenik(String ime, String prezime, Date datumRodenja) {
		zaposlenik.setIme(ime);
		zaposlenik.setPrezime(prezime);
		zaposlenik.setDatumRodenja(datumRodenja);

		String query = "insert into zaposlenik(ime, prezime, datum_rodenja) values (?,?,?)";

		try {
			Connection conn = Database.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, zaposlenik.getIme());
			stmt.setString(2, zaposlenik.getPrezime());
			stmt.setDate(3, (java.sql.Date) zaposlenik.getDatumRodenja());
			stmt.execute();
			return true;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;

	}

	public List<String> getAllZaposlenik() {
		List<String> listaZaposlenika = new ArrayList<String>();

		String query = "select * from zaposlenik";

		try {
			Connection conn = Database.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);

			try {
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					zaposlenik.setId(rs.getInt(1));
					zaposlenik.setIme(rs.getString(2));
					zaposlenik.setPrezime(rs.getString(3));
					zaposlenik.setDatumRodenja(rs.getDate(4));
					listaZaposlenika.add(zaposlenik.getId() + ", " + zaposlenik.getIme() + ", "
							+ zaposlenik.getPrezime() + ", " + zaposlenik.getDatumRodenja());
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			return listaZaposlenika;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		listaZaposlenika = null;
		return listaZaposlenika;

	}

	public boolean updateZaposlenik(int id, String ime, String prezime, Date datumRodenja) {
		Zaposlenik zaposlenik = new Zaposlenik();
		zaposlenik.setId(id);
		zaposlenik.setIme(ime);
		zaposlenik.setPrezime(prezime);
		zaposlenik.setDatumRodenja(datumRodenja);

		String query = "update zaposlenik set ime =?, prezime =?, datum_rodenja =? WHERE id =?";

		try {
			Connection conn = Database.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, zaposlenik.getIme());
			stmt.setString(2, zaposlenik.getPrezime());
			stmt.setDate(3, (java.sql.Date) zaposlenik.getDatumRodenja());
			stmt.setInt(4, zaposlenik.getId());
			stmt.executeUpdate();

			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return false;
	}

	public boolean deleteZaposlenik(int id) {
		Zaposlenik zaposlenik = new Zaposlenik();
		zaposlenik.setId(id);

		String query = "delete from zaposlenik where id=?";

		try {
			Connection conn = Database.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, zaposlenik.getId());
			ps.execute();

			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return false;
	}

	public List<String> getZaposlenikIdImePrezime() {
		List<String> zaposlenikList = new ArrayList<String>();

		String query = "select id, ime, prezime from rsrdoc.zaposlenik";

		try {
			Connection conn = Database.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);
			try {
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					zaposlenik.setId(rs.getInt(1));
					zaposlenik.setIme(rs.getString(2));
					zaposlenik.setPrezime(rs.getString(3));
					zaposlenikList.add(zaposlenik.getId() + " " + zaposlenik.getIme() + " " + zaposlenik.getPrezime());
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

}
