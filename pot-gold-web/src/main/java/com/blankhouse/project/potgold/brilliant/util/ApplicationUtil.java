package com.blankhouse.project.potgold.brilliant.util;

import com.sun.tools.javac.util.ArrayUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author hujia
 * @date 2019/6/27
 * @since 1.0.0
 */
@Component
public class ApplicationUtil implements ApplicationContextAware {

    private static ApplicationContext context = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        this.context = applicationContext;
    }


    public static String getActiveProfile() {
        String[] profiles = context.getEnvironment().getActiveProfiles();
        if (profiles != null && profiles.length > 0) {
            return profiles[0];
        }
        return "";
    }
}