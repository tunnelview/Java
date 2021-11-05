package prac_05_Ch9;

/* Question: In many textbooks, the first examples of recursion are the
mathematical functions factorial and fibonacci. These functions are defined
for non-negative integers using the following recursive formulas:
factorial(0)  =  1
factorial(N)  =  N*factorial(N-1)   for N > 0

fibonacci(0)  =  1
fibonacci(1)  =  1
fibonacci(N)  =  fibonacci(N-1) + fibonacci(N-2)   for N > 1
Write recursive functions to compute factorial(N) and fibonacci(N) for a
given non-negative integer N, and write a main() routine to test your functions.
Consider using the BigInteger class (see Exercise 8.2)
(In fact, factorial and fibonacci are really not very good examples of recursion,
since the most natural way to compute them is to use simple for loops.
Furthermore, fibonacci is a particularly bad example, since the natural
recursive approach to computing this function is extremely inefficient.) */

import java.math.BigInteger;

public class Ch9p1_factorials {
    public static BigInteger minusOne = new BigInteger("-1");
    public static BigInteger minusTwo = new BigInteger("-2");
    public static BigInteger one = new BigInteger("1");
    public static BigInteger zero = new BigInteger("0");
    private static BigInteger res;

    public static void main(String[] args) {
        //BigInteger n = new BigInteger("3"); //Tested it with a different value
        //BigInteger n = new BigInteger("10"); // Got a smaller number after fibonacci implementation
        // Note : line 27 has to be
        // left blank (or between line 26 and 28
        //BigInteger n = new BigInteger("2"); Tested it with 2, got correct results
        //BigInteger n = new BigInteger(""); Tested it with 3, got correct results
        //BigInteger n = new BigInteger("4"); Tested it with 4, got (n) = 5; incorrect
        // later googled and found that fibonacci for 4 is 5. Correct solution
        BigInteger n = new BigInteger("4");
        System.out.println("factorial n!=" + factorial(n));
        System.out.println("fibonacci (n)=" + fibonacci(n));
    }
    public static BigInteger factorial(BigInteger n){
        System.out.println("n = " + n);
//factorial(0)  =  1
//factorial(N)  =  N*factorial(N-1)   for N > 0
        if (n.equals(one) || n.equals(zero)) {
            return one;
        }
        BigInteger res = factorial(n.add(minusOne));
        //return factorial(n.add(minusOne)); // I had kept this line here and kept getting error in next line
        res = res.multiply(n);
        return res;
    }
    public static BigInteger fibonacci(BigInteger n){
        System.out.println("n = " + n);
//fibonacci(0)  =  1
//fibonacci(1)  =  1
//fibonacci(N)  =  fibonacci(N-1) + fibonacci(N-2)   for N > 1
        if (n.equals(one) || n.equals(zero)) {
            return one;
        }
        BigInteger res1 = fibonacci(n.add(minusOne));
        BigInteger res2 = fibonacci(n.add(minusTwo));
        return res1.add(res2);
    }
}
// In the end; looked at the solution.
// "https://math.hws.edu/javanotes/c9/ex1-ans.html"
//later googled and found out the fibonacci for 4 is 5 and for 5 its 8.
// There the solution is correctly implemented.

