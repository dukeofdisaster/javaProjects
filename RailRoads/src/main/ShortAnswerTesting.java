/*
 * Description:
 *
 *

 * Completion Time:
 *
 * Version:
 *
 */
package main;

/**
 *
 * @author joshortiz
 */
import java.util.LinkedList;
import java.util.Queue;

public class ShortAnswerTesting {

  public static void main(String[] args) {
    Queue<String> L = new LinkedList<String>();
    L.add("5");
    L.add("2");
    String x = L.remove(); //x = 5
    System.out.println(L.peek());
  }

}
