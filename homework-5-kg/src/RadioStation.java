import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

/**
 * A radio station that has a date and a collection of allRatings of type ISet.
 */
public class RadioStation {

    private GregorianCalendar date;

    private ISet allRatings;


    public RadioStation(GregorianCalendar date, ISet allRatings) {
        this.date = date;
        this.allRatings = allRatings;
    }


    // Methods

    /**
     * This returns the smallest rank this month or the highest ranking that the band received.
     * @return int
     */
    public int bestRankThisMonth() {

        return allRatings.rankingOfSurveyIterator(this.date.get(GregorianCalendar.MONTH), this.date.get(GregorianCalendar.YEAR));
    }

    /**
     * This takes in a month and year and then sums all the downloads that occurred during that timeframe.
     * @param month
     * @param year
     * @return int
     */
    public int totalSongDownloads(int month, int year) {
        return allRatings.downloadsOfSurveyIterator(month, year);
    }


    /**
     * Takes in a list of surveys and creates a new TodaysRatings object and adds it to the allRatings list.
     * Then adds 1 to the current date.
     * @param surveyLinkedList
     */
    public void addTodaysSurveys(LinkedList<Survey> surveyLinkedList) {
        LinkedList<Integer> currentListOfRanks = new LinkedList<Integer>();
        LinkedList<Integer> currentListOfDownloads = new LinkedList<Integer>();

        for (Survey survey : surveyLinkedList) {
            currentListOfRanks.add(survey.surveyRank());
            currentListOfDownloads.add(survey.surveyDownloads());
        }

        allRatings.addRating(new TodaysRatings(new GregorianCalendar(date.get(GregorianCalendar.YEAR), date.get(GregorianCalendar.MONTH), date.get(GregorianCalendar.DAY_OF_MONTH) + 1), currentListOfRanks, currentListOfDownloads));
        this.date = new GregorianCalendar(date.get(GregorianCalendar.YEAR), date.get(GregorianCalendar.MONTH), date.get(GregorianCalendar.DAY_OF_MONTH) + 1);
    }


    /**
     * Gets the day of the month from a radioStation object.
     * @return int
     */
    public int getDate() {
        return this.date.get(GregorianCalendar.DAY_OF_MONTH);
    }

}


/*
//What might be a better data structure than a LinkedList<TodaysRatings> to encapsulate? Why?

I believe a binary tree would be a good alternative to using the LinkedList data structure. This is because we could
organize the tree as a heap. We could have the lower values as the higher nodes and
the values would increase down each branch or they would be the same value. This would be simple to encapsulate because we
could simply call public recursive methods into the RadioStation class. We would use recursion to search for the lowest rank or
accumulate the number of downloads.

//How would you implement your interface's methods using this data structure instead of the linked list?

We would create a new class for binary tree and have its methods stored there. Since the datatype of allRatings is already
hidden behind the interface, ISet, we can just implement ISet in the new class we create for binary trees.


Do you think it is possible to implement that class without modifying the interface? Why or why not?

Our interface is currently specialized to work with LinkedLists as the functions are helper functions that work best for this datatype.
So, I believe with the current methods defined in the ISet interface, it is not possible to implement the class without modifying the interface.
Additionally, we may need to add more helper methods that are specialized for recursion instead of LinkedList methods.


 */

