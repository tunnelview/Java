package cp2406prac_02;

/* To "capitalize" a string means to change the first letter of each word in the string to upper case
(if it is not already upper case). For example,
a capitalized version of

"Now is the time to act!"

is "Now Is The Time To Act!".

Write a subroutine named printCapitalized that will print a capitalized version
of a string to standard output. The string to be printed should be a parameter to the subroutine.
Test your subroutine with a main() routine that gets a line of input from the user and applies the subroutine to it.
Note that a letter is the first letter of a word if it is not immediately preceded in the string by another letter.
Recall from Exercise 3.4 that there is a standard boolean-valued function Character.isLetter(char) that can be used
to test whether its parameter is a letter. There is another standard char-valued function, Character.toUpperCase(char),
that returns a capitalized version of the single character passed to it as a parameter.
That is, if the parameter is a letter, it returns the upper-case version. If the parameter is not a letter,
it just returns a copy of the parameter.
 */

import java.util.Scanner;

public class Ch4p1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text: ");
        String text = scanner.nextLine();
        System.out.println("");
        System.out.println("Your text:" + text);

        //Note: System.out.println("Your text: + text"); Here I made a mistake of putting the end quotes after
        // the 2nd text which will not print the line we are copying from the question. "Now is the time to act!";
        //  it will print "Your text: + text".

       // for (int i = 0; i < text.length; i++) {
         //    char c = text.charAt(i);

        //} The shortcut to get the for loop code populated is 'itar' + enter; and intelliJ auto completes the code. The
        // above code is a proposed solution in the text book.
        char [] arr = text.toCharArray();
        //char previous_char = '.'; "This is the way to write the initializing of previous char not being a letter."
        char previous_char = '.';// Clever code but tricky. At a later stage, "previous_char='.'- why? Its a more
        // clever code and when looked at a later stage, we forget what that cleverness was.
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (!Character.isLetter(previous_char) && Character.isLetter(c)){

                // The above line means; if the previous Character is not a letter(!Character.isLetter) and (&&)
                // Character is a letter; that's what we are checking. If the previous one is not a letter then we want
                // to go .toUpperCase().
                c = Character.toUpperCase(c);

                //System.out.println(c); println - means print end of line; therefore we will take off ln and just leave
                // print
                //System.out.print(c); // Important - If c is not put into print function; it will give an error;
                //"java: no suitable method found for print(no arguments)" - This program will give an output as
                // "NITTTA" because the loop is put inside the if statement. After debuggin the print statement is put
                // outside the if statement.
            }
            System.out.print(c);
            previous_char = c; // without this line the above code won't work becaue as "previous_char" is not updated.
        }

    }
}


