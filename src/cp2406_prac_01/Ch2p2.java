package cp2406_prac_01;

public class Ch2p2
{
    public static void main(String[] args)
    {

        /*  Question - Write a program that simulates rolling a pair of dice. You can simulate rolling one die by
        choosing one of the integers 1, 2, 3, 4, 5, or 6 at random. The number you pick represents the
        number on the die after it is rolled. As pointed out in Section 2.5, the expression (int)(Math.random()*6) + 1
        does the computation to select a random integer between 1 and 6.
        You can assign this value to a variable to represent one of the dice that are being rolled.
        Do this twice and add the results together to get the total roll.
        Your program should report the number showing on each die as well as the total roll. For example:
            The first die comes up 3
            The second die comes up 5
            Your total roll is 8  */

        int d1= (int)(Math.random()*6) + 1;
        int d2= (int)(Math.random()*6) + 1;
        int sum = d1+d2;

        System.out.println("The first die comes up "+d1+"\n" +
                "The second die comes up "+d2+"\n" +
                "Your total roll is " + sum);
    }
}
