package prac_03;

/* In this question - the the instance variables die 1 and die 2 are declared to be public. We want them
to be private, so that they would be protected from being chnged from outside the class. So we want to
write another version.
 */

public class PairOfDice {

    //public int die1 = 3;   // Number showing on the first die.
    //public int die2 = 4;   // Number showing on the second die.

    private int die1; //changed the die1 variable to private
    private int die2; //changed the die1 variable to private
    private int sum; // This should ideally be created by IntelliJ; however in my case it didn't happen
    // as the option for creating property wasn't available and I typed in getSum manually.

    public void roll() {
        // Roll the dice by setting each of the dice to be
        // a random number between 1 and 6.
        die1 = (int)(Math.random()*6) + 1;
        die2 = (int)(Math.random()*6) + 1;
        sum = die1 = die2;
        System.out.println("die1 = " + die1);
    }

    public int getDie1(){
        return die1;
    }

    public int getDie2() {
        return die2;
    }
    @Override
    public String toString(){
        return "d1:" + die1 + ", d2:" + die2;
    }

    /*The last part of the question- "Test your class with a short program
    that counts how many times a pair of dice is rolled,
    before the total of the two dice is equal to two.*/

    public int getSum() {
        return sum;
    }

    // public void setSum(int sum){ // We don't need the set; therefore we have graded out the setSum;
    //    this.sum = sum;
    //}

}