package com.metacube.get2019.factory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.metacube.get2019.dao.InventoryDao;
import com.metacube.get2019.model.Fruit;

public class InventoryFacade {
	static InventoryDao inventory=InventoryFactory.getInstanceOfInventoryDao();
	private static final String QUERY_GET_FRUITS="select * from inventory";
	private static final String QUERY_GET_FRUITS_BY_NAME="select * from inventory where name = ?";
	
	public static String getFruits() throws SQLException{
		List<Fruit> fruitList=inventory.getAllFruits(QUERY_GET_FRUITS);
		if(fruitList.size() > 0)
		{
			Gson gson = new Gson();
			String inventoryJson = gson.toJson(fruitList);
			return inventoryJson;
		}
		else
		{
			return "No Inventory Found";
		}
		
	}
	
	public static String getFruitByName(String fruitName) throws SQLException{
		Fruit fruit=inventory.getFruitByName(QUERY_GET_FRUITS_BY_NAME,fruitName);
		if( fruit != null )
		{
			Gson gson = new Gson();
			String inventoryJson = gson.toJson(fruit);
			return inventoryJson;
		}
		else
		{
			return "No Fruit Found";
		}
		
	}

}

