package com.ShopEase.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Data
@AllArgsConstructor
public class Payment
{
    @Id
    private String id; //from server(random UUID)

    private String transactionId; //from the razorpay

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @CreationTimestamp
    private LocalDateTime paymentTime;

    private double amount; //total payment amount

    @OneToOne
    @JoinColumn(name = "order_id",nullable = false)
    private Order order;

    public Payment() {
    }
}
