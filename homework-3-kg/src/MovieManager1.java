import java.util.LinkedList;

/**
 * A movie manager that contains the organize-movies method
 */
class MovieManager1 {
	
	MovieManager1() {}

	/**
	 * This method consumes a list of movies and outputs
	 * a filtered list of movies of the matinee time schedule
	 * @param movies
	 * @return matineeList
	 */
	public LinkedList<Movie> listofMatinee(LinkedList<Movie> movies) {
		LinkedList<Movie> matineeList = new LinkedList<Movie>();

		for (Movie aMovie : movies) {
			if (aMovie.showtime >= 700 && aMovie.showtime < 1200 && !aMovie.simulcast) {
				matineeList.add(aMovie);
			}
		}
		return matineeList;
	}


	/**
	 * This method consumes a list of movies and outputs
	 * 	 * a filtered list of movies of the primetime time schedule
	 * @param movies
	 * @return primetimeList
	 */
	public LinkedList<Movie> listofPrimetime(LinkedList<Movie> movies) {
		LinkedList<Movie> primtimeList = new LinkedList<Movie>();

		for (Movie aMovie : movies) {
			if (aMovie.showtime >= 1200 && aMovie.showtime < 2000 && !aMovie.simulcast) {
				primtimeList.add(aMovie);
			}
		}
		return primtimeList;
	}


	/**
	 * This method consumes a list of movies and outputs
	 * a filtered list of movies of the soiree time schedule
	 * @param movies
	 * @return soireeList
	 */
	public LinkedList<Movie> listofSoiree(LinkedList<Movie> movies) {
		LinkedList<Movie> soireeList = new LinkedList<Movie>();

		for (Movie aMovie : movies) {
			if (!aMovie.simulcast) {

				if (aMovie.showtime >= 2000 || aMovie.showtime < 200) {
					soireeList.add(aMovie);
				}
			}
		}
		return soireeList;
	}

	/**
	 * Consumes a list of movies and outputs a programme that
	 * has all of the movies assorted into the matinee, primetime, or soiree lists
	 * @param movies
	 * @return Programme
	 */
	public Programme organizeMovies(LinkedList<Movie> movies) {

		return new Programme(this.listofMatinee(movies), this.listofPrimetime(movies), this.listofSoiree(movies));
	}
	
}
