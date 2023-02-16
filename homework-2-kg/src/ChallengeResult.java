/**
 * Challenge result holds the reading result and writing result of a literarian.
 */
public class ChallengeResult {
    ReadingResult readLiterarian;
    WritingResult writeLiterarian;

    //Constructor
    ChallengeResult (ReadingResult readLiterarian, WritingResult writeLiterarian){
        this.readLiterarian = readLiterarian;
        this.writeLiterarian = writeLiterarian;

    }

    public double howClose(){

        return ((this.readLiterarian.differenceFromGoal() * 10000) + this.writeLiterarian.differenceFromGoal());
    }
}
