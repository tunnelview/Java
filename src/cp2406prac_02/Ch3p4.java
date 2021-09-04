package cp2406prac_02;


/* Question - Write a program that reads one line of input text and breaks it up into words.
The words should be output one per line. A word is defined to be a sequence of letters.
Any characters in the input that are not letters should be discarded. For example, if the user inputs the line -
He said, "That's not a good idea." then the output of the program should be
He
said
That
s
not
a
good
idea
An improved version of the program would list "that's" as a single word.
An apostrophe can be considered to be part of a word if there is a letter on each side of the apostrophe.

To test whether a character is a letter, you might use (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z').
However, this only works in English and similar languages.
A better choice is to call the standard function Character.isLetter(ch),
which returns a boolean value of true if ch is a letter and false if it is not.
This works for any Unicode character. */


import java.util.Scanner;
import java.util.StringTokenizer;

public class Ch3p4
{
    private static String str;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter one line of input text: ");
        //scanner.nextLine(); .nextline - This function reads the whole line.
        String line = scanner.nextLine();
        System.out.println("");
        System.out.println("line= " + line);

        StringTokenizer tokenizer = new StringTokenizer(line);
        while (tokenizer.hasMoreTokens())
        {
            String str = tokenizer.nextToken();
            str = filterLetters(str);
            System.out.println(str);
        }


    }
    private static String filterLetters(String str){
        char[] arr = str.toCharArray();
        //String result = "" Note here that we are creating a String result; and initializing it to empty string.
        String res = "";
        for (int i = 0; i < arr.length;i++) {
            char ch = arr[i];

            //if (!Character.isLetter(ch)) {
            // the below is to check only for the apostrophe.
            if (ch == '\''){
                if (i == 0 || i == arr.length-1)
                // the below if condition, the way it is written means, " after checking the if condition above;
                // if Character is not (!) a letter; then the program will do another check; i.e. one before i (written
                // as [i-1]) and one check after i (written as [i+1]); once established not a letter, 'continue' to the
                // begginning of the loop. If it is a letter; which is the second condition.

                //Quick Question - What will happen if i == 0; the program will crash. i.e. if i is first or i is last,
                //then that is not a valid check. That's why in line 58, a check to perform if i is first or last.
                    // the way to check if (i is last i == arr.length-1)

                if (Character.isLetter(arr[i-1])
                        && Character.isLetter(arr[i+1]))
                res = res + ch;
                continue;
            }
            if (Character.isLetter(ch)) {
                res = res + ch;
                continue;
            }
        }
        return res;
    }
}
