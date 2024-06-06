package com.java.main.springstarter.v1.serviceImpls;

import com.java.main.springstarter.v1.dtos.CreateProductDto;
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
    public Product registerProduct(CreateProductDto product){
        Product product1 = new Product();
        product1.setProduct_code(product.getProduct_code());
        product1.setName(product.getName());
        product1.setDate(product.getDate());
        product1.setPrice(product.getPrice());
        product1.setQuantity(product.getQuantity());
        return  productRepository.save(product1);

    }
    @Override
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
}

