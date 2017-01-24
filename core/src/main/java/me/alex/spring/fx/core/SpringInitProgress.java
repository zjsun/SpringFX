package me.alex.spring.fx.core;

import javafx.application.Preloader;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Spring context initialize progress notification.
 * <p>
 * Created by Alex.Sun on 1/24/17.
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SpringInitProgress implements Preloader.PreloaderNotification, BeanPostProcessor, ApplicationContextAware {

    private int count;
    private int step;
    private String details;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        step++;
        details = beanName;
        FxApplication.INSTANCE.notifyPreloader(this);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.count = applicationContext.getBeanDefinitionCount();
        this.step = 0;
    }

    public double getProgress() {
        return step * 1d / count;
    }

    public String getDetails() {
        return details;
    }
}
