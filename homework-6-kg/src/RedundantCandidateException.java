public class RedundantCandidateException extends Exception {

    private String name;

    public RedundantCandidateException(String name){
        this.name = name;
    }

}
