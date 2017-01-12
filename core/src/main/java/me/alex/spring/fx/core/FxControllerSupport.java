package me.alex.spring.fx.core;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.ApplicationListener;

/**
 * Fx view controller support.
 * <p>
 * Created by Alex.Sun on 1/12/17.
 */
public class FxControllerSupport extends FxView implements ApplicationListener<FxStartEvent> {

    private Scene scene;
    private Stage stage;
    private Stage primaryStage;

    public Scene getScene() {
        if (scene == null) {
            scene = createScene(getView());
        }
        return scene;
    }

    protected Scene createScene(Parent root) {
        return new Scene(root);
    }

    public Stage getStage() {
        if (stage == null) {
            stage = new Stage();
            initStage(stage);
        }
        return stage;
    }

    public void show(){
        getStage().show();
    }

    public void close(){
        getStage().close();
    }

    protected void initStage(Stage stage) {
        if (!meta.main()) {
            stage.initOwner(this.primaryStage);
        }
        stage.setScene(getScene());
    }

    //    @EventListener
    public void onFxStart(FxStartEvent event) {
        this.primaryStage = event.getPrimaryStage();
        if (meta.main()) {
            this.stage = this.primaryStage;
            initStage(this.stage);
            this.stage.show();
        }
    }

    @Override
    public void onApplicationEvent(FxStartEvent event) {
        onFxStart(event);
    }
}
