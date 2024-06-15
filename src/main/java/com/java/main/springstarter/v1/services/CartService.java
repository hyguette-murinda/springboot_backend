package com.java.main.springstarter.v1.services;

import com.java.main.springstarter.v1.dtos.CreateCartDto;
import com.java.main.springstarter.v1.models.Cart;
import com.java.main.springstarter.v1.models.CartItem;
import com.java.main.springstarter.v1.models.Purchase;

import java.util.List;

public interface CartService {

    Cart save();
    CartItem addProductToCart(Long productId, int quantity);
    Cart emptyCart();
    List<CartItem> allCartItems(Long cartId);

    Purchase purchaseItems();
}

