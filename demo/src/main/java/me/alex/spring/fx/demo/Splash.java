package me.alex.spring.fx.demo;

import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import me.alex.spring.fx.core.FxPreloader;
import me.alex.spring.fx.core.SpringInitProgress;

/**
 *
 * Created by Alex.Sun on 1/24/17.
 */
public class Splash extends FxPreloader {
    @FXML
    public ProgressBar progressBar;

    @Override
    protected String getViewPath() {
        return "/fxml/Splash.fxml";
    }

    @Override
    protected void updateProgress(SpringInitProgress info) {
        progressBar.progressProperty().set(info.getProgress());
    }
}
