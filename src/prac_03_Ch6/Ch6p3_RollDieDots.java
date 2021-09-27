package prac_03_Ch6;

/* Question : Write a program that shows a pair of dice. The dice are drawn on a Canvas.
You can assume that the size of the canvas is 100 by 100 pixels. When the user clicks on the canvas,
the dice should be rolled (that is, the dice should be assigned newly computed random values).
Each die should be drawn as a square showing from 1 to 6 dots. Since you have to draw two dice,
its a good idea to write a subroutine, such as "void drawDie(GraphicsContext g, int val, int x, int y)",
to draw a die at the specified (x,y) coordinates. The second parameter,
val, specifies the number of dots that are showing on the die. Here is a picture of a canvas displaying two the dice:

Image link- https://math.hws.edu/javanotes/c6/roll-dice-gui.png

Note: We copied the solution from Ex. 6.2 and we need to disable the dragging. We need the click enabled, and everytime
we click, we need to be able to redraw but without the moving.
 */

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;

public class Ch6p3_RollDieDots extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    //---------------------------------------------------------------------

    private int dice1 = 3; // Notice that the value of this changes, initially we tested with 1, 2 and 3.
    private int dice2 = 1; // Value changes, we tested with 1, 2  and 3.
//    private double SIZE = 30; // initially it was 30 and then changed the size to 100.
    private double SIZE = 100;
    private double DOT_SIZE = SIZE/5;
    private double DOT_SHIFT = DOT_SIZE/2;
//    private double x1 = 10, y1 = 10;   // Coords of top-left corner of the red square.
    private double x1 = SIZE/2, y1 = SIZE/2; // we changed it in this line to see it clear.
//    private double x2 = 50, y2 = 10;   // Coords of top-left corner of the blue square.
    private double x2 = SIZE*2, y2 = SIZE*2; // this one the question is asking for the dots to be displayed diagnally.

    private Canvas canvas;  // The canvas where the sqaures are drawn.
    public void start(Stage stage) {

        canvas = new Canvas(SIZE*4,SIZE*4); // Changed it from 300 and 250 to SIZE*4
        draw(); // show squares in original positions

        canvas.setOnMousePressed( e -> mousePressed(e) );
//        canvas.setOnMouseDragged( e -> mouseDragged(e) ); // we don't need the dragged so disabled it
//        canvas.setOnMouseReleased( e -> mouseReleased(e) ); // we don't need the mouse released, so disabled it

        Pane root = new Pane(canvas);
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Drag the squares!");
        stage.setResizable(false);
        stage.show();
    }


    /**
     * Draw the canvas, showing the squares in their current positions. We now need a function that draws the black dots
     * we need in our solution.
     */
    private void draw() { // this is the starting point of the solution, since the magic is happening in draw().
        GraphicsContext g = canvas.getGraphicsContext2D();
        g.setFill(Color.rgb(230,255,230)); // light green
        g.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
//        g.setFill(Color.RED);
        g.setFill(Color.WHITE); // changed this to WHITE FROM ORIGINAL CODE RED

        g.fillRect(x1, y1, SIZE, SIZE); // When we draw anything.Notice that the size is by default 30, it's hard coded.
//        To overcome this problem, we will make it to into variables - a constant.
        drawDie(g, dice1, x1, y1);
//        g.setFill(Color.BLUE);
        g.setFill(Color.WHITE); // changed this to WHITE FROM ORIGINAL CODE BLUE
        g.fillRect(x2, y2, SIZE, SIZE);
        drawDie(g, dice2, x2, y2);
    }

    void drawDie(GraphicsContext g, int val, double x, double y) {
        System.out.println("Val = " + val);
        if (val < 1 || val > 6) {
            return;
        }
        g.setFill(Color.BLACK);
        x -= DOT_SHIFT;
        y -= DOT_SHIFT; // we wrote these two since whereever we have x and y, its DOT_SHIFT. This is make all our
//        shades "center".
        // Now we need to draw - this is a perfect example of switch.
        switch (val){
            case 1:
//                g.fillOval(x2 +10, y2+10, 3, 3); Since we have declared a Variable SIZE on top, we don't have to do
//                the guess work, therefore we will rewrite the statement as
//                g.fillOval(x2 +SIZE/2, y2+SIZE/2, SIZE/5, SIZE/5); // This mistake here is the cut and paste, it
//                shouldn't be x2 ad y2. It should be x and y.
//                g.fillOval(x +SIZE/2, y+SIZE/2, SIZE/5, SIZE/5); We will changed this code after we have declared
//                DOT_SIZE AND DOT_SHIFT on top.
                g.fillOval(x +SIZE/2-DOT_SHIFT, y+SIZE/2-DOT_SHIFT, DOT_SIZE, DOT_SIZE);
//Note: Everywhere we have an x, its a DOT_SHIFT, everywhere we have a Y, its a DOT_SHIFT. Therefore we will just shift
//                the x and y and implementation of the solution is more refined.  Therefore we will rewrite the above
                g.fillOval(x +SIZE/2, y+SIZE/2, DOT_SIZE, DOT_SIZE);

                return;
            case 2:
//                g.fillOval(x +SIZE/3, y+SIZE/3, SIZE/5, SIZE/5); // 2 is diagnal
//                g.fillOval(x + 2*SIZE/3, y+ 2*SIZE/3, SIZE/5, SIZE/5); // 3 is also diagonal

                g.fillOval(x +SIZE/3, y+SIZE/3, DOT_SIZE, DOT_SIZE); // We changed this to DOT_SIZE just like case 1.
                g.fillOval(x + 2*SIZE/3, y+ 2*SIZE/3, DOT_SIZE, DOT_SIZE); // 3 is also diagonal
                return;
            case 3:
//                g.fillOval(x +SIZE/4, y+SIZE/4, SIZE/5, SIZE/5);
//                g.fillOval(x + 2*SIZE/4, y+ 2*SIZE/4, SIZE/5, SIZE/5);
//                g.fillOval(x + 3*SIZE/4, y+ 3*SIZE/4, SIZE/5, SIZE/5);

                g.fillOval(x +SIZE/4, y+SIZE/4, DOT_SIZE, DOT_SIZE); //We changed this to DOT_SIZE just like case 1& 2.
                g.fillOval(x + 2*SIZE/4, y+ 2*SIZE/4, DOT_SIZE, DOT_SIZE);
                g.fillOval(x + 3*SIZE/4, y+ 3*SIZE/4, DOT_SIZE, DOT_SIZE);
                return;
            case 4: // 4 is like 2 so we copied from 2 and added the last 2 lines, since we needed 4 dots. On run we
//                keep clicking till we get 4 dots on either of the dice.
                g.fillOval(x +SIZE/3, y+SIZE/3, DOT_SIZE, DOT_SIZE);
                g.fillOval(x + 2*SIZE/3, y+ 2*SIZE/3, DOT_SIZE, DOT_SIZE);
                g.fillOval(x + 1*SIZE/3, y+ 2*SIZE/3, DOT_SIZE, DOT_SIZE);
                g.fillOval(x + 2*SIZE/3, y+ 1*SIZE/3, DOT_SIZE, DOT_SIZE);
            case 5:
                g.fillOval(x +SIZE/4, y+SIZE/4, DOT_SIZE, DOT_SIZE);
                g.fillOval(x + 2*SIZE/4, y+ 2*SIZE/4, DOT_SIZE, DOT_SIZE);
                g.fillOval(x + 3*SIZE/4, y+ 3*SIZE/4, DOT_SIZE, DOT_SIZE);
                g.fillOval(x + 3*SIZE/4, y+SIZE/4, DOT_SIZE, DOT_SIZE);
                g.fillOval(x + SIZE/4, y+ 3*SIZE/4, DOT_SIZE, DOT_SIZE);
                return;
            case 6: // x is fixed and y is changing.
                g.fillOval(x +SIZE/4, y+SIZE/4, DOT_SIZE, DOT_SIZE);
                g.fillOval(x +SIZE/4, y+ 2*SIZE/4, DOT_SIZE, DOT_SIZE);
                g.fillOval(x +SIZE/4, y+ 3*SIZE/4, DOT_SIZE, DOT_SIZE);
                g.fillOval(x +3*SIZE/4, y+SIZE/4, DOT_SIZE, DOT_SIZE);
                g.fillOval(x +3*SIZE/4, y+ 2*SIZE/4, DOT_SIZE, DOT_SIZE);
                g.fillOval(x +3*SIZE/4, y+ 3*SIZE/4, DOT_SIZE, DOT_SIZE);
                return;

        }


    }


    //-----------------  Variables and methods for responding to drags -----------

    private boolean dragging;      // Set to true when a drag is in progress.

    private boolean dragRedSquare; // True if red square is being dragged, false
    //    if blue square is being dragged.

    private double offsetX, offsetY;  // Offset of mouse-click coordinates from the
    //   top-left corner of the square that was
    //   clicked.


    public void mousePressed(MouseEvent evt) { // We don't need the code for the mouse pressed, we that is not asked in
//        the question, instead of the mousePressed, we will just do the roll. We graded out the previous code for
//        mousePressed.

        System.out.println("rolling");
        dice1 = (int) (Math.random()*6) + 1; // Note that the random is between 0 and 1; 1 excluded. Threfore, if we
//        multiply it by 6, we will get between 0 and 5.
        dice2 = (int) (Math.random()*6) + 1; // Here we want to attain the changing of the dice and then redraw
//        on our click.
        draw(); // its working fine, since the random limit is between 1 and 3, everytime we click the value might not
//        change. On run, we see its working just fine. Last step in our solution is to draw the borders and fix the
//        position. So we first try to fix the positioning, in order to do that we have changed the sizes to see
//        clearly where to place it.


    }

}
