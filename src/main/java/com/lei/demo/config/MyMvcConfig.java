package com.lei.demo.config;

import com.lei.demo.utils.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 配置默认访问登录界面
 * @author Chris
 */
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");

                registry.addViewController("/main").setViewName("index");
                registry.addViewController("/main.html").setViewName("index");
            }

            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/", "/login", "/login.html", "/userLogin");
            }
        };
        return adapter;
    }
}
