package com.example.demo;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean<StaticResourceRewriteFilter> staticResourceRewriteFilter() {
        FilterRegistrationBean<StaticResourceRewriteFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new StaticResourceRewriteFilter());
        // Apply the filter to all URLs
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}
