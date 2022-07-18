package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.entity.Order;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderRepositoryTestSuite {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void testOrderFindAll() {
        //Given
        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order();
        //When
        orderRepository.save(order1);
        orderRepository.save(order2);
        orderRepository.save(order3);
        //Then
        List<Order> orders = orderRepository.findAll();
        Assert.assertEquals(3, orders.size());
        Assert.assertNotEquals(2, orders.size());
        //CleanUp
        orderRepository.deleteAll();
    }

    @Test
    public void testOrderSave() {
        //Given
        Order order = new Order();
        //When
        orderRepository.save(order);
        Long orderId = order.getOrder_id();
        //Then
        Long id = order.getOrder_id();
        Optional<Order> readOrder = orderRepository.findById(id);
        Assert.assertTrue(readOrder.isPresent());
        //CleanUp
        orderRepository.deleteAll();
    }

    @Test
    public void testOrderFindById() {
        //Given
        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order();
        //When
        orderRepository.save(order1);
        orderRepository.save(order2);
        orderRepository.save(order3);
        //Then
        Long id = order2.getOrder_id();
        Optional<Order> readOrder = orderRepository.findById(id);
        Assert.assertTrue(readOrder.isPresent());
        //CleanUp
        orderRepository.deleteAll();
    }

}
