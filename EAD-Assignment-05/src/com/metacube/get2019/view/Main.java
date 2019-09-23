package com.metacube.get2019.view;
import java.sql.SQLException;

import java.util.List;
import java.util.Scanner;

import com.metacube.get2019.controller.ProductController;
import com.metacube.get2019.model.Cart;
import com.metacube.get2019.model.Product;

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
			System.out.println("Invalid Login credentials..Login again!!");
			userId=userAuthentication(productController);
		}
		int choice = 0, productCode = 0, productQuantity;
		//label 
		Loop : do {
			System.out.println("Welcome to Shopping App!!!!\n1.Add product to cart\n2.Update cart\n3.Show cart\n4.Delete product in cart\n5.Exit");
			System.out.println("Enter choice : ");
			try {
				Scanner scanner = new Scanner(System.in);
				choice = scanner.nextInt();
				switch (choice) {
					case 1 :
						//list all product in stock
						showProducts(productController);
						System.out.println("enter product code : ");
						productCode = scanner.nextInt();
						Product product=productController.getProductById(productCode);
						//if product code is valid
						if (productController.isProductExist(productCode)) {
							//check if product is already in stock
							if (!productController.productIsInCart(userId,productCode)) {
								System.out.println("enter product quantity : ");
								productQuantity = scanner.nextInt();
								//check quantity
								if (productQuantity > 0){
									if(product.getAvailableQuantity()>=productQuantity) {
									//print status after adding product
									System.out.println(productController.addProductToCart(userId,productCode,productQuantity));
									}else{
										System.out.println("Entered Quantity not in stock");
									}
								} else {
									System.out.println("invalid quantity");
								}
							} else {
								System.out.println("product already is in your cart");
							}
						} else {
							System.out.println("invalid product code");
						}
						break;
					case 2 :
						System.out.println("enter product code : ");
						productCode = scanner.nextInt();
						//check if product is in cart
						if (productController.productIsInCart(userId,productCode)) {
							System.out.println("enter product quantity : ");
							productQuantity = scanner.nextInt();
							Product productToUpdate=productController.getProductById(productCode);
							//check if product quantity is valid
							if (productQuantity > 0) {
								if(productToUpdate.getAvailableQuantity()>=productQuantity) {
								//print status after updating product
								System.out.println(productController.updateProductInCart(userId,productQuantity,productToUpdate));}
								else {
									System.out.println("The entered quantity is not in stock");
								}
							} else {
								System.out.println("invalid quantity");
							}
						} else {
							System.out.println("product is not in your cart");
						}
						break;
					case 3 :
						//list for showing cart items
						List<Cart> cartList = productController.showCart(userId);
						System.out.println("Product Code\tProduct Name\tProduct Type\tProduct Quantity\tPrice");
						for (Cart cart : cartList) {
							System.out.println(cart.toString());
						}
						break;
					case 4 :
						System.out.println("enter product code : ");
						productCode = scanner.nextInt();
						//check if product is in cart
						if (productController.productIsInCart(userId,productCode)) {
							Product productToDelete=productController.getProductById(productCode);
							//print status after deleting product
							System.out.println(productController.deleteProduct(userId, productToDelete));
						} else {
							System.out.println("product is not in your cart");
						}
						break;
					default :
						System.out.println("The choice you entered is invalid. Please re-enter");
						break;
				}
			} catch (Exception e) {
				//exception for input mismatch
				e.printStackTrace();
				System.out.println("something went wrong");
				continue Loop;
			}
			//exit if choice is 5
		} while (choice != 5);
		System.out.println("Thank you for using Shopping App");
	}
	
	/**
	 * show product items in stock
	 */
	private static void showProducts(ProductController productController) {
		List<Product> productList = productController.getProductList();
		System.out.println("Product Code\tProduct Name\tProduct Type\tAvailable\tPrice");
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
		System.out.println("Enter Email : ");
		email = scanner.nextLine();
		System.out.println("Enter Password : ");			
		password = scanner.nextLine();
		if(!productController.userAuthentication(email, password)) {
			return -1;
		} else {
			userId = productController.getUserIdByEmail(email);
			return userId;
		} 	
	}
}