/**
 * 2º DAM DI
 * @author: Shihan Wei
 * Tema 1 Actividad 1
 * 4.3.6. PathTransition in Animation
 * Fecha: 02/10/2024
 */

package es.ieslosmontecillos.pathtransitiondemo;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.animation.*;

import static javafx.util.Duration.millis;


public class PathTransitionDemo extends Application {

    @Override
    public void start(Stage primaryStage) {

        /* creamos el contenedor */
        Pane contenedor = new Pane();

        /* creamo el círculo y establecemos sus propiedades */
        Circle c = new Circle();
        c.setStroke(Paint.valueOf("black"));
        c.setFill(Paint.valueOf("white"));
        c.setRadius(45);
        c.setCenterX(150);
        c.setCenterY(150);

        /* creamo el rectángulo y establecemos sus propiedades */
        Rectangle r = new Rectangle(50, 25);
        r.setFill(Paint.valueOf("orange"));
        r.setX(80);
        r.setY(130);

        /* creamos la animación para las figuras  */
        PathTransition animacion = new PathTransition();
        animacion.setPath(c);
        animacion.setNode(r);
        animacion.setDuration(millis(4000));
        animacion.play();

        /* la animación se pausa cuando pulsamos sobre el círculo */
        c.setOnMousePressed(new EventHandler<>() {
            @Override
            public void handle(MouseEvent e) {
                animacion.pause();
            }
        });

        /* reanuda la animación al soltar el click de ratón */
        c.setOnMouseReleased(e ->{
            animacion.play();
        });

        contenedor.getChildren().addAll(c, r);
        Scene scene = new Scene(contenedor, 300, 300);
        primaryStage.setTitle("PathTransition Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}