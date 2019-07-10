package com.lei.demo.controller;

import com.lei.demo.domain.*;
import com.lei.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 控制商品管理页面跳转
 * @author Chris
 */
@Controller
public class ShoesController {

    @Autowired
    private ShoesService shoesService;

    /**
     * @Author: Chris
     * @Date: 14:38 2018/7/2
     * @Description: 跳转到商品列表页面
     * @params:  * @param model
     */
    @GetMapping(value = "/shoesList")
    public String shoesList(Model model) {
        List<Shoes> shoes = shoesService.getShoesList();
        model.addAttribute("shoes", shoes);
        return "shoes/shoesList";
    }

//    @GetMapping(value = "/shoes")
//    public String shoesToAdd(Model model) {
//        List<Category> categories = categoryService.getCategoryList();
//        model.addAttribute("categories", categories);
//        return "shoes/addShoes";
//    }
//
//    @PostMapping(value = "/shoes")
//    public String addShoes(Shoes shoes) {
//        shoesService.saveShoes(shoes);
//        return "redirect:/shoesList";
//    }

    /**
     * @Author: Chris
     * @Date: 14:39 2018/7/2
     * @Description: 跳转到商品详情页面，可以编辑库存数量
     * @params:  * @param id
     * @param model
     */
    @GetMapping(value = "/shoes/{id}")
    public String shoesToEdit(@PathVariable(value = "id") Integer id, Model model) {
        Shoes shoes = shoesService.findShoesById(id);
        Category category = shoes.getProduct().getCategory();
        Product product = shoes.getProduct();
        Colour colour = shoes.getColour();
        Size size = shoes.getSize();
        model.addAttribute("shoes", shoes);
        model.addAttribute("category", category);
        model.addAttribute("product",product);
        model.addAttribute("colour", colour);
        model.addAttribute("size", size);
        return "shoes/editShoes";
    }

    /**
     * @Author: Chris
     * @Date: 14:40 2018/7/2
     * @Description: 编辑一种商品的库存，跳转回商品列表页面
     * @params:  * @param shoes
     */
    @PutMapping(value = "/shoes")
    public String editShoes(Shoes shoes) {
        shoesService.saveShoes(shoes);
        return "redirect:/shoesList";
    }

    /**
     * @Author: Chris
     * @Date: 14:41 2018/7/2
     * @Description: 删除一种商品
     * @params:  * @param id
     */
    @DeleteMapping(value = "/shoes/{id}")
    public String deleteShoes(@PathVariable(value = "id") Integer id) {
        shoesService.deleteShoes(id);
        return "redirect:/shoesList";
    }

//    @PostMapping(value = "/selectCategory")
//    @ResponseBody
//    public List<Product> getProducts(HttpServletRequest request) {
//        Integer id = Integer.valueOf(request.getParameter("id"));
//        return categoryService.findCategoryById(id).getProducts();
//    }
//
//    @PostMapping(value = "/selectProduct")
//    @ResponseBody
//    public Product getProduct(HttpServletRequest request) {
//        Integer id = Integer.valueOf(request.getParameter("id"));
//        return productService.findProductById(id);
//    }

}
