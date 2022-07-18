package com.kodilla.ecommercee.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static lombok.AccessLevel.PACKAGE;


@Entity
@Table(name = "order")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {

    @Setter(PACKAGE)
    @Column(name = "orderId", nullable = false, unique = true)
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long orderId;

    @ManyToOne(cascade = CascadeType.ALL, //, CascadeType.REMOVE},
            fetch = FetchType.LAZY)
    private Cart cart;
}