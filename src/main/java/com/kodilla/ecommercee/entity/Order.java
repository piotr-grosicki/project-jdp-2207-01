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
    @Column(name = "order_id", nullable = false, unique = true)
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long order_id;

    @ManyToOne(cascade = CascadeType.MERGE,
            fetch = FetchType.LAZY)
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Order(User user) {
        this.user = user;
    }

}