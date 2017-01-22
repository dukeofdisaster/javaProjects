/**
 *
 * creates a smart enum for use in other areas of the program. Initially there
 * was some confusion with the switch/case statement which was sorted out once I
 * figured out that both return and break will exit the case. THe most time
 * consuming part of the smart enum was figuring out the abbreviations for the
 * cities.
 *
 * Completion time: ~1 hour
 *
 *
 *
 * @author Joshua Ortiz
 *
 * @version 1.0
 *
 */
package main;

/**
 *
 * @author joshortiz
 */
public enum TrainStation {

    AMS,
    BRU,
    CDG,
    DUS,
    FRA,
    LHR,
    RWA,
    VIE;

    public static String getTrainStationCity(TrainStation city) {
        String location;

        switch (city) {
            case AMS:
                location = "Amsterdam";
                break;
            case BRU:
                location = "Brussels";
                break;
            case CDG:
                location = "Charles de Gaulle";
                break;
            case DUS:
                location = "Dusseldorf";
                break;
            case FRA:
                location = "France";
                break;
            case LHR:
                location = "London Heathrow";
                break;
            case RWA:
                location = "Warsaw";
                break;
            case VIE:
                location = "Vienna";
                break;
            default:
                location = "Unknown City";
                break;
        }

        return location;

    }
}
