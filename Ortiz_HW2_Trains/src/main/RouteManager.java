/**
 *
 * Description: Manages objects from the TrainRoute and Itinerary class
 *
 * This class is compatible with the classes I submitted last week. The findItineraries
 * class still needs debugging. There was lots of difficulty figuring out the logic
 * when trying to handle 2-train routes. In the end I was able to produce the
 * itineraries that matched in the RouteManagerTest, but I was unable to produce
 * an additional itinerary that I added to the RouteManagerTest class
 *
 * Completion time: 12+hours
 *
 *
 *
 * @author Joshua Ortiz
 *
 * @version 1.0
 *
 */
package main;

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

        TrainRoute[] startTrainsArray = new TrainRoute[100];
        int startTrainsCount = 0;
        TrainRoute[] endTrainsArray = new TrainRoute[100];
        int endTrainsCount = 0;

        TrainRoute startTrain = new TrainRoute();
        TrainRoute endTrain = new TrainRoute();
        int matchesFound = 0;

        //Loop to find 1-Train itineraries
        for (int i = 0; i < trainRouteCount; i++) {
            if (trainRoutes[i] != null) {
                Time leaving = trainRoutes[i].getDeparture();
                Time arriving = trainRoutes[i].getArrival();
                if ((trainRoutes[i].getSource() == src) && (trainRoutes[i].getDestination() == dest)) {
                    if (leaving.isLaterThan(idealDeparture)) {
                        potentialItineraries[matchesFound] = new Itinerary(trainRoutes[i]);
                        matchesFound += 1;
                    }
                }
            }
        }

        // Searches for Potential Start trains and saves them to an array
        for (TrainRoute x : trainRoutes) {
            if (x != null) {
                int loopCount = 0;
                if (x.getSource() == src
                        && (x.getDestination() != dest)
                        && ((x.getDeparture()).isLaterThan(idealDeparture))) {
                    System.out.println("Saved New Value to Start Train");
                    System.out.println(startTrainsCount);
                    startTrainsArray[startTrainsCount] = x;
                    startTrainsCount++;
                }
            }
        }
        //Searches for potential end trains and saves them to an array
        for (TrainRoute z : trainRoutes) {
            if (z != null) {
                if ((z.getSource() != src)
                        && (z.getDestination() == dest)) {
                    endTrainsArray[endTrainsCount] = z;
                    //System.out.println("New Value added to end Trian");
                    //}
                    endTrainsCount += 1;
                }
            }
        }

        for (TrainRoute xx : startTrainsArray) {
            if (xx != null) {
                for (TrainRoute yy : endTrainsArray) {
                    if (yy != null) {
                        if ((xx.getArrival()).isLaterThan(yy.getDeparture())
                                && (xx.getDestination() == yy.getSource())) {
                            potentialItineraries[matchesFound] = new Itinerary(xx, yy);
                            matchesFound += 1;
                        }
                    }
                }
            }
        }
        int foundRoutes = 0;
        for (TrainRoute xxx : trainRoutes) {
            if (xxx != null) {
                for (TrainRoute yyy : endTrainsArray) {
                    if (yyy != null) {

                        if ((xxx.getDestination() == yyy.getSource())) {
                            for (Itinerary x : potentialItineraries) {
                                if (x == null) {

                                    x = new Itinerary(xxx, yyy);
                                    foundRoutes++;
                                }
                            }
                        }
                    }
                }
            }
        }

        //}
        //System.out.println("StartTrains: " + startTrainsCount);
        System.out.println("EndTrains: " + endTrainsCount);
        Itinerary[] shrunkenMatches = shrinkItineraries(potentialItineraries);
        System.out.println("Matches Found " + matchesFound);
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
