import java.util.*;

/**
 * The data required to collect and store votes for the election.
 */
public class VotingData {

    private LinkedList<String> ballot = new LinkedList<String>();
    // Hashmaps
    private HashMap<String, Integer> firstVotes = new HashMap<String, Integer>();
    private HashMap<String, Integer> secondVotes = new HashMap<String, Integer>();
    private HashMap<String, Integer> thirdVotes = new HashMap<String, Integer>();

    VotingData() {}

    public LinkedList<String> getBallot() {
        return this.ballot;
    }


    /**
     * Takes in a voters top three choices and adds the tallies to the respective hashmaps.
     * @param c1
     * @param c2
     * @param c3
     * @throws CandidateChosenMoreThanOnceException when the same cndidate name is selected more than once.
     * @throws CandidateNotFoundException when the candidate name submitted is not found on the ballot.
     */
    public void submitVote(String c1, String c2, String c3) throws CandidateChosenMoreThanOnceException, CandidateNotFoundException {

        //Check the not found fucntion before the chosen more than once function
        //CandidateNotFoundException

        if (!ballot.contains(c1)) {
            throw new CandidateNotFoundException(c1);
        } else if (!ballot.contains(c2)) {
            throw new CandidateNotFoundException(c2);
        } else if (!ballot.contains(c3)) {
            throw new CandidateNotFoundException(c3);
        }

        // CandidateChosenMoreThanOnceException
        if (c1.equals(c2) || c1.equals(c3)) {
            throw new CandidateChosenMoreThanOnceException(c1);
        } else if (c2.equals(c3)) {
            throw new CandidateChosenMoreThanOnceException(c2);
        }

        firstVotes.put(c1, firstVotes.get(c1) + 1);
        secondVotes.put(c2, secondVotes.get(c2) + 1);
        thirdVotes.put(c3, thirdVotes.get(c3) + 1);
    }

    /**
     * Checks if the name is in the ballot.
     * If yes, then throws an exception (RedundantCandidateException).
     * If no, adds the name to the ballot list.
     * @param name
     * @throws Exception RedundantCandidateException if the candidate's name is already in the ballot.
     */
    public void nominateCandidate(String name) throws RedundantCandidateException {
        if (this.ballot.contains(name)) {
            throw new RedundantCandidateException(name);
        }
        this.ballot.add(name);
        this.firstVotes.put(name, 0);
        this.secondVotes.put(name, 0);
        this.thirdVotes.put(name, 0);
    }


    /**
     * checks if the winner is the candidate with more than 50% of the first place votes.
     * @return String
     */
    public String pickWinnerMostFirstChoice() {
        float total = 0;
        //Total number of first choice votes
        for (Map.Entry<String, Integer> candidate : firstVotes.entrySet()) {
            total = total + candidate.getValue();
        }
        //Choosing the best candidate
        for (Map.Entry<String, Integer> candidate : firstVotes.entrySet()) {
            if (candidate.getValue() >= (total / 2)) {
                return candidate.getKey();
            }
        }
        return "*Requires Runoff Poll*";
    }


    /**
     * Returns the candidate with the most number of points from the three preferences: first, second, and third.
     * @return String
     */
    public String pickWinnerMostAgreeable() {
        HashMap<String, Integer> candidateVotes = new HashMap<String, Integer>();

        for (String candidate : ballot) {
            int maxPoints = 0;
            LinkedList<Integer> pointsList = new LinkedList<Integer>();
            int firstChoice = firstVotes.get(candidate);
            int secondChoice = secondVotes.get(candidate);
            int thirdChoice = thirdVotes.get(candidate);

            pointsList.add(firstChoice);
            pointsList.add(secondChoice);
            pointsList.add(thirdChoice);

            for (int vote : pointsList) {
                if (maxPoints < vote) {
                    maxPoints = vote;
                }
            }
            candidateVotes.put(candidate, maxPoints);
        }
        int mostPoints = 0;
        String bestCand = "None";
        for (Map.Entry<String, Integer> candidate : candidateVotes.entrySet()) {
            if (candidate.getValue() >= mostPoints) {
                mostPoints = candidate.getValue();
                bestCand = candidate.getKey();
            }
        }
        return bestCand;
    }

}

