package com.ems.products.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ems.products.entity.Product;

@Repository
public interface ProductsRepository extends MongoRepository<Product, Integer> {

}
