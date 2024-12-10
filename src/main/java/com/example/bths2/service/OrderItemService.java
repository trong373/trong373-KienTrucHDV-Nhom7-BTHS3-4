package com.example.bths2.service;

import com.example.bths2.entity.OrderItem;
import com.example.bths2.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public Optional<OrderItem> getOrderItemById(int id) {
        return orderItemRepository.findById(id);
    }

    public OrderItem createOrderItem(OrderItem orderItem) {
        // Tính toán totalPrice trước khi lưu
        orderItem.setTotalPrice(orderItem.getUnitPrice().multiply(BigDecimal.valueOf(orderItem.getQuantity())));
        return orderItemRepository.save(orderItem);
    }

    public OrderItem updateOrderItem(int id, OrderItem orderItemDetails) {
        return orderItemRepository.findById(id).map(orderItem -> {
            orderItem.setQuantity(orderItemDetails.getQuantity()); // Cập nhật số lượng
            orderItem.setUnitPrice(orderItemDetails.getUnitPrice()); // Cập nhật giá đơn vị
            // Cập nhật totalPrice dựa trên số lượng và giá đơn vị mới
            orderItem.setTotalPrice(orderItem.getUnitPrice().multiply(BigDecimal.valueOf(orderItem.getQuantity())));
            return orderItemRepository.save(orderItem); // Lưu vào cơ sở dữ liệu
        }).orElseThrow(() -> new RuntimeException("Order item not found with id " + id));
    }

    public void deleteOrderItem(int id) {
        orderItemRepository.deleteById(id);
    }
}
