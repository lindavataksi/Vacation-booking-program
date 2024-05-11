package com.example.demo.entity;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "carts")
@Getter
@Setter

public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;

    @Column(name = "order_tracking_number")
    private String orderTrackingNumber;

    @Column(name = "package_price")
    private BigDecimal package_price;

    @Column(name = "party_size")
    private int party_size;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusType status;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private Set<CartItem> cartItems = new HashSet<>();
    
    
    public void add(CartItem cartItem) {    
        this.cartItems.add(cartItem);    
        cartItem.setCart(this);
    }


}
