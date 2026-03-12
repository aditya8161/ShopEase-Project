package com.ShopEase.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "cart_items")
@Data
@AllArgsConstructor
public class CartItem
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;

    //relations
    //with cart , product

    @ManyToOne
    @JoinColumn(name = "cart_id",nullable = false)
    private Cart cart;

    @OneToOne
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;

    public CartItem() {
    }
}
