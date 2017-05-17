/**
 *
 * This program reads user input from the console then writes it to a .txt file
 * and stores that file in the working directory. I used a default file name for
 * the code below but it could easily be modified to read input from the user to
 * create the file name.
 *
 * Completion time: approximately 3 hours
 *
 *
 *
 * @author Joshua Ortiz, Sylvia
 *
 * @version 1.2
 *
 */
package main;

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class Ortiz_HW01Q2 {

    public static void main(String[] args) throws FileNotFoundException {

        //Sentinel Variable for the while loop
        Boolean DONE = new Boolean(false);

        //Prompt the user for input by printing to the console; notify the user
        // of the exit input 'DONE'
        System.out.println("Enter Strings to write to a text file. To finish type DONE: ");

        //default filename; could alternatively read input from console to have
        // user-defined filename.
        String fileName = "userStrings.txt";

        try {
            //instance of a new file object
            File myFile = new File(fileName);
            PrintWriter outToFile = new PrintWriter(myFile);

            //While loop to read input from the user to store in the text file
            while (DONE != true) {

                Scanner scan = new Scanner(System.in);

                //we store the the input from the scanner into a string variable
                String input = scan.next();

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
