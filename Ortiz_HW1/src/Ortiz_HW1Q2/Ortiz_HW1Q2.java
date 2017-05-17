/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author joshortiz
 */
package Ortiz_HW1Q2;

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class Ortiz_HW1Q2 {

    public static void main(String[] args) {

        //Sentinel Variable for the while loop
        Boolean DONE = new Boolean(false);
        System.out.println("Enter Strings to write to a text file. To finish type DONE: ");
        File myFile = new File("userStrings.txt");
        try {
            while (DONE != true) {
                PrintWriter toFile = new PrintWriter(myFile);
                Scanner scan = new Scanner(System.in);
                String input = scan.next(); // Creating the file to store our strings

                //Creating the PrintWriter object for writing strings to
                if (myFile.exists()) {

                    if (input.equals("DONE")) {
                        DONE = true;
                        toFile.close();
                        break;
                    }
                    toFile.println(input);

                }

            }    //Using scanner to read input from the user
        } catch (FileNotFoundException notFound) {
            System.out.println(notFound);
        }
    }

}
/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author joshortiz
 */
/*
package main;

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class Hw1q2 {

    public static void main(String[] args) throws FileNotFoundException {

        //Sentinel Variable for the while loop
        Boolean DONE = new Boolean(false);
        System.out.println("Enter Strings to write to a text file. To finish type DONE: ");
        String fileName = "userStrings.txt";

        try {
            File myFile = new File(fileName);
            PrintWriter outToFile = new PrintWriter(myFile);

            while (DONE != true) {

                Scanner scan = new Scanner(System.in);
                String input = scan.next(); // Creating the file to store our strings

                if (input.equals("DONE")) {
                    DONE = true;
                    outToFile.close();
                    break;
                } else {
                    outToFile.println(input);
                }
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("File Not Found");
        }
    }
}
 */
