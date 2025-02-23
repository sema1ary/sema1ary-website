package ru.sema1ary.sema1ary_website.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Указываем, что запросы к /images/** будут обрабатываться из папки images в корне проекта
        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:images/");
    }
}
