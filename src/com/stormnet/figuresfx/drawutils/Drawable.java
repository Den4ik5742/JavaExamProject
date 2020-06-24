package com.stormnet.figuresfx.drawutils;

import com.stormnet.figuresfx.exceptions.figureSizeExсeption;
import javafx.scene.canvas.GraphicsContext;

public interface Drawable {
    void draw(GraphicsContext gc) throws figureSizeExсeption;
}
