package com.example.simsim.api;

import com.example.simsim.entity.Product;
import com.example.simsim.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1")
@RestController
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public ResponseEntity getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity(products, HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity getProductById(@PathVariable Long id){
        Product product = productService.getProductById(id);
        return new ResponseEntity(product, HttpStatus.OK);
    }


    @PostMapping("/products")
    public ResponseEntity addProducts(@RequestBody Product product){
        productService.saveProducts(product);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
