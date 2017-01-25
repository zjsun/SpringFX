package me.alex.spring.fx.core;

import javafx.application.Application;
import javafx.stage.Stage;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * Created by Alex.Sun on 1/11/17.
 */
public class FxApplication extends Application {
    private static FxApplication INSTANCE = null;
    private static String[] appArgs = ArrayUtils.EMPTY_STRING_ARRAY;

    private ConfigurableApplicationContext appContext;

    @Override
    public void init() throws Exception {
        super.init();
        INSTANCE = this;
        this.appContext = SpringApplication.run(getClass(), appArgs);
    }

    @Override
    public final void start(Stage primaryStage) throws Exception {
        appContext.publishEvent(new FxStartEvent(primaryStage));//todo: good idea? dispatch primaryStage to controllers
    }

    @Override
    public void stop() throws Exception {
        if (appContext != null) appContext.close();
        super.stop();
    }

    /**
     * Application entry.
     */
    public static void launchApp(Class<? extends FxApplication> mainApp, String[] args) {
        FxApplication.appArgs = args;
        Application.launch(mainApp, args);
    }

    /**
     * Register spring init progress bean to collect spring context loading progress info.
     */
    @Bean("springInitProgress")
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public static FxSpringInitProgress createSpringInitProgress() {
        return new FxSpringInitProgress(INSTANCE);
    }
}
