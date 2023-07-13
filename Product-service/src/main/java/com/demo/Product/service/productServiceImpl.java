package com.demo.Product.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Product.entities.Product;
import com.demo.Product.repositories.productRepo;

@Service
public class productServiceImpl implements ProductService {

	@Autowired
	productRepo productRepo;

	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	@Override
	public Product getProduct(Integer id) {
		Optional<Product> opt = productRepo.findById(id);
		return opt.orElse(null);
	}

	@Override
	public Product addProduct(Product p) {
		return productRepo.save(p);
	}

	@Override
	public Product updateProduct(Product p) {
		Optional<Product> target = productRepo.findById(p.getProductId());
		if (target.isPresent()) {
			BeanUtils.copyProperties(target, p);
			return productRepo.save(target.get());
		}
		return null;
	}

	@Override
	public String deleteProduct(Integer id) {
		productRepo.deleteById(id);
		return "deleted";
	}

	public List<Product> getProductsByUserId(Integer id) {
		List<Product> allProducts = productRepo.findAll();
		List<Product> result = allProducts.stream().filter(c -> (c.getUserId().equals(id))).collect(Collectors.toList());
		return result;
	}

}
