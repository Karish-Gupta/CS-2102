import java.util.LinkedList;

/**
 * A survey containing a rank and a number of downloads.
 */
public class Survey {

    private int rank;

    private int downloads;


    public Survey(int rank, int downloads){
        this.rank = rank;
        this.downloads = downloads;
    }

    /**
     * Gets the rank of a survey.
     * @return int
     */
    public int surveyRank() {
        return this.rank;
    }

    /**
     * Gets the number of downloads of a survey.
     * @return int
     */
    public int surveyDownloads() {
        return this.downloads;
    }

}
