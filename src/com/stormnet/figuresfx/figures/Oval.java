package com.stormnet.figuresfx.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import com.stormnet.figuresfx.exceptions.*;

import java.util.Objects;

public class Oval extends Figure {
    private double radius;

    public Oval(double cx, double cy, double lineWidth, Color color) {
        super(FIGURE_TYPE_OVAL, cx, cy, lineWidth, color);
    }

    public Oval(double cx, double cy, double lineWidth, Color color, double radius) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Oval oval = (Oval) o;
        return Double.compare(oval.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }

    @Override
    public String toString() {
        return "Oval{" +
                "radius=" + radius +
                ", cx=" + cx +
                ", cy=" + cy +
                ", lineWidth=" + lineWidth +
                ", color=" + color +
                '}';
    }

    @Override
    public void draw(GraphicsContext gc) throws figureSizeExсeption {
        gc.setLineWidth(lineWidth);
        gc.setStroke(color);
        if (radius > 0) {
            gc.strokeOval(cx - radius, cy - radius, radius * 2, radius * 5);
        } else {
            throw new figureSizeExсeption("Радис не может быть меньше или равен 0");
        }
    }
}
