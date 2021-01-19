package com.webstoreapp.service;

import java.util.List;
import java.util.Map;

import com.webstoreapp.model.Product;

public interface ProductService {

	List<Product> retrieveAllProducts();

	List<Product> retrieveProductsByCategory(String category);

	List<Product> retrieveProductsByFilter(Map<String, List<String>> filterParams);

	Product retrieveProductById(String productID);

	void updateAllStock();
}
