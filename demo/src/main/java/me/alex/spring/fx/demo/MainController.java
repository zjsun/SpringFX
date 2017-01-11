package me.alex.spring.fx.demo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import me.alex.spring.fx.core.FxController;
import me.alex.spring.fx.core.FxViewSupport;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Alex.Sun on 1/11/17.
 */
@FxController
public class MainController extends FxViewSupport implements Initializable {
    @FXML
    public Button btn01;
    @FXML
    public Button btn02;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
