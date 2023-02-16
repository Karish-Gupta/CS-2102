import java.util.LinkedList;

/**
 * Defines a set of helper functions for the TodaysRatingsLL.
 * Hides the dataType of allRatings in RadioStation
 */
public interface ISet {

    int rankingOfSurveyIterator(int month, int year);

    int downloadsOfSurveyIterator(int month, int year);

    void addRating(TodaysRatings aRating);



    }
