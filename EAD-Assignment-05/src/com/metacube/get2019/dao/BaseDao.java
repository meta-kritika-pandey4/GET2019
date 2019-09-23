package com.metacube.get2019.dao;

import java.util.List;

import com.metacube.get2019.enums.Status;
import com.metacube.get2019.model.Cart;
import com.metacube.get2019.model.Product;

/**
 * This class represents the base dao
 * @author Kritika
 *
 */
public interface BaseDao {

	/**
	 * This method is used to authenticate the user
	 * @param query
	 * @return true if user is authenticated else false
	 */
	public boolean userAuthentication(String query);
	
	/**
	 * This method is used to get the user id by email
	 * @param query
	 * @return user ID searched by email
	 */
	public int getUserIdByEmail(String query);
	
	/**
	 * This method is used to check is the input product exists in the stock
	 * @param query
	 * @return true if product is in product stock else false
	 */
	public boolean isProductExist(String query);
	
	/**
	 * This method is used to check is the input product exists in the cart
	 * @param query
	 * @return true if product is in cart else false
	 */
	public boolean productIsInCart(String query);
	
	/**
	 * This method is used to add a new product to the cart
	 * @param queryList
	 * @return Status (ADDED) if product added else FAILED
	 */
	public Status addProductToCart(List<String> queryList);
	
	/**
	 * This method is used to update a product in the cart
	 * @param queryList
	 * @return Status (UPDATED) if product added else FAILED
	 */
	public Status updateProductInCart(List<String> queryList);
	
	/**
	 * This method is used to show the user cart
	 * @param query
	 * @return list of product in cart 
	 */
	public List<Cart> showCart(String query);
	
	/**
	 * This method is used to delete the product from the cart
	 * @param queryList
	 * @return Status (DELETED) if product added else FAILED
	 */
	public Status deleteProduct(List<String> queryList);
	
	/**
	 * This method is used to get the list of products in stock
	 * @param query
	 * @return list of products in stock
	 */
	public List<Product> getProductList(String query);
	/**
	 * This method is used to retrieve the product by product_code
	 * @param query
	 * @return
	 */
	public Product getProductById(String query);
}