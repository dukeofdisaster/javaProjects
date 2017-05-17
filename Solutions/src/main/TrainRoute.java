// Taken from SOLUTION SOURCE FILES
/**
 * TrainRoute class.
 *
 * @ Sylvia Barnai
 *
 */
package main;

import java.text.NumberFormat;

public class TrainRoute {

    Train train;
    String trainNumber;
    double routeCost;
    Time departureTime;
    int durationTime;
    TrainStation sourceTrainStation;
    TrainStation destinationTrainStation;

    public TrainRoute(Train train, String trainNumber, double routeCost, Time departureTime, int durationTime,
            TrainStation sourceTrainStation, TrainStation destinationTrainStation) {
        this.train = train;
        this.trainNumber = trainNumber;
        this.routeCost = routeCost;
        this.departureTime = departureTime;
        this.durationTime = durationTime;
        this.sourceTrainStation = sourceTrainStation;
        this.destinationTrainStation = destinationTrainStation;
    }

    public Train getTrain() {
        return train;
    }

    public String getNumber() {
        return trainNumber;
    }

    public double getCost() {
        return routeCost;
    }

    public TrainStation getDestination() {
        return this.destinationTrainStation;
    }

    public Time getDeparture() {
        return departureTime;
    }

    public Time getArrival() {
        Time arrivalTime = new Time(departureTime.getHour(), departureTime.getMinute());
        arrivalTime.addMinutes(durationTime);
        return arrivalTime;
    }

    public TrainStation getSource() {
        return this.sourceTrainStation;
    }

    public String toOverviewString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        String output = nf.format(routeCost) + "\n" + getDeparture() + " - ";
        output += getArrival() + "\t" + durationTime / 60 + "h:" + durationTime % 60 + "m";
        output += "\n" + train.getTrainType() + "\t\t" + sourceTrainStation + "-" + destinationTrainStation;
        return output;
    }

    public String toDetailedString() {
        String output
                = getDeparture() + " - " + getArrival() + "\n" + TrainStation.getTrainStationCity(sourceTrainStation) + " ("
                + sourceTrainStation + ") - " + TrainStation.getTrainStationCity(destinationTrainStation) + " (" + destinationTrainStation + ")"
                + "\n" + train.getTrainType() + " " + trainNumber;
        return output;

    }

}
