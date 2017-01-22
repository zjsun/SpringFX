package me.alex.spring.fx.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import me.alex.spring.fx.core.FxController;
import me.alex.spring.fx.core.FxControllerSupport;
import me.alex.spring.fx.core.FxUtils;
import org.controlsfx.glyphfont.FontAwesome;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Alex.Sun on 1/12/17.
 */
@FxController("NewWindow")
public class NewWin extends FxControllerSupport implements Initializable {

    @FXML
    public Button btn01;
    @FXML
    public Button btn02;

    @Autowired
    private Main main;

    @FXML
    public void onClose(ActionEvent actionEvent) {
        getStage().close();
    }

    @FXML
    public void onCloseParent(ActionEvent actionEvent) {
        main.getStage().close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FxUtils.useIcon(btn01, FontAwesome.Glyph.EXCHANGE, ContentDisplay.LEFT);
        FxUtils.useIcon(btn02, FontAwesome.Glyph.EJECT, ContentDisplay.LEFT);
    }
}
