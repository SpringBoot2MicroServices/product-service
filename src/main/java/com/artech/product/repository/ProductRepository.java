package com.artech.product.repository;

import com.artech.product.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, Integer> {

    @Query("{'Category.name':?0}")
    List<Product> findByCategory(String category);
}
