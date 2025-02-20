package com.amazon.orders_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amazon.orders_service.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
