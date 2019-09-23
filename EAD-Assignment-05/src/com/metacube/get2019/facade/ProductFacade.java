package com.metacube.get2019.facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.get2019.dao.BaseDao;
import com.metacube.get2019.enums.Status;
import com.metacube.get2019.factory.Factory;
import com.metacube.get2019.model.Cart;
import com.metacube.get2019.model.Product;

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
		String query = "select email from store_user where email = '" + email	+ "' and password = '" + password + "'";
		return productDao.userAuthentication(query);
	}
	
	/**
	 * This method is used to get the user id by email
	 * @param email
	 * @return
	 */
	public int getUserIdByEmail(String email) {
		String query = "select user_id from store_user where email='" + email + "'";
		return productDao.getUserIdByEmail(query);
	}
	
	/**
	 * This method is used to check is the input product exists in the stock
	 * @param productCode
	 * @return
	 */
	public boolean isProductExist(int productCode) {
		String query = "select product_code from product where product_code = '" + productCode + "'";
		return productDao.isProductExist(query);
	}
	
	/**
	 * This method is used to check is the input product exists in the cart
	 * @param userId
	 * @param productCode
	 * @return
	 */
	public boolean productIsInCart(int userId, int productCode) {
		String query = "select product_code from cart where user_id ='"	+ userId + "' and product_code = '" + productCode + "'";
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
		String query1 = "insert into cart values(" + productCode+ "," + productQuantity + ","+userId + ")";
		String query2="update product set available_quantity=available_quantity-"+productQuantity+" where product_code="+productCode;
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
		String query1= "update cart set product_quantity ='" + productQuantity+ "' where user_id='" + userId + "' and product_code = '"+ productToUpdate.getProductCode() + "'";
		String query2="select product_quantity from cart where product_code="+productToUpdate.getProductCode();
		String query3="update product set available_quantity=available_quantity-("+productQuantity+"-?)";
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
		String query = "select c.product_code,p.product_name,p.product_type,c.product_quantity,p.price from cart c,product p where user_id='"
				+ userId + "' and p.product_code=c.product_code";
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
		String query1 = "delete from cart where user_id = '" + userId+ "' and product_code = '" + productToDelete.getProductCode() + "'";
		String query2="select product_quantity from cart where product_code="+productToDelete.getProductCode();
		String query3="update product set available_quantity=available_quantity+?";
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
		String query = "select * from product";
		return productDao.getProductList(query);
	}
	
	/**
	 * This method is used to retrieve the product by product_code
	 * @param productCode
	 * @return
	 */
	public Product getProductById(int productCode) {
		String query="select * from product where product_code="+productCode;
		return productDao.getProductById(query);
	}
}