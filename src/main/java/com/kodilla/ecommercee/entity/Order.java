package com.kodilla.ecommercee.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {

    @Setter(AccessLevel.NONE)
    // @Column(name = "orders_id", nullable = false, unique = true)
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long orders_id;

    @ManyToOne(cascade = CascadeType.MERGE,
            fetch = FetchType.LAZY)
    Cart cart;

}