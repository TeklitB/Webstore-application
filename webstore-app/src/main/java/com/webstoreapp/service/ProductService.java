package com.webstoreapp.service;

import java.util.List;

import com.webstoreapp.model.Product;

public interface ProductService {

	List <Product> retrieveAllProducts();

	void updateAllStock();
}
