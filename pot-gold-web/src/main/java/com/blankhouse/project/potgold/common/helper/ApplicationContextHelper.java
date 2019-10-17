package com.blankhouse.project.potgold.common.helper;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextHelper implements ApplicationContextAware {
    private static ApplicationContext applicationContext;
    public ApplicationContextHelper() {
    }
    /**
     * 实现ApplicationContextAware接口的回调方法，设置上下文环境
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextHelper.applicationContext = applicationContext;
    }
    /**
     * 获得spring上下文
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
    public static Object getBean(String beanName) {
        return applicationContext != null ? applicationContext.getBean(beanName) : null;
    }

}