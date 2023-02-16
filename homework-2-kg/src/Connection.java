import java.util.LinkedList;

/**
 * An abstract clas that contains the linked list numberOfWordsWritten and daysOfLastUpdate.
 * Contains the shared method averagePerDay.
 * Is extended by PoemResult and WritingReult.
 */
public abstract class Connection {

    LinkedList<Double> numberOfWordsWritten;

    int dayOfLastUpdate;


    /**
     * Returns the total words written bt adding up all the doubles in the list
     * @return words
     */
    public double averagePerDay() {
        double words = 0;

        for (Double n : numberOfWordsWritten) {
            words = words + n;
        }

        if (numberOfWordsWritten == null) {
            return 0;
        } else {
            return words;
        }
    }
}
