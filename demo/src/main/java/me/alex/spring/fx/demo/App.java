package me.alex.spring.fx.demo;

import me.alex.spring.fx.core.FxApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Demo Application.
 * <p>
 * Created by Alex.Sun on 1/11/17.
 */
@SpringBootApplication
public class App extends FxApplication {

    public static void main(String[] args) {
        launchApp(App.class, args);
    }

}
