/**
 *
 * Program throws an ExtraneousStringException when any string > 30 is entered
 * and reads input from the console until the user enters DONE, then concatenates
 * the strings and displays the input to the console
 *
 * Completion time: approximately 2 hours
 *
 *
 *
 * @author Joshua Ortiz, Sylvia
 *
 * @version 1.2
 *
 */
package Ortiz_HW1;

import java.util.Scanner;

public class Ortiz_HW1Q1 {

    public static void main(String[] args) throws ExtraneousStringException {
        //Prompting the user for input
        System.out.println("Enter some strings and Press Enter.");
        System.out.println("The program will read input until DONE is entered:");

        // Simple string variable to store input and/or display later
        String all = "";

        // Sentinel variable for the while loop
        Boolean DONE = new Boolean(false);

        // While loop to continue reading input until the user enters DONE or
        // enters a string that is too long
        while (DONE != true) {
            Scanner input = new Scanner(System.in);
            String s = input.next();

            //IF statement to validate the input for length requirements
            if (s.length() > 30) {
                throw new ExtraneousStringException();

            }

            // Another to check if the user is done entering input
            if (s.equals("DONE")) {
                DONE = true;

                //If the user is then the loop will exit via the break statement
                // which will also not add the input 'DONE' to the all string
                break;
            }
            all += s;
        }

        System.out.println("You Entered: " + all);
    }

    static class ExtraneousStringException extends Exception {

        public ExtraneousStringException() {
            super("String too long");
        }
    }
}
