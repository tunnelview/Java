package prac_04_Ch7;

/* Question - In Exercise 6.2, you wrote a program DragTwoSquares that allows the user to drag a red square and a blue square
around on a canvas. Write an much improved version where the user can add squares to a canvas and drag them around.
In particular: If the user shift-clicks or right-clicks the canvas, then the user is trying to drag a square; find
the square that contains the mouse position, if any, and move it as the user drags the mouse. Other clicks should
add squares. You can place the center of the new square at the current mouse position. To make the picture more
visually appealing, give each square a random color, and when you draw the squares,
draw a black outline around each square. (My program also gives the square a random alpha value between 0.5 and 1.0).

Write a class to represent the data needed for drawing one square, and use an ArrayList to store the data for all the
squares in the picture. If the user drags a square completely off the canvas, delete it from the list.*/

/*"the whole code is copied from https://math.hws.edu/javanotes/c6/ex2-ans.html - 6.2 solution" */

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

/**
 * A program that shows a red square and a blue square that the user
 * can drag with the mouse.   The user can drag the squares off
 * the canvas and drop them.  Pressing the escape key will restore
 * both squares to their original positions.
 */
public class DragTwoSquares extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    //---------------------------------------------------------------------

    private ArrayList<Double> xArr;
    private ArrayList<Double> yArr;
    private ArrayList<Boolean> xyDrag;
//    private double x1 = 10, y1 = 10;   // Coords of top-left corner of the red square.
//    private double x2 = 50, y2 = 10;   // Coords of top-left corner of the blue square.

    private Canvas canvas;  // The canvas where the sqaures are drawn.

    private void initArrs(){ // created this function
//        x1 = 10;
//        y1 = 10;
//        x2 = 50;
//        y2 = 10;

        xArr = new ArrayList<>();
        xArr.add(10.);
        xArr.add(50.);

        yArr = new ArrayList<>();
        yArr.add(10.);
        yArr.add(10.);

        xyDrag = new ArrayList<>();
        xyDrag.add(false);
        xyDrag.add(false);

    }


    /**
     *  The start method sets up the GUI.  It adds mouse event handlers to
     *  the canvas to implement dragging.  It adds a key pressed handler
     *  to the scene that will restore the squares to their original
     *  positions when the user presses the escape key.
     */
    public void start(Stage stage) {

        canvas = new Canvas(300,250);
        initArrs(); // in the original code the initialization was at the top, after fixing we have to call the
//      initArrs() before we draw it.
        draw(); // show squares in original positions

        canvas.setOnMousePressed( e -> mousePressed(e) );
        canvas.setOnMouseDragged( e -> mouseDragged(e) );
        canvas.setOnMouseReleased( e -> mouseReleased(e) );

        Pane root = new Pane(canvas);

        Scene scene = new Scene(root);

        scene.setOnKeyPressed( e -> {
            // If user pressed ESCAPE, move squares
            // back to starting positions, and redraw.
            if ( e.getCode() == KeyCode.ESCAPE ) {
                initArrs(); // called the function here
//                x1 = 10;
//                y1 = 10;
//                x2 = 50;
//                y2 = 10;
                draw();
            }
        });

        stage.setScene(scene);
        stage.setTitle("Drag the squares!");
        stage.setResizable(false);
        stage.show();
    }


    /**
     * Draw the canvas, showing the squares in their current positions.
     */
    private void draw() {
        GraphicsContext g = canvas.getGraphicsContext2D();
        g.setFill(Color.rgb(230,255,230)); // light green
        g.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
        g.setFill(Color.RED);

        for (int i = 0; i < xArr.size(); i++) { // what is the difference between array.size() and array.length
//            g.fillRect(x1, y1, 30, 30);// much cleaner solution implemented in line 117
            g.fillRect(xArr.get(i), yArr.get(i), 30, 30);

        }


//        g.setFill(Color.BLUE);
//        g.fillRect(x2, y2, 30, 30);
    }


    //-----------------  Variables and methods for responding to drags -----------

    private boolean dragging;      // Set to true when a drag is in progress.

//    private boolean dragRedSquare; // True if red square is being dragged, false
    //    if blue square is being dragged.

    private double offsetX, offsetY;  // Offset of mouse-click coordinates from the
    //   top-left corner of the square that was
    //   clicked.

    /**
     * Respond when the user presses the mouse on the canvas.
     * Check which square the user clicked, if any, and start
     * dragging that square.
     */

    public void addNewSquare(MouseEvent evt){
        double x = evt.getX();  // Location where user clicked.
        double y = evt.getY();
        xArr.add(x - 30/2);
        xArr.add(y - 30/2);
        xyDrag.add(false);
        draw(); // (Calls the draw() to show squares in new positions.)

    }

    public void mousePressed(MouseEvent evt) {
        if (dragging) { // Exit if a drag is already in progress.
            return;
        }

        addNewSquare(evt);
        double x = evt.getX();  // Location where user clicked.
        double y = evt.getY();
        for (int i = 0; i < xArr.size(); i++) {
            double x2 = xArr.get(i);
            double y2 = yArr.get(i);
            xyDrag.set(i, false); // what we want to do here is - we are scanning, assuming false false false, but if we
            // hit the right one, then it true - condition written in line 165.
            if (x >= x2 && x < x2 + 30 && y >= y2 && y < y2 + 30) {
                // It's the blue square (which should be checked first,
                // since it's drawn on top of the red square.)
                dragging = true;
//                dragRedSquare = false;
                xyDrag.set(i, true);
                offsetX = x - x2;  // Distance from corner of square to (x,y).
                offsetY = y - y2;
            }
        }
//
//        else if (x >= x1 && x < x1+30 && y >= y1 && y < y1+30) {
//            // It's the red square.
//            dragging = true;
//            dragRedSquare = true;
//            offsetX = x - x1;  // Distance from corner of square to (x,y).
//            offsetY = y - y1;
//        }

        }

        /**
         * Dragging stops when user releases the mouse button.
         */

        public void mouseReleased (MouseEvent evt){
            dragging = false;
        }

        /**
         * Respond when the user drags the mouse.  If a square is
         * not being dragged, then exit. Otherwise, change the position
         * of the square that is being dragged to match the position
         * of the mouse.  Note that the corner of the square is placed
         * in the same relative position with respect to the mouse that it
         * had when the user started dragging it.
         */

        public void mouseDragged (MouseEvent evt) {
            if (dragging == false)
                return;
            double x = evt.getX();
            double y = evt.getY();

            for (int i = 0; i < xArr.size(); i++) { // commented out the next chunk of code
                if (xyDrag.get(i)) {
//            double x2 = xArr.get(i); Commented out as this line is redundant
//            double y2 = yArr.get(i); Commented out as this line is redundant
                    double x2 = x - offsetX;
                    double y2 = y - offsetY; // we now updated x2 and y2 and now we need to put it back into the array.
                    xArr.set(i, x2); // this code is to set it back into the array.
                    yArr.set(i, y2);
                }

//        if (dragRedSquare) {  // Move the red square.
//            x1 = x - offsetX;
//            y1 = y - offsetY;
//        }
//        else {   // Move the blue square.
//            x2 = x - offsetX;
//            y2 = y - offsetY;
//        }
            }
        draw();  // (Calls the draw() to show squares in new positions.)// commented out as we are redrawing it in
//            Line 157.
        }

} // end class DragTwoSquares














//BOOK Solution- not working either
//
//        import javafx.application.Application;
//        import javafx.stage.Stage;
//        import javafx.scene.Scene;
//        import javafx.scene.canvas.Canvas;
//        import javafx.scene.canvas.GraphicsContext;
//        import javafx.scene.layout.Pane;
//        import javafx.scene.paint.Color;
//        import javafx.scene.input.MouseEvent;
//        import javafx.scene.input.MouseButton;
//
//        import java.util.ArrayList;
//
//
///**
// * A program that lets the user add squares to a canvas by clicking.
// * The center of a square is placed at the point where the user clicked.
// * Squares all have the same size (100-by-100).  They have random
// * colors with up to 50% transparency.  If the user shift-clicks
// * or right-clicks a square, the user can drag the square.  If
// * the user drags a square off the canvas, it is deleted from the
// * list of squares.
// */
//public class DragLotsOfSquares extends Application {
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    //---------------------------------------------------------------------
//
//    /**
//     * An object of type SquareData contains the data necessary to
//     * draw one square, that is, the color of the square and the
//     * coordinates of its center.
//     */
//    private static class SquareData {
//        double x,y;  // Location of center of square.  The size is always 100-by-100.
//        Color color; // The color of the square
//    }
//
//
//    private ArrayList<SquareData> squares;  // Info for all squares in the picture.
//
//    private Canvas canvas;  // The canvas where the sqaures are drawn.
//
//
//    /**
//     *  The start method sets up the GUI.  It adds mouse event handlers to
//     *  the canvas to implement adding and dragging squares.
//     */
//    public void start(Stage stage) {
//
//        squares = new ArrayList<SquareData>();
//
//        canvas = new Canvas(640,480);
//        draw(); // Will just fill canvas with background color.
//
//        canvas.setOnMousePressed( e -> mousePressed(e) );
//        canvas.setOnMouseDragged( e -> mouseDragged(e) );
//        canvas.setOnMouseReleased( e -> mouseReleased(e) );
//
//        Pane root = new Pane(canvas);
//
//        Scene scene = new Scene(root);
//
//        stage.setScene(scene);
//        stage.setTitle("Click to add a square. Right-click to drag.");
//        stage.setResizable(false);
//        stage.show();
//    }
//
//
//    /**
//     * Draw the canvas, showing all squares in their current positions.
//     */
//    private void draw() {
//        GraphicsContext g = canvas.getGraphicsContext2D();
//        g.setFill(Color.rgb(230,255,230)); // light green
//        g.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
//        g.setLineWidth(2);
//        g.setStroke(Color.BLACK);
//        for ( SquareData squareData: squares ) {
//            g.setFill( squareData.color );
//            g.fillRect( squareData.x - 50, squareData.y - 50, 100, 100);
//            g.strokeRect( squareData.x - 50, squareData.y - 50, 100, 100);
//        }
//    }
//
//
//    //-----------------  Variables and methods for responding to drags -----------
//
//    private boolean dragging;      // Set to true when a drag is in progress.
//
//    private SquareData draggedSquare;  // When a drag is in progress, this is
//    // the square that is being dragged.
//
//    private double offsetX, offsetY;  // Offset of mouse-click coordinates from the
//    //   center of the square that is being dragged.
//
//    /**
//     * Respond when the user presses the mouse on the canvas.
//     * A shift-click or right-click starts dragging the square
//     * under the mouse, if any.  Other clicks will add a new
//     * square with its center at the mouse position.  A drag
//     * operation is begun only if the user shift-clicks or
//     * right-clicks a square.
//     */
//    public void mousePressed(MouseEvent evt) {
//
//        if (dragging)  // Exit if a drag is already in progress.
//            return;
//
//        double x = evt.getX();  // Location where user clicked.
//        double y = evt.getY();
//
//        if (evt.isShiftDown() || evt.getButton() == MouseButton.SECONDARY) {
//            // If user shift-clicked a square, start dragging it.
//
//            /* Find the square, if any, that contains (x,y).  If several squares
//             * contain (x,y), we want the one on top, which is the LAST one in
//             * the list that contains (x,y) -- so consider the squares in the
//             * reverse of their order in the list. */
//
//            for (int i = squares.size() - 1; i >= 0; i--) {
//                SquareData squareData = squares.get(i);
//                double cx = squareData.x; // (cx,cy) is the center of the square
//                double cy = squareData.y;
//                if ( x >= cx - 50 && x <= cx + 50 && y >= cy - 50 && y <= cy + 50) {
//                    dragging = true;
//                    draggedSquare = squareData;
//                    offsetX = x - cx;
//                    offsetY = y - cy;
//                    break;  // stop as soon as we find  square containing (x,y)
//                }
//            }
//        }
//        else { // Add a new square with center at (x,y)
//            SquareData squareData = new SquareData();
//            squareData.x = x;
//            squareData.y = y;
//            // Use a random color for the square.  Choose random RGB components
//            // in the range 0.0 to 1.0 and a random alpha in the range 0.5 to 1.0.
//            // This will make a square that can be somewhat transparent but not
//            // too transparent.
//            squareData.color = Color.color(
//                    Math.random(), Math.random(), Math.random(), 0.5 + 0.5*Math.random() );
//            squares.add( squareData );
//            draw();  // Redraw the whole picture to show the new square.
//            //  (Could have just drawn it here instead!)
//        }
//    }
//
//
//    /**
//     * Dragging stops when user releases the mouse button.  If the user
//     * has dragged the square completely off the canvas, then it is deleted
//     * from the list of squares. (That will have no visible effect on the
//     * picture, so the canvas is not redrawn.)
//     */
//    public void mouseReleased(MouseEvent evt) {
//        if ( ! dragging )
//            return;
//
//        /* To test if the square has moved completely off the canvas,
//         * test that its center is at least 50 pixels outside the canvas. */
//
//        if (draggedSquare.x > canvas.getWidth() + 50
//                || draggedSquare.x < -50
//                || draggedSquare.y > canvas.getHeight() + 50
//                || draggedSquare.y < -50) {
//            // Square is completely off the canvas, so remove it!
//            squares.remove(draggedSquare);
//            // For testing, to make sure square is actually deleted:
//            System.out.println("Removed square; list size = " + squares.size());
//        }
//
//        dragging = false;  // drag operation has ended.
//        draggedSquare = null;
//    }
//
//
//    /**
//     * Respond when the user drags the mouse.  If a square is
//     * not being dragged, then exit. Otherwise, change the position
//     * of the square that is being dragged to match the position
//     * of the mouse.  Note that the center of the square is placed
//     * in the same relative position with respect to the mouse that it
//     * had when the user started dragging it.
//     */
//    public void mouseDragged(MouseEvent evt) {
//        if ( ! dragging )
//            return;
//        double x = evt.getX();
//        double y = evt.getY();
//        draggedSquare.x = x - offsetX;
//        draggedSquare.y = y - offsetY;
//        draw();  // Redraw picture to show square in new positions.
//    }
//
//} // end class DragLotsOfSquares