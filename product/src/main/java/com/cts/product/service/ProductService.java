package com.cts.product.service;

import java.util.List;

import com.cts.product.resource.Product;

public interface ProductService {

		List<Product> findAll();
		List<Product> findByCategory(String category);
		Product findById(int id);
	}


