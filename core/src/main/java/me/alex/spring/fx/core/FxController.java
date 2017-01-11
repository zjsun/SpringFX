package me.alex.spring.fx.core;

import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * A JavaFX view controller.
 * <p>
 * Created by Alex.Sun on 1/11/17.
 */
@Lazy
@Component
@Retention(RetentionPolicy.RUNTIME)
public @interface FxController {

    /**
     * fxml load by resource, default value would be detected by the controller class name.
     */
    @AliasFor("fxml")
    String value() default "";

    /**
     * same as value.
     */
    @AliasFor("value")
    String fxml() default "";

}
