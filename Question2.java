package com.metacube.get2019;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * It is a class for Assignment2
 * @author Kritika
 *
 */
public class Question2 {
	
	/**
	 * It is a method used for batch Insert.
	 * @param imageList List of images to be inserted
	 * @param product_id product id
	 * @throws SQLException
	 */
	public static void insertImage(List<String> imageList, String product_id) throws SQLException {
		DatabaseConnection jdbcObj = new DatabaseConnection();
		Queries queryObj = new Queries();
		try (Connection con = jdbcObj.connect();
		PreparedStatement stmt = con.prepareStatement(queryObj.query2()); ) {
			con.setAutoCommit(false);
			for(int i = 0; i < imageList.size(); i++) {
				String columnValues[] = imageList.get(i).split(",");
				stmt.setString(1, columnValues[0]);
				stmt.setString(2, columnValues[1]);
				stmt.setString(3, columnValues[2]);
				stmt.setString(4, product_id);
				stmt.addBatch();
			}
			int[] result = stmt.executeBatch();
			System.out.println("The number of rows inserted  : "+ result.length);
			con.commit();
		}
	}
	
	/**
	 * It is a main method.
	 * @param args unused.
	 * @throws SQLException
	 */
	public static void main(String args[]) {
		Scanner sc =  new Scanner(System.in);
		try {
			List<String> url = new ArrayList<String>();
			System.out.print("Enter the id of product for which u want to insert images  : ");
			String product_id = sc.next();
			System.out.println("Enter the no of images you want to add : ");
			int noOfImages = sc.nextInt();
			for( int i = 0; i< noOfImages; i++ ){
				System.out.println("Enter the image id : ");
				String image_id = sc.next();
				System.out.println("Enter the name of the image : ");
				String image_name = sc.next();
				System.out.println("Enter the url of the image : ");
				String imageLocation = sc.next();
				sc.next();
				String tuple = image_id + "," + image_name + "," + imageLocation;
				url.add(tuple);
			}
			insertImage(url, product_id);
		}
		catch (SQLException e) {
			System.out.println(e.getStackTrace());
		} finally {
			sc.close();
		}
	}
}