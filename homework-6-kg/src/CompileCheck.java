public class CompileCheck {

        public static void main(String [] args) {
            Exception e1 = new CandidateNotFoundException("gompei");
            Exception e2 = new RedundantCandidateException("gompei");
            Exception e3 = new CandidateChosenMoreThanOnceException("gompei");
            String runoff = "*Requires Runoff Poll*";
            VotingData vd = new VotingData();
            try {
                vd.nominateCandidate("a");
                vd.nominateCandidate("b");
                vd.nominateCandidate("c");
            } catch (RedundantCandidateException e) {}
            try {
                vd.submitVote("a","b","c");
            } catch (CandidateNotFoundException e) {
            } catch (CandidateChosenMoreThanOnceException e) {}
            String winner1 = vd.pickWinnerMostFirstChoice();
            String winner2 = vd.pickWinnerMostAgreeable();

            System.out.println ("Congratulations, your program compiled!");
        }
}
