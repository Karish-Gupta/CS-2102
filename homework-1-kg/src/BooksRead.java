/**
 * This class is the number of books read by a literarian.
 * Contains the genre and whether a book has been skimmed or not.
 */
public class BooksRead {
    double numberOfBooksRead;

    boolean bookSkimmed;
    String genre;

    //Constructor
    BooksRead (double numberOfBooksRead, String genre, boolean bookSkimmed) {
        this.numberOfBooksRead = numberOfBooksRead;
        this.genre = genre;
        this.bookSkimmed = bookSkimmed;
    }
}
