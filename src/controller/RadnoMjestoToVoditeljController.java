package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Database;
import model.RadnoMjesto;
import model.Voditelj;
import model.Zaposlenik;

public class RadnoMjestoToVoditeljController {

	RadnoMjesto radnoMjesto = new RadnoMjesto();
	Voditelj voditelj = new Voditelj();
	Zaposlenik zaposlenik = new Zaposlenik();

	public boolean assignRadnoMjestoToVoditelj(int idRadnoMjesto, int idVoditelj) {

		radnoMjesto.setId(idRadnoMjesto);
		voditelj.setId(idVoditelj);

		String query = "insert into rsrdoc.voditelj_radno_mjesto(id_voditelj, id_radno_mjesto) values(?,?)";

		try {
			Connection conn = Database.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, voditelj.getId());
			stmt.setInt(2, radnoMjesto.getId());
			stmt.execute();
			return true;

		} catch (SQLException e) {
			return false;
		}
	}

	public List<String> getAllRadnoMjestoToZaposlenik() {

		List<String> radnoMjestoToVoditeljList = new ArrayList<String>();

		String query = "select voditelj.ime, voditelj.prezime, radno_mjesto.naziv, voditelj_radno_mjesto.id_radno_mjesto from rsrdoc.voditelj_radno_mjesto "
				+ "left join rsrdoc.voditelj on voditelj.id = voditelj_radno_mjesto.id_voditelj "
				+ "left join rsrdoc.radno_mjesto on radno_mjesto.id = voditelj_radno_mjesto.id_radno_mjesto";

		try {
			Connection conn = Database.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);
			try {
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					voditelj.setId(rs.getInt(4));

					try {
						String queryZaposlenik = "select count(zaposlenik_radno_mjesto.id_zaposlenik) from rsrdoc.zaposlenik_radno_mjesto where id_radno_mjesto =?";
						PreparedStatement stmt1 = conn.prepareStatement(queryZaposlenik);
						stmt1.setInt(1, voditelj.getId());

						ResultSet rs1 = stmt1.executeQuery();
						while (rs1.next())
							zaposlenik.setBrojZaposlenika(rs1.getInt(1));
						rs1.close();
					} catch (SQLException e) {
						System.out.println(e);
					}

					radnoMjestoToVoditeljList.add(rs.getString(1) + " " + rs.getString(2) + ", " + rs.getString(3)
							+ ", " + zaposlenik.getBrojZaposlenika());
				}
			} catch (SQLException e1) {
				System.out.println(e1);
			}
			return radnoMjestoToVoditeljList;
		} catch (SQLException e) {
			radnoMjestoToVoditeljList = null;
			return radnoMjestoToVoditeljList;
		}
	}

}
