import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.print.Book;
import java.util.LinkedList;

// Karish Gupta
// Vivek Kasireddy


public class Examples {

    public Examples() {
    }

    PoemResult poemResult1 = new PoemResult(8.0, 20, 3);
    PoemResult poemResult2 = new PoemResult(0.0, 10, 2);

    @Test
    public void CheckPoemResultAvg() {
        poemResult1.numberOfWordsWritten.add(5.0);
        poemResult1.numberOfWordsWritten.add(7.0);
        assertEquals(1.0, poemResult1.averagePerDay(), 0.05);
    }

    @Test
    public void CheckPoemResultAvgZero() {
        assertEquals(0.0, poemResult2.averagePerDay(), 0.05);

    }


    WritingResult writingResult1 = new WritingResult(8.0, 20);
    WritingResult writingResult2 = new WritingResult(0.0, 10);


    @Test
    public void CheckWritingResultAvg1() {
        assertEquals(0.4, writingResult1.averagePerDay(), 0.05);
    }

    @Test
    public void CheckWritingResultAvg2() {
        writingResult1.numberOfWordsWritten.add(7.0);
        writingResult1.numberOfWordsWritten.add(6.0);
        assertEquals(1.05, writingResult1.averagePerDay(), 0.05);
    }

    @Test
    public void CheckWritingResultAvg3() {
        writingResult1.numberOfWordsWritten.add(0.0);
        assertEquals(0.0, writingResult2.averagePerDay(), 0.05);
    }

    BooksRead booksReadFic1 = new BooksRead(5.0, "Fantasy", true);
    BooksRead booksReadNonFic1 = new BooksRead(6.0, "Science", false);

    BooksRead booksReadFic2 = new BooksRead(4.0, "Sci-Fi", false);
    BooksRead booksReadNonFic2 = new BooksRead(3.0, "Biology", true);


    ReadingResult readingResult1 = new ReadingResult(2, booksReadFic1, booksReadNonFic1);
    ReadingResult readingResult2 = new ReadingResult(3, booksReadFic2, booksReadNonFic2);

    @Test
    public void CheckReadingResult1() {
        assertEquals(0.354, readingResult1.averagePerDay(), 0.05);
    }

    @Test
    public void CheckReadingResult2() {
        assertEquals(0.2258, readingResult2.averagePerDay(), 0.05);
    }

    @Test
    public void CheckBestTypeTrue1() {
        assertEquals("Science", readingResult1.bestGenreByType(true));
    }

    @Test
    public void CheckBestTypeTrue2() {
        assertEquals("Sci-Fi", readingResult2.bestGenreByType(true));
    }

    @Test
    public void CheckBestTypeFalse1() {
        assertEquals("Science", readingResult1.bestGenreByType(false));
    }

    @Test
    public void CheckBestTypeFalse2() {
        assertEquals("Sci-Fi", readingResult2.bestGenreByType(false));
    }


    // Examples for readingDNF:
    // Literarian 1
    BooksRead booksReadFicLit = new BooksRead(200, "horror", false);
    BooksRead booksReadNonFicLit = new BooksRead(200, "sci-fi", false);
    WritingResult writingResultLit = new WritingResult(9000, 30);
    ReadingResult readingResultLit = new ReadingResult(12, booksReadFicLit, booksReadNonFicLit);
    ChallengeResult challengeResultLit = new ChallengeResult(readingResultLit, writingResultLit);

    Literarian aLiterarian = new Literarian("bob", challengeResultLit);

    // Literarian 2

    BooksRead booksReadFicLit2 = new BooksRead(200, "horror", false);
    BooksRead booksReadNonFicLit2 = new BooksRead(200, "sci-fi", false);
    WritingResult writingResultLit2 = new WritingResult(9000, 30);
    ReadingResult readingResultLit2 = new ReadingResult(12, booksReadFicLit2, booksReadNonFicLit2);
    ChallengeResult challengeResultLit2 = new ChallengeResult(readingResultLit2, writingResultLit2);

    Literarian aLiterarian2 = new Literarian("hob", challengeResultLit2);


    // Literarian 3

    BooksRead booksReadFicLit3 = new BooksRead(1, "horror", false);
    BooksRead booksReadNonFicLit3 = new BooksRead(1, "sci-fi", false);
    WritingResult writingResultLit3 = new WritingResult(10, 10);
    ReadingResult readingResultLit3 = new ReadingResult(12, booksReadFicLit3, booksReadNonFicLit3);
    ChallengeResult challengeResultLit3 = new ChallengeResult(readingResultLit3, writingResultLit3);

    Literarian aLiterarian3 = new Literarian("hob", challengeResultLit3);



    @Test
    public void CheckReadingDNF1() {
        LinkedList<Literarian> aLiterarianList = new LinkedList<Literarian>();
        aLiterarianList.add(aLiterarian);
        aLiterarianList.add(aLiterarian2);
        LitJam aLitJam = new LitJam(5, aLiterarianList);

        LinkedList<String> names = new LinkedList<String>();
        names.add("bob");
        names.add("hob");
        assertEquals(names, aLitJam.readingDNF());
    }

    //finalScoreForLiterarian:



    @Test
    public void finalScoreForLiterarian1() {
        LinkedList<Literarian> aLiterarianList = new LinkedList<Literarian>();
        aLiterarianList.add(aLiterarian);
        aLiterarianList.add(aLiterarian2);
       LitJam aLitJam = new LitJam(1, aLiterarianList);
        assertEquals(aLitJam.finalScoreForLiterarian("bob"), 2030.0, 0.05);

    }

    @Test
    public void finalScoreForLiterarian2() {
        LinkedList<Literarian> aLiterarianList = new LinkedList<Literarian>();
        aLiterarianList.add(aLiterarian);
        aLiterarianList.add(aLiterarian2);
        LitJam aLitJam = new LitJam(1, aLiterarianList);
        assertEquals(aLitJam.finalScoreForLiterarian("hob"), 2030.0, 0.05);

    }


    @Test
    public void CheckAnyImprovement() {
        LinkedList<Literarian> aLiterarianList = new LinkedList<Literarian>();
        aLiterarianList.add(aLiterarian);
        aLiterarianList.add(aLiterarian2);
        LitJam aLitJam = new LitJam(1, aLiterarianList);

        LinkedList<Literarian> aLiterarianList2 = new LinkedList<Literarian>();
        aLiterarianList2.add(aLiterarian);
        aLiterarianList2.add(aLiterarian2);
        LitJam aLitJam2 = new LitJam(1, aLiterarianList2);

        assertFalse(aLitJam.anyImprovement(aLitJam2));

    }

    @Test
    public void CheckAnyImprovement2() {
        LinkedList<Literarian> aLiterarianList = new LinkedList<Literarian>();
        aLiterarianList.add(aLiterarian);
        aLiterarianList.add(aLiterarian2);
        LitJam aLitJam = new LitJam(1, aLiterarianList);

        LinkedList<Literarian> aLiterarianList2 = new LinkedList<Literarian>();
        aLiterarianList2.add(aLiterarian);
        aLiterarianList2.add(aLiterarian3);
        LitJam aLitJam2 = new LitJam(1, aLiterarianList2);

        assertFalse(aLitJam.anyImprovement(aLitJam2));

    }
    
}
