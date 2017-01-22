/**
 *
 * Train class has an instance variable that's a TrainType and its constructor
 * takes a TrainType enum value as an argument to set the initType to said value.
 * Initially there was some confusion with the constructor. I over-complicated
 * the process which resulted in a lot of wasted time.
 *
 *
 * Completion time: ~2 hours
 *
 *
 *
 * @author Joshua Ortiz
 *
 * @version 1.0
 *
 */
package main;

public class Train {

    private TrainType initType;

    public Train(TrainType x) {

        if (x == TrainType.EuroCity) {
            initType = TrainType.EuroCity;
        } else if (x == TrainType.EuroStar) {
            initType = TrainType.EuroStar;
        } else {
            initType = TrainType.InterCity; // recently removed.this from beginning

        }
    }

    public TrainType getTrainType() {
        return initType;
    }

    @Override
    public String toString() {

        if (initType == TrainType.EuroCity) {
            return "EuroCity*";
        } else if (initType == TrainType.EuroStar) {
            return "EuroStar*";
        } else {
            return "InterCity*";
        }
    }
}
