package prac_02;



/* Question - The hexadecimal digits are the ordinary, base-10 digits '0' through '9' plus the letters 'A' through 'F'.
In the hexadecimal system, these digits represent the values 0 through 15, respectively.
Write a function named hexValue that uses a switch statement to find the hexadecimal value of a given character.
The character is a parameter to the function, and its hexadecimal value is the return value of the function.
You should count lower case letters 'a' through 'f' as having the same value as the corresponding upper case letters.
If the parameter is not one of the legal hexadecimal digits, return -1 as the value of the function.
A hexadecimal integer is a sequence of hexadecimal digits, such as 34A7, ff8, 174204, or FADE.
If str is a string containing a hexadecimal integer, then the corresponding base-10 integer can be computed as follows:

value = 0;
for ( i = 0; i < str.length();  i++ )
   value = value*16 + hexValue( str.charAt(i) );

Of course, this is not valid if str contains any characters that are not hexadecimal digits.
Write a program that reads a string from the user.
If all the characters in the string are hexadecimal digits, print out the corresponding base-10 value.
If not, print out an error message.
 */


import java.util.Scanner;

public class Ch4p2  {
    public static void main(String[] args) {
        System.out.println("result = " + hexValue('0'));
        System.out.println("result = " + hexValue('F'));
        char[] arr = {'0', '1', '2', '9', 'a', 'A', 'q'};
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            //System.out.println("char" + c + "hexValue = " + hexValue(c)); // print this line; the output is
            /*result = 0
            result = 15
            char0hexValue = 0
            char1hexValue = 1
            char2hexValue = 2
            char9hexValue = 9
            charahexValue = 10
            charAhexValue = 10
            charqhexValue = -1*/

            System.out.println("char =" + c + ", hexValue = " + hexValue(c)); // This is the correct line of code.
            // and the output is
            /*  result = 0
                result = 15
                char =0, hexValue = 0
                char =1, hexValue = 1
                char =2, hexValue = 2
                char =9, hexValue = 9
                char =a, hexValue = 10
                char =A, hexValue = 10
                char =q, hexValue = -1*/
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text: ");
        String str = scanner.nextLine();
        int value = 0;
        for (int i = 0; i < str.length(); i++) { // this line without the 'int' will give an error:
            char c = str.charAt(i);
            // java: cannot find symbol
            //  symbol:   variable i
            //  location: class cp2406_Prac_02.Ch4p2 - That's to declare the type 'int' is important.

            // int currVal = hexValue(str.charAt(i)); - Original code bofore chaning it to negative value below lines.
            int currVal = hexValue(c);
            if (currVal == -1){ //int (currVal == -1){ - instead of 'if', keyed in 'Int'
                // - java error- "java: not a statement"
                System.out.println("ERROR: wrong char ='" + c + "'");
                return;
            }
            //value = value * 16 + hexValue(str.charAt(i)); - Original code bofore chaning it to negative value below
            // line.

            value = value * 16 + currVal;

        }
        System.out.println("value = " + value);

    }

    private static int hexValue(char c){
        if (Character.isDigit(c)){
            Integer.parseInt("" + c); //we want to convert a version of string with a char with one character
            // return  Integer.parseInt("" + c);
            return Integer.parseInt(Character.toString(c)); // this is a more preferred way of writing the above line
            // as its easy to understand and read technically.

        }
        c = Character.toLowerCase(c);
        switch (c){
            case 'a': return 10; // return statement is written in the next line, just for this program mentioning this
            // in the same line to make the code more compact.
            case 'b': return 11;
            case 'c': return 12;
            case 'd': return 13;
            case 'e': return 14;
            case 'f': return 15;
        }
        return -1; // This is mentioned in the question - "If the parameter is not one of the legal hexadecimal digits,
        // return -1 as the value of the function."
    }


}
