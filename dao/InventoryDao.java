package com.metacube.get2019.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.metacube.get2019.factory.InventoryFactory;
import com.metacube.get2019.model.Fruit;
/**
 * 
 * @author Kritika
 *
 */
public class InventoryDao implements BaseDao {


	@Override
	public List<Fruit> getAllFruits(String query) {
		try{
		Connection connection=DatabaseConnection.connect();
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		ResultSet rs= preparedStatement.executeQuery();
		List<Fruit> fruitList=new ArrayList<Fruit>();
		Fruit fruit;
		while(rs.next())
		{
			fruit=InventoryFactory.getInstanceOfFruit();
			fruit.setName(rs.getString("name"));
			fruit.setQuantity(rs.getInt("quantity"));
			System.out.println(fruit.getName()+" "+fruit.getQuantity());
			fruitList.add(fruit);
		}
		return fruitList;
}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public Fruit getFruitByName(String query, String fruitName) {
		try{
			Connection connection=DatabaseConnection.connect();
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1,fruitName);
			ResultSet rs= preparedStatement.executeQuery();
			Fruit fruit;
			fruit=InventoryFactory.getInstanceOfFruit();
			while(rs.next())
			{
				fruit.setName(rs.getString("name"));
				fruit.setQuantity(rs.getInt("quantity"));
				System.out.println(fruit.getName()+" "+fruit.getQuantity());
			}
			return fruit;
	}
			catch(Exception e){
				e.printStackTrace();
			}
			return null;
	}

	@Override
	public boolean updateFruit(String query) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAllFruits(String query) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteFruitByName(String query) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
