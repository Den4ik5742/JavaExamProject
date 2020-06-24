package com.stormnet.figuresfx.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import com.stormnet.figuresfx.exceptions.*;

public class Circle extends Figure {
    private double radius;

    private Circle(double cx, double cy, double lineWidth, Color color) {
        super(FIGURE_TYPE_CIRCLE, cx, cy, lineWidth, color);
    }

    public Circle(double cx, double cy, double lineWidth, Color color, double radius) {
        this(cx, cy, lineWidth, color);
        this.radius = radius < 10 ? 10 : radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw(GraphicsContext gc) throws figureSizeExсeption {
        gc.setLineWidth(lineWidth);
        gc.setStroke(color);
        if (radius > 0) {
            gc.strokeOval(cx - radius, cy - radius, radius * 2, radius * 2);
        } else {
            throw new figureSizeExсeption("Радиус не может быть меньше или равен 0");
        }
    }
}
