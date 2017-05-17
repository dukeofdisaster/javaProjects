/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author joshortiz
 */
public class InsertionSorter {

    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int next = a[i];
            //move all larger elements up
            int j = i;
            while (j > 0 && a[j - 1] > next) {
                a[j] = a[j - 1];
                j--;
            }
            // insert the element
            a[j] = next;
        }
    }

    public static void mergeSort(int[] a) {
        // test the base case first: ALWAYS
        if (a.length <= 1) {
            return;
        }
        int[] first = new int[a.length / 2];
        int[] second = new int[a.length - first.length];
        insertionSort(first);
        insertionSort(second);
        merge(first, second, a);

    }

    public static void merge(int[] first, int[] second, int[] a) {
        int iFirst = 0;
        int iSecond = 0;
        int j = 0;

        //as long as neither iFirst nor iSecond past the end, move the
        // smaller element into array a;
        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst] < second[iSecond]) {
                a[j] = first[iFirst];
                iFirst++;
            } else {
                a[j] = second[iSecond];
                iSecond++;
            }
            j++;
        }

        // only one of the remaining two loops will copy entreis
        while (iFirst < first.length) {
            a[j] = first[iFirst];
            iFirst++;
            j++;
        }
        while (iSecond < second.length) {
            a[j] = second[iSecond];
            iSecond++;
            j++;
        }
    }

    public static void main(String[] args) {
        InsertionSorter x = new InsertionSorter();
        int[] julia = new int[10];
        julia[0] = 12;
        julia[1] = 32;
        julia[2] = 50;
        julia[3] = 3;
        julia[4] = 4;
        julia[5] = 0;
        julia[6] = 7;
        julia[7] = 10;
        julia[8] = 9;
        julia[9] = 22;
        for (int i = 0; i < julia.length - 1; i++) {
            System.out.println(julia[i]);
        }
        System.out.println("-----------\n");
        insertionSort(julia);
        for (int i = 0; i < julia.length - 1; i++) {
            System.out.println(julia[i]);
        }
    }

}
