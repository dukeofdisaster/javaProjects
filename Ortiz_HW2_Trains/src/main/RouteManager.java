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
public class RouteManager {

    private TrainRoute[] trainRoutes = new TrainRoute[100];
    private int trainRouteCount;

    public RouteManager() {
        trainRoutes = new TrainRoute[100];
        trainRouteCount = 0;

    }

    public void addTrainRoute(TrainRoute newTrainRoute) {
        trainRoutes[trainRouteCount] = newTrainRoute;
        trainRouteCount++;
    }

    private void increaseSize() {
        int size = trainRoutes.length;
        size *= 2;
    }

    public Itinerary[] findItineraries(TrainStation src, TrainStation dest, Time idealDeparture) {
        Itinerary[] potentialItineraries = new Itinerary[100];
        TrainRoute startTrain = new TrainRoute();
        TrainRoute endTrain = new TrainRoute();
        for (int i = 0; i < trainRouteCount; i++) {
            if (trainRoutes[i] != null) {
                Time leaving = trainRoutes[i].getDeparture();
                Time arriving = trainRoutes[i].getArrival();
                if ((trainRoutes[i].getSource() == src) && (trainRoutes[i].getDestination() == dest)) {
                    if (leaving.isLaterThan(idealDeparture)) {
                        potentialItineraries[i] = new Itinerary(trainRoutes[i]);
                    }
                }
            }
        }

        for (TrainRoute x : trainRoutes) {

            if (x != null) {
                int loopCount = 0;
                if (x.getSource() == src
                        && (x.getDestination() != dest)
                        && ((x.getDeparture()).isLaterThan(idealDeparture))) {
                    startTrain = x;
                    System.out.println("Saved New Value to Start Train");
                }
                if ((x.getSource() != src)
                        && (x.getDestination() == dest)
                        && ((x.getDeparture()).isLaterThan(startTrain.getArrival()))) {
                    endTrain = x;
                }
                potentialItineraries[loopCount] = new Itinerary(startTrain, endTrain);
                loopCount += 1;
            }
        }

        Itinerary[] shrunkenMatches = shrinkItineraries(potentialItineraries);
        return shrunkenMatches;

    }

    private Itinerary[] shrinkItineraries(Itinerary[] itineraries) {
        int nullCount = 0;
        for (int x = 0; x < itineraries.length; x++) {
            if (itineraries[x] == null) {
                nullCount++;
            }
        }
        int full;
        Itinerary[] shrunkenArray = new Itinerary[(itineraries.length - nullCount)];
        for (int arraysize = 0; arraysize < shrunkenArray.length; arraysize++) {
            if (itineraries[arraysize] != null) {
                shrunkenArray[arraysize] = itineraries[arraysize];

            }
        }
        return shrunkenArray;

    }

}
