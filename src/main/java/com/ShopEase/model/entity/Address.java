package com.ShopEase.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;

@Entity
@Table(name = "address")
@Data
@AllArgsConstructor
public class Address
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String street;

    @Column(length = 50,nullable = false)
    private String city;

    @Column(length = 50,nullable = false)
    private String state;

    @Column(length = 6,nullable = false)
    private String pincode;

    @Column(length = 50,nullable = false)
    private String country;

    //relationship
    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    public Address() {
    }
}
