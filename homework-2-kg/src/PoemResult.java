import java.util.LinkedList;

/**
 * A poem result with a date of the last of the last update,
 * a number of words written as a list, and a number of poems submitted.
 */
public class PoemResult extends Connection implements IChallenge {
    LinkedList<Double> numberOfWordsWritten =  new LinkedList<Double>();
    int dayOfLastUpdate;
    int poemsSubmitted;

    PoemResult(double poemResultListDoub, int mostRecentDay, int poemsSubmitted) {
        this.numberOfWordsWritten.add(poemResultListDoub);
        this.dayOfLastUpdate = mostRecentDay;
        this.poemsSubmitted = poemsSubmitted;
    }

    /**
     * Adds the number of words to the linked list of number of words written.
     * Increases the int describing how many weeks have had a submitted poem by one if the boolean parameter is true.
     * @param aNumberOfWords
     * @param submitted
     * @return PoemResult
     */
    public PoemResult nextPoem(double aNumberOfWords, boolean submitted) {
        numberOfWordsWritten.add(aNumberOfWords);
        if (submitted) {
            this.poemsSubmitted = this.poemsSubmitted + 1;
        }
        return this;

    }

    /**
     * Returns the total words written bt adding up all the doubles in the list
     * @return words / dayOfLastUpdate
     */
    public double averagePerDay() {
        double words = 0;

        for (Double n : numberOfWordsWritten) {
            words = words + n;
        }

        if (numberOfWordsWritten == null) {
            return 0;
        } else {
            return words / dayOfLastUpdate;
        }
    }


    /**
     * Calculates the difference from goal using the wordsPerDay
     * @return wordsPerDay
     */
    public double differenceFromGoal() {
        double wordsPerDay = 0;
        double words = 0;

        for (Double n : numberOfWordsWritten) {
            words = words + n;
        }

        if (poemsSubmitted > 0) {
            double tempWordsPerDay = words / poemsSubmitted;
            wordsPerDay = (tempWordsPerDay * (4 - poemsSubmitted)) / (31 - dayOfLastUpdate + 1);
        }

        else if (poemsSubmitted == 0) {
            double tempWordsPerDay = words / 1;
            wordsPerDay = (tempWordsPerDay * (4 - poemsSubmitted)) / (31 - dayOfLastUpdate + 1);
        }

        return wordsPerDay;
    }

}

