package com.metacube.get2019.util;

/**
 * It is a class that stores static attributes into variables
 * @author kritika
 *
 */
public class Constant {
	public static final int ONE = 1; 
	public static final int TWO = 2;
	public static final int THREE = 3;
	public static final int FOUR = 4;
	public static final int FIVE = 5;
	public static final String AUTHENTICATION_QUERY_1 =  "select email from store_user where email = '";
	public static final String AUTHENTICATION_QUERY_2 = "' and password = '";
	public static final String GET_BY_EMAIL_QUERY = "select user_id from store_user where email='";
	public static final String PRODUCT_EXISTS =  "select product_code from product where product_code = '";
	public static final String PRODUCT_IN_CART_1 =  "select product_code from cart where user_id ='";
	public static final String PRODUCT_IN_CART_2 =  "' and product_code = '" ;
	public static final String INSERT_INTO_CART =  "insert into cart values(";
	public static final String UPDATE_PRODUCT_1 = "update product set available_quantity=available_quantity-";
	public static final String UPDATE_PRODUCT_2 = " where product_code=";
	public static final String SELECT_PRODUCT_BY_PRODUCT_CODE = "select product_quantity from cart where product_code=";
	public static final String UPDATE_CART_1 = "update cart set product_quantity ='";
	public static final String UPDATE_CART_2 =  "' where user_id='";
	public static final String SHOW_CART_1 =  "select c.product_code,p.product_name,p.product_type,c.product_quantity,p.price from cart c,product p where user_id='";
	public static final String SHOW_CART_2 =  "' and p.product_code=c.product_code";
	public static final String DELETE_PRODUCT_FROM_CART_1 = "delete from cart where user_id = '";
	public static final String SELECT_PRODUCT_QUANTITY = "select product_quantity from cart where product_code=";
	public static final String UPDATE_PRODUCT_3 = "update product set available_quantity=available_quantity+?";
	public static final String SELECT_ALL_PRODUCTS = "select * from product";
	public static final String SELECT_ALL_PRODUCT_BY_PRODUCT_CODE = "select * from product where product_code=";
	public static final String INVALID_AUTHENTICATION = "Invalid Login credentials..Login again!!";
	public static final String WELCOME = "Welcome to Shopping App!!!!\n1.Add product to cart\n2.Update cart\n3.Show cart\n4.Delete product in cart\n5.Exit";
	public static final String ENTER_CHOICE = "Enter choice : ";
	public static final String ENTER_PRODUCT_CODE = "Enter product code : ";
	public static final String ENTER_PRODUCT_QUANTITY = "Enter product quantity : ";
	public static final String QUATNTIY_NOT_IN_STOCK = "Entered Quantity not in stock";
	public static final String INVALID_QUANTITY = "Invalid quantity";
	public static final String PRODUCT_ALREADY_IN_CART = "Product already is in your cart";
	public static final String INVALID_PRODUCT_CODE = "Invalid product code";
	public static final String PRODUCT_NOT_IN_CART = "Product is not in your cart";
	public static final String SHOW_CART = "Product Code\tProduct Name\tProduct Type\tProduct Quantity\tPrice";
	public static final String THANK_YOU = "Thank you for using Shopping App";
	public static final String ENTER_EMAIL = "Enter Email : ";
	public static final String ENTER_PASSWORD = "Enter Password : ";
}