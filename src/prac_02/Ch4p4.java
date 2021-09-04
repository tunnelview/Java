package prac_02;

/* Question - This exercise builds on Exercise 4.3. Every time you roll the dice repeatedly,
trying to get a given total, the number of rolls it takes can be different.
The question naturally arises, what's the average number of rolls to get a given total?
Write a function that performs the experiment of rolling to get a given total 10000 times.
The desired total is a parameter to the subroutine. The average number of rolls is the return value.
Each individual experiment should be done by calling the function you wrote for Exercise 4.3.
Now, write a main program that will call your function once for each of the possible totals (2, 3, ..., 12).
It should make a table of the results, something like:

        Total On Dice     Average Number of Rolls
        -------------     -----------------------
        2               35.8382
        3               18.0607
        .                .
        .                .
*/

public class Ch4p4 {
    public static void main(String[] args) {
        System.out.println("Total On Dice     Average Number of Rolls\n" +
                "        -------------     -----------------------");
        int numExperiments = 109_000; // changed the value to 10000 based on the text book, then finally changed to the
        // number mentioned in the prac.
        for (int total = 2; total <= 13; total++) {
            double currSum = 0; // initializing each total to zero.
            for (int i = 0; i < numExperiments; i++) {
                int currCount = getNumOfRolls(total);
                currSum += currCount;
            }
            double res = currSum/numExperiments;
            System.out.println("\t" + total + "\t\t" + res);

        }
    }
    public static int getNumOfRolls(int needTotal)
            throws IllegalArgumentException {
        if (needTotal < 2 || needTotal > 12){ //As soon the program reaches 13 it will kill itself.
            throw new IllegalArgumentException("ERROR: wrong total" + needTotal);
        }
        int die1, die2;   // The values rolled on the two dice.
        int countRolls;   // Used to count the number of rolls.
        countRolls = 0;
        do {
            die1 = (int)(Math.random()*6) + 1;   // roll the dice
            die2 = (int)(Math.random()*6) + 1;
            countRolls++;                        // and count this roll
        } //while ( die1 != 1 || die2 != 1 ); - Original Code from Chapter 3.1 solution
        while ( die1 + die2 != needTotal); // This code is changed as we want to keep rolling
        // untill we get what we want!
//        System.out.println("It took " + countRolls +
//                " rolls to get needed total=" + needTotal); // commented out this code as it was messing up the
        // formatting.
        return countRolls;

    }  // end main()

    // Finally, we get the symmetrical results. For instance, in order to get a total of 2 is similar to getting
    // a total of 12. similarly, 3 and 11, similarly, 4 and 10 and so on.
}