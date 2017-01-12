package me.alex.spring.fx.core;

import javafx.application.Application;
import javafx.stage.Stage;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by Alex.Sun on 1/11/17.
 */
public class FxApplication extends Application {
    private static String[] appArgs = ArrayUtils.EMPTY_STRING_ARRAY;

    private ConfigurableApplicationContext appContext;

    @Override
    public void init() throws Exception {
        super.init();
        this.appContext = SpringApplication.run(getClass(), appArgs);
    }

    @Override
    public final void start(Stage primaryStage) throws Exception {
        appContext.publishEvent(new FxStartEvent(primaryStage));//dispatch primaryStage to controllers
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
}
