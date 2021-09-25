package prac_03_Ch6;

/* Question : Write a program that shows a small red square and a small blue square.
The user should be able to drag either square with the mouse. (You'll need an instance variable to remember
which square the user is dragging.) The user can drag the square out of the window if she wants,
and it will disappear. To allow the user to get the squares back into the window,
add a KeyPressed event handler that will restore the squares to their original positions when the user
presses the Escape key. The key code for the Escape key is KeyCode.ESCAPE.

Important :  Difference between Canvas and Scene - Note that Canvas doesn't take KeyPressed, in this program KeyPressed
is attached to scene. Even though the canvas accepts the function, but may be scene gets the event first and then
consumes (like there is nothing there, so ignore it) it. (As if there is nothing there to canvas).

Clarification Statement : You don't want the root component seding messages to the children component, it makes no
sense - meaning of the statement?

*/

import javafx.application.Application;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.layout.BorderPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.MouseButton;


public class Ch6p2_SimpleStamperWithDrag extends Application {

    private double redX = 100;
    private double redY = 100;
    private double bluex = 300;
    private double blueY = 100;

    public static void main(String[] args) {
        launch(args);
    }
    private boolean dragging;
//    private double redX, redY;
    private GraphicsContext canvasGraphics;

    public void start(Stage stage) {

        Canvas canvas = new Canvas(500,380);
        canvasGraphics = canvas.getGraphicsContext2D();
        canvasGraphics.setFill(Color.WHITE);
        canvasGraphics.fillRect(0,0,500,380);
        canvasGraphics.setStroke(Color.BLACK); // stroke color never changes
//        canvas.setOnMousePressed( e -> mousePressed(e) );// Commented out after commenting the MousePressed Class
        canvas.setOnMouseDragged( e -> mouseDragged(e) );
//        canvas.setOnKeyPressed(e -> myKeyPressed(e) ); // This line of code is not being recognized; because we added
//        KeyPressed to the wrong place.
        BorderPane root = new BorderPane(canvas);
        root.setStyle("-fx-border-color: black; -fx-border-width: 2px");

        drawMyShape(redX, redY, Color.RED);
        drawMyShape(bluex, blueY,Color.BLUE);

        Scene scene = new Scene(root);
        scene.setOnKeyPressed(e -> myKeyPressed(e) ); // We changed the 'canvas' to 'scene'; as canvas is for drawing.
        stage.setScene(scene);
        stage.setTitle("Mouse Drag Demo");
        stage.setResizable(false);
        stage.show();

    } // end start()

    private void myKeyPressed(KeyEvent evt) {

        KeyCode key = evt.getCode();// keyboard code for the pressed key
        System.out.println("Key Pressed: " + key);// for testing

        if (evt.getCode() == KeyCode.ESCAPE) {
            System.out.println("KeyCode.ESCAPE");
            clearMyShape(redX, redY); // Because we need to clear the original space and then draw the new shape.
            redX = 100;
            redY = 100;
            drawMyShape(redX, redY,Color.RED);
        }
    }


    private void drawMyShape(double x, double y,Color newColor) {
        // Draw a red rectangle centered at (x,y).
//        canvasGraphics.setFill(newColor.RED);   // Red interior.
        canvasGraphics.setFill(newColor); // I made a mistake here, output won't show blue rectangle if (newColor.RED)
        canvasGraphics.fillRect( x - 30, y - 15, 60, 30 );
//        canvasGraphics.strokeRect( x - 30, y - 15, 60, 30 );
    }

    private void clearMyShape(double x, double y) {
        canvasGraphics.setFill(Color.WHITE);
//        canvasGraphics.fillRect( x - 30, y - 15, 60, 30 );
        canvasGraphics.fillRect( x - 31, y - 16, 62, 32 ); // Increased the values by 1 and 2 compared to the above
//        line; as the stroke has another parameter; the width of the parameter and obviously set to 2. when we increase
//        the value we don't get the stroke traceback.
//        canvasGraphics.strokeRect( x - 30, y - 15, 60, 30 );
    }


    public void mouseDragged(MouseEvent evt) {
//        if ( dragging == false ) {
//            return; Commenting these 2 lines of the code as its the responsibility of the library to check if the
//        mouse has been dragged on not; no need to keep a track of it.
//        }

        double x = evt.getX();  // x-coordinate where user clicked.
        double y = evt.getY();  // y-coordinate where user clicked.

//        Copied the same text from below; logic here, if the user click any place more than >5 pixcels, we ignore it;
//        or x && Y > 5; then we ignore it too, changed the code accordingly. In simple terms; we only need to anything
//        if the user clicked at the right place - Its important Logic.***

        if ( Math.abs(x - redX) > 20 || Math.abs(y - redY) > 20 ) { //5 value was way to small that'w why changed to 20
            return; // even the logic is correct; if we don't disable the mouse pressed; it won't work.
        }

//        if ( Math.abs(x - redX) < 5 && Math.abs(y - redY) < 5 ) {
//            // The mouse has not moved at least 5 pixels horizontally
//            // or vertically, so don't draw another shape yet.
//            return;
//        }

        clearMyShape(redX, redY);

        redX = x;  // Save coords where the next shape is being drawn.
        redY = y;

        if (evt.isShiftDown() ) {
            // User was holding down the shift key. Draw a blue oval centered
            // at the point (x,y). (A black outline around the oval will make it
            // more distinct when shapes overlap.)
            canvasGraphics.setFill(Color.BLUE);  // Blue interior.
            canvasGraphics.fillOval( x - 30, y - 15, 60, 30 );
            canvasGraphics.strokeOval( x - 30, y - 15, 60, 30 );
        }
        else {
            // Draw a red rectangle centered at (x,y).
            canvasGraphics.setFill(Color.RED);   // Red interior.
            canvasGraphics.fillRect( x - 30, y - 15, 60, 30 );
            canvasGraphics.strokeRect( x - 30, y - 15, 60, 30 );
        }

    }


}

