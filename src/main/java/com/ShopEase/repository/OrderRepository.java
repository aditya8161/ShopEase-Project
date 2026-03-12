package com.ShopEase.repository;

import com.ShopEase.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,String>
{

}
