/**
 * A Literarian is a person with a challenge result and a pen name.
 */
public class Literarian {
    ChallengeResult challengeResult;
    String penName;

    Literarian ( String penName, ChallengeResult challengeResult) {
        this.penName = penName;
        this.challengeResult = challengeResult;
    }

    public boolean betterBookworm(Literarian literarian1){

        if (this.challengeResult.readLiterarian.differenceFromGoal() < literarian1.challengeResult.readLiterarian.differenceFromGoal()){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean wittierWordsmith( Literarian literarian1){

        if (this.challengeResult.writeLiterarian.averagePerDay() > literarian1.challengeResult.writeLiterarian.averagePerDay()){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean successfulScholar(Literarian literarian1){

        if (this.betterBookworm(literarian1) || this.wittierWordsmith(literarian1)){
            return true;
        }
        else{
            return false;
        }
    }


}
