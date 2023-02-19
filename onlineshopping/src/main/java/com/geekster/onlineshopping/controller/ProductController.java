package com.geekster.onlineshopping.controller;

import com.geekster.onlineshopping.model.Product;
import com.geekster.onlineshopping.service.ProductService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
    @Autowired
    ProductService productService;

    // getAllProducts
    @GetMapping("/products")
    public List<Product> getAllProducts(@Nullable @RequestParam String brand){
        return productService.getAllProducts(brand);
    }

    // getProductById
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable int id){
        return productService.getProductById(id);
    }

    // createProduct
    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product){
        return productService.creareProduct(product);
    }

    // updateProduct
    @PutMapping("/products/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestBody Product product){
        productService.updateProduct(id, product);
        return new ResponseEntity<>("Product updated", HttpStatus.OK);
    }

    // deleteProduct
    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product deleted", HttpStatus.OK);
    }




}
