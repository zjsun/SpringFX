package me.alex.spring.fx.core;

import javafx.application.Preloader;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Spring context initialize progress notification.
 * <p>
 * Created by Alex.Sun on 1/24/17.
 */
public class FxSpringInitProgress implements BeanPostProcessor, ApplicationContextAware, Preloader.PreloaderNotification {

    private int count;
    private int step;
    private String details;
    private FxApplication fxApplication;

    public FxSpringInitProgress(FxApplication fxApplication) {
        this.fxApplication = fxApplication;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        step++;
        details = beanName;
        fxApplication.notifyPreloader(this);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.count = applicationContext.getBeanDefinitionCount();
        this.step = 1;
    }

    public double getProgress() {
        return step * 1d / count;
    }

    public String getDetails() {
        return details;
    }
}
