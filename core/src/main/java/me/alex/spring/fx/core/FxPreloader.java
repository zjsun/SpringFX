package me.alex.spring.fx.core;

import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * Created by Alex.Sun on 1/24/17.
 */
@Slf4j
public abstract class FxPreloader extends Preloader {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        Scene scene = new Scene(loadView(primaryStage));
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    protected Parent loadView(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(getViewPath()));
        loader.setControllerFactory(param -> FxPreloader.this);
        return loader.load();
    }

    protected abstract String getViewPath();

    @Override
    public void handleProgressNotification(ProgressNotification info) {
        //ignore the default progress behavior
    }

    @Override
    public void handleStateChangeNotification(StateChangeNotification info) {
        if (info.getType() == StateChangeNotification.Type.BEFORE_START) {
            this.primaryStage.close();
        }
    }

    @Override
    public void handleApplicationNotification(PreloaderNotification info) {
        if (info instanceof FxSpringInitProgress) updateProgress((FxSpringInitProgress) info);
    }

    protected void updateProgress(FxSpringInitProgress info) {

    }
}
