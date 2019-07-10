package com.lei.demo.controller;

import com.lei.demo.domain.Size;
import com.lei.demo.service.ProductService;
import com.lei.demo.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 控制号码管理页面跳转
 * @author Chris
 */
@Controller
public class SizeController {

    @Autowired
    private SizeService sizeService;

    @Autowired
    private ProductService productService;

    /**
     * @Author: Chris
     * @Date: 14:41 2018/7/2
     * @Description: 跳转到号码列表页面
     * @params:  * @param model
     */
    @GetMapping(value = "/sizes")
    public String sizeList(Model model) {
        List<Size> sizes = sizeService.getSizeList();
        List<Integer> sizeList = productService.getSizeId();
        model.addAttribute("sizeList", sizeList);
        model.addAttribute("sizes", sizes);
        return "size/sizeList";
    }

    /**
     * @Author: Chris
     * @Date: 14:42 2018/7/2
     * @Description: 跳转到号码添加页面
     * @params:  * @param
     */
    @GetMapping(value = "/size")
    public String sizeToAdd() {
        return "size/addSize";
    }

    /**
     * @Author: Chris
     * @Date: 14:43 2018/7/2
     * @Description: 添加一个号码，跳转回号码列表页面
     * @params:  * @param size
     */
    @PostMapping(value = "/size")
    public String addSize(Size size) {
        sizeService.saveSize(size);
        return "redirect:/sizes";
    }

    /**
     * @Author: Chris
     * @Date: 14:43 2018/7/2
     * @Description: 跳转到编辑号码页面
     * @params:  * @param id
     * @param model
     */
    @GetMapping(value = "/size/{id}")
    public String sizeToEdit(@PathVariable(value = "id") Integer id, Model model) {
        Size size = sizeService.findSizeById(id);
        model.addAttribute("size", size);
        return "size/addSize";
    }

    /**
     * @Author: Chris
     * @Date: 14:45 2018/7/2
     * @Description: 编辑一个号码，跳转回号码列表页面
     * @params:  * @param size
     */
    @PutMapping(value = "/size")
    public String editSize(Size size) {
        sizeService.saveSize(size);
        return "redirect:/sizes";
    }

    /**
     * @Author: Chris
     * @Date: 14:46 2018/7/2
     * @Description: 删除一个号码
     * @params:  * @param id
     */
    @DeleteMapping(value = "/size/{id}")
    public String deleteSize(@PathVariable(value = "id") Integer id) {
        sizeService.deleteSize(id);
        return "redirect:/sizes";
    }
}
