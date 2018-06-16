/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawcircles;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import java.util.Random;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Joseph
 */
public class DrawCircles extends Application {
    
        private Canvas canvas = new Canvas(400, 400);

    /** 
     * Setting up the scene with a mouse event and the canvas
     * @param primaryStage 
     */
    @Override
    public void start(Stage primaryStage) {
     
        VBox root = new VBox();
        root.getChildren().add(canvas);
       
        Scene scene = new Scene(root);
        canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                drawCircles();
            }
        });
        
        
        primaryStage.setTitle("Draw Circles");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void drawCircles() {
          // radius of the circles
        final int RADIUS = 20;
        Random rand = new Random();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        for (int i =0; i <50; i++) {
            int x = rand.nextInt(400);
            int y = rand.nextInt(400);
            gc.fillOval(x,  y, RADIUS, RADIUS);
            gc.setFill(Color.rgb(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));

        }
    }



    
/**
 * @param args 
 */    
public static void main(String[] args) {
        launch(args);
    }

}

