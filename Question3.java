package com.metacube.get2019;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * It is a class for assignment3
 * @author Kritika
 *
 */
public class Question3 {

	/**
	 * It is a main method used to return number of product effected on a particular condition.
	 * @param args unused
	 * @throws SQLException
	 */
	public static void main(String args[]) throws SQLException {
		DatabaseConnection jdbcObj = new DatabaseConnection();
		Queries queryObj = new Queries();
		ArrayList<String> query = queryObj.query3();
		try (Connection con = jdbcObj.connect();
				PreparedStatement stmt = con.prepareStatement(query.get(0))) {
				stmt.executeUpdate();
		}
		try (Connection con = jdbcObj.connect();
		PreparedStatement stmt = con.prepareStatement(query.get(1))) {
			int rowsAffected = stmt.executeUpdate();
			System.out.println("Number of product effected  : " + rowsAffected);
		}
	}
}