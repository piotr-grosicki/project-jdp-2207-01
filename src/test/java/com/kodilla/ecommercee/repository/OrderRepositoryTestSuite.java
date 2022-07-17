package com.kodilla.ecommercee.repository;


import com.kodilla.ecommercee.entity.Order;
import com.kodilla.ecommercee.entity.Product;
import com.kodilla.ecommercee.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderRepositoryTestSuite {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

    @Test
    void testGetOneOrderSuite() {
        //Given
        User user = new User(1L,"AdamA", "Adam", "Nowak", "nowak@gmail.com", "Kielce");
        Order order = new Order();
        //When
        userRepository.save(user);
        orderRepository.save(order);
        Long id = order.getOrder_id();
        Optional<Order> oneOrder = orderRepository.findById(id);
        //Then
        assertTrue(oneOrder.isPresent());
        //CleanUp
        orderRepository.deleteById(id);
        userRepository.delete(user);
    }

    @Test
    void testUpdateOrder() {
        //Given
        User user = new User(1L,"AdamA", "Adam", "Nowak", "nowak@gmail.com", "Kielce");
        User user1 = new User(2L,"JohnL", "John", "Lock", "johnl@gmail.com", "Sydney");
        Order order = new Order(user);
        userRepository.save(user);
        userRepository.save(user1);
        orderRepository.save(order);
        Long id = order.getOrder_id();
        //When
        Optional<Order> before = orderRepository.findById(id);
        assertTrue(before.get().getUser().getName().equals("name"));
        order.setUser(user1);
        orderRepository.save(order);
        Long id1 = order.getOrder_id();
        Optional<Order> after = orderRepository.findById(id1);
        //Then
        assertTrue(after.get().getUser().getName().equals("name1"));
        //CleanUp
        Iterable<Order> orderIterable = orderRepository.findAll();
        orderIterable.forEach(o -> orderRepository.deleteById(o.getOrder_id()));
        Iterable<Product> productIterable = productRepository.findAll();
        productIterable.forEach(p -> productRepository.deleteById(p.getProductId()));
    }

    @Test
    void testSaveOrderSuite() {
        //Given
        User user = new User(1L,"AdamA", "Adam", "Nowak", "nowak@gmail.com", "Kielce");
        Order order = new Order(user);
        userRepository.save(user);
        orderRepository.save(order);
        //When
        List<Order> orderList = orderRepository.findAll();
        assertEquals(1, orderList.size());
        Order order1 = new Order(user);
        orderRepository.save(order1);
        orderList = orderRepository.findAll();
        //Then
        assertEquals(2, orderList.size());
        //CleanUp
        Iterable<Order> orderIterable = orderRepository.findAll();
        orderIterable.forEach(o -> orderRepository.deleteById(o.getOrder_id()));
        userRepository.delete(user);
    }

    @Test
    void testDeleteOrderSuite() {
        //Given
        User user = new User(2L,"JohnL", "John", "Lock", "johnl@gmail.com", "Sydney");
        Order order = new Order(user);
        Order order1 = new Order(user);
        Order order2 = new Order(user);
        Order order3 = new Order(user);
        userRepository.save(user);
        orderRepository.save(order);
        orderRepository.save(order1);
        orderRepository.save(order2);
        orderRepository.save(order3);
        List<Order> orderList = orderRepository.findAll();
        assertEquals(4, orderList.size());
        //When
        orderRepository.deleteById(2L);
        orderList = orderRepository.findAll();
        //Then
        assertEquals(2, orderList.size());
        Iterable<Order> orderIterable = orderRepository.findAll();
        orderIterable.forEach(o -> orderRepository.deleteById(o.getOrder_id()));
        //CleanUp
        Iterable<Product> productIterable = productRepository.findAll();
        productIterable.forEach(p -> productRepository.deleteById(p.getProductId()));
    }
}
