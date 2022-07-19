package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class OrderDto {
    private Long orderId;
    private LocalDateTime created;
    private Long cartId;
}
