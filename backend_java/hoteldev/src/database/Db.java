package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Db {

	private static final String USERNAME = "Root";
	private static final String PASSWORD = " ";
	private static final String DATABASE_URL = "jdbc:mysql.//localhost:3306/hoteldev";

	public static Connection createConnectionToMySQL() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Cria a conexão com o banco de dados
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

		return connection;
	}

	public static void main(String[] args) throws Exception {

		Connection con = createConnectionToMySQL();

		if (con != null) {
			System.out.println("Conexão feita com sucesso!");
			con.close();
		}
	}
}