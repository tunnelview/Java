package prac_02;


/* Question - Write a program that will evaluate simple expressions such as 17 + 3 and 3.14159 * 4.7.
The expressions are to be typed in by the user. The input always consists of a number,
followed by an operator, followed by another number.
The operators that are allowed are +, -, *, and /.
You can read the numbers with TextIO.getDouble() and the operator with TextIO.getChar().
Your program should read an expression, print its value, read another expression, print its value, and so on.
The program should end when the user enters 0 as the first number on the line.

// Basically, in this program, we are writing a calculator. In the (Number- Operator- Number format)

 */

import java.util.Scanner;

public class Ch3p3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        //double result_addition = 0; Notice- That below sout didn't recognize result_addition as it was not declared;
        // and result_addition without the "promitive data type double" won't be recognized; that's why Java is a
        //strongly typed language.

        double arithmatic_result = 0;
        while (true) {
            System.out.println("Calculate what? (number operator number) : ");

            double d1 = scanner.nextDouble();
            System.out.println("d1 = " + d1);

            String op = scanner.next();
            System.out.println("op" + op);

            double d2 = scanner.nextDouble();
            System.out.println("d2 = " + d2);

            switch (op) {
                case "+":
                    arithmatic_result = d1 + d2;
                    break;
            }
            switch (op) {
                case "-":
                    arithmatic_result = d1 - d2;
                    break;
            }
            switch (op) {
                case "*":
                    arithmatic_result = d1 * d2;
                    break;
            }
            switch (op) {
                case "/":
                    arithmatic_result = d1 / d2;
                    break;

                default:
                    System.out.println("Are you on drugs? I am not Siri");
            }
            System.out.println("arithmatic_result = " + arithmatic_result);
        }
    }
}