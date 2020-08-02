package com.xpossess.springboot.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class HelloController {
//    @RequestMapping("/index.html")
//    public String index() {
//        return "index";
//    }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @RequestMapping("/success")
    public String success(Map<String,Object> map) {
        map.put("hello","<h1>你好</h1>");
       map.put("users", Arrays.asList("丈夫上","时返回的数据","大师傅似的"));
        return "success";
    }

}
