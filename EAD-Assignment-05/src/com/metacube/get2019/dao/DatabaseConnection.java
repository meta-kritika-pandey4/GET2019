package com.metacube.get2019.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
  *This class is used for database connectivity
  * @autor Kritika
  *
  */
public class DatabaseConnection {
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping_store", "root", "root");
			return connection;
		} catch (ClassNotFoundException e) {
			throw new AssertionError("class not found");
		} catch (SQLException e) {
			throw new AssertionError("SQL Exception");
		}
	}
}


