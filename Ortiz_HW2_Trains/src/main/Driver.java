/**
 *
 * Completion time: For total project was ~12 and probably an additional 1-2
 * hours over the course of the project commenting out and uncommenting out
 * sections to test the various classes.
 *
 *
 *
 * @author Joshua Ortiz, Barnai
 *
 * @version 1.0
 *
 */
package main;

public class Driver {

    public static void main(String[] args) {

        //Please note that these tests are not comprehensive.
        testTrainType();
        testTrainStation();
        testTrain();
        testTime();
        testTrainRoute();
    }

    public static void testTrainType() {
        System.out.println("==testTrainType()==");

        //Test 1: create enum variables
        TrainType t1 = TrainType.InterCity;
        TrainType t2 = TrainType.EuroCity;
        TrainType t3 = TrainType.EuroStar;
        TrainType t4 = TrainType.EuroCity;

        //Test 2: display and compare variables
        System.out.println("t1: " + t1);
        System.out.println("t2 == t3: " + (t1 == t2));
        System.out.println("t2 == t4: " + (t2 == t4));

    }

    public static void testTrainStation() {
        System.out.println("==testTrainStation()==");

        //Test 1: create enum variables
        TrainStation s1 = TrainStation.AMS;
        TrainStation s2 = TrainStation.BRU;
        TrainStation s3 = TrainStation.CDG;
        TrainStation s4 = TrainStation.DUS;
        TrainStation s5 = TrainStation.FRA;
        TrainStation s6 = TrainStation.LHR;
        TrainStation s7 = TrainStation.RWA;
        TrainStation s8 = TrainStation.VIE;

        //Test 2: display and compare variables
        System.out.println("s1: " + s1);
        System.out.println("s2 == s3: " + (s1 == s2));
        System.out.println("s2 == s4: " + (s2 == s4));
        System.out.println("s5 == s8: " + (s5 == s8));
        System.out.println("s1: " + TrainStation.getTrainStationCity(s1));
        System.out.println("s3: " + TrainStation.getTrainStationCity(s3));
        System.out.println("s5: " + TrainStation.getTrainStationCity(s5));
        System.out.println("s7: " + TrainStation.getTrainStationCity(s7));

    }

    public static void testTrain() {
        System.out.println("==testTrain()==");

        //Test 1: create train objects
        Train o1 = new Train(TrainType.EuroCity);
        Train o2 = new Train(TrainType.EuroStar);

        //Test 2: display train information.
        System.out.println(o1.getTrainType());
        System.out.println(o1);
        System.out.println(o2);
    }

    public static void testTime() {
        System.out.println("==testTime()==");

        //Test 1: use default constructor.
        Time t1 = new Time();

        //Test 2: use overloaded constructor.
        Time t2 = new Time(9, 0);
        Time t3 = new Time(1, 15);

        //Test 3: use clone operation.
        Time t4 = t3.getCopy();
        //Test 4: run toString on AM times.
        System.out.println(new Time(0, 5));
        System.out.println(new Time(1, 15));
        System.out.println(new Time(2, 45));
        System.out.println(new Time(10, 5));
        System.out.println(new Time(11, 15));
        //Test 5: run toString on PM times.
        System.out.println(new Time(12, 45));
        System.out.println(new Time(13, 5));
        System.out.println(new Time(22, 15));
        System.out.println(new Time(23, 45));

        //Test 6: run toString on object from default constructor.
        System.out.println("t1: " + t1);

        //Test 7: testing addTime operation
        System.out.println("t2: " + t2);
        t2.addTime(t3);
        System.out.println("t2: " + t2);
        //Test 8: testing addMinutes operation
        t2.addMinutes(181);
        System.out.println("t2: " + t2);
        //Test 9: testing8 addHours operation
        t2.addHours(2);
        System.out.println("t2: " + t2);

        //Test 10: testing cloned copy.
        t4.addHours(1);
        System.out.println("t3: " + t3);//original
        System.out.println("t4: " + t4);//clone

        //Test 11: testing isEarlierThan.
        System.out.println("t3 < t4: " + t3.isEarlierThan(t4));
        System.out.println("t4 < t3: " + t4.isEarlierThan(t3));
        System.out.println("t2 < t4: " + t2.isEarlierThan(t4));
        System.out.println("t4 < t2: " + t4.isEarlierThan(t2));
        System.out.println("t2 < t2: " + t2.isEarlierThan(t2));

        //Test 12: testing isLaterThan.
        System.out.println("t2 > t4: " + t2.isLaterThan(t4));
        System.out.println("t4 > t2: " + t4.isLaterThan(t2));
        System.out.println("t4 > t4: " + t4.isLaterThan(t4));

        //Test 13: testing isSameTime.
        System.out.println("t2 = t4: " + t2.isSameTime(t4));
        System.out.println("t4 = t4: " + t4.isSameTime(t4));
        System.out.println("t4 = 2:15AM: " + t4.isSameTime(new Time(2, 15)));
    }

    public static void testTrainRoute() {
        System.out.println("==testTrainRoute()==");

        //Test 1: create train routes using different settings
        TrainRoute r1 = new TrainRoute(new Train(TrainType.EuroStar),
                "495", 65,
                new Time(10, 50), 205,
                TrainStation.LHR, TrainStation.BRU);

        TrainRoute r2 = new TrainRoute(new Train(TrainType.InterCity),
                "79", 55,
                new Time(11, 5),
                201,
                TrainStation.DUS,
                TrainStation.AMS);

        TrainRoute r3 = new TrainRoute(new Train(TrainType.EuroStar),
                "400", 230,
                new Time(8, 20),
                135,
                TrainStation.LHR,
                TrainStation.CDG);

        TrainRoute r4 = new TrainRoute(new Train(TrainType.EuroCity),
                "775", 29,
                new Time(7, 10),
                673,
                TrainStation.FRA,
                TrainStation.RWA);

        TrainRoute r5 = new TrainRoute(new Train(TrainType.EuroCity),
                "59", 52,
                new Time(14, 50),
                270,
                TrainStation.RWA,
                TrainStation.VIE);

        System.out.println(r1.toDetailedString());
        System.out.println();
        System.out.println(r1.toOverviewString());

        System.out.println();
        System.out.println();

        System.out.println(r5.toDetailedString());
        System.out.println();
        System.out.println(r5.toOverviewString());

    }
}
