package com.example.simsim.service;


import com.example.simsim.entity.Product;
import com.example.simsim.entity.ProductRepository;
import com.example.simsim.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @Transactional
    public Product getProductById(Long id){
        Product product = productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("no " + id + "in Product"));
        return product;
    }

    @Transactional
    public void saveProducts(Product product){
        productRepository.save(product);
    }



}
