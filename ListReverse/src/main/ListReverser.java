/*
 * Description: Method reverses the items in a LinkedList by placing them into
 * a temporary list (looping through given list and adding items from given list
 * to the reversedList using addFirst()) and then copying them back into the
 * given Linked list in reverse order
 *
 *

 * Completion Time: >1Hr
 *
 * Version: 1.0
 *
 */
package main;

/**
 *
 * @author joshortiz
 */
import java.util.LinkedList;

public class ListReverser {

    public static void reverse(LinkedList given) {
        LinkedList<Object> reversedList = new LinkedList<Object>();
        for (Object x : given) {
            reversedList.addFirst(x);
        }
        given.clear();
        for (Object x : reversedList) {
            given.addLast(x);
        }

    }

    public static void main(String[] args) {
        LinkedList<String> lst = new LinkedList<String>();
        lst.addLast("D");
        lst.addLast("H");
        lst.addLast("R");
        lst.addLast("T");

        System.out.println("Original:");
        System.out.println(lst);
        reverse(lst);

        System.out.println("\nReversed:");
        System.out.println(lst);
    }
}
