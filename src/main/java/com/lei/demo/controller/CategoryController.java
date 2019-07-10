package com.lei.demo.controller;

import com.lei.demo.domain.Category;
import com.lei.demo.domain.Product;
import com.lei.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 控制产品类别页面跳转
 * @author Chris
 */
@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * @Author: Chris
     * @Date: 14:17 2018/7/2
     * @Description: 跳转到产品分类列表页面
     * @params:  * @param model
     */
    @GetMapping(value = "/categories")
    public String categoryList(Model model) {
        List<Category> categories = categoryService.getCategoryList();
        model.addAttribute("categories", categories);
        return "category/categoryList";
    }

    /**
     * @Author: Chris
     * @Date: 14:19 2018/7/2
     * @Description: 跳转到添加产品分类页面
     * @params:  * @param
     */
    @GetMapping(value = "category")
    public String categoryToAdd() {
        return "category/addCategory";
    }

    /**
     * @Author: Chris
     * @Date: 14:20 2018/7/2
     * @Description: 添加一个产品分类，跳转回产品分类列表页面
     * @params:  * @param category
     */
    @PostMapping(value = "/category")
    public String addCategory(Category category) {
        categoryService.saveCategory(category);
        return "redirect:/categories";
    }

    /**
     * @Author: Chris
     * @Date: 14:21 2018/7/2
     * @Description: 跳转到产品分类编辑页面
     * @params:  * @param id
     * @param model
     */
    @GetMapping(value = "/category/{id}")
    public String categoryToEdit(@PathVariable(value = "id") Integer id, Model model) {
        Category category = categoryService.findCategoryById(id);
        model.addAttribute("category", category);
        return "category/addCategory";
    }

    /**
     * @Author: Chris
     * @Date: 14:21 2018/7/2
     * @Description: 编辑一个产品分类，跳转回产品分类列表页面
     * @params:  * @param category
     */
    @PutMapping(value = "/category")
    public String editCategory(Category category) {
        categoryService.saveCategory(category);
        return "redirect:/categories";
    }

    /**
     * @Author: Chris
     * @Date: 14:22 2018/7/2
     * @Description: 删除一个产品分类
     * @params:  * @param id
     */
    @DeleteMapping(value = "/category/{id}")
    public String deleteCategory(@PathVariable(value = "id") Integer id) {
        categoryService.deleteCategory(id);
        return "redirect:/categories";
    }

    /**
     * @Author: Chris
     * @Date: 14:22 2018/7/2
     * @Description: 根据产品分类id查找到所有属于该分类的产品，跳转到该分类的产品列表页面
     * @params:  * @param id
     * @param model
     */
    @GetMapping(value = "/category_product/{id}")
    public String productList(@PathVariable(value = "id") Integer id, Model model){
        List<Product> products = categoryService.findCategoryById(id).getProducts();
        model.addAttribute("products", products);
        return "product/productList";
    }
}
