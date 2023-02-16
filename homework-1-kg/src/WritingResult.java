import java.util.LinkedList;

/**
 * A writing result that has a number of days for the last update and a list of number of words written.
 */
public class WritingResult extends Connection implements IChallenge {

    LinkedList<Double> numberOfWordsWritten = new LinkedList<Double>();
    int dayOfLastUpdate;

    //Constructor
    WritingResult(double numberOfWordsWrittenDoub, int dayOfLastUpdate) {
        this.numberOfWordsWritten.add(numberOfWordsWrittenDoub);
        this.dayOfLastUpdate = dayOfLastUpdate;
    }


    /**
     * Returns the total words written bt adding up all the doubles in the list
     * @return words
     */
    public double averagePerDay() {
        double words = 0;

        for ( Double n : numberOfWordsWritten) {
            words = words + n;
        }

        if ( numberOfWordsWritten == null ){
            return 0;
        }

        else{
            return words / dayOfLastUpdate;
        }
    }


    /**
     * Uses the averagePerDay and divides by the final update day to obtain the difference from goal of 50,000 words
     * @return double
     */
    public double differenceFromGoal() {

        return ((50000 - numberOfWordsWritten.size()) / (30 - this.dayOfLastUpdate + 1));
    }


    /**
     * This takes in a chapter value of type double and adds it to the writingResultList
     * @param chapter
     * @return WritingResult
     */
    public WritingResult nextChapter(double chapter) {
        numberOfWordsWritten.add(chapter);
        return this;

    }

}
