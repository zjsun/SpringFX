package me.alex.spring.fx.core;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * A JavaFX view controller.
 * <p>
 * Created by Alex.Sun on 1/11/17.
 */
@Component
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
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

    /**
     * flag the main controller which starts the main app view
     */
    boolean main() default false;
}
