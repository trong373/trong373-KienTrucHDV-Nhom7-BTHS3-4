package com.example.bths2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.bths2.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}