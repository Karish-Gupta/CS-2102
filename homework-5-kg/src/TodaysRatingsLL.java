import java.util.GregorianCalendar;
import java.util.LinkedList;

/**
 * A list of ratings that implements ISet interface.
 */
public class TodaysRatingsLL implements ISet {

    private LinkedList<TodaysRatings> theRatings;

    TodaysRatingsLL(LinkedList<TodaysRatings> Ratings) {
        this.theRatings = Ratings;
    }


    /**
     * Iterates through a list of ratings and find the lowest integer (the highest ranking).
     * @param month
     * @param year
     * @return int
     */
    @Override
    public int rankingOfSurveyIterator(int month, int year) {
        int runningMin = -1;
        for (TodaysRatings rating : this.theRatings) {
            if (rating.compareMonth(month) && rating.compareYear(year)) {
                if (runningMin > rating.calcMinRank() || runningMin == -1) {
                    runningMin = rating.calcMinRank();
                }
            }
        }
        return runningMin;
    }

    /**
     * Iterates through a list of downloads and returns the total number of downloads.
     * @param month
     * @param year
     * @return int
     */
    @Override
    public int downloadsOfSurveyIterator(int month, int year) {
        int runningTotal = 0;
        for (TodaysRatings rating : this.theRatings) {
            if (rating.compareMonth(month) && rating.compareYear(year)) {
                if (runningTotal >= 0) {
                    runningTotal = runningTotal + rating.totalDownloads();
                }
            }
        }
        return runningTotal;
    }

    /**
     * Adds a rating to a list of ratings.
     * @param aRating
     */
    @Override
    public void addRating(TodaysRatings aRating){
        theRatings.add(aRating);
    }


}
