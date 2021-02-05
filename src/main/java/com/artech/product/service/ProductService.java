package com.artech.product.service;

import com.artech.product.entity.Product;
import com.artech.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    List<Product> products = new ArrayList<>();

    public String saveProduct(Product product){
        productRepository.save(product);
        return "success";
    }

    public List<Product> getProductList() {
        return productRepository.findAll();
    }

    public List<Product> getProductListByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public Product getProductByProductId(Integer id) {
        return productRepository.findById(id).get();
    }

    public String updateProduct(Product product) {
        productRepository.save(product);
        return "Record updated successfully";
    }

    public String deleteProduct(Integer id) {

       productRepository.deleteById(id);

      return "Product deleted successfully";

    }
}
