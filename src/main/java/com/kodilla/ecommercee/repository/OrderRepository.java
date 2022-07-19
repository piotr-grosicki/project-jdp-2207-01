package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.entity.Order;
import com.kodilla.ecommercee.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAll();
    Optional<Order> findByOrderId(Long order_id);
    List<Order> findByUser(User user);
    Order save(Order order);
    void deleteByOrderId(Long orderId);
}
