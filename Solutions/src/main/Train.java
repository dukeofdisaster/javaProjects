//TAKEN FROM SOLUTION SOURCE FILES
package main;

/**
 * Train class.
 *
 * @author Sylvia Barnai
 */
public class Train {

    TrainType trainType;

    public Train(TrainType trainType) {
        this.trainType = trainType;
    }

    public TrainType getTrainType() {
        return this.trainType;
    }

    @Override
    public String toString() {
        return this.trainType + " * ";
    }

}
