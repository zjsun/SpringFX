package me.alex.spring.fx.core;

import javafx.stage.Stage;
import org.springframework.context.ApplicationEvent;

/**
 * Created by Alex.Sun on 1/12/17.
 */
public class FxStartEvent extends ApplicationEvent {

    public FxStartEvent(Stage primaryStage) {
        super(primaryStage);
    }

    @Override
    public Stage getSource() {
        return (Stage) super.getSource();
    }

    public Stage getPrimaryStage(){
        return getSource();
    }
}
