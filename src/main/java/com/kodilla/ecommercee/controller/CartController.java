package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.controller.service.CartDbService;
import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.entity.Cart;
import com.kodilla.ecommercee.exception.CartNotExistException;
import com.kodilla.ecommercee.exception.ProductNotExistException;
import com.kodilla.ecommercee.exception.UserNotExistException;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/cart")
public class CartController {

    private final CartDbService cartDbService;
    private final CartMapper cartMapper;
    private final ProductMapper productMapper;

    @GetMapping(value = "{cartId}")
    public ResponseEntity<CartDto> getCart(@PathVariable Long cartId) {
        try {
            Cart cart = cartDbService.getCart(cartId);
            return ResponseEntity.ok(cartMapper.mapToCartDto(cart));
        } catch (CartNotExistException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "{cartId}/products")
    public ResponseEntity<List<ProductDto>> getProductsFromCart(@PathVariable Long cartId) {
        try {
            Cart cart = cartDbService.getCart(cartId);
            return ResponseEntity.ok(productMapper.mapToProductDtoList(cart.getProducts()));
        } catch (CartNotExistException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(value = "{userId}")
    public ResponseEntity<String> createNewCart(@RequestBody CartDto cartDto) {
        try {
            Cart cart = cartMapper.mapToCart(cartDto);
            cart = cartDbService.createNewCart();
            return ResponseEntity.ok().body("Cart has been created");
        } catch (UserNotExistException e) {
            return ResponseEntity.badRequest().body("User doesn't exist");
        }
    }

    @PostMapping(value = "/{cartId}/{productId}")
    public ResponseEntity<CartDto> addProductToCart(@PathVariable Long cartId, @PathVariable Long productId) {
        try {
            Cart cart = cartDbService.addProductToCart(cartId, productId);
            return ResponseEntity.ok(cartMapper.mapToCartDto(cart));
        } catch (ProductNotExistException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping(value = "{cartId}/{productId}")
    public ResponseEntity<String> deleteChosenProductFromCart(@PathVariable Long cartId, @PathVariable Long productId) {
        try {
            Cart cart = cartDbService.deleteChosenProductFromCart(cartId, productId);
            return ResponseEntity.ok("Chosen product has been deleted from your cart.");
        } catch (CartNotExistException e) {
            return ResponseEntity.badRequest().body("Cart doesn't exist");
        } catch (ProductNotExistException e) {
            return ResponseEntity.badRequest().body("Product doesn't exist");
        }
    }
}