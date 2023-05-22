package com.ems.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ems.products.entity.Product;
import com.ems.products.service.ProductsService;

@Controller
public class ProductsController {

    @Autowired
    private ProductsService service;

    @GetMapping("/")
    public String getProducts(Model model) {
        List<Product> products = service.getProducts();
        model.addAttribute("products", products);
        return "home";
    }

    @GetMapping("/add")
    public String getProduct(Model model) {
        model.addAttribute("products", new Product());
        return "add";
    }

    @GetMapping("/{id}")
    public String getProduct(@PathVariable int id) {
        service.getProduct(id);
        return "product";
    }

    @PostMapping("/add")
    public String addProduct(@RequestBody Product product) {
        service.addProduct(product);
        return "redirect:/";
    }

    @PutMapping("/{id}")
    public String updateProduct(@PathVariable int id, @RequestBody Product product) {
        service.updateProduct(id, product);
        return "Product updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id) {
        service.deleteProduct(id);
        return "Product deleted successfully";
    }

}