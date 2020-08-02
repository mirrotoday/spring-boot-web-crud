package com.xpossess.springboot.conponent;

import com.sun.corba.se.spi.resolver.LocalResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 再链接上
 */
public class MyLocaleResolver implements LocaleResolver {


    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String l = request.getParameter("l");//从request中获取参数链接中的"l"(值)
        Locale locale = Locale.getDefault();//获得操作系统默认的
        if(!StringUtils.isEmpty(l)){ //如果参数不为空
            String [] split = l.split("_");//使用下划线分割
                    locale = new Locale(split[0],split[1]);//语言代码,地名代码

        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
