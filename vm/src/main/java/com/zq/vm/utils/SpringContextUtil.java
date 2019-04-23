package com.zq.vm.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext context; //应用上下文环境

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
    	if(SpringContextUtil.context == null) {
    		SpringContextUtil.context = applicationContext;
        }
    }

    public static ApplicationContext getContext() {
        return context;
    }

    /**
     * 根据Class获取对象
     * @param clazz
     * @param <T>
     * @return
     * @throws BeansException
     */
    public static <T> T getBean(Class<T> clazz) throws BeansException {
        return context.getBean(clazz);
    }
}
