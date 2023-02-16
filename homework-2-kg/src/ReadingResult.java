import java.util.LinkedList;
import java.util.List;

/**
 * A reading result with a number of average books per day goal, an object of BooksRead for fiction and nonfiction, and  a list of genres.
 */
public class ReadingResult implements IChallenge {

    int averageBooksPerDay;

    BooksRead fiction;

    BooksRead nonfiction;

    LinkedList<BooksRead> genreList;


    //Constructor
    ReadingResult(int averageBooksPerDay, BooksRead fiction, BooksRead nonfiction) {
        this.averageBooksPerDay = averageBooksPerDay;
        this.genreList = new LinkedList<BooksRead>();
        this.fiction = fiction;
        this.nonfiction = nonfiction;

        this.genreList.add(fiction);
        this.genreList.add(nonfiction);

    }

    /**
     * Cycles through list of genres and sums total number of books read
     *
     * @return double
     */
    public double averagePerDay() {
        double totalBooksRead = 0;

        for (BooksRead item : genreList) {

            totalBooksRead += item.numberOfBooksRead;
        }
        return totalBooksRead / 31;
    }

    public double differenceFromGoal() {

        double difference = this.averageBooksPerDay - this.averagePerDay();

        if (difference > 0) {
            return difference;
        } else {
            return 0;
        }
    }

    /**
     * Adds a book parameter to the linked list field
     *
     * @param aBook
     * @return ReadingList
     */
    public ReadingResult readSomeBooks(BooksRead aBook) {
        genreList.add(aBook);
        return this;

    }

    /**
     * Outputs the genre string of the best books read in the genre list
     * @param bookSkimmed
     * @return
     */
    public String bestGenreByType(boolean bookSkimmed) {

        double count = 0.0;
        String bestGenre = "";

        if (bookSkimmed == true) {

            for (BooksRead item : genreList) {

                if (item.bookSkimmed == true) {
                    continue;
                } else if (item.bookSkimmed == false) {
                    if (item.numberOfBooksRead >= count) {
                        count = item.numberOfBooksRead;
                        bestGenre = item.genre;
                    }
                }
            }
            return bestGenre;
        }
        else {
            for (BooksRead item : genreList) {

                if (item.numberOfBooksRead >= count) {
                    count = item.numberOfBooksRead;
                    bestGenre = item.genre;
                }
            }
            return bestGenre;
        }
    }
}


