package com.metacube.get2019.facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.get2019.dao.BaseDao;
import com.metacube.get2019.enums.Status;
import com.metacube.get2019.factory.Factory;
import com.metacube.get2019.model.Cart;
import com.metacube.get2019.model.Product;
import com.metacube.get2019.util.Constant;

/**
 * This class represents the facade layer
 * @author Kritika
 *
 */
public class ProductFacade {
	
	private BaseDao productDao; 
	public ProductFacade() throws ClassNotFoundException, SQLException{
		productDao = Factory.createProductDao();
	}
	
	/**
	 * This method is used to authenticate the user
	 * @param email
	 * @param password
	 * @return
	 */
	public boolean userAuthentication(String email, String password) {
		String query =Constant.AUTHENTICATION_QUERY_1 + email	+ Constant.AUTHENTICATION_QUERY_2 + password + "'";
		return productDao.userAuthentication(query);
	}
	
	/**
	 * This method is used to get the user id by email
	 * @param email
	 * @return
	 */
	public int getUserIdByEmail(String email) {
		String query = Constant.GET_BY_EMAIL_QUERY + email + "'";
		return productDao.getUserIdByEmail(query);
	}
	
	/**
	 * This method is used to check is the input product exists in the stock
	 * @param productCode
	 * @return
	 */
	public boolean isProductExist(int productCode) {
		String query =Constant.PRODUCT_EXISTS+ productCode + "'";
		return productDao.isProductExist(query);
	}
	
	/**
	 * This method is used to check is the input product exists in the cart
	 * @param userId
	 * @param productCode
	 * @return
	 */
	public boolean productIsInCart(int userId, int productCode) {
		String query =Constant.PRODUCT_IN_CART_1+ userId +Constant.PRODUCT_IN_CART_2+ productCode + "'";
		return productDao.productIsInCart(query);
	}
	
	/**
	 * This method is used to add a new product to the cart
	 * @param userId
	 * @param productCode
	 * @param productQuantity
	 * @return
	 */
	public Status addProductToCart(int userId, int productCode,int productQuantity) {
		List<String> queryList=new ArrayList<String>();
		String query1 =Constant.INSERT_INTO_CART+ productCode+ "," + productQuantity + ","+userId + ")";
		String query2=Constant.UPDATE_PRODUCT_1+productQuantity+Constant.UPDATE_PRODUCT_2+productCode;
		queryList.add(query1);
		queryList.add(query2);
		return productDao.addProductToCart(queryList);
	}
	
	/**
	 * This method is used to update a product in the cart
	 * @param userId
	 * @param productQuantity
	 * @param productToUpdate
	 * @return
	 */
	public Status updateProductInCart(int userId, int productQuantity,Product productToUpdate) {
		List<String> queryList=new ArrayList<String>();
		String query1= Constant.UPDATE_CART_1 + productQuantity+Constant.UPDATE_CART_2 + userId +Constant.PRODUCT_IN_CART_2+ productToUpdate.getProductCode() + "'";
		String query2=Constant.SELECT_PRODUCT_BY_PRODUCT_CODE+productToUpdate.getProductCode();
		String query3=Constant.UPDATE_PRODUCT_1+productQuantity+"-?)";
		queryList.add(query1);
		queryList.add(query2);
		queryList.add(query3);
		return productDao.updateProductInCart(queryList);
	}
	
	/**
	 * This method is used to show the user cart
	 * @param userId
	 * @return
	 */
	public List<Cart> showCart(int userId) {
		String query =Constant.SHOW_CART_1 + userId + Constant.SHOW_CART_2;
		return productDao.showCart(query);
	}
	
	/**
	 * This method is used to delete the product from the cart
	 * @param userId
	 * @param productToDelete
	 * @return
	 */
	public Status deleteProduct(int userId, Product productToDelete) {
		List<String> queryList=new ArrayList<String>();
		String query1 = Constant.DELETE_PRODUCT_FROM_CART_1+ userId+ Constant.PRODUCT_IN_CART_2 + productToDelete.getProductCode() + "'";
		String query2=Constant.SELECT_PRODUCT_QUANTITY+productToDelete.getProductCode();
		String query3=Constant.UPDATE_PRODUCT_3;
		queryList.add(query1);
		queryList.add(query2);
		queryList.add(query3);
		return productDao.deleteProduct(queryList);
	}
	
	/**
	 * This method is used to get the list of products in stock
	 * @return
	 */
	public List<Product> getProductList() {
		String query = Constant.SELECT_ALL_PRODUCTS;
		return productDao.getProductList(query);
	}
	
	/**
	 * This method is used to retrieve the product by product_code
	 * @param productCode
	 * @return
	 */
	public Product getProductById(int productCode) {
		String query=Constant.SELECT_ALL_PRODUCT_BY_PRODUCT_CODE+productCode;
		return productDao.getProductById(query);
	}
}
