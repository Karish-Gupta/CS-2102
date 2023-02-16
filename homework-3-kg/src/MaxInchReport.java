/**
 * The report of the max inches of snow on a given date
 */
class MaxInchReport {
  double date;
  double maxInches;

  MaxInchReport(double date, double maxInches) {
    this.date = date;
    this.maxInches = maxInches;
  }

  // the equals method for use in testing
	public boolean equals(Object other) 
	{
		if(!(other instanceof MaxInchReport))
		{
			return false;
		}
		
		MaxInchReport otherR = (MaxInchReport) other;
		
		return otherR.date == this.date &&
			otherR.maxInches == this.maxInches;
	}
  
  // the toString method so that reports display when tests fail
	public String toString()
	{
		return "Snow | " + date + ": " + maxInches + "\"";
	}
}
