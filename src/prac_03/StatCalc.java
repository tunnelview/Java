package prac_03;

/**
 * An object of class StatCalc can be used to compute several simple statistics
 * for a set of numbers.  Numbers are entered into the dataset using
 * the enter(double) method.  Methods are provided to return the following
 * statistics for the set of numbers that have been entered: The number
 * of items, the sum of the items, the average, and the standard deviation
 */

public class StatCalc
{

    private int count = 0;   // Number of numbers that have been entered.
    private double sum;  // The sum of all the items that have been entered.
    private double squareSum;  // The sum of the squares of all the items.
    private double min = Double.MAX_VALUE; // Java run time error on (StatCalc.java:61);
    // if the variable min and max are not initialized. The above line needs to be carefully initialized.
    private double max = -Double.MIN_VALUE; // This is to get the lowest possible number for the
    //maximum double.
    // private double max = Double.NEGATIVE_INFINITY - Given in the Text Book
    // private double min = Double.POSITIVE_INFINITY - Given in the Text Book

    /**
     * Add a number to the dataset.  The statistics will be computed for all
     * the numbers that have been added to the dataset using this method.
     */
    public void enter(double num)
    {
        count++;
        sum += num;
        squareSum += num*num;
        if (num > max)
        {
            max = num;
            // this condition will be true because the lowest possible number (or nay number
            //inputted by the user will be greater than the lowest possible number for a maximum double;
            // that's how we have initialized it.
        }
        if (num < min)
        {
            min = num;
        }
    }


    /**
     * Return the number of items that have been entered into the dataset.
     */
    public int getCount()
    {
        return count;
    }

    /**
     * Return the sum of all the numbers that have been entered.
     */
    public double getSum()
    {
        return sum;
    }

    /**
     * Return the average of all the items that have been entered.
     * The return value is Double.NaN if no numbers have been entered.
     */
    public double getMean()
    {
        return sum / count;
    }

    /**
     * Return the standard deviation of all the items that have been entered.
     * The return value is Double.NaN if no numbers have been entered.
     */
    public double getStandardDeviation()
    {
        double mean = getMean();
        return Math.sqrt( squareSum/count - mean*mean );
    }

    public double getMin()
    {
        //double min = getMin();kept running the program with this line and it gave an error, commented; and it worked.
        return min;
    }

    public double getMax()
    {
        //double max = getMax();kept running the program with this line and it gave an error, commented; and it worked.
        return max;
    }

}