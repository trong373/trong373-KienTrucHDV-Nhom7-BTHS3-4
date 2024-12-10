package com.example.bths2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bths2.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
