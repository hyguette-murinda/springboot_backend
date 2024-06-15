package com.java.main.springstarter.v1.repositories;

import com.java.main.springstarter.v1.models.Cart;
import com.java.main.springstarter.v1.models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findAllByCart(Cart cart);
}
