package me.alex.spring.fx.demo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import me.alex.spring.fx.core.FxPreloader;
import me.alex.spring.fx.core.FxSpringInitProgress;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Splash window, it's managed by JavaFx.
 * <p>
 * Created by Alex.Sun on 1/24/17.
 */
public class Splash extends FxPreloader implements Initializable {
    @FXML
    public ProgressBar progressBar;
    @FXML
    public Label lbDetails;
    @FXML
    public ImageView imageView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        imageView.setImage(Res.LOGO);
    }

    @Override
    protected String getViewPath() {
        return "/fxml/Splash.fxml";
    }

    @Override
    protected void updateProgress(FxSpringInitProgress info) {
        progressBar.progressProperty().set(info.getProgress());
        lbDetails.textProperty().set("Loading " + info.getDetails() + " ...");
    }


}
