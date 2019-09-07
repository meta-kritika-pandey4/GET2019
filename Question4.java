package com.metacube.get2019;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * It is a class for assignment 4
 * @author Kritika
 *
 */
public class Question4 {
	
	/**
	 * It is a main method used to get category and number of there child categories.
	 * @param args unused
	 * @throws SQLException
	 */
	public static void main(String args[]) throws SQLException {
		DatabaseConnection jdbcObj = new DatabaseConnection();
		Queries queryObj = new Queries();
		try( Connection con = jdbcObj.connect();
		PreparedStatement stmt = con.prepareStatement(queryObj.query4())) {
			ResultSet rs = stmt.executeQuery();
			System.out.println("Category_Name  SubCategories");
			while (rs.next()) {
				System.out.println(rs.getString(1) + "\t" + rs.getInt(2));
			}
		}
	}
}