import java.util.LinkedList;

/**
 * A LitJam with a linked list and a uniqueGenre.
 */
public class LitJam {

    int uniqueGenre;

    LinkedList<Literarian> LiterarianList;

    LitJam(int uniqueGenre, LinkedList<Literarian> LiterarianList) {
        this.uniqueGenre = uniqueGenre;
        this.LiterarianList = new LinkedList<Literarian>();
    }

    /**
     * Produces a linked list of names of Literarians whose number of books read objects
     * in the genre list is less than the number of unique genres
     * @return LinkedList<String>
     */
    public LinkedList<String> readingDNF() {

        LinkedList<String> litNameList =  new LinkedList<String>();

        for (Literarian lit : LiterarianList) {

            if (lit.challengeResult.readLiterarian.genreList.size() < uniqueGenre) {
                litNameList.add(lit.penName);

            }
        }

        return litNameList;
    }


    /**
     * Takes the name of a literarian and produces the score based on the reading and writing results
     * @param litName
     * @return score
     */
    public Integer finalScoreForLiterarian(String litName) {

        BooksRead booksReadFic2 = new BooksRead(200, "horror", false);
        BooksRead booksReadNonFic2 = new BooksRead( 200, "sci-fi", false);
        WritingResult writingResult2 = new WritingResult(9000, 30);
        ReadingResult readingResult2 = new ReadingResult(12, booksReadFic2, booksReadNonFic2);
        ChallengeResult challengeResult2 = new ChallengeResult(readingResult2, writingResult2);

        Literarian myLit = new Literarian("notInList", challengeResult2);

        for (Literarian lit : LiterarianList) {
            if (lit.penName.equals(litName)) {
                myLit = lit;
            }
        }

        int score = 0;

        if (myLit.challengeResult.readLiterarian.genreList.size() >= uniqueGenre) {

            score = score + 25;
        }

        for (BooksRead item : myLit.challengeResult.readLiterarian.genreList) {

            if (item.bookSkimmed == false) {
                score = score + ((int) (5 * item.numberOfBooksRead));
            }
        }

        if (myLit.challengeResult.readLiterarian.averagePerDay() >= myLit.challengeResult.readLiterarian.averageBooksPerDay) {
            score = score + 5;
        }
        if (myLit.challengeResult.writeLiterarian.numberOfWordsWritten.size() > 50000) {

            score = score + ((int) 5 * myLit.challengeResult.writeLiterarian.dayOfLastUpdate);

        }

        return score;
    }

    /**
     * Takes in a LitJam object and ouputs a boolean stating whether the final score of this LitJam is greater than
     * the final score of the parameter LitJam
     * @param litJam
     * @return boolean
     */
    public boolean anyImprovement(LitJam litJam) {

        int thisFinalScore = 0;
        int litFinalScore = 0;

        for (Literarian lit : this.LiterarianList) {

            if (this.finalScoreForLiterarian(lit.penName) > thisFinalScore) {

                thisFinalScore = this.finalScoreForLiterarian(lit.penName);
            }
        }

        for (Literarian lit2 : litJam.LiterarianList) {

            if (litJam.finalScoreForLiterarian(lit2.penName) > litFinalScore) {

                litFinalScore = litJam.finalScoreForLiterarian(lit2.penName);
            }
        }

        return (thisFinalScore > litFinalScore);
    }
}


// There were quite a few times throughout this homework assignment where we felt it may be helpful to create a helper function
// in order to break the problem down into smaller pieces. This was most prominent in the finalScoreForLiterarian() methpd, which
// required us to first find the correct literarian in the LiterarianList corresponding to the String name parameter.
// Having a separate method for this may have made the code more organized and simpler. We could have made similar implementations
// in other larger functions like bestGenreByType or anyImprovement.



