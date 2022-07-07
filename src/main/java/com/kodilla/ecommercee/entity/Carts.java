package com.kodilla.ecommercee.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="carts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Carts {


    @Column(name="cart_id", unique = true)
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int cartsid;
    @OneToMany(cascade={CascadeType.MERGE,
            CascadeType.PERSIST},
            fetch = FetchType.EAGER,
            targetEntity = Orders.class,
    mappedBy = "cart")
    @JoinColumn(name  = "order_id")
    private List<Orders> orders;





    @Column(name="user_id", unique = false)
    @NotNull
    private BigInteger userID;

    @Column(name="date_id_ID", unique = false)
    @NotNull
    private Date date;





}