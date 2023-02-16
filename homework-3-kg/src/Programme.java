import java.util.LinkedList;

/**
 * A set programme with lists of movies for showtimes matinee, primetime, and soiree
 */
class Programme {
	
	LinkedList<Movie> matinee;
	LinkedList<Movie> primetime;
	LinkedList<Movie> soiree;
	
	Programme()
	{
		this.matinee = new LinkedList<Movie>();
		this.primetime = new LinkedList<Movie>();
		this.soiree = new LinkedList<Movie>();
	}
	
	Programme(LinkedList<Movie> matinee, LinkedList<Movie> primetime, LinkedList<Movie> soiree)
	{
		this.matinee = matinee;
		this.primetime = primetime;
		this.soiree = soiree;
	}


	/**
	 * Takes two programs and produces true if all the movies in the matinee list match
	 * @param aProgramme
	 * @return boolean
	 */
	public boolean parseMatinee(Programme aProgramme) {
		if (this.matinee.size() != aProgramme.matinee.size()) {
			return false;
		}

		for (int i = 0; i < aProgramme.matinee.size(); i++) {

			Movie movie1 = this.matinee.get(i);
			Movie movie2 = aProgramme.matinee.get(i);

			if (!movie1.title.equals(movie2.title) || movie1.showtime != movie2.showtime) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Takes two programs and produces true if all the movies in the primetime list match
	 * @param aProgramme
	 * @return boolean
	 */
	public boolean parsePrimetime(Programme aProgramme) {
		if (this.primetime.size() != aProgramme.primetime.size()) {
			return false;
		}

		for (int i = 0; i < aProgramme.primetime.size(); i++) {

			Movie movie1 = this.primetime.get(i);
			Movie movie2 = aProgramme.primetime.get(i);

			if (!movie1.title.equals(movie2.title) || movie1.showtime != movie2.showtime) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Takes two programs and produces true if all the movies in the soiree list match
	 * @param aProgramme
	 * @return boolean
	 */
	public boolean parseSoiree(Programme aProgramme) {
		if (this.soiree.size() != aProgramme.soiree.size()) {
			return false;
		}

		for (int i = 0; i < aProgramme.soiree.size(); i++) {

			Movie movie1 = this.soiree.get(i);
			Movie movie2 = aProgramme.soiree.get(i);

			if (!movie1.title.equals(movie2.title) || movie1.showtime != movie2.showtime) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Overrides equals function and returns true if matinee list, primetime list, and soiree list all match in a programme object
	 * @param obj
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj) {
		return this.parseMatinee((Programme) obj) && this.parsePrimetime((Programme) obj) && this.parseSoiree((Programme) obj);
	}
}

