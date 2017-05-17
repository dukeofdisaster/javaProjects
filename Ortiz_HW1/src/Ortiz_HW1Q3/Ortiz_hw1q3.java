/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ortiz_HW1Q3;

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 *
 * @author joshortiz
 */
public class Ortiz_hw1q3 {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Enter the name of a java sourcefile to open: ");

        //Scanner object to get the input file name from the console.
        Scanner inputGetter = new Scanner(System.in);

        //Store the filename as a string so we can manipulate it
        String enteredFileName = inputGetter.next();

        // New file object of the enteredFileName
        File inFile = new File(enteredFileName);

        //New string object for the new file name  with added _.txt
        //I used the substring method, assuming the user would enter some file name with .java
        String outPutFileName = enteredFileName.substring(0, (enteredFileName.length() - 5)) + "_.txt";
        System.out.println(outPutFileName);

        //The line below would show as an error without the throws statement in the main class
        Scanner readFile = new Scanner(inFile);

        File outputFile = new File(outPutFileName);

        PrintWriter writesNew = new PrintWriter(outputFile);
        int lineCount = 0;
        while (readFile.hasNextLine()) {
            ++lineCount;
            String line = readFile.nextLine();
            writesNew.write(lineCount + line);
        }
        writesNew.close();
        readFile.close();
    }

}
