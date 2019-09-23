package com.metacube.get2019.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.get2019.enums.Status;
import com.metacube.get2019.model.Cart;
import com.metacube.get2019.model.Product;

/**
 * This is the dao class
 * @author Kritika
 *
 */
public class MySqlDao implements BaseDao {

	private Connection connection;
	public MySqlDao() throws ClassNotFoundException, SQLException {
		connection = DatabaseConnection.getConnection();
	}

	@Override
	public boolean userAuthentication(String query) {
		try {
			PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			return resultSet.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int getUserIdByEmail(String query) {
		int userId = 0;
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			userId = resultSet.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userId;
	}

	@Override
	public boolean isProductExist(String query) {
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			return resultSet.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean productIsInCart(String query) {
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			return resultSet.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Status addProductToCart(List<String> query) {
		try {
			PreparedStatement statement = connection.prepareStatement(query.get(0));
			statement.executeUpdate();
			statement=connection.prepareStatement(query.get(1));
			statement.executeUpdate();
			return Status.ADDED;
		} catch (SQLException e) {
				e.printStackTrace();
		}
		return Status.FAILED;
	}
	
	@Override
	public Status updateProductInCart(List<String> queryList) {
		try {
			PreparedStatement statement=connection.prepareStatement(queryList.get(1));
			ResultSet resultSet=statement.executeQuery();
			resultSet.next();
			int cartQuantity=resultSet.getInt(1);
			statement = connection.prepareStatement(queryList.get(0));
			statement.executeUpdate();
			statement=connection.prepareStatement(queryList.get(2));
			statement.setInt(1,cartQuantity);
			statement.executeUpdate();
			return Status.UPDATED;
		} catch (SQLException e) {
				e.printStackTrace();
		}
		return Status.FAILED;
	}
	
	@Override
	public List<Cart> showCart(String query) {
		List<Cart> cartList = new ArrayList<Cart>();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				cartList.add(new Cart(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),resultSet.getInt(4),resultSet.getFloat(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cartList;
	}

	@Override
	public Status deleteProduct(List<String> queryList) {
		try {
			PreparedStatement statement=connection.prepareStatement(queryList.get(1));
			ResultSet resultSet=statement.executeQuery();
			resultSet.next();
			int cartQuantity=resultSet.getInt(1);
			statement = connection.prepareStatement(queryList.get(0));
			statement.executeUpdate();
			statement=connection.prepareStatement(queryList.get(2));
			statement.setInt(1,cartQuantity);
			statement.executeUpdate();
			return Status.DELETED;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Status.FAILED;
	}
	
	@Override
	public List<Product> getProductList(String query) {
		List<Product> productList = new ArrayList<Product>();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				productList.add(new Product(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDouble(4),resultSet.getInt(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productList;
	}

	@Override
	public Product getProductById(String query) {
		Product product=null;
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				product=new Product(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDouble(4),resultSet.getInt(5));
			
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}
}
