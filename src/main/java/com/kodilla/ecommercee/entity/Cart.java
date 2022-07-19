package com.kodilla.ecommercee.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
@Entity
@Table(name = "cart")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cart {

    @Id
<<<<<<< HEAD
=======
    @NotNull
>>>>>>> c1e93e5ac319be062c47ec0c2045f9be11aa7aa6
    @Column(name = "cart_id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "carts")
    private List<Product> products;

    @OneToMany(mappedBy = "cart")
    private List<Order> orders;

    @Column(name = "user_id")
<<<<<<< HEAD
    private Long userID;


=======
    @NotNull
    private Long userId;
>>>>>>> c1e93e5ac319be062c47ec0c2045f9be11aa7aa6
}