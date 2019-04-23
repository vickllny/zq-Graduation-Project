package com.zq.vm.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.context.SpringContextUtils;

import com.zq.vm.config.interceptor.BaseInterceptor;
import com.zq.vm.filter.LoginFilter;
import com.zq.vm.filter.XssFilter;
import com.zq.vm.utils.SpringContextUtil;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new BaseInterceptor()).addPathPatterns("/**");
    }

    /**
     * loginFilter
     * @return
     */
    @Bean
    public FilterRegistrationBean<LoginFilter> loginFilter() {
        FilterRegistrationBean<LoginFilter> bean = new FilterRegistrationBean<LoginFilter>();
        bean.setFilter(new LoginFilter());
        bean.setOrder(1);
        bean.addUrlPatterns("/*");
        return bean;
    }
    
    /**
     * xssFilter
     * @return
     */
    @Bean
    public FilterRegistrationBean<XssFilter> xssFilter() {
        FilterRegistrationBean<XssFilter> bean = new FilterRegistrationBean<XssFilter>();
        bean.setFilter(new XssFilter());
        bean.setOrder(2);
        bean.addUrlPatterns("/*");
        return bean;
    }
    
}
