package com.demo.Product.service;

import java.util.List;

import com.demo.Product.entities.Product;

public interface ProductService {
	public List<Product> getAllProducts();
	public Product getProduct(Integer id);
	public Product addProduct(Product p);
	public Product updateProduct(Product p);
	public String deleteProduct(Integer id);
}
