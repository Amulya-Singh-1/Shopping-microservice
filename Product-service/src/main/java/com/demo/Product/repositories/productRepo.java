package com.demo.Product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.Product.entities.Product;

@Repository
public interface productRepo extends JpaRepository<Product, Integer> {

}
