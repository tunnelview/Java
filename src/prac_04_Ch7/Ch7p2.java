package prac_04_Ch7;

/* Question - Suppose that M is a two-dimensional array that has R rows and C columns. The transpose of M is defined to be an array
T that has C rows and R columns such that T[i][j] = M[j][i] for each i and j. Write a function that takes an array
of type int[][] as a parameter, and returns the transpose of that array. (Assume that the parameter is a typical
2D array in which all the rows have the same length.) Also write a subroutine to print a 2D array of integers in
neat rows and columns, and include a main() routine to test your work.
 */

public class Ch7p2 {
    public static void main(String[] args) {
        //int[][] test1 = {{1}, {2}}; for the test purpose we took 2 rows and 1 column
        int[][] test1 = {{1, 2}, {3, 4}, {5, 6}};
        myPrint(test1);// called function myPrint to test if it works
        test1 = flipRowsToCols(test1);
        myPrint(test1);
    }
    public  static int[][] flipRowsToCols(int[][] arr){
        int nRows = arr.length; // we need to convert the rows to columns, first dimension is the row.
        int nCols = arr[0].length; // this is to take the first row and see how long it is; that's number of columns
        int [][] res = new int[nCols][nRows];
        for (int r = 0; r < nRows; r++) { // r is used for rows
            for (int c = 0; c < nCols; c++) { // c is used for columns
                int v = arr[r][c]; // v is for value, we take the value from r - rows and c - columns
                res[c][r] = v; // this is the flick as we want transpose values - taking it from [r][c] and putting it
                // in [c][r].


            }
        }
        return res;

    }
    public  static void myPrint(int[][] arr){ // we wrote a function myPrint(int[][] arr) that prints
        int nRows = arr.length;
        int nCols = arr[0].length;
        for (int r = 0; r < nRows; r++) {
            for (int c = 0; c < nCols; c++) {
                int v = arr[r][c];
                System.out.println("\t" + v);// print without end of line
            }
            System.out.println("\n"); // at the end of each row, we print end of line
        }
    }
}
