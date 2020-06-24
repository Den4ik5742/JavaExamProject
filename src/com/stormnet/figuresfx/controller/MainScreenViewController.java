package com.stormnet.figuresfx.controller;

import com.stormnet.figuresfx.drawutils.Drawer;
import com.stormnet.figuresfx.figures.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import com.stormnet.figuresfx.exceptions.*;
import org.apache.log4j.Logger;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class MainScreenViewController implements Initializable {
    private static final Logger logger = Logger.getLogger(MainScreenViewController.class);
    private List<Figure> figures;
    private Random random;

    @FXML
    private Canvas canvas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logger.info("App is initialized!");
        figures = new ArrayList<>();
        random = new Random(System.currentTimeMillis());
    }

    private void addFigure(Figure figure) {
        figures.add(figure);
    }

    private Figure createFigure(double x, double y) throws figureTypeException {
        Figure figure = null;
        int figureType = random.nextInt(4);
        if (figureType >= 0 && figureType < 4) {
            switch (figureType) {
                case Figure.FIGURE_TYPE_CIRCLE:
                    figure = new Circle(x, y, random.nextInt(3), Color.GREEN, random.nextInt(50));
                    logger.info("Круг нарисован!");
                    break;
                case Figure.FIGURE_TYPE_RECTANGLE:
                    figure = new Rectangle(x, y, random.nextInt(3), Color.RED, random.nextInt(10), random.nextInt(30));
                    logger.info("Прямоугольник нарисован!");
                    break;
                case Figure.FIGURE_TYPE_TRIANGLE:
                    figure = new Triangle(x, y, random.nextInt(3), Color.BLUE, random.nextInt(30));
                    logger.info("Треугольник нарисован!");
                    break;
                case Figure.FIGURE_TYPE_OVAL:
                    figure = new Oval(x, y, random.nextInt(3), Color.BLACK, random.nextInt(30));
                    logger.info("Овал нарисован!");
                    break;
                default:
                    logger.warn("Unknown figure type!");
            }
        } else {
            throw new figureTypeException("Неивестный тип фигуры");
        }

        return figure;
    }

    private void repaint() {
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        Drawer<Figure> drawer = new Drawer<>(figures);
        drawer.draw(canvas.getGraphicsContext2D());
    }

    @FXML
    private void onMouseClicked(MouseEvent mouseEvent) {
        try {
            addFigure(createFigure(mouseEvent.getX(), mouseEvent.getY()));
        } catch (figureTypeException e) {
            e.printStackTrace();
        }
        repaint();
    }
}
