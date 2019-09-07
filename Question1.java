package com.metacube.get2019;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * It is a class for assignment1
 * @author Kritika
 *
 */
public class Question1 {

	/**
	 * It is a main method to get order details.
	 * @param args unused
	 * @throws SQLException
	 */
	public static void main(String args[]) throws SQLException {
		Scanner sc  = new Scanner(System.in);
		Queries queryObj = new Queries();
		DatabaseConnection jdbcObj = new DatabaseConnection();
		try ( Connection con = jdbcObj.connect(); ) {
			System.out.print("Enter the id of user : ");
			String user_Id = sc.next();
			try (PreparedStatement stmt = con.prepareStatement(queryObj.returnQuery(user_Id)); ) {
				ResultSet rs = stmt.executeQuery();
				System.out.println("Order_id  order_date  order_amount");
				while (rs.next()) {
					System.out.println( rs.getString("Order_id") + "\t" + rs.getTimestamp("Order_date") + "\t" + rs.getDouble("Order_Total"));
				}
				sc.close();
			}
		}
	}
}