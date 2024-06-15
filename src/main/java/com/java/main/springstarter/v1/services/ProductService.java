package com.java.main.springstarter.v1.services;

import com.java.main.springstarter.v1.dtos.CreateProductDto;
import com.java.main.springstarter.v1.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product registerProduct(CreateProductDto product);
    Product findById(Long id);
    Page<Product> findAll(Pageable pageable);
    void deleteProduct(Long id);

    Page<Product> search(Pageable pageable, String searchKey);
}
