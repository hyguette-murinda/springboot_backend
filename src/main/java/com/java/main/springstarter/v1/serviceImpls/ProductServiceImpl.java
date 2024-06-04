package com.java.main.springstarter.v1.serviceImpls;

import com.java.main.springstarter.v1.models.Product;
import com.java.main.springstarter.v1.repositories.IProductRepository;
import com.java.main.springstarter.v1.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final IProductRepository productRepository;
    @Override
    public Product registerProduct(Product product){
        return (Product) productRepository.save(product);

    }
    @Override
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
}

