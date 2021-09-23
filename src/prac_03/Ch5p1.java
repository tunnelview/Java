package prac_03;

/* Question : In all versions of the PairOfDice class in Section 5.2,
the instance variables die1 and die2 are declared to be public.
They really should be private, so that they would be protected from being changed from outside the class.
Write another version of the PairOfDice class in which the instance variables die1 and die2 are private.
Your class will need "getter" methods that can be used to find out the values of die1 and die2.
(The idea is to protect their values from being changed from outside the class,
but still to allow the values to be read.) Include other improvements in the class,
including at least a toString() method.
Test your class with a short program that counts how many times a pair of dice is rolled,
before the total of the two dice is equal to two.*/


public class Ch5p1 {
    public static void main(String[] args) {
        System.out.println("Hello");
        PairOfDice pg = new PairOfDice();
        // Note that roll(); is the function,if we run it without calling the function then the program
        //gives the output as Hello but no pair of dice will be printed. In the next line we are calling
        // the function, the output will show the "die 1 = (any die1 number from 1 to 6)"
        pg.roll();

// Now when we try to run the program; it gives an error; "java: die1 has private access in
// prac_03.PairOfDice"; because we changed the variable to private; but we are accessing it directly.
// that's why pg gets highlighted in IntelliJ.

        //System.out.println("d1 = " + pg.die1);// Not one of the best practices, but just good to keep it.
        //System.out.println("d1 = " + pg.die2);// Not one of the best practices, but just good to keep it.

        System.out.println("d1 = " + pg.getDie1());
        System.out.println("d2 = " + pg.getDie2());
        System.out.println("" + pg);// This is the second part of the question.
        System.out.println("" + pg.toString());

        int sum = 0;
        int count = 0;
        while (sum != 2) { // An if condition below is mentioned with While loop; question is do we really
            // need an if statement, this loop can be refactored without the if statement. its good enough
            // for this instance.
            pg.roll();
            //sum = pg.getSum; // Notice that the brackets() are missing. When I ran the program; it gave me
            // an error stating " java: cannot find symbol
            //  symbol:   variable getSum
            //  location: variable pg of type prac_03.PairOfDice"
            sum = pg.getSum();
            System.out.println("" + pg);
            if (sum != 2) {
                count++;
            }
        }
        System.out.println("count =" + count);// Note that count =0; is not initialized; if we run this
        // we will again get an error "java: cannot find symbol
        //  symbol:   variable count
        //  location: class prac_03.Ch5p1"; Once we initialize, the error is gone.

    }
}
