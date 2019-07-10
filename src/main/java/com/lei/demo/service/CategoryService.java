package com.lei.demo.service;

import com.lei.demo.domain.Category;
import com.lei.demo.domain.Product;

import java.util.List;

/**
 * @author Chris
 */
public interface CategoryService {

    List<Category> getCategoryList();

    Category findCategoryById(Integer id);

    Category saveCategory(Category category);

    void deleteCategory(Integer id);
}
