import java.util.LinkedList;

/**
 * Contains methods for list of data of snowfall each month
 */
class Snowfall2 {
  Snowfall2() {
  }

  // checks whether a datum is a date
  boolean isDate(double anum) {
    return (int) anum >= 101;
  } // Jan 1st

  // extracts the month from an 4-digit date
  int extractMonth(double dateNum) {
    return ((int) (dateNum / 100));
  }


  /**
   * Outputs the greatest snowfall reading for each day in a specified month
   * @param data
   * @param month
   * @return result
   */

  public LinkedList<MaxInchReport> dailyMaxForMonth(LinkedList<Double> data, int month) {
    LinkedList<MaxInchReport> result = new LinkedList<MaxInchReport>();

    for (int i = 0; i < data.size(); i++) {
      double currDate = data.get(i);

      if (extractMonth(data.get(i)) == month) {
        double maxValue = data.get(i + 1);

        for (int j = i + 1; ((data.get(i) < 99) && (j < data.size() - 1)); i++) {

          if (maxValue < data.get(j + 1) && maxValue > 0 && data.get(j + 1) < 99) {
            maxValue = data.get(j + 1);
          }
        }
        MaxInchReport report = new MaxInchReport(currDate, maxValue);
        result.add(report);
      }
    }
    return result;
  }

}