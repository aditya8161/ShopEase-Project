package com.ShopEase.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50,nullable = false)
    private String firstName;

    @Column(length = 50,nullable = false)
    private String lastName;


    @Column(length = 50,nullable = false)
    private String email;

    @Column(length = 50,nullable = false)
    private String password;

    @Transient
    private String phone;

    @ElementCollection
    private List<String> phoneList = new ArrayList<>();

    private String role;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

        public void setPhone(String p) {
        this.phone = p;
        if(!phoneList.contains(p)) phoneList.add(p);
    }

    //relationship
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Address> address=new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>();

    @OneToOne(mappedBy = "user")
    private Cart cart;

    public User() {
    }
}
