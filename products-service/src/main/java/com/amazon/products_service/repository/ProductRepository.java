package com.amazon.products_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amazon.products_service.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
