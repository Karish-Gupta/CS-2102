import java.util.LinkedList;
public class CompileCheck {
    public static void main(String[] args){
        /* Homework 1 carry-over */
        // dummy variables for assignment
        double x;
        boolean y;
        // test making BooksRead
        BooksRead booksRead1 = new BooksRead(1.0, "fiction",false);
        BooksRead booksRead2 = new BooksRead(3.5, "non-fiction", true);
        // test making each of the Result classes
        ReadingResult readingResult = new ReadingResult(2, booksRead1, booksRead2);
//goal average books per day, fiction books read, non fiction books read.
        WritingResult writingResult = new WritingResult(25000.5, 15); //words
        //written, last day novel was updated
        ChallengeResult challengeResult = new ChallengeResult(readingResult,
                writingResult);
        // test making literarians
        Literarian literarian1 = new Literarian("Litty", challengeResult);
        Literarian literarian2 = new Literarian("Reeds", challengeResult);
        // test averagePerDay and differenceFromGoal methods
        x = readingResult.averagePerDay();
        x = writingResult.averagePerDay();
        x = readingResult.differenceFromGoal();
        x = writingResult.differenceFromGoal();
        // test howClose
        x = challengeResult.howClose();
        //test betterBookworm method
        y = literarian1.betterBookworm(literarian2);
        //test wittierWordsmith method
        y = literarian1.wittierWordsmith(literarian2);
        //test successfulScholar method
        y = literarian1.successfulScholar(literarian2);
        /* Homework 2 Compile Checks */
        //test nextChapter
        writingResult = writingResult.nextChapter(50);
        // test poem result
        PoemResult poemResult = new PoemResult(100,5,1);
        x = poemResult.averagePerDay();
        x = poemResult.differenceFromGoal();
        poemResult = poemResult.nextPoem(100.0, true);
        //test readSomeBooks
        BooksRead techManuals = new BooksRead(100, "technical manuals", false);
        readingResult = readingResult.readSomeBooks(techManuals);
        //test bestGenreByType
        String s = readingResult.bestGenreByType(false);
        //test LitJam
        LinkedList<Literarian> lits = new LinkedList<Literarian>();
        lits.add(literarian1);
        lits.add(literarian2);
        LitJam litJam = new LitJam(5,lits);
        LinkedList<String> names = litJam.readingDNF();
        int i = litJam.finalScoreForLiterarian("Litty");
        y = litJam.anyImprovement(litJam);
        System.out.println("Your code has compiled successfully!");
    }
}