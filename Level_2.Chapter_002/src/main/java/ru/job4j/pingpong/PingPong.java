package ru.job4j.pingpong;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Класс PingPong.
 *
 * @author Анастасия Гладун
 * @since 12.07.2018
 */
public class PingPong extends Application {
    /**
     * Название программы.
     */
    private static final String PINGPONG = "Ping-pong";

    /**
     * Реализация абстрактного метода start.
     *
     * @param stage - основа для создания графического интерфейса.
     */
    @Override
    public void start(Stage stage) {
        int limitX = 300;
        int limitY = 300;
        Group group = new Group();
        Rectangle rect = new Rectangle(5, 150, 10, 10);
        group.getChildren().add(rect);
        new Thread(new RectangleMove(rect)).start();
        stage.setScene(new Scene(group, limitX, limitY));
        stage.setTitle(PINGPONG);
        stage.setResizable(false);
        stage.show();
    }
}
