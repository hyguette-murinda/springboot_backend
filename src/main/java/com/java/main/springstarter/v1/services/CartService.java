package com.java.main.springstarter.v1.services;

import com.java.main.springstarter.v1.dtos.CreateCartDto;
import com.java.main.springstarter.v1.models.Cart;

import java.util.List;

public interface CartService {
    Cart addCart(CreateCartDto cart);
    void removeCartWithId(Long cartId);

    void removeAllCart();
}

