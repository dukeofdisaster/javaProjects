/*
 * Description: StringLengthComporator implements the Comparator interface to
 * create a custom compare(method) that sorts strings by length and sorts
 * strings of the same length alphabetically
 *
 *

 * Completion Time:  < 1hr
 *
 * Version:1
 *
 */
package main;

/**
 *
 * @author joshortiz
 */
import java.util.*;

public class StringLengthComparator implements Comparator<String> {

    @Override
    public int compare(String one, String two) {
        if (one.length() > two.length()) {
            return 1;
        } else if (one.length() < two.length()) {
            return -1;
        } else {
            return one.compareTo(two);
        }

    }

    public static void main(String[] args) {
        String[] words = new String[6];
        words[0] = ("AB");
        words[1] = ("abb");
        words[2] = ("abbbb");
        words[3] = ("a");
        words[4] = ("d");
        words[5] = "c";

        for (String x : words) {

            System.out.println(x);
        }
        System.out.println("------");
        Arrays.sort(words, new StringLengthComparator());

        for (String x : words) {
            System.out.println(x);
        }
    }
}
