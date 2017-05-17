/*
 * Description: Vehicle class demonstrates comparing of class objects by
 * implementing the comparable interface
 *
 *

 * Completion Time: ~2hrs
 *
 * Version: 1.0
 *
 */
package main;

/**
 *
 * @author joshortiz
 */
import java.util.Scanner;

public class Vehicle implements Comparable<Vehicle> {

    private String make = "";

    public Vehicle(String s) {
        make = s;

    }

    public String getMake() {
        return make;
    }

    @Override
    //Returns 0 if the objects are equal, positive integer if otherVehicle precedes
    // the vehicle lexicographically. Returns negative integer if otherVehicle follows
    // the vehicle lexicographically.
    public int compareTo(Vehicle otherVehicle) throws NullPointerException {

        if (make.equals(otherVehicle.getMake())) {
            return 0;
        } else {
            return make.compareTo(otherVehicle.getMake());
        }

    }

    @Override
    public String toString() {
        return ("Make: " + make);
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Vehicle[] enteredVehicles = new Vehicle[8];
        boolean DONE = false;
        int fullCount = 0;

        //Ask for input 8 times or until an empty string is entered
        while (DONE != true) {
            for (int i = 0; i < 8; i++) {

                System.out.print("Enter the make of a vehicle: ");

                String s = in.nextLine();
                if (s.equals("")) {
                    DONE = true;
                    break;
                } else {
                    enteredVehicles[i] = new Vehicle(s);

                }
                fullCount++;
            }
            if (fullCount == 8) {
                DONE = true;
            }
        }
        //int checkLength = 0;

        // testing for empty objects.
        // for (int j = 0; j < enteredVehicles.length - 1; j++) {
        //    if (enteredVehicles[j] != null) {
        //        checkLength++;
        //    }
        //
        //}
        //
        //System.out.println(checkLength);
        //Subtract 1 from check length since the count == number of actual objects
        // but index count starts at 0;
        //checkLength -= 1;
        Vehicle first = enteredVehicles[0];
        Vehicle last = enteredVehicles[0];

        //Get the first vehicle
        for (Vehicle x : enteredVehicles) {
            if (x != null) {
                if (first.compareTo(x) > 0) {
                    first = x;
                }
            }
        }

        //Get the last vehicle
        for (Vehicle x : enteredVehicles) {
            if (x != null) {
                if (last.compareTo(x) < 0) {
                    last = x;
                }
            }
        }
        System.out.println("First: " + first);
        System.out.println("Last: " + last);

    }
}
