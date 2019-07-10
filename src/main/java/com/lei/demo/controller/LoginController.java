package com.lei.demo.controller;

import com.lei.demo.domain.User;
import com.lei.demo.serviceImpl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 登录界面跳转控制
 * @author Chris
 */
@Controller
public class LoginController {

    @Autowired
    private LoginServiceImpl loginServiceImpl;

    /**
     * @Author: Chris
     * @Date: 14:31 2018/7/2
     * @Description: 从数据库查询用户是否正确，成功跳转到首页，否则重定向到登录页
     * @params:  * @param request
     * @param session
     * @param model
     */
    @PostMapping(value = "/userLogin")
    public String login(HttpServletRequest request, HttpSession session, Model model) {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        if(!loginServiceImpl.verify(userName, password).isEmpty()) {
            User loginUser = loginServiceImpl.verify(userName, password).get(0);
            //防止表单重复提交
            session.setAttribute("loginUser", loginUser);
            return "redirect:/main";
        } else {
            model.addAttribute("msg", "用户名或密码错误！");
            return "login";
        }
    }
}
