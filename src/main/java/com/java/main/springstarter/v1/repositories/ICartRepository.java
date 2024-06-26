package com.java.main.springstarter.v1.repositories;

import com.java.main.springstarter.v1.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByUser_Id(Long customerId);
}
