/**
 * The TrainStation class.
 *
 * @author Sylvia Barnai
 */
package main;

public enum TrainStation {
    AMS,
    BRU,
    CDG,
    DUS,
    FRA,
    LHR,
    RWA,
    VIE;

    public static String getTrainStationCity(TrainStation trainStation) {

        switch (trainStation) {
            case AMS:
                return "Amsterdam";

            case BRU:
                return "Brussels";

            case CDG:
                return "Paris";

            case DUS:
                return "Dusseldorf";

            case FRA:
                return "Frankfurt";

            case LHR:
                return "London";

            case RWA:
                return "Warsaw";

            case VIE:
                return "Vienna";

            default:
                return "Unknown City";

        }
    }

}
