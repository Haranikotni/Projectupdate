package com.example.product.controller;

import java.util.List;
import java.util.Optional;

import com.example.product.ProductServiceImpl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.product.entities.Product;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductServiceImpl productdao;

    @GetMapping("/ Allproducts")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productdao.getProducts();
        return ResponseEntity.of(Optional.of(products));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable(value = "id") int id) {
        Product product = productdao.getProduct(id);
        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(product));
    }

    @GetMapping("/{color}")
    public ResponseEntity<List<Product>> getProductsByColor(@PathVariable(value = "color") String color) {
        List<Product> products = productdao.getProductsByColor(color);
        return ResponseEntity.of(Optional.of(products));
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Product>> getProductsByName(@PathVariable(value = "name") String name) {
        List<Product> products = productdao.getProductsByName(name);
        return ResponseEntity.of(Optional.of(products));
    }

    @GetMapping("/{categoty}")
    public ResponseEntity<List<Product>> getProductsByCategoty(@PathVariable(value = "categoty") String categoty) {
        List<Product> products = productdao.getProductsByCategory(categoty);
        if (products == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(products));
    }

    @GetMapping("/{color}/{categoty}")
    public ResponseEntity<List<Product>> getProductsByColorAndCategoty(@PathVariable(value = "color") String color, @PathVariable(value = "categoty") String category) {
        List<Product> products = productdao.getProductsByColorAndCategory(color, category);
        if (products == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(products));
    }

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        this.productdao.createProduct(product);
        return ResponseEntity.of(Optional.of(product));
        // return ResponseEntity.ok("Succesfully Created!!");
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable(value = "id") int id) {
        this.productdao.deleteProduct(id);
        return ResponseEntity.ok("Successfull Deleted!!");
    }
}




