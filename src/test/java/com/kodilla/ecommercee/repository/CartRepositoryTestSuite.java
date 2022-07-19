package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.entity.Cart;
import com.kodilla.ecommercee.entity.Group;
import com.kodilla.ecommercee.entity.Order;
import com.kodilla.ecommercee.entity.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

@Transactional
@SpringBootTest
@RunWith(SpringRunner.class)
public class CartRepositoryTestSuite {

    @Autowired
    CartRepository cartRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    GroupRepository groupRepository;
    @Autowired
    OrderRepository orderRepository;

    @Test
    public void findCartById() {
        //Given
        List<Product> products = new ArrayList<>();
        Group group = Group.builder().name("Group 1").build();
        groupRepository.save(group);

        Product product = Product.builder()
                .productName("test product no 1")
                .group(group)
                .build();
        products.add(product);

        Cart cart = Cart.builder().products(products).build();

        //When
        cartRepository.save(cart);

        Order order = new Order();
        order.setCart(cart);

        orderRepository.save(order);
        List<Order> ordersList = new ArrayList<>();
        ordersList.add(order);
        cart.setOrders(ordersList);
        cartRepository.save(cart);

        Long id = cart.getCartId();
        Optional<Cart> result = cartRepository.findById(id);
        
        //Then
        assertNotNull(result.get());
        Assert.assertEquals(cart.getProducts().get(0).getGroup().getName(),"Group 1");

        //CleanUp
        cartRepository.deleteAll();
        groupRepository.deleteAll();

    }

    @Test
    public void deleteCartById() {
        //Given
        List<Product> products1 = new ArrayList<>();
        Product product1 = Product.builder()
                .productName("test product no 2")
                .build();
        products1.add(product1);
        Cart cart = Cart.builder().products(products1).build();
        cartRepository.save(cart);
        Long id = cart.getCartId();

        //When
        cartRepository.deleteById(id);

        //Then
        Assert.assertNull(cartRepository.findById(id).orElse(null));

        //CleanUp
        cartRepository.deleteAll();

    }
}