package prac_03_Ch6;

/* Question : In Subsection 6.3.2, the following code was given as an example. It installs a MousePressed
event handler on a canvas. The handler lets the user draw a red rectangle at the point where
the user clicks the mouse, or, by holding the shift key down, a blue oval:

canvas.setOnMousePressed( evt -> {
GraphicsContext g = canvas.getGraphicsContext2D();
if ( evt.isShiftDown() ) {
    g.setFill( Color.BLUE );
    g.fillOval( evt.getX() - 30, evt.getY() - 15, 60, 30 )
    }
    else {
    g.setFill( Color.RED );
    g.fillRect( evt.getX() - 30, evt.getY() - 15, 60, 30 );
    }
} );
Write a complete program that does the same, but in addition, the program will continue to draw figures
if the user drags the mouse. That is, the mouse will leave a trail of figures as the user drags.
However, if the user right-clicks the canvas, then the canvas should simply be cleared and no figures
should be drawn even if the user drags the mouse after right-clicking. See the discussion of dragging
in Subsection 6.3.3. Here is a picture of the solution:
https://math.hws.edu/javanotes/c6/simple-stamper-with-drag.png

*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


/* Steps we have done in this program
1. Created a variable - okToDraw
2. Created a function - clearMyScreen()
3. Checked for the secondary button - if (evt.isSecondaryButtonDown())
4. Created Borders for Rectangles - g.strokeRect(evt.getX() - 30, evt.getY() - 15, 60, 30)
5. Created Borders for Oval - g.strokeOval(evt.getX() - 30, evt.getY() - 15, 60, 30)
 */

/**
 * This program displays information about mouse events on a canvas, including the
 * type of event, the position of the mouse, a list of modifier keys that were down
 * when the event occurred, and an indication of which mouse button was pressed
 * or released, if any.  It also shows information about mouse events seen
 * by an event filter on the screen object; the screen gets to see most events before
 * they are seen by the event target.
 */
public class Ch6p1_SimpleTrackMouse extends Application {

    private boolean okToDraw = true; // initialized to true; however this is a "class field and is generated by options
// showed as by bulb highlighter
    private double upLeftX = 0;
    private double upLeftY = 0;

    public static void main(String[] args) {
        launch(args);
    }


    private Canvas canvas;  // The canvas that fills the window.
    // The program reports about mouse events for which the
    // canvas is the target.

    private StringBuilder eventInfo;  // Contains a string with information about the event.
    // This string is drawn on the canvas.


    /**
     * Set up a window containing just a canvas.  Install handlers for common
     * mouse events on the canvas.  Also install an event filter for mouse
     * events on the screen.  Information about mouse events will be displayed
     * on the canvas.
     */
    public void start(Stage stage) {

        eventInfo = new StringBuilder();

        canvas = new Canvas(550,400);
        Pane root = new Pane(canvas);
        Scene scene = new Scene( root );
        stage.setScene(scene);
        stage.setTitle("Mouse Event Info");
        stage.setResizable(false);

        /* Draw an initial message on the canvas */

        GraphicsContext g = canvas.getGraphicsContext2D();
        clearMyScreen();
//        g.setFont( Font.font(18) ); Commenting out these four lines as we created a funtion and calling that.
//        g.setFill(Color.WHITE);
//        g.fillRect(0,0,550,400);
//        g.setFill(Color.BLACK);
        g.fillText("WAITING FOR FIRST MOUSE EVENT", 50, 50);

        /* Install an event filter for all mouse events on the scene.  The
         * filter just calls mouseEventOnScene(e) when an event occurs. */

//        scene.addEventFilter(MouseEvent.ANY, e -> mouseEventOnScene(e) );

        /* Install event handlers for common mouse events on the canvas.
         * I could have used a single event handler on the canvas, but this
         * shows how to handle the individual types of event.  The response
         * in each case is simply to call mouseEventOnCanvas() */

        canvas.setOnMousePressed( evt -> {
//            GraphicsContext g = canvas.getGraphicsContext2D();
            if ( evt.isShiftDown() ) {
                g.setFill( Color.BLUE );
                g.fillOval( evt.getX() - 30, evt.getY() - 15, 60, 30 ); // There was a small bug, semi-colon
            }
            else {
                g.setFill( Color.RED );
                g.fillRect( evt.getX() - 30, evt.getY() - 15, 60, 30 );
            }
        } );

//The below section is where the events are happening.

//        canvas.setOnMousePressed( e -> mouseEventOnCanvas(e, "Mouse Pressed") ); // commented out the whole section
//        as this wehere the events were happening.
//        canvas.setOnMouseReleased( e -> mouseEventOnCanvas(e, "Mouse Released") );
//        canvas.setOnMouseClicked( e -> mouseEventOnCanvas(e, "Mouse Clicked") );
       canvas.setOnMouseDragged( e -> mouseEventOnCanvas(e, "Mouse Dragged") ); // We had initally commented out this
//        but in the question, on mouse pressed,it should continue to draw.
        canvas.setOnMousePressed( e -> mouseEventOnCanvas(e, "Mouse Pressed") ); // So is the case with Pressed.
//        canvas.setOnMouseMoved( e -> mouseEventOnCanvas(e, "Mouse Moved") );
//        canvas.setOnMouseEntered( e -> mouseEventOnCanvas(e, "Mouse Entered") );
//        canvas.setOnMouseExited( e -> mouseEventOnCanvas(e, "Mouse Exited") );

        stage.show();  // make the window visible

    } // end start()

    private void clearMyScreen() { // this function is to clear the screen
        GraphicsContext g = canvas.getGraphicsContext2D();
        g.setFont( Font.font(18) );
        g.setFill(Color.WHITE);
        g.fillRect(0,0,550,400);
        g.setFill(Color.BLACK);
    }




    /**
     * The draw() method is called from mouseEventOnCanvas() to show the
     * information about the event on the canvas.  It simply draws the
     * eventInfo string.
     */
    private void draw() {
        GraphicsContext g = canvas.getGraphicsContext2D();
        g.setFill(Color.WHITE);
        g.fillRect( 0, 0, g.getCanvas().getWidth(), g.getCanvas().getHeight() );
        g.setFill(Color.BLACK);
        g.fillText( eventInfo.toString(), 40, 40 );
    }


    /**
     * This is called by the event filter for mouse events that was installed
     * on the screen.  It adds a note about the event to the eventInfo string
     * but does not redraw the canvas.  The note will be part of the event
     * info shown in the canvas after the next call to mouseEventOnCanvas().
     */
    private void mouseEventOnScene(MouseEvent evt) {
        if (evt.getTarget() == canvas) {
            eventInfo.append("MOUSE EVENT ON SCENE: " + evt.getEventType() + "\n\n");
        }
    }


    /**
     * Adds information about a mouse event on the canvas to the eventInfo string,
     * and displays that string on the canvas.  The eventInfo string is then cleared,
     * except in the case of a Mouse Entered event (otherwise, the Mouse Entered
     * event would always be immediately replaced by a Mouse Moved event before
     * the user could have any chance of seeing it).
     */
    private void mouseEventOnCanvas(MouseEvent evt, String eventType) {
        if (!okToDraw){
            System.out.println("Not ok to draw");
            return;
        }
        if (evt.isSecondaryButtonDown()) {
            okToDraw = false;
            // todo clear screen
            clearMyScreen();
            System.out.println("You right clicked, You will not be able to draw anymore");
            return;
        }
        GraphicsContext g = canvas.getGraphicsContext2D();
        if ( evt.isShiftDown() ) {
            g.setFill( Color.BLUE );
            g.fillOval( evt.getX() - 30, evt.getY() - 15, 60, 30 ); // There was a small bug, semi-colon
            g.strokeOval(evt.getX() - 30, evt.getY() - 15, 60, 30); // strokeOval to get the black borders
        }
        else {
            g.setFill( Color.RED );


            double currLeftX = evt.getX() - 30;
            double currLeftY = evt.getY() - 15;
            if (Math.abs(currLeftX - upLeftX) < 5 &&  Math.abs(currLeftY - upLeftY) < 5) { // If the current is within
                // 5 pixcels of the original position then we leave it as it is.
                return;
            }

            upLeftX = currLeftX; // Names can be changed as Old and New - for better naming conventions.
            upLeftY = currLeftY;

//            g.fillRect( evt.getX() - 30, evt.getY() - 15, 60, 30 ); // Keeping the original code
            g.fillRect( upLeftX, upLeftY, 60, 30 );
//            g.setStroke();
            g.strokeRect(upLeftX, upLeftY, 60, 30); // Not sure why the border name is strokeRectangle
        }


//        eventInfo.append(eventType + " on canvas at (");
//        eventInfo.append( (int)evt.getX() + "," + (int)evt.getY() + ")\n");
//        if (eventType.equals("Mouse Pressed") || eventType.equals("Mouse Released")
//                || eventType.equals("Mouse Clicked")) {
//            eventInfo.append( "Mouse button pressed or released: " + evt.getButton() + "\n");
//        }
//        if (eventType.equals("Mouse Clicked")) {
//            eventInfo.append( "Click count: " + evt.getClickCount() + "\n" );
//        }
//        eventInfo.append("Modifier keys held down:  ");
//        if (evt.isShiftDown())
//            eventInfo.append("Shift  ");
//        if (evt.isControlDown())
//            eventInfo.append("Control  ");
//        if (evt.isMetaDown())
//            eventInfo.append("Meta  ");
//        if (evt.isAltDown())
//            eventInfo.append("Alt");
//        eventInfo.append("\n");
//        eventInfo.append("Mouse buttons held down:  ");
//        if (evt.isPrimaryButtonDown())
//            eventInfo.append("Primary  ");
//        if (evt.isMiddleButtonDown())
//            eventInfo.append("Middle  ");
//        if (evt.isSecondaryButtonDown()) // this is the right click button.
//            eventInfo.append("Secondary  ");
//        draw();
//        if ( eventType.equals("Mouse Entered") ) {
//            eventInfo.append("\n\n(Info not erased after Mouse Entered)\n\n\n");
//        }
//        else {
//            eventInfo.setLength(0);
//        }
    }


}