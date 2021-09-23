package prac_03;
/* Question : The BlackjackHand class from Subsection 5.5.1 is an extension of the Hand class from Section 5.4.
The instance methods in the Hand class are discussed in that section. In addition to those methods,
BlackjackHand includes an instance method, getBlackjackValue(), which returns the value of the hand for the game
of Blackjack. For this exercise, you will also need the Deck and Card classes from Section 5.4.
A Blackjack hand typically contains from two to six cards.

Write a program to test the BlackjackHand class.
You should create a BlackjackHand object and a Deck object. Pick a random number between 2 and 6.
Deal that many cards from the deck and add them to the hand. Print out all the cards in the hand,
and then print out the value computed for the hand by getBlackjackValue().
Repeat this as long as the user wants to continue.

In addition to TextIO.java, your program will depend on Card.java, Deck.java, Hand.java, and BlackjackHand.java.

https://math.hws.edu/javanotes/source/chapter5/Card.java
https://math.hws.edu/javanotes/source/chapter5/Deck.java
https://math.hws.edu/javanotes/source/chapter5/Hand.java
https://math.hws.edu/javanotes/source/chapter5/BlackjackHand.java
 */


import java.util.Scanner;

public class Ch5p4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // to take the input and read it
        while (true) { // assuming this condition is true for ever
            System.out.println("Play Y/N?");
            String text = scanner.nextLine(); // taking the user input in 'text' and "scanner.nextLine()" to read
            if (text.equals("Y")) {
                playOnce();
            }
            else {
                break;
            }

        }
    }

    public static void playOnce() {
        BlackjackHand hand = new BlackjackHand(); // This is the first step; create an object. simple
        Deck deck = new Deck();
        deck.shuffle(); // This is a inbuilt function to shuffle the deck; if we don't shuffle, all card are in order
        int n = (int)(Math.random()*5 + 2); // notice that random returns between 0 and 1 and 1 is excluded;
        // "between" is the key.
        // All classes begin with a Capital letter; and all functions have a () in front of them.
        System.out.println("n = " + n); // Notice that this line is to check the value of 'n'; if n is 1 then nothing
        // will be printed.

        for (int i = 0; i < n; i++) { // This is to implemnt the 3rd point - " Deal that many cards
            // from the deck and add them to the hand "
            Card card = deck.dealCard();
            System.out.println("card = " + card);
            hand.addCard(card);// this to add the card to our hands- added the card
        }
        System.out.println("value = " + hand.getBlackjackValue()); // this is to show the value of the card
    }

}

