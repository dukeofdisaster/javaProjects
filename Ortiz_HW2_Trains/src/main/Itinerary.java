/**
 *
 * Description: creates Itineraries of TrainRoute objects
 *
 * This class is compatible with the classes I submitted last week.
 *
 * Completion time: ~3 hours
 *
 *
 *
 * @author Joshua Ortiz
 *
 * @version 1.0
 *
 */
package main;

public class Itinerary extends TrainRoute {

    private TrainRoute first;
    private TrainRoute second;

    // 1. first constructor
    public Itinerary(TrainRoute t1) {
        first = t1;
        second = null;

    }

    // 2. Overloaded constructor
    public Itinerary(TrainRoute t1, TrainRoute t2) {
        first = t1;
        second = t2;
    }

    // 3. Accessor
    public TrainRoute getFirstTrainRoute() {
        return first;
    }

    // 4. Accessor
    public TrainRoute getSecondTrainRoute() {
        return second;
    }

    // 5. Check for connected trains
    public boolean hasConnection() {
        boolean connected = false;
        if ((first == null) || (second == null)) {
            connected = false;
        }
        if ((first != null) && (second != null)) {
            connected = true;
        }
        return connected;
    }

    // 6. returns total cost of all TrainRoutes in the Itnerary
    public double getTotalCost() {
        double total = 0;
        total += first.getCost();
        if ((second != null)) {
            total += second.getCost();
        }
        return total;
    }

    // 7. Returns the departure time of the first train
    @Override
    public Time getDeparture() {
        return first.getDeparture();
    }

    //8. returns arrival time of second train
    @Override
    public Time getArrival() {
        if (second == null) {
            return first.getArrival();
        } else {
            return second.getArrival();
        }
    }

    @Override
    public String toString() {
        String itineraryToString = "";
        int checkForNull = 0;
        if (second == null) {
            checkForNull += 1;
        } else {
            checkForNull = 0;
        }

        switch (checkForNull) {
            case 1:
                itineraryToString
                        = String.format("Total Cost: $%1$.2f\n%2$s", this.getTotalCost(), first.toDetailedString());
                break;
            case 0:
                itineraryToString
                        = String.format("Total Cost: $%1$.2f\n%2$s\n%3$s", this.getTotalCost(), first.toDetailedString(), second.toDetailedString());
        }
        return itineraryToString;
    }

}
