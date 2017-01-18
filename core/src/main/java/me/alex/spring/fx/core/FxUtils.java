package me.alex.spring.fx.core;

import org.controlsfx.glyphfont.FontAwesome;

/**
 * Created by Alex.Sun on 1/18/17.
 */
public class FxUtils {
    static {
        //register local font file
        new FontAwesome(FxUtils.class.getResource("/fxml/fontawesome-webfont.ttf").toExternalForm());
    }
}
