package com.kodilla.ecommercee.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "order")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {

    @Setter(AccessLevel.NONE)
    @Column(name = "orderId", nullable = false, unique = true)
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long orderId;

    @ManyToOne(cascade = CascadeType.MERGE,
            fetch = FetchType.LAZY)
    private Cart cart;
}