package com.artech.product.controller;

import com.artech.product.entity.Product;
import com.artech.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1")
public class ProductController {

   private ProductService productService;

   public ProductController(ProductService productService){
       this.productService = productService;
   }

    @PostMapping("/product")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){

       String status = productService.saveProduct(product);

        log.info("Product added status { }", status);

        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){

       List<Product> productList = productService.getProductList();

       return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/products/{category}")
    public ResponseEntity<List<Product>> getProductByCategory(@PathVariable String category){

        List<Product> productList = productService.getProductListByCategory(category);

        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id){

       return new ResponseEntity<>(productService.getProductByProductId(id), HttpStatus.OK);
    }

    @PutMapping("/product")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){

       return new ResponseEntity<>(productService.updateProduct(product), HttpStatus.OK);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id){

     return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);

   }
}
