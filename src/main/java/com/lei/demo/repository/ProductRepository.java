package com.lei.demo.repository;

import com.lei.demo.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Chris
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(nativeQuery = true, value = "SELECT DISTINCT colours_colour_id FROM product_colours ")
    List<Integer> findColourId();

    @Query(nativeQuery = true, value = "SELECT DISTINCT sizes_size_id FROM product_sizes")
    List<Integer> findSizeId();

    List<Product> findProductsByCategory_Id(Integer id);
}
