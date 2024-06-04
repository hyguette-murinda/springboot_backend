package com.java.main.springstarter.v1.repositories;

import com.java.main.springstarter.v1.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICartRepository extends JpaRepository<Cart, Long> {
}
