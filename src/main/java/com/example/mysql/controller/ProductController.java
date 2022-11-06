package com.example.mysql.controller;

import com.example.mysql.model.Product;
import com.example.mysql.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;


    @GetMapping("/product")
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/product/{id}")
    public Optional<Product> getProductById(@PathVariable Integer id){
        return productRepository.findById(id);
    }

    @PostMapping("/product")
    public Optional<Product> saveProduct(@RequestBody Product product){
        productRepository.save(product);
        return productRepository.findById(product.getId());
    }

    @DeleteMapping("/product")
    public void deleteAllProduct(){
        productRepository.deleteAll();
    }
}
