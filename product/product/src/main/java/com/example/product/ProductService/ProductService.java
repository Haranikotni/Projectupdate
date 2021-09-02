package com.example.product.ProductService;


import java.util.List;

import com.example.product.entities.Product;

public interface ProductService {
    Product createProduct(Product product);

    List<Product> getProducts();

    void deleteProduct(int pid);

    Product getProduct(int pid);

    List<Product> getProductsByColor(String color);

    List<Product> getProductsByName(String name);

    List<Product> getProductsByCategory(String category);

    List<Product> getProductsByColorAndCategory(String color, String Cateegory);


}
