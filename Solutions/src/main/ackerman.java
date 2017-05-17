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
public class ackerman {

  public static int ackerFunc(int a, int b) {
    if (a >= 1 && b == 0) {
      System.out.println("returned 0");
      return 0;
    }
    if (a == 0) {
      System.out.println("returned 2b");
      return (2 * b);
    }
    if (a >= 1 && b == 1) {
      System.out.println("returned 2");
      return 2;
    } else if (a >= 1 && b >= 1) {
      System.out.println("recursive call to ackerfunc");
      return ackerFunc(a - 1, ackerFunc(a, b - 1));
    } else {
      return -1;
    }
  }

  public static void main(String[] args) {
    System.out.println(ackerFunc(3, 3));
    System.out.println(ackerFunc(1, 0));

  }
}
