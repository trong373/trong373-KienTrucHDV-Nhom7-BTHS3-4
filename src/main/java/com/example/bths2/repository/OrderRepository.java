package com.example.bths2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.bths2.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}