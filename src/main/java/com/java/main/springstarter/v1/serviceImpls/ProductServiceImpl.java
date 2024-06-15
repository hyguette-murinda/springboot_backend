package com.java.main.springstarter.v1.serviceImpls;

import com.java.main.springstarter.v1.dtos.CreateProductDto;
import com.java.main.springstarter.v1.exceptions.ResourceNotFoundException;
import com.java.main.springstarter.v1.models.Product;
import com.java.main.springstarter.v1.models.Quantity;
import com.java.main.springstarter.v1.repositories.IProductRepository;
import com.java.main.springstarter.v1.repositories.IQuantityRepository;
import com.java.main.springstarter.v1.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final IProductRepository productRepository;
    private final IQuantityRepository quantityRepository;

    @Override
    public Product registerProduct(CreateProductDto dto){
        Quantity quantity = new Quantity();
        quantity.setQuantity((int) dto.getQuantity());
        this.quantityRepository.save(quantity);
        Product product = new Product(dto.getProductName(), dto.getProductType(), dto.getPrice(), quantity, dto.getImage());
        return this.productRepository.save(product);

    }
    @Override
    public void deleteProduct(Long id) {
        Product product = this.productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
        this.productRepository.deleteById(id);
    }
    @Override
    public Product findById(Long id) {
        return this.productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return this.productRepository.findAll(pageable);
    }

    @Override
    public Page<Product> search(Pageable pageable, String searchKey) {
        return this.productRepository.searchAll(pageable, searchKey);
    }
}

