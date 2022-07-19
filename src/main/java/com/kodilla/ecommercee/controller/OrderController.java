package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.controller.service.OrderDbService;
import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.entity.Order;
import com.kodilla.ecommercee.exception.CartNotExistException;
import com.kodilla.ecommercee.exception.OrderNotExistException;
import com.kodilla.ecommercee.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderDbService orderDbService;
    private final OrderMapper orderMapper;

    @GetMapping
    public ResponseEntity<List<OrderDto> > getOrders() {
        List<Order> orders = orderDbService.getAllOrders();
        return ResponseEntity.ok(orderMapper.mapToOrderDtoList(orders));
    }

    @GetMapping(value = "{orderId}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable Long orderId) {
        try {
            Order order = orderDbService.getOrder(orderId);
            return ResponseEntity.ok(orderMapper.mapToOrderDto(order));
        } catch (OrderNotExistException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping(value = "{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long orderId) {
        try {
            orderDbService.deleteOrder(orderId);
            return ResponseEntity.ok().body("Order has been deleted");
        } catch (OrderNotExistException e) {
            return ResponseEntity.badRequest().body("Order doesn't exist");
        }
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderDto> updateOrder(@RequestBody OrderDto orderDto) {
        try {
            Order order = orderMapper.mapToOrder(orderDto);
            order = orderDbService.updateOrder(order);
            return ResponseEntity.ok(orderMapper.mapToOrderDto(order));
        } catch (OrderNotExistException e) {
            return ResponseEntity.badRequest().build();
        } catch (CartNotExistException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createOrder(@RequestBody OrderDto orderDto) {
        try {
            Order order = orderMapper.mapToOrder(orderDto);
            orderDbService.createOrder(order);
            return ResponseEntity.ok().body("Order has been created");
        } catch (CartNotExistException e) {
            return ResponseEntity.badRequest().body("Cart doesn't exist");
        }
    }
}
