package com.java.main.springstarter.v1.controllers;

import com.java.main.springstarter.v1.dtos.CreateProductDto;
import com.java.main.springstarter.v1.enums.ERole;
import com.java.main.springstarter.v1.models.Product;
import com.java.main.springstarter.v1.payload.ApiResponse;
import com.java.main.springstarter.v1.services.ProductService;
import com.java.main.springstarter.v1.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.xml.validation.Validator;
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
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping(path = "/all")
    private ResponseEntity<ApiResponse> getAll(
            @RequestParam(value = "page", defaultValue = Constants.DEFAULT_PAGE_NUMBER) int page,
            @RequestParam(value = "size", defaultValue = Constants.DEFAULT_PAGE_SIZE) int limit
    ) {
        Pageable pageable = PageRequest.of(page, limit);
        return ResponseEntity.ok(new ApiResponse(true));
    }

    @DeleteMapping("/{productId}")
    private ResponseEntity<ApiResponse> deleteProduct(
            @PathVariable("productId") Long id
    ) {
        this.productService.deleteProduct(id);
        return ResponseEntity.ok( new ApiResponse(true));
    }
}

