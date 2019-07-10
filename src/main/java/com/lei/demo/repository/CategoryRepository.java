package com.lei.demo.repository;

import com.lei.demo.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Chris
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
