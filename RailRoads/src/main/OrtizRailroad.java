/*
 * Description: Railroad simulates the rearranging of cars on a train track.
 * The user is asked to enter the order of incoming cars, which are pushed to
 * a String stack until the user enters DONE. After the user enters DONE, the
 * the size of the stack is stored as an int and used to determine the amount
 * of times a for loop is ran to ask the user to enter the desired output order.
 *
 * Each value  from the desired output order entered is stored in a Queue. Then
 * a for loop is used to compare .pop() values from the stack, to .remove()
 * values from the queue, and a counter is used to determine the amount of
 * matches. If the amount of matches == size of the stack, then all values have
 * been matched, and a message is printed to the console saying such. Otherwise
 * a message is printed stating that the input did not match the desired output
 * order.
 *
 *

 * Completion Time: ~2Hours
 *
 * Version: 1.0
 *
 */
package main;

/**
 *
 * @author joshortiz
 */
import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class OrtizRailroad {

  public static void main(String[] args) {

    System.out.println("Please enter the order of incoming Cars. Enter"
            + " DONE when done");

    Scanner input = new Scanner(System.in);
    Stack<String> cars = new Stack<String>();

    boolean DONE = false;

    // Loop for input until user enters "DONE", printing a message for empty
    // input, and allowing user to continue entering input.
    while (!DONE) {

      String nextUp = input.nextLine();

      if (nextUp.isEmpty()) {
        System.out.println("Empty input not allowed. Enter the order of"
                + " incoming cars.");
      } else if (nextUp.equals("DONE")) {
        DONE = true;
      } else {
        cars.push(nextUp);
      }
    }

    // Size get's stored  to be used later.
    int carStack = cars.size();

    //Prompt user again push entered data into a new stack
    Queue<String> desiredOrder = new LinkedList<String>();
    System.out.println("Please enter the desired output order. Note:"
            + " you must provide as many output values as input values");
    for (int i = 0; i < cars.size(); i++) {
      String input2 = input.nextLine();
      desiredOrder.add(input2);
    }

    int matchCount = 0;
    for (int k = 0; k < carStack; k++) {
      if (cars.pop().equals(desiredOrder.remove())) {
        matchCount++;
      }
    }

    if (matchCount == carStack) {
      System.out.println("The input was matched to the output!");
    } else {
      System.out.println("Sorry, the input was not successfully matched");
    }
  }
}
