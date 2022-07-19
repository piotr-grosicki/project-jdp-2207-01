package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.entity.Cart;
import com.kodilla.ecommercee.entity.Order;
import com.kodilla.ecommercee.exception.CartNotExistException;
import com.kodilla.ecommercee.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderMapper {

    CartRepository cartRepository;

    public Order mapToOrder(final OrderDto orderDto) throws CartNotExistException {
        Cart cart = cartRepository.findById(orderDto.getCartId()).orElseThrow(CartNotExistException::new);
        Order order = Order.builder()
                .orderId(orderDto.getOrderId())
                .cart(cart)
                .build();
        return order;
    }

    public OrderDto mapToOrderDto(final Order order) {
        OrderDto orderDto = OrderDto.builder()
                .orderId(order.getOrderId())
                .cartId(order.getCart().getCartId())
                .build();
        return orderDto;
    }

    public List<OrderDto> mapToOrderDtoList(final List<Order> orderList) {
        return orderList.stream()
                .map(this::mapToOrderDto)
                .collect(Collectors.toList());
    }
}
