package com.ShopEase.repository;

import com.ShopEase.model.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long>
{

}
