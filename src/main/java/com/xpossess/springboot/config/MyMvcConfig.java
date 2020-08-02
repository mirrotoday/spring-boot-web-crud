package com.xpossess.springboot.config;

import com.xpossess.springboot.conponent.LoginHandlerInterceptor;
import com.xpossess.springboot.conponent.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // super.addViewControllers(registry);
        //浏览器发送 /atguigu 请求来到 success
        registry.addViewController("/xpossess").setViewName("success");
    }
    //所有的WebMvcConfigurerAdapter组件都会一起起作用
    @Bean //将组件注册在容器
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                //添加视图映射
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("main.html").setViewName("dashboard");
            }
            /**
             * 注册拦截器,限制访问----index.html  /user/login 向登陆页面的的限制
             */

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
               // super.addInterceptors(registry);
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/","/index.html","/user/login");
            }
        };
        return adapter;
    }

    @Bean
   public LocaleResolver localeResolver(){
       return new MyLocaleResolver();
    }
}
