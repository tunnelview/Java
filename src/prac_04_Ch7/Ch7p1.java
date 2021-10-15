package prac_04_Ch7;

/* Question - Write a subroutine that creates an ArrayList containing several different random
integers in the range from 1 up to some specified maximum. The number of integers and the maximum
allowed value for the integers should be parameters to the subroutine. Write a main() routine to test
your subroutine.
 */

import java.util.ArrayList;
import java.util.Iterator;

public class Ch7p1 {

    public static void main(String[] args) {
        System.out.println("hello");


        int testSize = 100;
        int testMaxVal = 20;
        ArrayList<Integer> arr = makeIntArray(testSize, testMaxVal);
        System.out.println("arr.size()" + arr.size());

        //if (arr.size() == testSize - 1) { // This line of code any error simulation/changes
        if (arr.size() == testSize) {
            System.out.println("testSize PASSED");
        }else {
            System.out.println("testSize ERROR");
            return;
        }

        // Testing Starts **************************************************************
        int myMax = -Integer.MAX_VALUE; // the lowest possible number with the negative
        for (Iterator<Integer> iterator = arr.iterator();// itco tab (itar and itco) iterateArray and iterateContainer
             iterator.hasNext(); ) {
            Integer next =  iterator.next();
            int v = next; // this will automatically unbox
            if(v > myMax){
                myMax = v;
            }
        }
        // if (myMax <= testMaxVal - 1)// When we see the value, we see that the test is passing, that's not correct
        // if (myMax <= testMaxVal - 1) { // after we re-wrote line 53 and 55, we changed the value to retest.
        if (myMax <= testMaxVal) { // test runs both ways.
            System.out.println("testMaxVal PASSED");
        }else {
            System.out.println("testMaxVal ERROR");
            return;
        }
        // Testing Ends *****************************************************************

    }
    public static ArrayList<Integer> makeIntArray(int arrSize, int maxVal) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i <arrSize; i++) {
            //int v = (int)(Math.random()) * maxVal +1;// This line will give us 1 as a bug when we print it.
            int v = (int)(Math.random() * maxVal) +1; // the int of a random is always zero, between zero and one, one
            // is excluded.
            System.out.println("" + v); // when we print, we get to know there is a bug in the program, its always 1.
            // the reason why its 1 is because of line number 52. We need to multiple random first and then take int.
            arr.add(v); // java does the trick, it auto boxing and auto unboxking, it converts int automatically
            // to an object int, if object int type is required

        }
        return arr;
    }
}
