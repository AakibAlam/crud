package com.ems.products.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.ems.products.entity.Product;
import com.ems.products.repository.ProductsRepository;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository repository;

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Optional<Product> getProduct(@PathVariable int id) {
        return repository.findById(id);
    }

    public String addProduct(@RequestBody Product product) {
        repository.save(product);
        return "Product added successfully";
    }

    public String updateProduct(@PathVariable int id, @RequestBody Product product) {
        Product existingProduct = repository.findById(id).get();
        existingProduct.setName(product.getName());
        existingProduct.setCode(product.getCode());
        repository.save(existingProduct);
        return "Product updated successfully";
    }

    public String deleteProduct(@PathVariable int id) {
        repository.deleteById(id);
        return "Product deleted successfully";
    }

}
