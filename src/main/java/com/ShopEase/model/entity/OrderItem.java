package com.ShopEase.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "order_items")
@Data
@AllArgsConstructor
public class OrderItem
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;
    private double price;

    @ManyToOne
    @JoinColumn(name = "order_id",nullable = false)
    private Order order;

    @OneToOne
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;

    public OrderItem() {
    }
}
