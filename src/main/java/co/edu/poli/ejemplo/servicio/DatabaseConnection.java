package co.edu.poli.ejemplo.servicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class DatabaseConnection {

	private DatabaseConnection() throws Exception {

		try {
			ResourceBundle bundle = ResourceBundle.getBundle("database");
			String url = bundle.getString("database.url");
			String username = bundle.getString("database.user");
			String password = bundle.getString("database.password");

			if (url == null || username == null || password == null) {
				throw new Exception("Faltan propiedades necesarias en el archivo database.properties.");
			}
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			throw new Exception("Error al conectar a la base de datos");
		}
	}

	private static DatabaseConnection instancia;

	private Connection connection;

	public static DatabaseConnection getInstance() throws Exception {
		if (instancia == null) {
			instancia = new DatabaseConnection();
		}
		return instancia;
	}

	public Connection getConnection() {
		return connection;
	}

}