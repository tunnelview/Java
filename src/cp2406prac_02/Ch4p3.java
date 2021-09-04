package cp2406prac_02;

/*Write a function that simulates rolling a pair of dice until the total on the dice comes up to be a given number.
The number that you are rolling for is a parameter to the function.
The number of times you have to roll the dice is the return value of the function.
The parameter should be one of the possible totals: 2, 3, ..., 12.
The function should throw an IllegalArgumentException if this is not the case.
Use your function in a program that computes and prints the number of rolls it takes to get snake eyes.
(Snake eyes means that the total showing on the dice is 2.)

Here is the key points are - The number that you are rolling for is a parameter to the function.
The number of times you have to roll the dice is the return value of the function.
 */

public class Ch4p3 {
    public static void main(String[] args) {
        for (int i = 2; i <= 13; i++) {
            getNumOfRolls(i);

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
        while ( die1 + die2 != needTotal); // This code is changed as we want to keep rolling untill we get what we want!
        System.out.println("It took " + countRolls + " rolls to get needed total=" + needTotal);
        return countRolls;

    }  // end main()

}  // end class
