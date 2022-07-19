package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.entity.Cart;
import com.kodilla.ecommercee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartMapper {

    @Autowired
    private UserRepository userRepository;

    public Cart mapToCart(final CartDto cartDto) {
        Cart cart = Cart.builder()
                .cartId(cartDto.getCartId())
                .products(cartDto.getProducts())
                .user(userRepository.findById(cartDto.getUserId()).get())
                .build();

        return cart;
    }

    public CartDto mapToCartDto(final Cart cart) {
        CartDto cartDto = CartDto.builder()
                .cartId(cart.getCartId())
                .products(cart.getProducts())
                .userId(cart.getUser().getId())
                .build();

        return cartDto;
    }
}
