public class CandidateNotFoundException extends Exception{
    //candidate not on the ballot

    private String name;

    public CandidateNotFoundException(String name){
        this.name = name;
    }

    // Getter
    public String getName() {
        return name;
    }
}



