package com.demo.Product.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Product.entities.Product;
import com.demo.Product.service.productServiceImpl;

@RestController
@RequestMapping("/product")
public class productController {

	@Autowired
	productServiceImpl productServiceImpl;

	@GetMapping("/getAll")
	public List<Product> getAll() {
		return productServiceImpl.getAllProducts();
	}

	@GetMapping("/get/{id}")
	public Product get(@PathVariable Integer id) {
		return productServiceImpl.getProduct(id);
	}

	@GetMapping("/user/{id}")
	public List<Product> getProductsByUserId(@PathVariable Integer id) {
//		System.out.println("hi");
		return productServiceImpl.getProductsByUserId(id);
	}

	@PostMapping("/add")
	public Product add(@RequestBody Product p) {
		return productServiceImpl.addProduct(p);
	}

	@PutMapping("/update")
	public Product update(@RequestBody Product p) {
		return productServiceImpl.updateProduct(p);
	}

	@DeleteMapping("/delete")
	public String delete(@PathVariable Integer id) {
		return productServiceImpl.deleteProduct(id);
	}

}
