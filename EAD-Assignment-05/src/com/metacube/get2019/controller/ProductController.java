package com.metacube.get2019.controller;
import java.sql.SQLException;
import java.util.List;
import com.metacube.get2019.enums.Status;
import com.metacube.get2019.facade.ProductFacade;
import com.metacube.get2019.factory.Factory;
import com.metacube.get2019.model.Cart;
import com.metacube.get2019.model.Product;

/**
 * This class forms the controller layer
 * @author Kritka
 */
public class ProductController {
	private ProductFacade productFacade;
	
	/**
	 * constructor
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ProductController() throws ClassNotFoundException, SQLException{
		productFacade= Factory.createProductFacade();
	}
	
	/**
	 * This method is used to authenticate the user
	 * @param email
	 * @param password
	 * @return
	 */
	public boolean userAuthentication(String email, String password) {
		return productFacade.userAuthentication(email, password);
	}
	/**
	 * This method is used to get the user id by email
	 * @param email
	 * @return
	 */
	public int getUserIdByEmail(String email) {
		return productFacade.getUserIdByEmail(email);
	}
	
	/**
	 * This method is used to check is the input product exists in the stock
	 * @param productCode
	 * @return
	 */
	public boolean isProductExist(int productCode) {
		return productFacade.isProductExist(productCode);
	}
	
	/**
	 * This method is used to check is the input product exists in the cart
	 * @param userId
	 * @param productCode
	 * @return
	 */
	public boolean productIsInCart(int userId, int productCode) {
		return productFacade.productIsInCart(userId, productCode);
	}
	
	/**
	 * This method is used to add a new product to the cart
	 * @param userId
	 * @param productCode
	 * @param productQuantity
	 * @return
	 */
	public Status addProductToCart(int userId, int productCode,
			int productQuantity) {
		return productFacade.addProductToCart(userId, productCode,
				productQuantity);
	}
	
	/**
	 * This method is used to update a product in the cart
	 * @param userId
	 * @param productCode
	 * @param productToUpdate
	 * @return
	 */
	public Status updateProductInCart(int userId, int productCode,Product productToUpdate) {
		return productFacade.updateProductInCart(userId, productCode,productToUpdate);
	}
	
	/**
	 * This method is used to show the user cart
	 * @param userId
	 * @return
	 */
	public List<Cart> showCart(int userId) {
		return productFacade.showCart(userId);
	}
	
	/**
	 * This method is used to delete the product from the cart
	 * @param userId
	 * @param productToDelete
	 * @return
	 */
	public Status deleteProduct(int userId, Product productToDelete) {
		return productFacade.deleteProduct(userId, productToDelete);
	}
	
	/**
	 * This method is used to get the list of products in stock
	 * @return
	 */
	public List<Product> getProductList() {
		return productFacade.getProductList();
	}
	
	/**
	 * This method is used to retrieve the product by product_code
	 * @param productCode
	 * @return
	 */
	public Product getProductById(int productCode) {
		return productFacade.getProductById(productCode);
	}
}