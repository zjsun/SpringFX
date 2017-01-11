package me.alex.spring.fx.core;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by Alex.Sun on 1/11/17.
 */
public class FxApplication extends Application {
    private static String[] appArgs;

    private ConfigurableApplicationContext appContext;
    private Stage mainStage;

    @Override
    public void init() throws Exception {
        super.init();
        this.appContext = SpringApplication.run(getClass(), appArgs);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.mainStage = primaryStage;
        //todo:
        this.mainStage.show();
    }

    @Override
    public void stop() throws Exception {
        if (appContext != null) appContext.close();
        super.stop();
    }

    /**
     * Application entry.
     */
    public static void launchApp(Class<? extends FxApplication> mainClass, String[] args) {
        FxApplication.appArgs = args;
        Application.launch(mainClass, args);
    }
}
