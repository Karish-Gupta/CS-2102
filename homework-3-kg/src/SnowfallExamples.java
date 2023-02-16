import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

public class SnowfallExamples {
  Snowfall1 E1 = new Snowfall1();

  LinkedList<Double> noData = new LinkedList<Double>();
  LinkedList<Double> threeDates = new LinkedList<Double>();
  LinkedList<Double> moreDates = new LinkedList<Double>();

  LinkedList<MaxInchReport> DecReports = new LinkedList<MaxInchReport>();

  LinkedList<MaxInchReport> DecReports2 = new LinkedList<MaxInchReport>();

  LinkedList<MaxInchReport> DecReports3 = new LinkedList<MaxInchReport>();


  public SnowfallExamples() {
    threeDates.add(1113.0);
    threeDates.add(10.0);
    threeDates.add(5.0);
    threeDates.add(1120.0);
    threeDates.add(4.0);
    threeDates.add(5.0);
    threeDates.add(4.5);
    threeDates.add(1201.0);
    threeDates.add(6.0);
    threeDates.add(-0.5);


    DecReports.add(new MaxInchReport(1201.0,6.0));

    DecReports2.add(new MaxInchReport(1113.0,10.0));
    DecReports2.add(new MaxInchReport(1120.0,5.0));


    moreDates.add(101.0);
    moreDates.add(-1.0);
    moreDates.add(-3.0);
    moreDates.add(-6.0);
    moreDates.add(-10.0);
    moreDates.add(102.0);
    moreDates.add(-1.0);
    moreDates.add(-3.0);
    moreDates.add(-6.0);
    moreDates.add(-10.0);


    DecReports3.add(new MaxInchReport(101.0,0.0));
    DecReports3.add(new MaxInchReport(102.0,0.0));





  }

  //Tests for Snowfall1

  @Test
  public void instructorTestEQ() { 
    assertEquals(DecReports, E1.dailyMaxForMonth(threeDates, 12));
  }

  @Test
  public void dailyMaxForMonthEmptyList() {
    assertEquals(noData, E1.dailyMaxForMonth(threeDates, 1));
  }

  @Test
  public void dailyMaxForMonth() {
    assertEquals(DecReports2, E1.dailyMaxForMonth(threeDates, 11));
  }

  @Test
  public void dailyMaxForMonthNegativeValuesOnly() {
    assertEquals(DecReports3, E1.dailyMaxForMonth(moreDates, 1));
  }




// Identifying Subtasks for dailyMaxForMonth in SnowFall 1 and 2

  // Identifying Subtasks for Snowfall
  // takes in a list of data (doubles) and a month (int between 1 - 12)
  // goes through the data to check for the max value in that data
  // ignore data for months other than the given one
  // ignore negative snowfall values
  // checks if data contains only negative values
  // if only negative values then the max snowfall will be 0
  // return the max value after filtering all the other values

// dailyMaxForMonth in SnowFall1 vs SnowFall2

  // In SnowFall1, we iterate through the list until we find the month we are looking for. Then we add the date value to
  // a MaxInchReport object with 0 inches. We then find the max value for the values after it that correspond to it.
  // This method uses cleaning as we filter the valuable data into a separate list and then output this list.

  // In Snowfall2 we iterate through a list and once again we iterate through the list when the month we are looking
  // for is found. Then it adds the max value of the corresponding month to an object and adds it to the result.
  // This method uses cleaning as we filter the valuable data into a separate list and then output this list.


}
