package com.kodilla.ecommercee.controller.service;

import com.kodilla.ecommercee.entity.Cart;
import com.kodilla.ecommercee.entity.Product;
import com.kodilla.ecommercee.exception.CartNotExistException;
import com.kodilla.ecommercee.exception.ProductNotExistException;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartDbService {

    @Autowired
    private final CartRepository cartRepository;
    @Autowired
    private final ProductRepository productRepository;
    @Autowired
    private final ProductMapper productMapper;

    public Cart getCart(Long cartId) throws CartNotExistException {
        Cart cart = cartRepository.findById(cartId).orElseThrow(CartNotExistException::new);
        return cart;
    }

    public List<Product> getProductFromCart(Long cartId) throws CartNotExistException {
        Cart cart = getCart(cartId);
        List<Product> products = cart.getProducts();
        return products;
    }

    public void createNewCart() {
        Cart cart = new Cart();
        cartRepository.save(cart);
    }

    public Cart addProductToCart(Long cartId, Long productId) throws ProductNotExistException {
        Cart cart = cartRepository.findById(cartId).orElse(new Cart());
        cart.getProducts()
                .add(productRepository.findById(productId)
                        .orElseThrow(ProductNotExistException::new));
        return cart;
    }

    public Cart deleteChosenProductFromCart(Long cartId, Long productId) throws CartNotExistException, ProductNotExistException {
        Cart cart = cartRepository.findById(cartId).orElseThrow(CartNotExistException::new);
        Product product = productRepository.findById(productId).orElseThrow(ProductNotExistException::new);
        productMapper.mapToProductDtoList(cart.getProducts()).remove(product);
        cartRepository.save(cart);
        return cart;
    }
}
