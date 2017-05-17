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
public class IteneraryTest {

    public static void main(String[] args) {
        TrainRoute t1 = new TrainRoute(new Train(TrainType.EuroCity),
                "400", 230,
                new Time(8, 20),
                135,
                TrainStation.LHR,
                TrainStation.CDG);

        TrainRoute t2 = new TrainRoute(new Train(TrainType.InterCity),
                "525", 320,
                new Time(12, 50),
                228,
                TrainStation.CDG,
                TrainStation.FRA);

        Itinerary i1 = new Itinerary(t1);
        Itinerary i2 = new Itinerary(t1, t2);

        System.out.println(i1);
        System.out.println();
        System.out.println(i2);
    }

}
