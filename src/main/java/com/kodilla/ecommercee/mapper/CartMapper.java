package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.entity.Cart;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartMapper {

    public Cart mapToCart(final CartDto cartDto) {
        Cart cart = Cart.builder()
                .cartId(cartDto.getCartId())
                .products(cartDto.getProducts())
                .userId(cartDto.getUserId())
                .build();

        return cart;
    }

    public CartDto mapToCartDto(final Cart cart) {
        CartDto cartDto = CartDto.builder()
                .cartId(cart.getCartId())
                .products(cart.getProducts())
                .userId(cart.getUserId())
                .build();

        return cartDto;
    }

    public List<CartDto> mapToCartDtoList(final List<Cart> cartList) {
        return cartList.stream()
                .map(this::mapToCartDto)
                .collect(Collectors.toList());
    }
}
