import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.GregorianCalendar;

/**
 * Contains a LinkedList of rankings and a LinkedList of downloads and a date. Today's ratings for a band.
 */
public class TodaysRatings {

    private GregorianCalendar date;

    private LinkedList<Integer> rankingsOfSurveys;

    private LinkedList<Integer> downloadsOfSurveys;


    // Constructing a date for daily ratings

    public TodaysRatings(GregorianCalendar date, LinkedList<Integer> rankingsOfSurveys, LinkedList<Integer> downloadsOfSurveys) {
        this.date = date;
        this.rankingsOfSurveys = rankingsOfSurveys;
        this.downloadsOfSurveys = downloadsOfSurveys;

    }

    /**
     * Compares a TodaysRating month with a given month.
     * @param month
     * @return boolean
     */
    public boolean compareMonth(int month) {
        return this.date.get(GregorianCalendar.MONTH) == month;
    }

    /**
     * Compares months of two TodaysRatings objects.
     * @param rating
     * @return boolean
     */
    public boolean compareMonth(TodaysRatings rating) {
        return this.date.get(GregorianCalendar.MONTH) == rating.date.get(GregorianCalendar.MONTH);
    }

    /**
     * Compares year of a TodaysRating object and a given year.
     * @param year
     * @return boolean
     */
    public boolean compareYear(int year) {
        return this.date.get(GregorianCalendar.YEAR) == year;
    }

    /**
     * Compares year of a TodaysRating object and another TodaysRating object year.
     * @param rating
     * @return
     */
    public boolean compareYear(TodaysRatings rating) {
        return this.date.get(GregorianCalendar.YEAR) == rating.date.get(GregorianCalendar.YEAR);
    }


    /**
     * Iterates through a list of downloads and sums total number of downloads.
     * @return int
     */
    public int totalDownloads() {
        int downloads = 0;
        for (int adownload : this.downloadsOfSurveys) {
            downloads = downloads + adownload;
        }
        return downloads;
    }

    /**
     * Iterates through a list of rankings and finds the minimum ranking (the highest ranking).
     * @return int
     */
    public int calcMinRank() {
        int LowestRank = -1;
        for(int rank : this.rankingsOfSurveys) {
            if (LowestRank == -1 || rank < LowestRank) {
                LowestRank = rank;
            }
        }
        return LowestRank;
    }


}
