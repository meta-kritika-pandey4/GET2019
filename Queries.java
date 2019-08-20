package com.metacube.get2019;

import java.util.ArrayList;

/**
 * It is a class which holds all queries
 * @author Kritika
 *
 */
public class Queries {

	/**
	 * It is a method to return query which get details of order from the database.
	 * @param user_Id id of user
	 * @return sql query
	 */
	public String returnQuery(String user_Id) {
		String query1 = "SELECT so.order_id, so.order_date, SUM((p.product_price*(100-oi.discount)/100)*oi.ordered_quantity) AS Order_Total FROM shopping_order so"
				+ " INNER JOIN order_item oi ON so.order_id = oi.order_id "
				+ " INNER JOIN stock s ON s.stock_id = oi.stock_id "
				+ " INNER JOIN product p ON p.product_id = s.product_id "
				+ " WHERE so.user_id = '" + user_Id + "' AND oi.order_status = 'Shipped' "
				+ " GROUP BY order_id "
				+ " ORDER BY order_date" ;
		return query1;
	}
	
	/**
	 * It is a method to return query to insert image of a product into image table.
	 * @return sql query
	 */
	public String query2() {
		String query2 = "INSERT INTO image VALUES (?, ?, ?, ?)";
		return query2;
	}
	
	/**
	 * It is a method to return query to update details of a product into the database.
	 * @return sql query
	 */
	public ArrayList<String> query3() {
		ArrayList<String> queries = new ArrayList<String>();
		String query5 = "DELETE FROM image"
				+ " WHERE product_id"
				+ " NOT IN (SELECT product_id FROM(SELECT p.product_id FROM product p"
				+ " INNER JOIN stock s ON p.product_id = s.product_id"
				+ " INNER JOIN order_item  oi ON s.stock_id = oi.stock_id"
				+ " INNER JOIN shopping_order so ON so.order_id = oi.order_id"
				+ " WHERE s.stock_id = oi.stock_id AND DATEDIFF(CURRENT_TIMESTAMP(), so.order_date) < 365 ) AS temporary)";
		queries.add(query5);
		String query3 = "DELETE FROM product"
				+ " WHERE product_id"
				+ " NOT IN (SELECT product_id FROM(SELECT p.product_id FROM product p"
				+ " INNER JOIN stock s ON p.product_id = s.product_id"
				+ " INNER JOIN order_item  oi ON s.stock_id = oi.stock_id"
				+ " INNER JOIN shopping_order so ON so.order_id = oi.order_id"
				+ " "
				+ " WHERE s.stock_id = oi.stock_id AND DATEDIFF(CURRENT_TIMESTAMP(), so.order_date) < 365 ) AS temporary)";
		queries.add(query3);
		return queries;
	}
	
	/**
	 * It is a method to return query used to get parent categories and no of there child categories.
	 * @return sql query
	 */
	public String query4() {
		String query4 = " SELECT p.category_name, count(p.parent_id) as SubCategories"
				+ " FROM category c INNER JOIN category p"
				+ " ON  c.parent_id = p.category_id "
				+ " GROUP BY p.category_id "
				+ " ORDER BY p.category_name ";
		
		return query4;
	}
}