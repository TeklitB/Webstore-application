package com.webstoreapp.model.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.webstoreapp.model.Product;

public interface ProductRepository {
	List<Product> getAllProducts();
}