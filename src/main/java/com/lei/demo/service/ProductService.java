package com.lei.demo.service;

import com.lei.demo.domain.Product;

import java.util.List;

/**
 * @author Chris
 */
public interface ProductService {

    List<Product> getProductList();

    Product findProductById(Integer id);

    Product saveProduct(Product product);

    void deleteProduct(Integer id);

    List<Integer> getColourId();

    List<Integer> getSizeId();

    List<Product> getProducts(Integer id);
}
