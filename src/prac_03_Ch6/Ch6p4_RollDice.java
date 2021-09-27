package prac_03_Ch6;

/*In Exercise 6.3,
you wrote a graphical pair-of-dice program where the dice are rolled when the user clicks on the canvas.
Now make a pair-of-dice program where the user rolls the dice by clicking a button. The button should appear under the
canvas that shows the dice. Also make the following change: When the dice are rolled, instead of just showing the
new value, show a short animation during which the values on the dice are changed in every frame. The animation is
supposed to make the dice look more like they are actually rolling.
*/

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ch6p4_RollDice extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    //---------------------------------------------------------------------

    private int die1 = 4;  // The values shown on the dice.
    private int die2 = 3;

    private Canvas canvas;  // The canvas on which the dice are drawn.

    public void start(Stage stage) {

        canvas = new Canvas(100,100);
        draw();  // Draw the original dice.

//        canvas.setOnMousePressed( e -> roll() ); we don't need this in this program.


        Button rollButton =  new Button("Roll me!"); // Button used here is the Java.FX Button
//        rollButton.setOnAction(e -> roll()); We graded this code after we copied the Animation Timer & manyRolls().
        rollButton.setOnAction(e -> manyRolls()); // now we have a chance to connect our animation.


//        Pane root = new Pane(canvas);
        BorderPane root = new BorderPane(canvas); // When you add something to the construct of the border pane, it
        // flaunts it to the center.
        BorderPane centerButton = new BorderPane(rollButton); // Here we added another border pane, placed it in the
//        center and then attach the rollButton to that border pane.

//        root.setBottom(rollButton);
        root.setBottom(centerButton); // now instead of adding that button to the bottom, we add that center Button.

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Dice!");
        stage.setResizable(false);
        stage.show();

    }

    private void drawDie(GraphicsContext g, int val, int x, int y) {
        g.setFill(Color.WHITE);
        g.fillRect(x, y, 35, 35);
        g.setStroke(Color.BLACK);
        g.strokeRect(x+0.5, y+0.5, 34, 34);
        g.setFill(Color.BLACK);
        if (val > 1)  // upper left dot
            g.fillOval(x+3, y+3, 9, 9);
        if (val > 3)  // upper right dot
            g.fillOval(x+23, y+3, 9, 9);
        if (val == 6) // middle left dot
            g.fillOval(x+3, y+13, 9, 9);
        if (val % 2 == 1) // middle dot (for odd-numbered val's)
            g.fillOval(x+13, y+13, 9, 9);
        if (val == 6) // middle right dot
            g.fillOval(x+23, y+13, 9, 9);
        if (val > 3)  // bottom left dot
            g.fillOval(x+3, y+23, 9, 9);
        if (val > 1)  // bottom right dot
            g.fillOval(x+23, y+23, 9,9);
    }


    private void manyRolls() {
        AnimationTimer anim = new AnimationTimer() { // The payload is with the AnimationTimer() and the handle().
            int count = 0;
            public void handle(long now) {
                count++;
                try {
                Thread.sleep(100);
                }// this is to control the blurred run, animator running on a seperate thread, time
                // given to sleepp is 100 milli of a second and then it rolls. Also this line has to be surrounded by
                // try catch. Upon running the blurriness is gone.
                catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (count >30) { // initially the value was 100 and changed to 30 as it was too long.
                    this.stop();
                }
                roll(); // if we click on it, it will call the roll() for ever. (infinite times); this is before the
                // counter.

                // scope of improvement - after setting up the counter, its kind of blurry when it runs.
                // Here the animator has to run in a separate thread. This is to control the blurred run.


            }
        };
        anim.start();
    }



    private void roll() {
        die1 = (int)(Math.random()*6) + 1;
        die2 = (int)(Math.random()*6) + 1;
        draw();
    }

    private void draw() {
        GraphicsContext g = canvas.getGraphicsContext2D();
        g.setFill(Color.rgb(200,200,255));
        g.fillRect(0,0,100,100);
        g.setStroke( Color.BLUE );
        g.setLineWidth(2);
        g.strokeRect(1,1,98,98);
        drawDie(g, die1, 10, 10);
        drawDie(g, die2, 55, 55);
    }

}