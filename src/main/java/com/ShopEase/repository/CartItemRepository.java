package com.ShopEase.repository;

import com.ShopEase.model.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem,Long>
{

}
