package prac_04_Ch7;

/*Question - In Subsection 7.4.4, it is mentioned that the standard sorting method Arrays.sort() is much faster and efficient
than selection sort. Write a program to test this claim. To be specific, your program should create a large array
filled with random real numbers. It should use both Arrays.sort() and selectionSort() to sort the array, and it
should time how long it takes to perform each sort. Furthermore, it should do the same thing for a large array of
random Strings. To find the times, you can use System.nanoTime()
(see Subsection 2.3.1 and the example TimedComputation.java).
https://math.hws.edu/javanotes/source/chapter2/TimedComputation.java */


public class Ch7p3 {
    public static void mainOLD(String[] args) {
        //int n = 100; // changed this to 100_000 in the next line as was getting a very small value with 100
        int n = 100_000;
        double[] arr = makeDoubles(n);
        long startTime = System.nanoTime();
        //arr = Arrays.sort(arr); This is an error; as it Arrays.sort doesn't return anything. Correct code is line 21
//        Arrays.sort(arr); we graded this out after we are calling the selection sort.
//        selectionSort(arr); // instead of calling our array sort, we are calling our selection sort(arr)
        long endTime = System.nanoTime();
        System.out.println("seconds = " + (endTime-startTime)/1_000_000_000.0);

    }

    public static void main (String[] args) {
        int n = 10_000; // changed this to 10_000 and we get the result as 1/100 th of a second
        String[] arr = makeManyStrings(n);
        long startTime = System.nanoTime();
        //arr = Arrays.sort(arr); This is an error; as it Arrays.sort doesn't return anything. Correct code is line 21
//        Arrays.sort(arr); //we ungraded graded this out after implemnting the String main()
        selectionSort(arr); // we graded graded this out after grading the Arrays.sort(arr)
        /*While running the program towards the end, I un graded the selectionSort(arr) in the OLDmain, as it gave an
        error
        C:\Users\jc653691\Desktop\prac_03\src\Ch7\Ch7p3.java:22:23
        java: incompatible types: double[] cannot be converted to java.lang.String[]
        Then I ungraded the main and graded the OLDmain - out put - seconds = 0.2158143
         */

        long endTime = System.nanoTime();
        System.out.println("seconds = " + (endTime-startTime)/1_000_000_000.0);

        /* After we implmented the selection sort, we run it and see that the time taken is "seconds = 4.091877".
            Basically, that is 200 times slower, on the other hand the time taken on the Arrays.sort(arr) was way too
            less. Implementation  - Line 21 & Line 23.*/

    }

    /* The below code has been changed because we want to do strings,but before we can do the strings, we need
        to make strings. but kept the original code for a later look. */

//    private static double[] makeDoubles(int n) {
//        double[] res = new double[n]; // we want a double[] array result, new double [] of size[n]
//        for (int i = 0; i < res.length; i++) {
//            res[i] = Math.random();
//          //  System.out.println("" + res[i]);
//        }
//        return res;
//    }

    private static String[] makeManyStrings(int n) { // changed the double to String
        String[] res = new String[n]; // we want a double[] array result, new double [] of size[n]
        for (int i = 0; i < res.length; i++) {
            res[i] = makeOneString();
        }
        return res;
    }

    private static String makeOneString(){
        int size = (int) (Math.random() * 100) + 1; // this will be between seize 1 and 100
        StringBuilder maker = new StringBuilder();
        //for (int i = 0; i < size.length; i++) { this line gave me the error, changed it in Line 68.
        for (int i = 0; i < size; i++) {
            int v = (int) (Math.random() * 26); //v is random value, initially 23 letters of alphabet, later changed 26
            char c = (char) ((int)'A' + v ); // we convrted to int, add the random number and converted back to char,
            // that should give us between capital 'A' and capital 'Z' options. then we add that to the maker(line 66).
            maker.append(c);
        }
        String res = maker.toString(); // res means result
        // System.out.println(res); diabled printing after checking the output
        return res;
    }

    /* we copied the below code from the selectionSortOLD and changed it to string, and we need to change it to
       comparison, in this code the comparison is happening in line 94 */

    static void selectionSort(String[] A) { // changed the int to double
        // Sort A into increasing order, using selection sort

        for (int lastPlace = A.length - 1; lastPlace > 0; lastPlace--) {
            // Find the largest item among A[0], A[1], ...,
            // A[lastPlace], and move it into position lastPlace
            // by swapping it with the number that is currently
            // in position lastPlace.

            int maxLoc = 0;  // Location of largest item seen so far.

            for (int j = 1; j <= lastPlace; j++) {
                //if (A[j] > A[maxLoc]) { original code
                if (A[j].compareTo(A[maxLoc]) > 0) {

                    // Since A[j] is bigger than the maximum we've seen
                    // so far, j is the new location of the maximum value
                    // we've seen so far.
                    maxLoc = j;
                }
            }

            String temp = A[maxLoc];  // Swap largest item with A[lastPlace]. // // changed the int to double
            A[maxLoc] = A[lastPlace];
            A[lastPlace] = temp;

        }  // end of for loop
    }

    private static double[] makeDoubles(int n)
        {
        double[] res = new double[n]; // we want a double[] array result, new double [] of size[n]
        for (int i = 0; i < res.length; i++)
        {
            res[i] = Math.random();
            //  System.out.println("" + res[i]);
        }
        return res;
    }

// the below code is copied from Chapter 7.4.4
//https://math.hws.edu/javanotes/c7/s4.html

    static void selectionSortOLD(double[] A) { // changed the int to double
        // Sort A into increasing order, using selection sort

        for (int lastPlace = A.length-1; lastPlace > 0; lastPlace--) {
            // Find the largest item among A[0], A[1], ...,
            // A[lastPlace], and move it into position lastPlace
            // by swapping it with the number that is currently
            // in position lastPlace.

            int maxLoc = 0;  // Location of largest item seen so far.

            for (int j = 1; j <= lastPlace; j++) {
                if (A[j] > A[maxLoc]) {
                    // Since A[j] is bigger than the maximum we've seen
                    // so far, j is the new location of the maximum value
                    // we've seen so far.
                    maxLoc = j;
                }
            }

            double temp = A[maxLoc];  // Swap largest item with A[lastPlace]. // // changed the int to double
            A[maxLoc] = A[lastPlace];
            A[lastPlace] = temp;

        }  // end of for loop

    }
}
