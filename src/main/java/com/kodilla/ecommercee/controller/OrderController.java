package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    @GetMapping
    public List<OrderDto> getOrders() {
        return new ArrayList<>();
    }

    @GetMapping(value = "{orderId}")
    public OrderDto getOrder(@PathVariable Long orderId) {
        return new OrderDto(1L, LocalDateTime.of(2022, 6, 6, 6, 6));
    }

    @DeleteMapping
    public void deleteOrder(Long orderId) {

    }

    @PutMapping
    public OrderDto updateOrder(OrderDto orderDto) {
        return new OrderDto(2L, LocalDateTime.of(2022, 6, 6, 6, 7));
    }

    @PostMapping
    public void createOrder(OrderDto orderDto) {

    }
}
