package com.metacube.get2019.view;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.metacube.get2019.controller.ProductController;
import com.metacube.get2019.model.Cart;
import com.metacube.get2019.model.Product;
import com.metacube.get2019.util.Constant;

/**
 * This is the main class
 * @author Kritika
 *
 */
public class Main {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ProductController productController = new ProductController();
		//call userAuthentication for getting authentication
		int userId = userAuthentication(productController);
		while(userId==-1) {
			System.out.println(Constant.INVALID_AUTHENTICATION);
			userId=userAuthentication(productController);
		}
		int choice = 0, productCode = 0, productQuantity;
		//label 
		Loop : do {
			System.out.println(Constant.WELCOME);
			System.out.println(Constant.ENTER_CHOICE);
			try {
				Scanner scanner = new Scanner(System.in);
				choice = scanner.nextInt();
				switch (choice) {
					case Constant.ONE:
						//list all product in stock
						showProducts(productController);
						System.out.println(Constant.ENTER_PRODUCT_CODE);
						productCode = scanner.nextInt();
						Product product=productController.getProductById(productCode);
						//if product code is valid
						if (productController.isProductExist(productCode)) {
							//check if product is already in stock
							if (!productController.productIsInCart(userId,productCode)) {
								System.out.println(Constant.ENTER_PRODUCT_QUANTITY);
								productQuantity = scanner.nextInt();
								//check quantity
								if (productQuantity > 0){
									if(product.getAvailableQuantity()>=productQuantity) {
									//print status after adding product
									System.out.println(productController.addProductToCart(userId,productCode,productQuantity));
									}else{
										System.out.println(Constant.QUATNTIY_NOT_IN_STOCK);
									}
								} else {
									System.out.println(Constant.INVALID_QUANTITY);
								}
							} else {
								System.out.println(Constant.PRODUCT_ALREADY_IN_CART);
							}
						} else {
							System.out.println(Constant.INVALID_PRODUCT_CODE);
						}
						break;
					case Constant.TWO :
						System.out.println(Constant.ENTER_PRODUCT_CODE);
						productCode = scanner.nextInt();
						//check if product is in cart
						if (productController.productIsInCart(userId,productCode)) {
							System.out.println(Constant.ENTER_PRODUCT_QUANTITY);
							productQuantity = scanner.nextInt();
							Product productToUpdate=productController.getProductById(productCode);
							//check if product quantity is valid
							if (productQuantity > 0) {
								if(productToUpdate.getAvailableQuantity()>=productQuantity) {
								//print status after updating product
								System.out.println(productController.updateProductInCart(userId,productQuantity,productToUpdate));}
								else {
									System.out.println(Constant.QUATNTIY_NOT_IN_STOCK);
								}
							} else {
								System.out.println(Constant.INVALID_QUANTITY);
							}
						} else {
							System.out.println(Constant.PRODUCT_NOT_IN_CART);
						}
						break;
					case Constant.THREE :
						//list for showing cart items
						List<Cart> cartList = productController.showCart(userId);
						System.out.println(Constant.SHOW_CART);
						for (Cart cart : cartList) {
							System.out.println(cart.toString());
						}
						break;
					case Constant.FOUR:
						System.out.println(Constant.ENTER_PRODUCT_CODE);
						productCode = scanner.nextInt();
						//check if product is in cart
						if (productController.productIsInCart(userId,productCode)) {
							Product productToDelete=productController.getProductById(productCode);
							//print status after deleting product
							System.out.println(productController.deleteProduct(userId, productToDelete));
						} else {
							System.out.println(Constant.PRODUCT_NOT_IN_CART);
						}
						break;
					default :
						System.out.println("The choice you entered is invalid. Please re-enter");
						break;
				}
			} catch (Exception e) {
				//exception for input mismatch
				e.printStackTrace();
				continue Loop;
			}
			//exit if choice is 5
		} while (choice != 5);
		System.out.println(Constant.THANK_YOU);
	}
	
	/**
	 * show product items in stock
	 */
	private static void showProducts(ProductController productController) {
		List<Product> productList = productController.getProductList();
		System.out.println(Constant.SHOW_CART);
		for (Product product : productList) {
			System.out.println(product);
		}
	}

	/**
	 * @return userId after authentication done successfully
	 */
	private static int userAuthentication(ProductController productController) {
		Scanner scanner = new Scanner(System.in);
		String email, password;
		int userId;
		System.out.println(Constant.ENTER_EMAIL);
		email = scanner.nextLine();
		System.out.println(Constant.ENTER_PASSWORD);			
		password = scanner.nextLine();
		if(!productController.userAuthentication(email, password)) {
			return -1;
		} else {
			userId = productController.getUserIdByEmail(email);
			return userId;
		} 	
	}
}
