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
public class RouteManagerTest {

    RouteManager manager;

    public static void main(String[] args) {
        RouteManagerTest rmt = new RouteManagerTest();
        rmt.run();
    }

    public RouteManagerTest() {
        manager = new RouteManager();
        loadTrainRoutes();
    }

    public void run() {
        Itinerary[] itineraries = manager.findItineraries(TrainStation.LHR, TrainStation.FRA, new Time(8, 0));

        for (Itinerary i : itineraries) {
            System.out.println(i);
        }
    }

    private void loadTrainRoutes() {
        manager.addTrainRoute(new TrainRoute(new Train(TrainType.EuroStar),
                "495", 65,
                new Time(10, 50), 205,
                TrainStation.LHR, TrainStation.BRU));

        manager.addTrainRoute(new TrainRoute(new Train(TrainType.InterCity),
                "79", 55,
                new Time(11, 5),
                201,
                TrainStation.DUS,
                TrainStation.AMS));

        manager.addTrainRoute(new TrainRoute(new Train(TrainType.EuroStar),
                "400", 230,
                new Time(8, 20),
                135,
                TrainStation.LHR,
                TrainStation.CDG));

        manager.addTrainRoute(new TrainRoute(new Train(TrainType.EuroCity),
                "775", 29,
                new Time(7, 10),
                673,
                TrainStation.FRA,
                TrainStation.RWA));

        manager.addTrainRoute(new TrainRoute(new Train(TrainType.InterCity),
                "525", 320,
                new Time(12, 50),
                228,
                TrainStation.CDG,
                TrainStation.FRA));

        manager.addTrainRoute(new TrainRoute(new Train(TrainType.EuroCity),
                "59", 52,
                new Time(14, 50),
                270,
                TrainStation.RWA,
                TrainStation.VIE));
        manager.addTrainRoute(new TrainRoute(new Train(TrainType.EuroCity), "59", 52, new Time(9, 50), 300,
                TrainStation.LHR,
                TrainStation.FRA));
        System.out.println("added trainRoutes");
    }

}
