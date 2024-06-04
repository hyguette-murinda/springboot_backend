package com.java.main.springstarter.v1.services;

import com.java.main.springstarter.v1.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product registerProduct(Product product);
    List<Product> getAllProducts();
}
