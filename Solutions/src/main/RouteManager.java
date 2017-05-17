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
import java.util.Arrays;

public class RouteManager {

    private TrainRoute[] trainRoutes;
    private int trainRouteCount;

    public RouteManager() {
        trainRoutes = new TrainRoute[1];
        trainRouteCount = 0;
    }

    public void addTrainRoute(TrainRoute newTrainRoute) {
        trainRouteCount++;
        if (trainRoutes.length == trainRouteCount) {
            increaseSize();
        }
        trainRoutes[trainRouteCount - 1] = newTrainRoute;
    }

    private void increaseSize() {

        TrainRoute[] temp = new TrainRoute[trainRoutes.length * 2];
        for (int i = 0; i < trainRouteCount; i++) {
            temp[i] = trainRoutes[i];
        }

        trainRoutes = temp;
    }

    public Itinerary[] findItineraries(TrainStation src,
            TrainStation dest, Time idealDeparture) {

        Itinerary[] trainRouteMatches = new Itinerary[100];

        searchOneTrainRouteItinerary(src, dest, idealDeparture, trainRouteMatches);

        return shrinkItineraries(trainRouteMatches);
    }

    private void searchOneTrainRouteItinerary(TrainStation src, TrainStation dst, Time depart,
            Itinerary[] itineraryArray) {

        int i = 0;
        boolean timeComparison;

        for (int j = 0; j < trainRouteCount; j++) {

            timeComparison = compareTimes(depart, trainRoutes[j].getDeparture());

            if ((trainRoutes[j].getSource()) == src && timeComparison) {
                if (trainRoutes[j].getDestination() == dst) {
                    itineraryArray[i] = new Itinerary(trainRoutes[j]);
                    i++;
                } else {
                    i = searchTwoTrainRoutesItinerary(trainRoutes[j], dst,
                            itineraryArray, i);
                }
            }
        }

    }

    private int searchTwoTrainRoutesItinerary(TrainRoute primaryTrainRoute, TrainStation dst,
            Itinerary[] itineraryArray, int trainRoutesIndex) {
        boolean timeComparison;

        for (int k = 0; k < trainRouteCount; k++) {

            Time newArrival = primaryTrainRoute.getArrival().getCopy();
            newArrival.addMinutes(10);
            timeComparison = compareTimes(newArrival, trainRoutes[k].getDeparture());

            if (primaryTrainRoute.getDestination() == trainRoutes[k].getSource() && trainRoutes[k].getDestination() == dst && timeComparison) {

                itineraryArray[trainRoutesIndex] = new Itinerary(primaryTrainRoute, trainRoutes[k]);
                trainRoutesIndex++;
            }
        }

        return trainRoutesIndex;
    }

    private boolean compareTimes(Time time1, Time time2) {

        if (time1.getHour() > time2.getHour()) {
            return false;
        } else if (time1.getMinute() > time2.getMinute()) {
            return false;
        } else {
            return true;
        }

    }

    private Itinerary[] shrinkItineraries(Itinerary[] itineraries) {
        int newSize = 0;
        for (int i = 0; i < itineraries.length; i++) {
            if (itineraries[i] != null) {
                newSize++;
            }
        }

        Itinerary[] newItinerary = new Itinerary[newSize];
        int newIndex = 0;
        for (int i = 0; i < itineraries.length; i++) {
            if (itineraries[i] != null) {
                newItinerary[newIndex] = itineraries[i];
                newIndex++;
            }
        }

        return newItinerary;
    }
}
