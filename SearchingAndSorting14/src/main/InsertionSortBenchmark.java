/*
 * This program demos sorting by Insertion. Note that the program gets exceedingly
 * slow for arrays >10000 elements.

 * Completion time: ~3hrs.
 */
package main;

/**
 *
 * @author joshortiz
 */
import java.util.Random;
import java.util.Scanner;

public class InsertionSortBenchmark extends InsertionSorter {

    static StopWatch timer = new StopWatch();

    static Random randInt = new Random();
    static BubbleSorter bs = new BubbleSorter();

    public static int[] generateData(int n) {
        int[] generated = new int[n];
        for (int i = 0; i < n - 1; i++) {
            generated[i] = randInt.nextInt(n * 2);
        }
        return generated;
    }

    public static int[] bubbleSort(int[] a) {
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
        return a;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the smallest array size (n) to test: ");
        int smallest = input.nextInt();
        System.out.print("Please enter the largest array size (n) to test: ");
        int largest = input.nextInt();
        System.out.print("Please enter the number of measurements to take: ");
        int measures = input.nextInt();
        System.out.println("Size\t\tTime(milliseconds)");
        //The program will only move forward if the difference of the largest
        // and smallest values is greater than the amount of measurements to take.
        if ((largest - smallest) > measures) {
            // the amount we need to add to the smallest until we reach the largest
            int increments = ((largest - smallest) / measures);
            int startingPoint = smallest;
            while (startingPoint <= largest) {
                System.out.print(startingPoint + "\t\t");
                timer.start();
                insertionSort(generateData(startingPoint));
                timer.stop();
                System.out.print(timer.getElapsedTime() + "\n");
                timer.reset();
                startingPoint += increments;

            }

        } else {
            System.out.println("The program will not work with the current"
                    + "parameters. \nMake sure smallest<largest and largest-smallest>measures");
        }
        int[] newArr = generateData(smallest);
        for (int x : newArr) {
            System.out.println(x);

        }
        bubbleSort(newArr);
        for (int x : newArr) {
            System.out.println(x);
        }

    }

}
