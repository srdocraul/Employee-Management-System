package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
	private static Connection conn;
	private final String URL = "jdbc:mysql://";
	private final String USERNAME = "";
	private final String PASSWORD = "";
	private static Database database = new Database();

	private Database() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Database.conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception ex) {
			Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static Database getDatabase() {
		return database;
	}

	public static Connection getConnection() {
		return conn;
	}
}
