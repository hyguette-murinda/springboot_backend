package com.java.main.springstarter.v1.controllers;

import com.java.main.springstarter.v1.dtos.CreateCartDto;
import com.java.main.springstarter.v1.models.Cart;
import com.java.main.springstarter.v1.models.CartItem;
import com.java.main.springstarter.v1.payload.ApiResponse;
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
    @GetMapping("/")
    private ResponseEntity<ApiResponse> addCart(){
        return ResponseEntity.ok(new ApiResponse(true,cartService.save()));
    }

    @PutMapping("/add-item")
    private ResponseEntity<ApiResponse> addItemToCart(
            @RequestParam("product") Long productId,
            @RequestParam(value = "quantity", defaultValue = "1") int quantity
    ) {
        CartItem cartItem = this.cartService.addProductToCart(productId, quantity);
        return ResponseEntity.ok( new ApiResponse(true, cartItem));
    }
    @GetMapping("/all/cart-items")
    private ResponseEntity<ApiResponse> allCartItems(@RequestParam("cart") Long cartId){
        return ResponseEntity.ok(new ApiResponse(true,cartService.allCartItems(cartId)));
    }
}

