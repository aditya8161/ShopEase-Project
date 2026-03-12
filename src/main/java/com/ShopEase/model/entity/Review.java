package com.ShopEase.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "reviews")
@Data
@AllArgsConstructor
public class Review
{
    @Id
    private String id; //random UUID

    @Column(nullable = false)
    private String comment; //product comment

    @Column(nullable = false)
    private int rating; //1 to 5 [1-Bad 3-Average , 4-Good , 5 Best]

    @CreationTimestamp
    private LocalDate createdAt; //date

    //user_id , product_id
    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;

    public Review() {
    }
}
