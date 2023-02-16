public class CandidateChosenMoreThanOnceException extends Exception {
    // candidate voted for mutiple times

    private String name;

    public CandidateChosenMoreThanOnceException(String name){
        this.name = name;
    }

}
