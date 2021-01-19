package com.webstoreapp.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webstoreapp.model.Product;
import com.webstoreapp.model.repository.ProductRepository;
import com.webstoreapp.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void addProduct(Product product) {
		productRepository.addProduct(product);
	}

	public List<Product> retrieveAllProducts() {
		return productRepository.getAllProducts();
	}

	public List<Product> retrieveProductsByCategory(String category) {
		return productRepository.getProductsByCategory(category);
	}

	public List<Product> retrieveProductsByFilter(Map<String, List<String>> filterParams) {
		return productRepository.getProductsByFilter(filterParams);
	}

	@Override
	public Product retrieveProductById(String productID) {
		return productRepository.getProductById(productID);
	}

	@Override
	public void updateAllStock() {
		List<Product> allProducts = productRepository.getAllProducts();
		for (Product product : allProducts) {
			if (product.getUnitsInStock() < 500)
				productRepository.updateStock(product.getProductId(), product.getUnitsInStock() + 1000);
		}
	}
}