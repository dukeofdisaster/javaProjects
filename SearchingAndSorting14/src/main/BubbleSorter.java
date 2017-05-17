/*
 * Description: BubbleSorter demos sorting an array wih a bubbleSort method
 * Completion Time: < 1 HR
 */
package main;

/**
 *
 * @author joshortiz
 */
public class BubbleSorter {

    public static void bubbleSort(int[] a) {
        int temp;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 1; j < a.length - i; j++) {
                if (a[j - 1] > a[j]) {
                    temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[5];
        arr[0] = 12;
        arr[1] = 13;
        arr[4] = 22;
        arr[3] = 333;

        for (int x : arr) {
            System.out.println(x);
        }
        System.out.println("-------");
        bubbleSort(arr);
        for (int x : arr) {
            System.out.println(x);
        }
    }
}
