package com.metacube.get2019;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * It is a class to open connection with database;
 * @author Kritika
 * 
 *
 */
public class DatabaseConnection {

		/**
		 * It is a method used to open a connection with the database
		 * @return connection object
		 * @throws SQLException
		 */
		public Connection connect() throws SQLException {
			String host = "jdbc:mysql://localhost:3306/";
			String dbName = "meta_parking_system";
			String mysqlURL = host + dbName;
			String userId = "root";
			String password = "root";
			Connection connection;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = (Connection)DriverManager.getConnection(mysqlURL, userId, password);
				return connection;
			} catch (ClassNotFoundException e) {
				System.out.println("Error loading driver");
			} catch (SQLException e) {
				System.out.println("SQL connection error");
			}
			return null;
		}
}
