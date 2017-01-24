package me.alex.spring.fx.demo;

import me.alex.spring.fx.core.FxApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Alex.Sun on 1/11/17.
 */
@SpringBootApplication(scanBasePackages = {"me.alex.spring.fx.core", "me.alex.spring.fx.demo"})
public class App extends FxApplication {

    public static void main(String[] args) {
        launchApp(App.class, args);
    }

}
