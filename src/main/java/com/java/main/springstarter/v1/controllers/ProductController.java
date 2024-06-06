package com.java.main.springstarter.v1.controllers;

import com.java.main.springstarter.v1.dtos.CreateProductDto;
import com.java.main.springstarter.v1.enums.ERole;
import com.java.main.springstarter.v1.models.Product;
import com.java.main.springstarter.v1.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Product> registerProduct(@RequestBody CreateProductDto product){
        Product savedProduct = productService.registerProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}

