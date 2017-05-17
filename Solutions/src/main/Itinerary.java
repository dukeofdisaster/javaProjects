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
import java.text.NumberFormat;

public class Itinerary {

    private TrainRoute t1;
    private TrainRoute t2;

    public Itinerary(TrainRoute first) {
        t1 = first;
        t2 = null;
    }

    public Itinerary(TrainRoute first, TrainRoute second) {
        t1 = first;
        t2 = second;
    }

    public TrainRoute getFirstTrainRoute() {
        return t1;
    }

    public TrainRoute getSecondTrainRoute() {
        return t2;
    }

    public boolean hasConnection() {
        if (t2 == null) {
            return false;
        } else {
            return true;
        }
    }

    public double getTotalCost() {
        double total = 0;

        if (t2 != null) {
            total = t1.getCost() + t2.getCost();
        } else {
            total = t1.getCost();
        }

        return total;
    }

    public Time getDeparture() {
        return t1.getDeparture();
    }

    public Time getArrival() {
        return t2.getArrival();
    }

    @Override
    public String toString() {
        String str = "";
        NumberFormat fmt1 = NumberFormat.getCurrencyInstance();
        str += "Total cost: " + fmt1.format(getTotalCost()) + "\n";
        str += t1.toDetailedString();
        if (t2 != null) {
            str += "\n" + t2.toDetailedString();
        }

        return str;
    }
}
