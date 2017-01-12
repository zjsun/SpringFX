package me.alex.spring.fx.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import me.alex.spring.fx.core.FxController;
import me.alex.spring.fx.core.FxControllerSupport;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Alex.Sun on 1/12/17.
 */
@FxController("NewWin")
public class NewWin extends FxControllerSupport {

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
}
