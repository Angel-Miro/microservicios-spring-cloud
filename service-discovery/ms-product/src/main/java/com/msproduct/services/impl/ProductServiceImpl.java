package com.msproduct.services.impl;

import com.msproduct.entities.Product;
import com.msproduct.repositories.ProductRepository;
import com.msproduct.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final Environment environment;

    @Override
    @Transactional
    public List<Product> findAll() {
        return this.productRepository.findAll().stream().peek(product -> product.setPort(Integer.parseInt(environment.getProperty("server.port")))).toList();
    }

    @Override
    public Optional<Product> findById(Long id) {

        return this.productRepository.findById(id).map(product -> {
            product.setPort(Integer.parseInt(environment.getProperty("server.port")));
            return product;
        });

    }
}
