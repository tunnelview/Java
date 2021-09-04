package prac_01;

import java.util.Scanner;

public class Ch2p4 {
    public static void main(String[] args)
    {
        System.out.println("Hello");

        /* Question - Write a program that helps the user count his change.
        The program should ask how many quarters the user has,
        then how many dimes, then how many nickels, then how many pennies.
        Then the program should tell the user how much money he has, expressed in dollars.
         */


        // Scanner class to read from the input
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many quarters: ");

        //String num_quarters = scanner.next();

        // The below line - converting the string to integer; as its accepting the Inegers as well as Strings
        // if the user inputs quarters (in numbers)- no error; but if the user inputs quarters (in letters)
        // system will throw an error; this program is written assuming the user knows what the input should be.
        int num_quarters = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Inputted " + num_quarters);

        System.out.println("How many dimes: ");
        int num_dimes = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Inputted " + num_dimes);

        System.out.println("How many nickles: ");
        int num_nickles = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Inputted " + num_nickles);

        System.out.println("How many pennies: ");
        int num_pennies = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Inputted " + num_pennies);

        int sum_cents = 25 * num_quarters + 10 * num_dimes + 5 * num_nickles + 1 * num_pennies;
        System.out.println(" sum_of_cents " + sum_cents);


        // This last line is to convert the sum to dollars; as the above value (or sum) is in cents
        System.out.println(" sum $ " + sum_cents/100);



        // Important Point : scanner.nextLine(); if the numbers inputted are vertical, i.e. one after the other;
        // VS if the input is on a horizontal format (1 2 3 4 5- with spaces) then without the "scanner.nextline()";
        // the system will consider the next number as the next input.

        // Also we see that printing each input is equally important to see what we inputted and what is actually
        // considered as an input (1111111111111) if the number is larger than 16 digits; it will throw an error.
    }
}
