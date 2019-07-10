package com.lei.demo.controller;

import com.lei.demo.domain.Colour;
import com.lei.demo.service.ColourService;
import com.lei.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 控制颜色管理页面跳转
 * @author Chris
 */
@Controller
public class ColourController {

    @Autowired
    private ColourService colourService;

    @Autowired
    private ProductService productService;

    /**
     * @Author: Chris
     * @Date: 14:24 2018/7/2
     * @Description: 跳转到颜色列表页面
     * @params:  * @param model
     */
    @GetMapping(value = "/colours")
    public String colourList(Model model) {
        List<Colour> colours = colourService.getColourList();
        List<Integer> colourList = productService.getColourId();    //查找一种产品拥有的所有颜色id
        model.addAttribute("colourList", colourList);
        model.addAttribute("colours", colours);
        return "colour/colourList";
    }

    /**
     * @Author: Chris
     * @Date: 14:24 2018/7/2
     * @Description: 跳转到添加颜色页面
     * @params:  * @param
     */
    @GetMapping(value = "/colour")
    public String colourToAdd() {
        return "colour/addColour";
    }

    /**
     * @Author: Chris
     * @Date: 14:25 2018/7/2
     * @Description: 添加一种颜色，跳转回颜色列表页面
     * @params:  * @param colour
     */
    @PostMapping(value = "/colour")
    public String addColour(Colour colour) {
        colourService.saveColour(colour);
        return "redirect:/colours";
    }

    /**
     * @Author: Chris
     * @Date: 14:25 2018/7/2
     * @Description: 跳转到编辑颜色页面
     * @params:  * @param id
     * @param model
     */
    @GetMapping(value = "/colour/{id}")
    public String colourToEdit(@PathVariable(value = "id") Integer id, Model model) {
        Colour colour = colourService.findColourById(id);
        model.addAttribute("colour", colour);
        return "colour/addColour";
    }

    /**
     * @Author: Chris
     * @Date: 14:26 2018/7/2
     * @Description: 编辑一种颜色，跳转回夜色列表页面
     * @params:  * @param colour
     */
    @PutMapping(value = "/colour")
    public String editColour(Colour colour) {
        colourService.saveColour(colour);
        return "redirect:/colours";
    }

    /**
     * @Author: Chris
     * @Date: 14:27 2018/7/2
     * @Description: 删除一种颜色
     * @params:  * @param id
     */
    @DeleteMapping(value = "/colour/{id}")
    public String deleteColour(@PathVariable(value = "id") Integer id) {
        colourService.deleteColour(id);
        return "redirect:/colours";
    }
}
