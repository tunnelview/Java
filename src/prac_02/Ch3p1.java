package prac_02;

/* Question - How many times(on AVERAGE) do you have to roll a pair of dice before they come up snake eyes?
        You could do the experiment by rolling the dice by hand.
        Write a computer program that simulates the experiment.
        The program should report the number of rolls that it makes before the dice come up snake eyes.
        (Note: "Snake eyes" means that both dice show a value of 1.)
        Exercise 2.2 explained how to simulate rolling a pair of dice.
         */

    public class Ch3p1
    {
        public static void main(String[] args)
        {
            rollOnce();

            //int num_of_tries = 10000; Note: Initially, the number was 100, then changed it to 1000,
            // then changed to to 10000 , then 100000 and as we increased the zeros' we see that the probability
            // of getting 1 on each dice is comming closer.

            //int count = 0; (Here the int has to be divided by an int) we could convert this to float or a double.
            // Important point - Why are we converting this a double from an int? to get the print as a number; for eg.
            // 0.06 instead of getting 0. 'Zero' can't be a probability.

            int num_of_tries = 100000;
            double count = 0;

            for (int i =0; i < num_of_tries; i++)
            {
                int[] result_of_tries = rollOnce();
                if (result_of_tries[0] == 1 && result_of_tries[1] == 1)
                {
                    count++;
                }

            }
            System.out.println("probability of getting snake eyes = " + count/num_of_tries);
            double actual_probability_of_getting_one = (1./6) * (1./6);
            System.out.println("actual_probability_of_getting_one = " + actual_probability_of_getting_one);
        }
        public static int[] rollOnce()
        {

            {

                int die1;   // The number on the first die.
                int die2;   // The number on the second die.
                int total_roll_of_dies;   // The total roll (sum of the two dice).

                die1 = (int) (Math.random() * 6) + 1;
                die2 = (int) (Math.random() * 6) + 1;
                total_roll_of_dies = die1 + die2;


                int[] ret = {die1, die2};
                return ret;
            }
        }
    }
