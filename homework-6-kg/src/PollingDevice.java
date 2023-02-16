import java.util.Scanner;

/**
 * Contains methods that allows one to interact with the poll and participate in th election.
 */
public class PollingDevice {

    private Scanner keyboard = new Scanner(System.in);
    private VotingData vd;

    public PollingDevice() {}


    public void printBallot() {
        System.out.println("The candidates are ");
        for (String s : vd.getBallot()) {
            System.out.println(s);
        }
    }

    public void screen() {
        try {
            this.printBallot();
            System.out.println("Who do you want to vote for?");
            String candidate1 = keyboard.next();
            String candidate2 = keyboard.next();
            String candidate3 = keyboard.next();
            System.out.println("You voted for " + candidate1 + ", "  + candidate2 + ", " + candidate3);
            vd.submitVote(candidate1, candidate2, candidate3);

        } catch (CandidateNotFoundException e) {
            System.out.println(e.getName() + " is not on the ballot, would you like to add them? Y/N");
            String newCand = keyboard.next();
            if (newCand.equals("Y") || newCand.equals("y")) {
                addWriteIn(e.getName());
                System.out.println("Candidate was added.");
                screen();
            }
        }catch (CandidateChosenMoreThanOnceException e2) {
            System.out.println("You may not vote for the same person multiple times");
            screen();
        }
    }


    /**
     * Adds a candidate name to the ballot.
     * @param name
     */
    public void addWriteIn(String name) {
        try {
            vd.nominateCandidate(name);
            System.out.println("Added Successfully");
        } catch (RedundantCandidateException e) {
            System.out.println(e + " already exists");
        }
    }


}