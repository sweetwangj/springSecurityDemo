package com.operation.qkwall.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //映射图片保存地址
        registry.addResourceHandler("/appIcon/**").addResourceLocations("file:///home/qkwall/appIcon/");
        registry.addResourceHandler("/appIcon/**").addResourceLocations("F:\\appIcon");
    }
}