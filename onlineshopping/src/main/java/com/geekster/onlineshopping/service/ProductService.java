package com.geekster.onlineshopping.service;

import com.geekster.onlineshopping.dao.ProductRepository;
import com.geekster.onlineshopping.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    // getAllProducts
    public List<Product> getAllProducts(String brand){
        List<Product> productList = productRepository.findAll();
        if(brand == null)
            return productList;
        else {
            List<Product> filterList = new ArrayList<>();
            for(Product product:productList){
                if(product.getBrand().equals(brand))
                    filterList.add(product);
            }
            return filterList;
        }

    }

    // getProductById
    public Product getProductById(int id){
        return productRepository.findById(id).get();
    }

    // creareProduct
    public Product creareProduct(Product product){
        return productRepository.save(product);
    }

    // updateProduct
    public Product updateProduct(int id, Product reqProduct){
        Product product = getProductById(id);
        product.setName(reqProduct.getName());
        product.setPrice(reqProduct.getPrice());
        product.setDescription(reqProduct.getDescription());
        product.setCategory(reqProduct.getCategory());
        product.setBrand(reqProduct.getBrand());

        return productRepository.save(product);
    }

    // deleteProduct
    public void deleteProduct(int id){
        productRepository.deleteById(id);
    }


}
