package prac_05_Ch9;

/* Question : Suppose that linked lists of integers are made from objects belonging to the
class ListNode {
   int item;       // An item in the list.
   ListNode next;  // Pointer to the next node in the list.
}
Write a subroutine that will make a copy of a list, with the order of the items of the
list reversed. The subroutine should have a parameter of type ListNode, and it should return
a value of type ListNode. The original list should not be modified.
You should also write a main() routine to test your subroutine. */

import java.util.ArrayList;

public class Ch9p3_ListNode {
    public static void main(String[] args) { // Created ListNodes from Line 14 to 22, not Linked
        ListNode origLi = new ListNode();
        origLi.item = 1;
        ListNode i2 = new ListNode();
        i2.item = 2;
        ListNode i3 = new ListNode();
        i3.item = 3;
        ListNode i4 = new ListNode();
        i4.item = 4;

        // Next line of code we are linking the nodes - line 24 to line 27
//        origLi.next = i2;
//        i2.next = i3;
//        i3.next = i4;
        // in the next code block, we switched the nodes around.
        origLi.next = i2;
        i2.next = i3;
        i3.next = i4;

        printMyList(origLi); // created a function
        ListNode newList = reverseOrder(origLi);
        System.out.printf("------------------------");
        printMyList(newList);

        System.out.println("------------------------");
        printMyList(origLi);
    }
    // Note : To link the nodes, we need to know the current node and the next node
    // This function is last part of the question. Interestingly, the reversing of the order
    // will be easier if we have the function pointing to "ListNode" class.
    // We only have the forward nodes, first we need to store all the nodes into a list and then
    // rebuild it.
    public static ListNode reverseOrder(ListNode node) {
        ArrayList<ListNode> arr = new ArrayList<>();
        while (true) {
            if (node == null) {
                break;
            }
            ListNode newNode = new ListNode();
            newNode.item = node.item;
            newNode.next = node.next;
            //arr.add(node); // everytime we see a node we save it

            arr.add(newNode);
            System.out.println("item = " + node.item);
            node = node.next;
        }
        ListNode first = null;
        //ListNode last = null;
        ListNode nextNode = null;
        for (int i = 0; i < arr.size() - 1; i++) {
            node = arr.get(arr.size() - i - 1);
            nextNode = arr.get(arr.size() - (i + 1) - 1);
            node.next = nextNode;
            if (first == null) {
                first = node;
            } // the last will be nextNode at the last element of the loop
            if (i == arr.size()-2) { // the highest it gets to is -2
                nextNode.next = null; // Fixed bug
            }
        }
        return first;
    }
    public static ListNode printMyList(ListNode node) {
        //while (node.next != null) {
        while (true) { // Meaning of the loop - While the loop runs forever, +
            if (node == null) { // if we get a null pointer +
                break; // we break and come out of the loop +
            }
            System.out.println("item = " + node.item); // if it's not a null pointer then, we print an item
            node = node.next;
        }
        ListNode ret = null;
        return ret;
    }
}

