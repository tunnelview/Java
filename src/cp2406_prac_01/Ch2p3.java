package cp2406_prac_01;

    import java.util.Scanner;

public class Ch2p3
{
    public static void main(String[] args)
    {

        /*Question - Write a program that asks the user's name, and then greets the user by name.
        Before outputting the user's name, convert it to upper case letters.
        For example, if the user's name is Fred, then the program should respond "Hello, FRED, nice to meet you!".
         */

        // we need to read from the input,
        // create a scanner so we can read the command-line input


        Scanner scanner = new Scanner(System.in);

                // prompt for the user's name
        System.out.println("Enter your name: ");

        String username = scanner.next();

        System.out.println("HELLO " + username);

        //.toUpperCase to convert it to Uppercase

        username = username.toUpperCase();
        System.out.println("HELLO " + username);


    }
}
