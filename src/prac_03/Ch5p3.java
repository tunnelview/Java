package prac_03;
/* Question :  This problem uses the PairOfDice class from Exercise 5.1 and the StatCalc class from Exercise 5.2.
The program in Exercise 4.4 performs the experiment of counting how many times a pair of dice is rolled before
a given total comes up. It repeats this experiment 10000 times and then reports the average number of rolls.
It does this whole process for each possible total (2, 3, ..., 12).
Redo that exercise. But instead of just reporting the average number of rolls, you should also report the
standard deviation and the maximum number of rolls. Use a PairOfDice object to represent the dice.
Use a StatCalc object to compute the statistics. (You'll need a new StatCalc object for each possible
total, 2, 3, ..., 12. You can use a new pair of dice if you want, but it's not required.)
 */

// We have copied the 4.4 code from the Text Book Section; and in this qustion the task is to
//-- instead of just reporting the average number of rolls, you should also report the standard deviation
// and the maximum number of rolls. "https://math.hws.edu/javanotes/c4/ex4-ans.html"

public class Ch5p3 {
    /**
     * The number of times that the experiment "roll for a given total"
     * is to be repeated.  The program performs this many experiments, and
     * prints the average of the result, for each possible roll value,
     */
    public static final int NUMBER_OF_EXPERIMENTS = 10000;

    public static void main(String[] args) {
        System.out.println("Total On Dice     Average Number of Rolls");
        System.out.println("-------------     -----------------------");
        for ( int dice = 2;  dice <= 12;  dice++ ) {
            StatCalc calc = getRollStats( dice );
            System.out.printf("%10d %22.4f %22.4f %22.4f\n", //the formatting is missing, (%22."Careful of the sapaces"
                    dice, calc.getMean(), //every %(percentage sign is a placeholder for the number we want to print)
                    calc.getStandardDeviation(),
                    calc.getMax()
            );

        }
    }

    /**
     * Find the average number of times a pair of dice must be rolled to get
     * a given total.  The experiment of rolling for the given total is
     * repeated NUMBER_OF_EXPERIMENTS times and the average number of rolls
     * over all the experiments is computed.
     * Precondition:  The given total must be between 2 and 12, inclusive.
     * @param roll the total that we want to get on the dice
     * @return the average number of rolls that it takes to get the specified
     *    total
     */
    public static StatCalc getRollStats(int roll ) { // Here the return type is changed to StatCalc
        StatCalc calc = new StatCalc(); // Here when we right click and put a debugger we see that the program gives us
        // a different out put beause we messed up the count in StatCalc. java "private int count = Integer.MIN_VALUE;"
        // it should be 0 'zero'. Upon changing it gives the expected result.
        for ( int i = 0;  i < NUMBER_OF_EXPERIMENTS;  i++ ) {
            int rollCountThisExperiment = rollFor( roll );
            calc.enter(rollCountThisExperiment);
        }
//        return calc.getMean(); But this is not asked in the question.
        return calc; // this is asked in the question.
    }

    /**
     * Simulates rolling a pair of dice until a given total comes up.
     * Precondition:  The desired total is between 2 and 12, inclusive.
     * @param N the total that we want to get on the dice
     * @return the number of times the dice are rolled before the
     *    desired total occurs
     * @throws IllegalArgumentException if the parameter, N, is not a number
     *    that could possibly come up on a pair of dice
     */
    public static int rollFor( int N ) {
        if ( N < 2 || N > 12 )
            throw new IllegalArgumentException("Impossible total for a pair of dice.");
        int die1, die2;  // Numbers between 1 and 6 representing the dice.
        int roll;        // Total showing on dice.
        int rollCt;      // Number of rolls made.
        rollCt = 0;
        do {
            die1 = (int)(Math.random()*6) + 1;
            die2 = (int)(Math.random()*6) + 1;
            roll = die1 + die2;
            rollCt++;
        } while ( roll != N );
        return rollCt;
    }

}
