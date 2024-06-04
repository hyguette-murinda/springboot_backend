package com.java.main.springstarter.v1.controllers;

import com.java.main.springstarter.v1.dtos.CreateCartDto;
import com.java.main.springstarter.v1.models.Cart;
import com.java.main.springstarter.v1.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;
    @PostMapping
    public ResponseEntity<Cart> addCart(@RequestBody CreateCartDto cart){
        Cart cart1 = cartService.addCart(cart);
        return new ResponseEntity<>(cart1, HttpStatus.CREATED);
    }
    @DeleteMapping("/{cartId}")
    public void removeCartWithId(@PathVariable Long cartId){
        cartService.removeCartWithId(cartId);
    }

    @DeleteMapping
    public void removeAllCart(){
        cartService.removeAllCart();
    }
}

