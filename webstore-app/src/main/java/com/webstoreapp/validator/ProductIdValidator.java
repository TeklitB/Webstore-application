package com.webstoreapp.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.webstoreapp.exception.ProductNotFoundException;
import com.webstoreapp.model.Product;
import com.webstoreapp.service.ProductService;

public class ProductIdValidator implements ConstraintValidator<ProductId, String> {
	@Autowired
	private ProductService productService;

	public void initialize(ProductId constraintAnnotation) {
// intentionally left blank; this is the place to initialize the constraint annotation for any sensible default values.
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		Product product;
		try {
			product = productService.retrieveProductById(value);
		} catch (ProductNotFoundException e) {
			return true;
		}
		if (product != null) {
			return false;
		}
		return true;
	}
}