package me.alex.spring.fx.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.stage.Stage;
import me.alex.spring.fx.core.FxController;
import me.alex.spring.fx.core.FxControllerSupport;
import me.alex.spring.fx.core.FxUtils;
import org.controlsfx.glyphfont.FontAwesome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Main demo window.
 * <p>
 * Created by Alex.Sun on 1/11/17.
 */
@FxController(main = true)
public class Main extends FxControllerSupport implements Initializable {
    @FXML
    public Button btn01;
    @FXML
    public Button btn02;

    @Value("${app.title:'Demo App'}")
    private String title;

    @Autowired
    private NewWin newWin;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FxUtils.useIcon(btn01, FontAwesome.Glyph.FOLDER_OPEN, ContentDisplay.LEFT);
        FxUtils.useIcon(btn02, FontAwesome.Glyph.CLOSE, ContentDisplay.LEFT);
    }

    @Override
    protected void initStage(Stage stage) {
        super.initStage(stage);
        stage.setTitle(title);
        stage.getIcons().add(Res.LOGO);
    }

    @FXML
    public void onClose(ActionEvent actionEvent) {
        getStage().close();
    }

    @FXML
    public void onNewWindow(ActionEvent actionEvent) {
        newWin.getStage().show();
    }
}
