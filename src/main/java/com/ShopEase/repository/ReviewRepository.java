package com.ShopEase.repository;

import com.ShopEase.model.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,String>
{

}
