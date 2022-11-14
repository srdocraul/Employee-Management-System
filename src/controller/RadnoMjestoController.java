package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Database;
import model.RadnoMjesto;

public class RadnoMjestoController {

	public boolean addRadnoMjesto(String radnoMjesto) {

		RadnoMjesto radnoMjesto1 = new RadnoMjesto(radnoMjesto);

		String query = "insert into radno_mjesto(naziv) values (?)";

		try {
			Connection conn = Database.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, radnoMjesto1.getRadnoMjesto());
			stmt.execute();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;

	}

	public List<String> getAllRadnoMjesto() {
		List<String> listaRadnoMjesto = new ArrayList<String>();

		String query = "select * from radno_mjesto";

		try {
			Connection conn = Database.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);

			try {
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					listaRadnoMjesto.add(rs.getInt(1) + ", " + rs.getString(2));
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			return listaRadnoMjesto;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		listaRadnoMjesto = null;
		return listaRadnoMjesto;

	}

	public boolean updateRadnoMjesto(int id, String naziv) {
		RadnoMjesto radnoMjesto = new RadnoMjesto();
		radnoMjesto.setId(id);
		radnoMjesto.setRadnoMjesto(naziv);

		String query = "update radno_mjesto set naziv=? where id =?";

		try {
			Connection conn = Database.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, radnoMjesto.getRadnoMjesto());
			stmt.setInt(2, radnoMjesto.getId());
			stmt.executeUpdate();

			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean deleteRadnoMjesto(int id) {
		RadnoMjesto radnoMjesto = new RadnoMjesto();
		radnoMjesto.setId(id);

		String query = "delete from radno_mjesto where id=?";

		try {
			Connection conn = Database.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, radnoMjesto.getId());
			ps.execute();

			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return false;
	}

	public List<String> getRadnoMjestoIdAndName() {

		List<String> listaRadnogMjesta = new ArrayList<String>();

		String query = "select id, naziv from rsrdoc.radno_mjesto";

		try {
			Connection conn = Database.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);

			try {
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					listaRadnogMjesta.add(rs.getInt(1) + " " + rs.getString(2));
				}
			} catch (Exception e1) {
				System.out.println(e1);
			}
			return listaRadnogMjesta;
		} catch (SQLException e) {
			System.out.println(e);
			listaRadnogMjesta = null;
			return listaRadnogMjesta;
		}
	}

}
