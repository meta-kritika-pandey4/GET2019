package com.metacube.get2019.factory;

import java.sql.SQLException;

import com.metacube.get2019.dao.MySqlDao;
import com.metacube.get2019.facade.ProductFacade;
import com.metacube.get2019.model.Product;

public class Factory {

	public static ProductFacade createProductFacade() throws ClassNotFoundException, SQLException {
		return new ProductFacade();
	}
	public static MySqlDao createProductDao() throws ClassNotFoundException, SQLException {
			return new MySqlDao();
	}
	public Product createProduct(int productCode, String productName,String productType, double price,int available) {
		Product product = new Product(productCode, productName, productType,price,available);
		return product;
	}
}