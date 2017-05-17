/**
 *
 * Description:
 *
 * Completion time: approximately 4 hours
 *
 *
 *
 * @author Joshua Ortiz
 *
 * @version 1.0
 *
 */
package main;

public class TrainRoute {

    private Train train;
    private String number;
    private double cost;
    private Time departure;
    private int duration = 0;
    private TrainStation source;
    private TrainStation destination;

    //Constructor 1
    public TrainRoute() {

    }

    public TrainRoute(Train t, String trainNumber, double routeCost,
            Time departureTime, int durationTime, TrainStation sourceTrainStation,
            TrainStation destinationTrainStation) {
        train = t;
        number = trainNumber;
        cost = routeCost;
        departure = departureTime;
        duration = durationTime;
        source = sourceTrainStation;
        destination = destinationTrainStation;

    }

    //Method1.
    public Train getTrain() {
        return this.train;
    }

    //Method 2.
    public String getNumber() {
        return this.number;

    }

    // Method 3.
    public double getCost() {
        return this.cost;

    }

    //Method 4.
    public TrainStation getDestination() {
        return this.destination;
    }

    //Method 5.
    public Time getDeparture() {
        return departure;

    }

    //Method 6.
    public Time getArrival() {
        departure.addMinutes(duration);
        return departure;

    }

    //Method 7.
    public TrainStation getSource() {
        return source;

    }

    public int getDurationHour() {
        int durationHour = duration / 60;
        return durationHour;
    }

    public double getDurationMinute() {
        double durationMinute = duration % 60;
        return durationMinute;
    }

    //Method 8.
    public String toOverviewString() {
        String formattedOverviewString = String.format("%1$s - %2$s\n%3$s (%4$s) - %5$s (%6$s)\n%7$s %8$s", departure.toString(),
                getArrival(), TrainStation.getTrainStationCity(source), source,
                TrainStation.getTrainStationCity(destination), destination, train.getTrainType(), number);
        return formattedOverviewString;
    }

    //Method 9.
    public String toDetailedString() {
        String formattedDetailedString = String.format("$%1$.2f \n%2$s - %3$s\t%4$sh:%5$sm\n%6$s\t\t%7$s-%8$s",
                getCost(), departure.toString(), getArrival(), (duration / 60), (duration % 60), train.getTrainType(), source, destination);
        return formattedDetailedString;

    }
}
