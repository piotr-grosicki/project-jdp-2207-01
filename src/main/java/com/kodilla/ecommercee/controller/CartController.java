package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.CartDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/cart")
public class CartController {

    @GetMapping
    public List <CartDto> getNewCart() {
        return new ArrayList<>();
    }

    @GetMapping(value = "{cartId}")
    public List <CartDto> getProductsFromCart(@PathVariable Long cartId) {
        return new ArrayList<>();
    }

      @PostMapping(value = "{cartId}", consumes = APPLICATION_JSON_VALUE)
    public CartDto addProductToCart(@PathVariable Long cartId, @PathVariable Long productId) {
        return new CartDto(2L, Arrays.asList("Product1"), 1L);//L
    }

    @DeleteMapping(value = "{cartId}")
    public ResponseEntity<Void> deleteChosenProductFromCart(@PathVariable Long cartId, @PathVariable Long productId) {
                   return ResponseEntity.ok().build();
        }

    @PostMapping( consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addNewOrder(@RequestBody CartDto cartDto) {
        return ResponseEntity.ok().build();    }


}
