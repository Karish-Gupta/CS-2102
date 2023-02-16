import java.util.LinkedList;

/**
 * Contains methods for list of data of snowfall each month
 */
class Snowfall1 {

  Snowfall1(){}

  // checks whether a datum is a date
  boolean isDate(double anum) {
    return (int)anum >= 101; } // Jan 1st


  // extracts the month from an 4-digit date
  int extractMonth(double dateNum) {
    return ((int)( dateNum / 100)); }

  /**
   * Outputs the greatest snowfall reading for each day in a specified month
   * @param data
   * @param month
   * @return filter
   */
  public LinkedList<MaxInchReport> dailyMaxForMonth(LinkedList<Double> data, int month) {

    MaxInchReport baseCase = new MaxInchReport(101,0);
    LinkedList<MaxInchReport> filter = new LinkedList<MaxInchReport>();
    MaxInchReport report = baseCase;
    double dateHolder = 0;

    for (Double aValue : data) {
      if (isDate(aValue)) {
        dateHolder = aValue;
        if (extractMonth(aValue) == month) {
          report = new MaxInchReport(aValue, 0);
          filter.add(report);
        }
      }
      else if (aValue >= report.maxInches && aValue >= 0 && report.date == dateHolder) {
          report.maxInches = aValue;
        }
    }
    return filter;
  }

}  

