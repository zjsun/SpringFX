package me.alex.spring.fx.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import java.nio.charset.StandardCharsets;

/**
 * FXML view bean factory.
 * <p>
 * Created by Alex.Sun on 1/11/17.
 */
public class FxView extends AbstractFactoryBean<Parent> {

    private String fxmlPrefix = "/fxml/";
    private String fxmlSuffix = ".fxml";
    private String controllerSuffix = "Controller";

    private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();

    private BeanFactory beanFactory;

    private ClassPathResource fxmlResource;

    protected FxController meta = AnnotationUtils.findAnnotation(getClass(), FxController.class);

    /**
     * obtain the view root.
     */
    public Parent getView() {
        try {
            return getObject();
        } catch (Exception e) {
            throw new FxException(e);
        }
    }

    @Override
    public Class<Parent> getObjectType() {
        return Parent.class;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.beanClassLoader = classLoader;
        super.setBeanClassLoader(classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
        super.setBeanFactory(beanFactory);
    }

    @Override
    protected Parent createInstance() throws Exception {
        FXMLLoader loader = new FXMLLoader(StandardCharsets.UTF_8);
        loader.setClassLoader(this.beanClassLoader);
        loader.setControllerFactory(this.beanFactory::getBean);
        loader.setLocation(fxmlResource.getURL());
        return loader.load();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.fxmlResource = createFxmlResource();
        super.afterPropertiesSet();
    }

    protected ClassPathResource createFxmlResource() {
        String path = meta.fxml();
        if (StringUtils.isEmpty(path)) {
            path = StringUtils.removeEnd(getClass().getSimpleName(), controllerSuffix);
        }
        if (!StringUtils.startsWith(path, fxmlPrefix)) path = fxmlPrefix + path;
        if (!StringUtils.endsWith(path, fxmlSuffix)) path += fxmlSuffix;
        return new ClassPathResource(path);
    }

    public void setFxmlPrefix(String fxmlPrefix) {
        this.fxmlPrefix = fxmlPrefix;
    }

    public void setFxmlSuffix(String fxmlSuffix) {
        this.fxmlSuffix = fxmlSuffix;
    }

    public void setControllerSuffix(String controllerSuffix) {
        this.controllerSuffix = controllerSuffix;
    }

}
