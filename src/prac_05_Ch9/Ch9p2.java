/* Question : Exercise 7.6 asked you to read a file, make an alphabetical list of all the words that occur in the file,
 and write the list to another file. In that exercise, you were asked to use an ArrayList<String> to store the words.
 Write a new version of the same program that stores the words in a binary sort tree instead of in an arraylist.
 You can use the binary sort tree routines from SortTreeDemo.java, which was discussed in Subsection 9.4.2.  */

// In this program- line number 24 is the problem.

package prac_05_Ch9;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Ch9p2 {
    public static void main(String[] args) {

        String outPath = "C:\\Users\\jc653691\\IdeaProjects\\prac_05\\src\\prac_05\\Ch9p2_text_out.txt";

        //File file = new File( // Was trying to get the pathname automatically, by pressing ALT + Enter; but couldn't
        // code from internet in the next line and automatically got "pathname"
        //pathname: C:\Users\jc653691\IdeaProjects\prac_05\src\Ch9p2.java); // error line

        //File file = new File(
          //      "C:\\Users\\jc653691\\IdeaProjects\\prac_05\\src\\Ch9p2.java"); // again copied the wrong code
        //and ran the program, changed the computer, but copied the previous code.
        File file = new File(
                "/Users/shibinabraham/Desktop/presentation_code/src/com/demo/prac/Ch9p2.java");
        BufferedReader br = null;
        // Ran after removing,same error
        ArrayList<String>arr = new ArrayList<>();
        TreeSet<String> set = new TreeSet<>();


        try {
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null)  // br.readline() still showed the error; then chose the 3rd option
                // i.e., the exception needs to be more generic as it wasn't catching the error.
            { // I missed out in this particular bracket. It was an error.
                System.out.println(line);
                StringTokenizer st = new StringTokenizer(line," \t(),\\[];{}."); // the delimiter will ignore all
                while (st.hasMoreTokens()) {
                    String word = st.nextToken();
                    System.out.println(word);
                    arr.add(word);
                    set.add(word); // In line 33 we added a TreeSet and then in line 48, adding each word, as we are
                    // adding each word, each word will be sorted automatically.
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // at this point, we ran the program and we got back the actual text we have in the file.
        // in the question, it is asked to do the array list, therefore its not required to unique, because array list
        // can take duplicates

        System.out.println("-----------------------------------"); // Converting Arrays to String
        System.out.println(Arrays.toString(arr.toArray()));
        Object[] arr2 = arr.toArray(); // TO Do This Better Object[] is changed back to string as that's not right.
        //String[] arr2 = (String[]) arr.toArray(); // An important thing we can do better is to not go too generic to
        // array, because it looses information about what type of objects are there.
        Arrays.sort(arr2);

        System.out.println("-----------------------------------");// code to sort it
        System.out.println(Arrays.toString(arr2));

        try {
            Writer writer = new BufferedWriter(
                    new OutputStreamWriter(
                    new FileOutputStream(outPath), "utf-8"));
            for (int i = 0; i < arr2.length; i++) {
                // String word = (String)arr2[i];
                Object word = arr2[i];
                writer.write(word.toString());
                writer.write("\n");
            }
            System.out.println("-----------------------------------------");
            writer.flush(); // may be it was written into a buffer and buffer didn't flush. This line was written after
            // we tried running the program and it didn't show no text_out.
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("-----------------------------------");
        System.out.println(Arrays.toString(arr.toArray()));
    }
}

/* Couldn't implement the binary tree implementation as we couldn't find the binary tree implementation */

/* Caveat : Never or rather not recommended to use own classes for doing general implementation, always preferred to
* use the already available class from Library*/