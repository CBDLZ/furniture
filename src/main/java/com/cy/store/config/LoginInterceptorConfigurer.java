package com.cy.store.config;

import com.cy.store.intercaptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class LoginInterceptorConfigurer implements WebMvcConfigurer {

    /** 拦截器配置 */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 创建拦截器对象
        HandlerInterceptor interceptor = new LoginInterceptor();

        // 白名单
        List<String> patterns = new ArrayList<String>();
        patterns.add("/pic/**");
//        patterns.add("/UI/api/**");
        patterns.add("/UI/css/**");
        patterns.add("/UI/images/**");
        patterns.add("/UI/js/**");
        patterns.add("/UI/lib/**");
        patterns.add("/UI/store_page/asset/**");
        patterns.add("/UI/store_page/bootstrap/**");
        patterns.add("/UI/store_page/bootstrap3/**");
        patterns.add("/UI/store_page/css/**");
        patterns.add("/UI/store_page/images/**");
        patterns.add("/UI/store_page/pic2/**");
        patterns.add("/UI/store_page/login.html");
        patterns.add("/UI/store_page/new_login.html");
        patterns.add("/UI/store_page/register.html");
        patterns.add("/UI/store_page/hot.html");
        patterns.add("/UI/store_page/index.html");

        patterns.add("/users/reg");
        patterns.add("/users/login");



        // 通过注册工具添加拦截器
        registry.addInterceptor(interceptor).addPathPatterns("/**").excludePathPatterns(patterns);
    }
}
