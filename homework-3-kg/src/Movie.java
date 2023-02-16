/**
 * A movie with a title, a showtime, a runtime, and a true/false for the simulcast
 */
class Movie {

	String title;
	double showtime;
	int runtime;
	boolean simulcast;
	
	public Movie(String title, double showtime, int runtime, boolean simulcast)
	{
		this.title = title;
		this.showtime = showtime;
		this.runtime = runtime;
		this.simulcast = simulcast;
	}
	
}
