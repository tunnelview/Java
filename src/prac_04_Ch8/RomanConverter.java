package prac_04_Ch8;

import textio.TextIO;

/* Question - A Roman numeral represents an integer using letters. Examples are XVII to represent 17,
MCMLIII for 1953, and MMMCCCIII for 3303. By contrast, ordinary numbers such as 17 or 1953 are called Arabic numerals.
The following table shows the Arabic equivalent of all the single-letter Roman numerals:

M    1000            X   10
D     500            V    5
C     100            I    1
L      50
When letters are strung together, the values of the letters are just added up, with the following exception.
When a letter of smaller value is followed by a letter of larger value, the smaller value is subtracted from the
larger value. For example, IV represents 5 - 1, or 4.
And MCMXCV is interpreted as M + CM + XC + V, or 1000 + (1000 - 100) + (100 - 10) + 5, which is 1995.
In standard Roman numerals, no more than three consecutive copies of the same letter are used.
Following these rules, every number between 1 and 3999 can be represented as a
Roman numeral made up of the following one- and two-letter combinations:

M    1000            X   10
CM    900            IX   9
D     500            V    5
CD    400            IV   4
C     100            I    1
XC     90
L      50
XL     40
Write a class to represent Roman numerals. The class should have two constructors.
One constructs a Roman numeral from a string such as "XVII" or "MCMXCV". It should throw a NumberFormatException
if the string is not a legal Roman numeral. The other constructor constructs a Roman numeral from an int.
It should throw a NumberFormatException if the int is outside the range 1 to 3999.

In addition, the class should have two instance methods. The method toString() returns the string that represents the
Roman numeral. The method toInt() returns the value of the Roman numeral as an int.

At some point in your class, you will have to convert an int into the string that represents the corresponding
Roman numeral. One way to approach this is to gradually "move" value from the Arabic numeral to the Roman numeral.
Here is the beginning of a routine that will do this, where number is the int that is to be converted:

String roman = "";
int N = number;
while (N >= 1000) {
      // Move 1000 from N to roman.
   roman += "M";
   N -= 1000;
}
while (N >= 900) {
      // Move 900 from N to roman.
   roman += "CM";
   N -= 900;
}
.
.  // Continue with other values from the above table.
.
(You can save yourself a lot of typing in this routine if you use arrays in a clever way to represent the
data in the above table.)

Once you've written your class, use it in a main program that will read both Arabic numerals and Roman numerals
entered by the user. If the user enters an Arabic numeral, print the corresponding Roman numeral.
If the user enters a Roman numeral, print the corresponding Arabic numeral.
(You can tell the difference by using TextIO.peek() to peek at the first character in the user's input
(see Subsection 8.2.2). If the first character is a digit, then the user's input is an Arabic numeral. Otherwise,
it's a Roman numeral.) The program should end when the user inputs an empty line. */



/**
 * This program will convert Roman numerals to ordinary arabic numerals
 * and vice versa.  The user can enter a numerals of either type.  Arabic
 * numerals must be in the range from 1 to 3999 inclusive.  The user ends
 * the program by entering an empty line.
 */


public class RomanConverter {

    public static void main(String[] args) {

        System.out.println("Enter a Roman numeral and I will convert it to an ordinary");
        System.out.println("arabic integer.  Enter an integer in the range 1 to 3999");
        System.out.println("and I will convert it to a Roman numeral.  Press return when");
        System.out.println("you want to quit.");

        while (true) {

            System.out.println();
            System.out.print("? ");

             /* Skip past any blanks at the beginning of the input line.
                Break out of the loop if there is nothing else on the line. */

            while (TextIO.peek() == ' ' || TextIO.peek() == '\t')
                TextIO.getAnyChar();
            if ( TextIO.peek() == '\n' )
                break;

             /* If the first non-blank character is a digit, read an arabic
                numeral and convert it to a Roman numeral.  Otherwise, read
                a Roman numeral and convert it to an arabic numeral. */

            if ( Character.isDigit(TextIO.peek()) ) {
                int arabic = TextIO.getlnInt();
                try {
                    RomanNumeral N = new RomanNumeral(arabic);
                    System.out.println(N.toInt() + " = " + N.toString());
                }
                catch (NumberFormatException e) {
                    System.out.println("Invalid input.");
                    System.out.println(e.getMessage());
                }
            }
            else {
                String roman = TextIO.getln();
                try {
                    RomanNumeral N = new RomanNumeral(roman);
                    System.out.println(N.toString() + " = " + N.toInt());
                }
                catch (NumberFormatException e) {
                    System.out.println("Invalid input.");
                    System.out.println(e.getMessage());
                }
            }

        }  // end while

        System.out.println("OK.  Bye for now.");

    }  // end main()

} // end class RomanConverter