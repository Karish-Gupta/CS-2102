import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class MovieExamples {
	MovieManager1 mm1 = new MovieManager1();
	LinkedList<Movie> movies = new LinkedList<Movie>();
	Programme programme1 = new Programme();
	Programme programme3 = new Programme();


	Movie starTrek = new Movie("Star Trek Into Darkness", 1400, 132, false);
	Movie pinicchio = new Movie("GUILLERMO DEL TORO'S PINOCCHIO", 945, 114, false);
	Movie swampThing = new Movie("RiffTrax Live: The Return of Swamp Thing", 2030, 118, true);
	Movie sevenSamurai = new Movie("Seven Samurai", 0, 207, false);


	// Movies for programme 3
	Movie avengers = new Movie("Avengers", 800, 135, false);

	Movie avatar3 = new Movie("Avatar 3", 1900, 162, false);

	Movie missionimpossible4 = new Movie("Mission Impossible 4", 2300, 145, false);

	Movie smurfs5 = new Movie("Smurfs 5", 100, 115, true);

	public MovieExamples() {
		movies.add(starTrek);
		programme1.primetime.add(starTrek);

		movies.add(pinicchio);
		programme1.matinee.add(pinicchio);

		movies.add(swampThing);
		programme1.soiree.add(swampThing);

		movies.add(sevenSamurai);
		programme1.soiree.add(sevenSamurai);


		programme3.matinee.add(avengers);
		programme3.primetime.add(avatar3);
		programme3.soiree.add(smurfs5);
		programme3.soiree.add(missionimpossible4);


	}

	// Tests for Equals Override
	@Test
	public void instructorTestProgramme_EmptyReport() {
		Programme report2 = new Programme();
		assertFalse(programme1.equals(report2));
	}


	@Test
	public void instructorTestProgramme_WrongOrder() {
		Programme programme2 = new Programme();

		programme2.primetime.add(starTrek);
		programme2.matinee.add(pinicchio);
		programme2.soiree.add(sevenSamurai);
		programme2.soiree.add(swampThing);


		assertFalse(programme1.equals(programme2));
	}

	@Test
	public void instructorTestProgramme_DifferentInstances() {
		Programme programme2 = new Programme();

		Movie starTrek2 = new Movie("Star Trek Into Darkness", 1400, 132, false);
		Movie pinocchio2 = new Movie("GUILLERMO DEL TORO'S PINOCCHIO", 945, 114, false);
		Movie swampThing2 = new Movie("RiffTrax Live: The Return of Swamp Thing", 2030, 118, true);
		Movie sevenSamurai2 = new Movie("Seven Samurai", 0, 207, false);

		programme2.primetime.add(starTrek2);
		programme2.matinee.add(pinocchio2);
		programme2.soiree.add(swampThing2);
		programme2.soiree.add(sevenSamurai2);

		assertTrue(programme1.equals(programme2));
	}

	@Test
	public void instructorTestProgramme_SameInstances() {
		Programme programme2 = programme1;
		assertTrue(programme1.equals(programme2));
	}

	// Tests for OrganizeMovies in MM1 and MM2

	@Test
	public void instructorTestOrganizeMovies()
	{
		Programme programme2 = mm1.organizeMovies(movies);
		programme1.soiree.remove(swampThing); //it's a simulcast
		assertEquals(programme1, programme2);
	}


	@Test
	public void instructorTestOrganizeMoviesNotEquals() {
		Programme programme2 = mm1.organizeMovies(movies);
		programme2.matinee.add(starTrek);
		programme2.primetime.add(sevenSamurai);
		assertNotEquals(programme1, programme2);
	}

	@Test
	public void instructorTestOrganizeMoviesNotEquals2() {
		Programme programme1 = mm1.organizeMovies(movies);
		assertNotEquals(programme1, programme3);
	}


	@Test
	public void instructorTestOrganizeMoviesIdenticalLists() {
		Programme programme4 = mm1.organizeMovies(movies);
		Programme programme2 = programme4;
		assertEquals(programme2, programme4);
	}




}


// Identifying Subtasks for organizeMovies in MovieMoanager 1 and 2

// create a list of movies for Matinee
// create a list of movies for PrimeTime
// create a list of movies for Soiree
// checks if a movie is Matinee if showtime is after 7 am and before 12 pm
// checks if a movie is PrimeTime if showtime is after 12 pm and before 8 pm
// checks if a movie is Soiree if showtime is after 8 pm and before 2 am
// checks if the movie is a simulcast
// if the movie is not a simulcast then that movie gets added to the list it belongs to
// adds the list of movies to the Programme

// organizeMovies in MM1 vs MM2
	// In MM1 we use three helper methods to parse through the three lists in programme.
	// Each parse function returns a boolean stating whether the two programmes we are comparing are equal.
	// Then we call three helpers in the main function and this function returns true if all other functions return true.
	// This method uses parsing as we split up the subtasks into smaller functions.

	// In MM2 we one single function that initializes three separate lists (one for each range of showtimes).
	// We then use if statements to filter the Movie objects into separate lists and then finally return a programme
	// Object that consists of all three lists. This method uses cleaning as we are filtering the data into separate lists.
