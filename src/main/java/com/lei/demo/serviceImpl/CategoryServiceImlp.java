package com.lei.demo.serviceImpl;

import com.lei.demo.domain.Category;
import com.lei.demo.domain.Product;
import com.lei.demo.repository.CategoryRepository;
import com.lei.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Chris
 */
@Service
public class CategoryServiceImlp implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategoryList() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findCategoryById(Integer id) {
        return categoryRepository.findOne(id);
    }

    @Override
    @Transactional
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    @Transactional
    public void deleteCategory(Integer id) {
        categoryRepository.delete(id);
    }
}
