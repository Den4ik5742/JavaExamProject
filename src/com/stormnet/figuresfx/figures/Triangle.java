package com.stormnet.figuresfx.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import com.stormnet.figuresfx.exceptions.*;

import java.util.Objects;

public class Triangle extends Figure {
    private double base;


    private Triangle(double cx, double cy, double lineWidth, Color color) {
        super(FIGURE_TYPE_TRIANGLE, cx, cy, lineWidth, color);
    }

    public Triangle(double cx, double cy, double lineWidth, Color color, double base) {
        this(cx, cy, lineWidth, color);
        this.base = base < 10 ? 10 : base;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.base, base) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(base);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "base=" + base +
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
        if (base > 0) {
            gc.strokePolygon(new double[]{cx, cx + base / 2, cx - base / 2}, new double[]{cy - base / 2, cy + base / 2, cy + base / 2}, 3);
        } else {
            throw new figureSizeExсeption("Сторона не может быть меньше или равна 0");
        }
    }
}
