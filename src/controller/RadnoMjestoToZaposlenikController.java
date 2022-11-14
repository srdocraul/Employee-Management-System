package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Database;
import model.RadnoMjesto;
import model.Zaposlenik;

public class RadnoMjestoToZaposlenikController {
	
	public boolean assignRadnoMjestoToZaposlenik(int idRadnoMjesto, int idZaposlenik) {
		RadnoMjesto radnoMjesto = new RadnoMjesto();
		radnoMjesto.setId(idRadnoMjesto);
		Zaposlenik zaposlenik = new Zaposlenik();
		zaposlenik.setId(idZaposlenik);

		String query = "insert into rsrdoc.zaposlenik_radno_mjesto(id_radno_mjesto, id_zaposlenik) values(?,?)";

		try {
			Connection conn = Database.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, radnoMjesto.getId());
			stmt.setInt(2, zaposlenik.getId());
			stmt.execute();
			return true;

		} catch (SQLException e) {
			return false;
		}
	}

	public List<String> getAllRadnoMjestoToZaposlenik() {
		
		List<String> radnoMjestoToZaposlenikList = new ArrayList<String>();

		String query = "select zaposlenik.ime, zaposlenik.prezime, radno_mjesto.naziv from rsrdoc.zaposlenik_radno_mjesto "
				+ "left join rsrdoc.zaposlenik on zaposlenik.id = zaposlenik_radno_mjesto.id_zaposlenik "
				+ "left join rsrdoc.radno_mjesto on radno_mjesto.id = zaposlenik_radno_mjesto.id_radno_mjesto";

		try {
			Connection conn = Database.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);
			try {
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					radnoMjestoToZaposlenikList.add(rs.getString(1) + " " + rs.getString(2) + ", " + rs.getString(3));
				}
			} catch (SQLException e1) {
				System.out.println(e1);
			}
			return radnoMjestoToZaposlenikList;
		} catch (SQLException e) {
			radnoMjestoToZaposlenikList = null;
			return radnoMjestoToZaposlenikList;
		}
	}

}
