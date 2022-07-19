package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.entity.Cart;
import com.kodilla.ecommercee.entity.Order;
import com.kodilla.ecommercee.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderRepositoryTestSuite {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void addNewOrder() {
        //Given
        Order testOrder = new Order();
        //When
        orderRepository.save(testOrder);
        //Then
        assertEquals(1, orderRepository.findAll().size());
        //Clean up
        orderRepository.deleteAll();
    }
    @Test
    public void testFindAllOrders(){
        //Given
        Order testOrder = new Order();
        Order testOrder1 = new Order();
        Order testOrder2 = new Order();

        //When
        orderRepository.save(testOrder);
        orderRepository.save(testOrder1);
        orderRepository.save(testOrder2);

        //Then
        assertEquals(3, orderRepository.findAll().size());

        //Clean up
        orderRepository.deleteAll();
    }

    @Test
    public void testFindByOrderId() {
        Order testOrder = new Order();
        //When
        orderRepository.save(testOrder);
        Optional<Order> testOrderId = orderRepository.findByOrderId(testOrder.getOrder_id());
        //Then
        assertEquals(testOrder.getOrder_id(), testOrderId.get().getOrder_id());
        //Clean up
        orderRepository.deleteAll();
    }
    @Test
    public void findOrdersByUser(){
        //Given
        User testUser = new User(1L, "JohnL", "John", "Lock", "johnl@gmail.com", "Sydney", true, new Order());
        Order testOrder = new Order();
        Order testOrder2 = new Order();

        //When
        userRepository.save(testUser);
        orderRepository.save(testOrder);
        orderRepository.save(testOrder2);

        //Then
        List<Order> testListOfOrders = new ArrayList<>();
        testListOfOrders.add(testOrder);
        testListOfOrders.add(testOrder2);
        assertEquals(testListOfOrders.size(), orderRepository.findByUser(testUser).size());

        //Clean up
        orderRepository.deleteAll();
        userRepository.deleteAll();
    }

    @Test
    public void deleteOrderById(){
        //Given
        User testUser = new User(1L, "JohnL", "John", "Lock", "johnl@gmail.com", "Sydney", true, new Order());
        Cart testCart = new Cart();
        Order testOrder = new Order(2L,testCart, (List<User>) testUser, 1L);

        //When
        userRepository.save(testUser);
        cartRepository.save(testCart);
        orderRepository.save(testOrder);

        //Then
        assertEquals(1, orderRepository.findAll().size());

        orderRepository.deleteByOrderId(testOrder.getOrder_id());

        assertEquals(0, orderRepository.findAll().size());
        assertEquals(1, cartRepository.findAll().size());
        assertEquals(1, userRepository.findAll().size());

        //Clean up
        userRepository.deleteAll();
        cartRepository.deleteAll();
        orderRepository.deleteAll();
    }

    @Test
    public void findCartForOrder(){
        //Given
        User testUser = new User(1L, "JohnL", "John", "Lock", "johnl@gmail.com", "Sydney", true, new Order());
        Cart testCart = new Cart();
        Order testOrder = new Order(2L,testCart, (List<User>) testUser, 1L);

        //When
        userRepository.save(testUser);
        cartRepository.save(testCart);
        orderRepository.save(testOrder);

        //Then
        assertEquals(testCart, testOrder.getCart());

        //Clean up
        userRepository.deleteAll();
        cartRepository.deleteAll();
        orderRepository.deleteAll();
    }

}
