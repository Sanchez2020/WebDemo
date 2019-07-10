package com.lei.demo.controller;

import com.lei.demo.domain.Category;
import com.lei.demo.domain.Colour;
import com.lei.demo.domain.Product;
import com.lei.demo.domain.Size;
import com.lei.demo.service.CategoryService;
import com.lei.demo.service.ColourService;
import com.lei.demo.service.ProductService;
import com.lei.demo.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 控制产品管理页面跳转
 * @author Chris
 */
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ColourService colourService;

    @Autowired
    private SizeService sizeService;

    @Autowired
    private CategoryService categoryService;

    /**
     * @Author: Chris
     * @Date: 14:35 2018/7/2
     * @Description: 跳转到产品列表页面
     * @params:  * @param model
     */
    @GetMapping(value = "/products")
    public String productList(Model model){
        List<Product> products = productService.getProductList();
        model.addAttribute("products", products);
        return "product/productList";
    }

    /**
     * @Author: Chris
     * @Date: 14:35 2018/7/2
     * @Description: 跳转到添加产品页面
     * @params:  * @param model
     */
    @GetMapping(value = "/product")
    public String productToAdd(Model model) {
        List<Category> categories = categoryService.getCategoryList();
        List<Colour> colourList = colourService.getColourList();
        List<Size> sizeList = sizeService.getSizeList();
        model.addAttribute("categories", categories);
        model.addAttribute("colourList", colourList);
        model.addAttribute("sizeList", sizeList);
        return "product/addProduct";
    }

    /**
     * @Author: Chris
     * @Date: 14:36 2018/7/2
     * @Description: 添加一个产品，跳转回产品列表页面
     * @params:  * @param product
     */
    @PostMapping(value = "/product")
    public String addProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }

    /**
     * @Author: Chris
     * @Date: 14:37 2018/7/2
     * @Description: 跳转到编辑产品页面
     * @params:  * @param id
     * @param model
     */
    @GetMapping(value = "/product/{id}")
    public String productToEdit(@PathVariable(value = "id") Integer id, Model model) {
        Product product = productService.findProductById(id);

        List<Category> categories = categoryService.getCategoryList();

        List<Colour> colours = product.getColours();    //获取一款产品的所有颜色
        List<Colour> colourList = colourService.getColourList();

        List<Size> sizes = product.getSizes();      //获取一款产品的所有号码
        List<Size> sizeList = sizeService.getSizeList();

        model.addAttribute("product", product);
        model.addAttribute("categories", categories);
        model.addAttribute("colours", colours);
        model.addAttribute("colourList", colourList);
        model.addAttribute("sizes", sizes);
        model.addAttribute("sizeList", sizeList);
        return "product/addProduct";
    }

    /**
     * @Author: Chris
     * @Date: 14:37 2018/7/2
     * @Description: 编辑一种产品，跳转回产品列表页面
     * @params:  * @param product
     */
    @PutMapping(value = "/product")
    public String editProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }

    /**
     * @Author: Chris
     * @Date: 14:38 2018/7/2
     * @Description: 删除一种产品
     * @params:  * @param id
     */
    @DeleteMapping(value = "/product/{id}")
    public String deleteProduct(@PathVariable(value = "id") Integer id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}
