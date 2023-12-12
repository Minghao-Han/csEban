package com.AAA.csEban.Utils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.resource.PathResourceResolver;

import java.util.ArrayList;
import java.util.List;


@Configuration
public class WebSecurityConfig implements WebMvcConfigurer {

    /**
     * 登录session key
     */
    public static final String SESSION_KEY = "JWT";
    @Autowired
    private TokenInterceptor tokenInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> excludePath = new ArrayList<>();
        //这里用来排除拦截的接口,例如登录前调用的接口
        excludePath.add("/");  //登录
        excludePath.add("/login");     //注册
        excludePath.add("/error");
        excludePath.add("/static/**");//排除对静态资源对拦截
        registry.addInterceptor(tokenInterceptor) // 注册拦截器
                .addPathPatterns("/**")
                .excludePathPatterns(excludePath);
        WebMvcConfigurer.super.addInterceptors(registry);
    }
    // 解决跨域问题
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedHeaders("*")
//                .allowedMethods("*")
//                .maxAge(1800)
//                .allowedOrigins("*");
//    }
}

