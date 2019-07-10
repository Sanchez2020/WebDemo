package com.lei.demo.serviceImpl;

import com.lei.demo.domain.Product;
import com.lei.demo.repository.ProductRepository;
import com.lei.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Chris
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProductList() {
        return productRepository.findAll();
    }

    @Override
    public Product findProductById(Integer id) {
        return productRepository.findOne(id);
    }

    @Override
    @Transactional
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    @Transactional
    public void deleteProduct(Integer id) {
        productRepository.delete(id);
    }

    @Override
    public List<Integer> getColourId() {
        return productRepository.findColourId();
    }

    @Override
    public List<Integer> getSizeId() {
        return productRepository.findSizeId();
    }

    @Override
    public List<Product> getProducts(Integer id) {
        return productRepository.findProductsByCategory_Id(id);
    }
}
