package com.artech.product.service;

import com.artech.product.entity.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class ProductService {

    List<Product> products = new ArrayList<>();

    public String saveProduct(Product product){
        products.add(product);
        return "success";
    }

    public List<Product> getProductList() {
        return products;
    }

    public List<Product> getProductListByCategory(String category) {
        return products.stream().filter(product ->
                          product.getCategory().getName().equalsIgnoreCase(category))
                          .collect(toList());
    }

    public Product getProductByProductId(Integer id) {
        return products.stream().filter(product -> product.getId().equals(id)).findAny().get();
    }

    public Product updateProduct(Product product) {

        Optional<Product> optionalProduct = Optional.empty();

        for (Product prod : products) {

            if (prod.getId().equals(product.getId())) {

                prod.setProductName(product.getProductName());
                prod.setDiscount(product.getDiscount());
                prod.setCategory(product.getCategory());
                prod.setDiscountDescription(product.getDiscountDescription());

                optionalProduct = Optional.of(prod);

                return optionalProduct.get();
            }
        }
        return optionalProduct.get();
    }

    public String deleteProduct(Integer id) {

        for (Product prod : products) {
            if(prod.getId() == id){
                products.remove(prod);
                return "Product deleted successfully";
            }
        }
        return "Error occurred while deleting the given product";
    }
}
