package com.martin.springcloud.msvc.products.msvcproducts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.martin.springcloud.msvc.products.msvcproducts.entities.Product;
import com.martin.springcloud.msvc.products.msvcproducts.repositories.ProductRepository;

import jakarta.persistence.EntityNotFoundException;


@Service
public class ProductServcieImpl implements ProductService {


    private final  ProductRepository productRepository;


    public ProductServcieImpl(ProductRepository productR){
        this.productRepository = productR;
    }
    @Transactional(readOnly = true)
    @Override
    public List<Product> findAll() {
        return ( List<Product>)this.productRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Product> findById(Long id) {
        
        return this.productRepository.findById(id);
    }
}
