package me.alex.spring.fx.core;

import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Labeled;
import javafx.scene.paint.Color;
import org.controlsfx.glyphfont.FontAwesome;
import org.controlsfx.glyphfont.Glyph;

/**
 * Created by Alex.Sun on 1/18/17.
 */
public class FxUtils {
    public static final FontAwesome FONT_AWESOME = new FontAwesome(FxUtils.class.getResource("/font/fontawesome-webfont.ttf").toExternalForm());

    /**
     * create glyph from the font.
     *
     * @param glyph          awesome font name
     * @param sizeFactor
     * @param color
     * @param gradientEffect
     * @return
     */
    public static Glyph createGlyph(FontAwesome.Glyph glyph, int sizeFactor, Color color, boolean gradientEffect) {
        Glyph graphic = FONT_AWESOME.create(glyph);
        if (sizeFactor > 0)
            graphic.sizeFactor(sizeFactor);

        if (color != null)
            graphic.color(color);

        if (gradientEffect)
            graphic.useGradientEffect();

        return graphic;
    }

    public static Glyph createGlyph(FontAwesome.Glyph glyph) {
        return createGlyph(glyph, 0, null, false);
    }

    public static Labeled useIcon(Labeled control, Glyph glyph, ContentDisplay display) {
        control.setGraphic(glyph);
        control.setContentDisplay(display);
        return control;
    }

    public static Labeled useIcon(Labeled control, FontAwesome.Glyph glyph, ContentDisplay display){
        return useIcon(control, createGlyph(glyph), display);
    }
}
