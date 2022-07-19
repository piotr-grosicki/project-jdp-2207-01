package com.kodilla.ecommercee.controller.service;

import com.kodilla.ecommercee.entity.Order;
import com.kodilla.ecommercee.exception.OrderNotExistException;
import com.kodilla.ecommercee.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderDbService {

    private final OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrder(final Long orderId) throws OrderNotExistException {
        return orderRepository.findById(orderId).orElseThrow(OrderNotExistException::new);
    }

    public void deleteOrder(final Long orderId) throws OrderNotExistException {
        if (orderRepository.existsById(orderId)) {
            orderRepository.deleteById(orderId);
        } else {
            throw new OrderNotExistException();
        }
    }

    public Order updateOrder(final Order order) throws OrderNotExistException {
        if (orderRepository.existsById(order.getOrderId())) {
            orderRepository.save(order);
            return order;
        } else {
            throw new OrderNotExistException();
        }
    }

    public Order createOrder(final Order order) {
        return orderRepository.save(order);
    }
}
