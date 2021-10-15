package prac_04_Ch8;

/* Question -  As discussed in Section 8.1, values of type int are limited to 32 bits. Integers that are too large
to be represented in 32 bits cannot be stored in an int variable. Java has a standard class, java.math.BigInteger,
that addresses this problem. An object of type BigInteger is an integer that can be arbitrarily large.
(The maximum size is limited only by the amount of memory available to the Java Virtual Machine.) Since BigIntegers
are objects, they must be manipulated using instance methods from the BigInteger class. For example, you can't add two
BigIntegers with the + operator. Instead, if N and M are variables that refer to BigIntegers, you can compute the sum
of N and M with the function call N.add(M). The value returned by this function is a new BigInteger object that is
equal to the sum of N and M.

The BigInteger class has a constructor new BigInteger(str), where str is a string. The string must represent an integer,
 such as "3" or "39849823783783283733". If the string does not represent a legal integer, then the constructor throws
 a NumberFormatException.

There are many instance methods in the BigInteger class. Here are a few that you will find useful for this exercise.
Assume that N and M are variables of type BigInteger.

N.add(M) — a function that returns a BigInteger representing the sum of N and M.
N.multiply(M) — a function that returns a BigInteger representing the result of multiplying N times M.
N.divide(M) — a function that returns a BigInteger representing the result of dividing N by M, discarding the remainder.
N.signum() — a function that returns an ordinary int. The returned value represents the sign of the integer N.
The returned value is 1 if N is greater than zero. It is -1 if N is less than zero. And it is 0 if N is zero.

N.equals(M) — a function that returns a boolean value that is true if N and M have the same integer value.
N.toString() — a function that returns a String representing the value of N.
N.testBit(k) — a function that returns a boolean value. The parameter k is an integer. The return value is true if the
k-th bit in N is 1, and it is false if the k-th bit is 0. Bits are numbered from right to left, starting with 0.
Testing "if (N.testBit(0))" is an easy way to check whether N is even or odd. N.testBit(0) is true if and
only if N is an odd number.
For this exercise, you should write a program that prints 3N+1 sequences with starting values specified by the user.
In this version of the program, you should use BigIntegers to represent the terms in the sequence.
You can read the user's input into a String with the TextIO.getln() function or with the nextLine() function of a
Scanner. Use the input value to create the BigInteger object that represents the starting point of the 3N+1 sequence.
Don't forget to catch and handle the NumberFormatException that will occur if the user's input is not a legal integer!
The program should not end when that happens; it should just output an error message.
You should also check that the input number is greater than zero.

If the user's input is legal, print out the 3N+1 sequence. Count the number of terms in the sequence, and print the
count at the end of the sequence. Exit the program when the user inputs an empty line. */



import java.math.BigInteger;
import java.util.Scanner;

/**
 * This program prints out 3N+1 sequences for starting values of N that
 * are entered by the user.  Since integers are represented as objects of
 * type BigInteger, it will work for arbitrarily large integers.  The
 * starting value specified by the user must be greater than zero.  The
 * program continues to read input from the user and print 3N+1 sequences
 * until the user inputs an empty line.  If the user's input is illegal,
 * the program will print an error message and continue.
 */
public class BigThreeN {


    private static final BigInteger THREE = new BigInteger("3");
    private static final BigInteger ONE = new BigInteger("1");
    private static final BigInteger TWO = new BigInteger("2");


    public static void main(String[] args) {

        Scanner scanner = new Scanner( System.in );  // for reading user's input.

        String line;   // A line of input from the user.

        BigInteger N;  // The starting point for the 3N+1 sequence,
        //   as specified by the user.

        System.out.println("This program will print 3N+1 sequences for positive starting values");
        System.out.println("that you enter.  There is no pre-set limit on the number of");
        System.out.println("digits in the numbers that you enter.  The program will end when");
        System.out.println("you enter an empty line.");

        while (true) {
            System.out.println();
            System.out.println("Enter the starting value, or press return to end.");
            System.out.print("? ");
            line = scanner.nextLine().trim();
            if (line.length() == 0)
                break;
            try {
                N = new BigInteger(line);
                if (N.signum() == 1)
                    printThreeNSequence(N);
                else
                    System.out.println("Error:  The starting value cannot be less than or equal to zero.");
            }
            catch (NumberFormatException e) {
                System.out.println("Error:  \"" + line + "\" is not a legal integer.");
            }
        }

        System.out.println();
        System.out.println("OK.  Bye for now!");

    }  // end main()


    /**
     * Print the 3N+1 sequence starting from N, and count the number
     * of terms in the sequence.  It is assumed that N is not null and
     * that it is greater than zero.
     */
    private static void printThreeNSequence(BigInteger N) {

        assert N != null && N.signum() == 1 : "Illegal parameter value.";

        int count;  // The number of terms in the sequence.

        System.out.println();
        System.out.println("The 3N+1 sequence starting with " + N + " is:");
        System.out.println();

        System.out.println(N.toString());   // Print N as the first term of the sequence
        count = 1;

        while ( ! N.equals(ONE) ){   // Compute and print the next term
            if (N.testBit(0) == false) {
                // N is even.  Divide N by 2.
                N = N.divide(TWO);
            }
            else {
                // N is odd.  Multiply N by 3, then add 1.
                N = N.multiply(THREE);
                N = N.add(ONE);
            }
            System.out.println(N.toString());
            count++;
        }

        System.out.println();
        System.out.println("There were " + count + " terms in the sequence.");

    }  // end printThreeNSequence


} // end BigThreeN