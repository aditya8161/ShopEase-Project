package com.ShopEase.repository;

import com.ShopEase.model.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,String>
{

}
