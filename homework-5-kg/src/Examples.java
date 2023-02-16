import org.junit.Test;
import sun.awt.image.ImageWatched;
import static org.junit.Assert.*;
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class Examples {

    public Examples() {
        //Add surveys to surveyList1
        surveyList1.add(survey1);
        surveyList1.add(survey2);
        surveyList1.add(survey3);
        surveyList1.add(survey4);
        surveyList1.add(survey5);

        //Add survey rankings1
        rankingsOfSurveys1.add(survey1.surveyRank());
        rankingsOfSurveys1.add(survey2.surveyRank());
        rankingsOfSurveys1.add(survey3.surveyRank());
        rankingsOfSurveys1.add(survey4.surveyRank());
        rankingsOfSurveys1.add(survey5.surveyRank());

        //Add survey downloads1
        downloadsofsurvey1.add(survey1.surveyDownloads());
        downloadsofsurvey1.add(survey2.surveyDownloads());
        downloadsofsurvey1.add(survey3.surveyDownloads());
        downloadsofsurvey1.add(survey4.surveyDownloads());
        downloadsofsurvey1.add(survey5.surveyDownloads());

        //Add surveys to surveyList2
        surveyList2.add(survey6);
        surveyList2.add(survey7);
        surveyList2.add(survey8);
        surveyList2.add(survey9);
        surveyList2.add(survey10);

        //Add survey rankings1
        rankingsOfSurveys2.add(survey6.surveyRank());
        rankingsOfSurveys2.add(survey7.surveyRank());
        rankingsOfSurveys2.add(survey8.surveyRank());
        rankingsOfSurveys2.add(survey9.surveyRank());
        rankingsOfSurveys2.add(survey10.surveyRank());

        //Add survey downloads1
        downloadsofsurvey2.add(survey6.surveyDownloads());
        downloadsofsurvey2.add(survey7.surveyDownloads());
        downloadsofsurvey2.add(survey8.surveyDownloads());
        downloadsofsurvey2.add(survey9.surveyDownloads());
        downloadsofsurvey2.add(survey10.surveyDownloads());


        //Adding TodaysRatings to TodaysRatingLL
        allRatingsLL1.addRating(todaysRatings1);
        allRatingsLL1.addRating(todaysRatings2);

        allRatingsLL2.addRating(todaysRatings1);



    }

    //GregorianCalendar

    GregorianCalendar date0 = new GregorianCalendar(2017, 0, 28);
    GregorianCalendar date1 = new GregorianCalendar(2016, 11, 17);
    GregorianCalendar date2 = new GregorianCalendar(2017, 0, 28);
    GregorianCalendar date3 = new GregorianCalendar(2018, 5, 3);
    GregorianCalendar date4 = new GregorianCalendar(2019, 7, 9);


    //Surveys

    Survey survey1 = new Survey(4, 6);
    Survey survey2 = new Survey(3, 9);
    Survey survey3 = new Survey(9, 2);
    Survey survey4 = new Survey(7, 4);
    Survey survey5 = new Survey(2, 20);


    Survey survey6 = new Survey(6, 20);
    Survey survey7 = new Survey(3, 7);
    Survey survey8 = new Survey(25, 6);
    Survey survey9 = new Survey(82, 9);
    Survey survey10 = new Survey(1, 10);

    //LinkedList of Surveys
    LinkedList<Survey> surveyList1 = new LinkedList<Survey>();
    LinkedList<Survey> surveyList2 = new LinkedList<Survey>();



    //TodaysRatings
    LinkedList<Integer> rankingsOfSurveys1 = new LinkedList<Integer>();
    LinkedList<Integer> downloadsofsurvey1 = new LinkedList<Integer>();
    TodaysRatings todaysRatings1 = new TodaysRatings(date2, rankingsOfSurveys1, downloadsofsurvey1);



    LinkedList<Integer> rankingsOfSurveys2 = new LinkedList<Integer>();
    LinkedList<Integer> downloadsofsurvey2 = new LinkedList<Integer>();
    TodaysRatings todaysRatings2 = new TodaysRatings(date3, rankingsOfSurveys2, downloadsofsurvey2);


    //Initializing radioStation1
    LinkedList<TodaysRatings> allRatingsList = new LinkedList<>();
    TodaysRatingsLL allRatingsLL1 = new TodaysRatingsLL(allRatingsList);
    RadioStation radioStation1 = new RadioStation(date1, allRatingsLL1);


    //Initializing radioStation2
    LinkedList<TodaysRatings> allRatingsList2 = new LinkedList<>();
    TodaysRatingsLL allRatingsLL2 = new TodaysRatingsLL(allRatingsList2);
    RadioStation radioStation2 = new RadioStation(date0, allRatingsLL2);


    //Initializing radioStation3
    LinkedList<TodaysRatings> allRatingsList3 = new LinkedList<>();
    TodaysRatingsLL allRatingsLL3 = new TodaysRatingsLL(allRatingsList3);
    RadioStation radioStation3 = new RadioStation(date4, allRatingsLL3);


    //Helper tests

    //CompareMonth test
    @Test
    public void CheckCompareMonthTrue() {
        assertTrue(todaysRatings1.compareMonth(0));
    }
    @Test
    public void CheckCompareMonthFalse() {
        assertFalse(todaysRatings1.compareMonth(1));
    }
    @Test
    public void CheckCompareMonthV2() {
        assertTrue(todaysRatings1.compareMonth(todaysRatings1));
    }


    //CompareYear
    @Test
    public void CheckCompareYearTrue() {
        assertTrue(todaysRatings1.compareYear(2017));
    }
    @Test
    public void CheckCompareYearFalse() {
        assertFalse(todaysRatings1.compareYear(2016));
    }
    @Test
    public void CheckCompareYearV2() {
        assertTrue(todaysRatings1.compareYear(todaysRatings1));
    }

    //TotalDownloads
    @Test
    public void CheckTotalDownloads() {
        assertEquals(todaysRatings1.totalDownloads(), 41, 0.05);
    }

    //CalcMinRank
    @Test
    public void CheckCalcMinRank() {
        assertEquals(todaysRatings1.calcMinRank(), 2, 0.05);
    }


    //RankingOfSurveyIterator

    @Test
    public void CheckRankingOfSurveyIteratorTodaysRating1() {
        assertEquals(allRatingsLL1.rankingOfSurveyIterator(0, 2017), todaysRatings1.calcMinRank(), 0.05);
    }

    @Test
    public void CheckRankingOfSurveyIteratorTodaysRatings2() {
        assertEquals(allRatingsLL1.rankingOfSurveyIterator(5, 2018), todaysRatings2.calcMinRank(), 0.05);
    }

    @Test
    public void CheckRankingOfSurveyIteratorNotEquals() {
        assertNotEquals(allRatingsLL1.rankingOfSurveyIterator(0, 2019), todaysRatings1.calcMinRank(), 0.05);
    }


    //DownloadsOfSurveyIterator

    @Test
    public void CheckDownloadsOfSurveyIteratorTodaysRatings1() {
        assertEquals(allRatingsLL1.downloadsOfSurveyIterator(0, 2017), todaysRatings1.totalDownloads(), 0.05);
    }

    @Test
    public void CheckDownloadsOfSurveyIteratorTodaysRatings2() {
        assertEquals(allRatingsLL1.downloadsOfSurveyIterator(5, 2018), todaysRatings2.totalDownloads(), 0.05);
    }


    //AddRating

    @Test
    public void CheckAddRating() {
        assertEquals(allRatingsList.size(), 2, 0.05);
    }

    @Test
    public void CheckAddRatingNone() {
        assertEquals(allRatingsList2.size(), 1, 0.05);
    }


    //BestRankThisMonth

    @Test
    public void CheckBestRankThisMonthEquals() {
        assertEquals(radioStation2.bestRankThisMonth(), 2, 0.05);
    }

    @Test
    public void CheckBestRankThisMonthNotEquals() {
        assertNotEquals(radioStation1.bestRankThisMonth(), 2, 0.05);
    }


    //TotalSongDownloads

    @Test
    public void CheckTotalSongDownloadsTodaysRatings1() {
        assertEquals(radioStation1.totalSongDownloads(0, 2017), 41, 0.05);
    }

    @Test
    public void CheckTotalSongDownloadTodaysRatings2() {
        assertEquals(radioStation1.totalSongDownloads(5, 2018), 52, 0.05);
    }

    @Test
    public void CheckTotalSongDownloadsRadioStation2() {
        assertEquals(radioStation2.totalSongDownloads(0, 2017), 41, 0.05);
    }

    @Test
    public void CheckTotalSongDownloadsWrongDate() {
        assertNotEquals(radioStation1.totalSongDownloads(0, 2019), 41, 0.05);
    }

    //AddTodaysSurveys
    //Here I am running my previous functions on RadioStation3. I know that this method is working correctly
    //when my expected values match the actual values of these tests.
    //By running these tests I am making sure that the new TodaysRating object is being added to the radioStation3 object.

    @Test
    public void CheckAddTodaysSurveys_BestRankThisMonth() {
        radioStation3.addTodaysSurveys(surveyList1);

        assertEquals(radioStation3.bestRankThisMonth(), 2, 0.05);
    }

    @Test
    public void CheckAddTodaysSurveys_BestRankThisMonthNotEquals() {
        radioStation3.addTodaysSurveys(surveyList1);

        assertNotEquals(radioStation3.bestRankThisMonth(), 5, 0.05);
    }

    @Test
    public void CheckAddTodaysSurvey_TotalSongDownloads() {
        radioStation3.addTodaysSurveys(surveyList1);

        assertEquals(radioStation3.totalSongDownloads(7, 2019), 41, 0.05);
    }

    @Test
    public void CheckAddTodaysSurvey_TotalSongDownloadsNotEquals() {
        radioStation3.addTodaysSurveys(surveyList1);

        assertNotEquals(radioStation3.totalSongDownloads(7, 2020), 41, 0.05);
    }

    //Since both of the above methods work, we know that the onject is being properly
    //created and added to the radioStation3 object.


    @Test
    public void CheckAddTodaysSurvey_Date() {
        radioStation3.addTodaysSurveys(surveyList1);

        assertEquals(radioStation3.getDate(), 10);
    }

    @Test
    public void CheckAddTodaysSurvey_DateNotEqual() {
        radioStation3.addTodaysSurveys(surveyList1);

        assertNotEquals(radioStation3.getDate(), 9);
    }

    //The above two functions show that the date was increased by 1 and it asserts unequal when the date is not incremented.




}
