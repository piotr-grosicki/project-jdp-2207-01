package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.entity.Cart;
import com.kodilla.ecommercee.entity.Order;
import com.kodilla.ecommercee.entity.Product;
import com.kodilla.ecommercee.exception.CartNotExistException;
import com.kodilla.ecommercee.exception.ProductNotExistException;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/cart")
public class CartController {

    private final CartMapper cartMapper;
    private final ProductMapper productMapper;
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    @GetMapping(value = "{cartId}")
    public ResponseEntity<CartDto> getCart(@PathVariable Long cartId) throws CartNotExistException {
        Cart cart = cartRepository.findById(cartId).orElseThrow(CartNotExistException::new);
        return ResponseEntity.ok(cartMapper.mapToCartDto(cart));
    }

    @GetMapping(value = "{cartId}/products")
    public ResponseEntity<List <ProductDto>> getProductsFromCart(@PathVariable Long cartId) throws CartNotExistException {
        Cart cart = cartRepository.findById(cartId).orElseThrow(CartNotExistException::new);
        return ResponseEntity.ok(productMapper.mapToProductDtoList(cart.getProducts()));
    }

    @PostMapping(value = "{userId}")
    public ResponseEntity<Void> createNewCart(@PathVariable Long userId) {
        Cart cart = new Cart();
        cartRepository.save(cart);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/{cartId}/{productId}")
    public ResponseEntity<CartDto> addProductToCart(@PathVariable Long cartId, @PathVariable Long productId) throws ProductNotExistException {
        Cart cart = cartRepository.findById(cartId).orElse(new Cart());
        cart.getProducts()
                .add(productRepository.findById(productId)
                        .orElseThrow(ProductNotExistException::new));
        return ResponseEntity.ok(cartMapper.mapToCartDto(cart));
    }

    @DeleteMapping(value = "{cartId}/{productId}")
    public ResponseEntity<String> deleteChosenProductFromCart(@PathVariable Long cartId, @PathVariable Long productId) throws CartNotExistException, ProductNotExistException {
        Cart cart = cartRepository.findById(cartId).orElseThrow(CartNotExistException::new);
        Product product = productRepository.findById(productId).orElseThrow(ProductNotExistException::new);
        productMapper.mapToProductDtoList(cart.getProducts()).remove(product);
        cartRepository.save(cart);
        return ResponseEntity.ok("Chosen product has been deleted from your cart.");
    }
}