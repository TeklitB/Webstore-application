package com.webstoreapp.service;

import java.util.List;
import java.util.Map;

import com.webstoreapp.model.Product;

public interface ProductService {

	List<Product> retrieveAllProducts();

	void updateAllStock();

	List<Product> getProductsByCategory(String category);

	List<Product> getProductsByFilter(Map<String, List<String>> filterParams);
}
