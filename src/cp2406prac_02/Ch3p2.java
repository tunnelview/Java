package cp2406prac_02;

//The source code for that example is CountDivisors.java.

/* Question - Which integer between 1 and 10000 has the largest number of divisors, and how many divisors does it have?
Write a program to find the answers and print out the results. It is possible that several integers in this
range have the same, maximum number of divisors. Your program only has to print out one of them.
You might need some hints about how to find a maximum value. The basic idea is to go through all the integers,
keeping track of the largest number of divisors that you've seen so far.
Also, keep track of the integer that had that number of divisors.*/


public class Ch3p2
{
    public static void main(String[] args)
    {
        getDivisors(100);
        // In the above line, just need to enter 100 and intelli J will auto populate the 'N:',
        // incase it's not populated,
        // just run the program once and it will auto populate.

        int n = 10000;
        int maxCount = 0;
        for (int i = 1; i <= n; i++){
            int count = getDivisors(i);
            if(count > maxCount){
                maxCount = count;
                System.out.println("number " + i + " has maxCount = " +maxCount);
            }
        }

    }


    //private static void getDivisors(int N) - when you run it with void - java throws an error
    // "java: incompatible types: unexpected return value" - but when I change it
    // to integer type " private static int getDivisors(int N)" - the error is gone.
    private static int getDivisors(int n)
    {
            int testDivisor;  // A number between 1 and N that is a
            // possible divisor of N.

            //Impdouble divisorCount; - When you run it with 'double'- it throws an error;
            // java: incompatible types: unexpected return value- Change it to 'int' in the below line-it works.

            int divisorCount;  // Number of divisors of N that have been found.

            int numberTested;  // Used to count how many possible divisors
            // of N have been tested.  When the number
            // reaches 10000000, a period is output and
            // the value of numberTested is reset to zero.
            divisorCount = 0;
            numberTested = 0;

            for (testDivisor = 1; testDivisor <= n; testDivisor++)
            {
                if (n % testDivisor == 0)
                    divisorCount++;
                numberTested++;
                if (numberTested == 10000000)
                {
                    System.out.print('.');
                    numberTested = 0;
                }
            }
            //??System.out.println();
            //System.out.println("The number of divisors of " + n
                    //+ " is " + divisorCount);
            return divisorCount;
    }
}











