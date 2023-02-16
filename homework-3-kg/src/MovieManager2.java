import java.util.LinkedList;

/**
 * A movie manager that contains the organize-movies method
 */
class MovieManager2 {
	
	MovieManager2() {}


	/**
	 * Consumes a list of movies and outputs a programme that
	 * has all of the movies assorted into the matinee, primetime, or soiree lists
	 * @param movies
	 * @return Programme
	 */
	public Programme organizeMovies(LinkedList<Movie> movies) {

		LinkedList<Movie> matineeList = new LinkedList<Movie>();
		LinkedList<Movie> primtimeList = new LinkedList<Movie>();
		LinkedList<Movie> soireeList = new LinkedList<Movie>();

		for (Movie aMovie : movies) {

			if (!aMovie.simulcast) {
				if (aMovie.showtime >= 700 && aMovie.showtime < 1200) {
					matineeList.add(aMovie);
				}
				if (aMovie.showtime >= 1200 && aMovie.showtime < 2000) {
					primtimeList.add(aMovie);
				}
				if (aMovie.showtime >= 2000 || aMovie.showtime < 200) {
					soireeList.add(aMovie);
				}
			}
		}
		return new Programme(matineeList, primtimeList, soireeList);
	}
	
}
