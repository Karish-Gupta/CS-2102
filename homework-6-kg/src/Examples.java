import org.junit.Test;
import static org.junit.Assert.*;

public class Examples {

    // Setups
    VotingData setup1() {

        VotingData vd = new VotingData();

        // put candidates on the ballot
        try {

            vd.nominateCandidate("gompei");
            vd.nominateCandidate("husky");
            vd.nominateCandidate("ziggy");

        } catch (Exception e) {}

        // cast votes

        try {
            // Gompei has two first votes and is more agreeable
            vd.submitVote("gompei", "husky", "ziggy");
            vd.submitVote("gompei", "ziggy", "husky");
            vd.submitVote("husky", "gompei", "ziggy");

        } catch (Exception e) {}

        return(vd);

    }

    VotingData setup2() {

        VotingData vd2 = new VotingData();

        // put candidates on the ballot
        try {

            vd2.nominateCandidate("gompei");
            vd2.nominateCandidate("husky");
            vd2.nominateCandidate("ziggy");

        } catch (Exception e) {}

        // cast votes

        try {
            // gompei and ziggy both have the same number of points
            vd2.submitVote("gompei", "husky", "ziggy");
            vd2.submitVote("ziggy", "gompei", "husky");
            vd2.submitVote("husky", "gompei", "ziggy");

        } catch (Exception e) {}

        return(vd2);

    }

    VotingData setup3() {

        VotingData vd3 = new VotingData();

        // put candidates on the ballot
        try {

            vd3.nominateCandidate("gompei");
            vd3.nominateCandidate("husky");
            vd3.nominateCandidate("ziggy");

        } catch (Exception e) {}

        // cast votes

        try {
            // gompei and ziggy both have the same number of points
            vd3.submitVote("gompei", "husky", "ziggy");
            vd3.submitVote("ziggy", "husky", "gompei");
            vd3.submitVote("gompei", "husky", "ziggy");
            vd3.submitVote("gompei", "husky", "ziggy");
            vd3.submitVote("ziggy", "husky", "gompei");
            vd3.submitVote("gompei", "husky", "ziggy");

        } catch (Exception e) {}

        return(vd3);

    }

    // Exception setups
    VotingData setup4() {

        VotingData vd4 = new VotingData();

        // put candidates on the ballot
        try {

            vd4.nominateCandidate("gompei");
            vd4.nominateCandidate("husky");
            vd4.nominateCandidate("ziggy");

        } catch (Exception e) {}

        // cast votes

        try {
            // gompei and ziggy both have the same number of points
            vd4.submitVote("gompei", "husky", "ziggy");
            vd4.submitVote("ziggy", "husky", "gompei");
            vd4.submitVote("karish", "husky", "gompei");



        } catch (Exception e) {
            return(vd4);
        }

        return(vd4);

    }
    VotingData setup5() {

        VotingData vd5 = new VotingData();

        // put candidates on the ballot
        try {

            vd5.nominateCandidate("gompei");
            vd5.nominateCandidate("husky");
            vd5.nominateCandidate("ziggy");

        } catch (Exception e) {}

        // cast votes

        try {
            // gompei and ziggy both have the same number of points
            vd5.submitVote("gompei", "husky", "ziggy");
            vd5.submitVote("husky", "husky", "gompei");
            vd5.submitVote("karish", "husky", "gompei");



        } catch (Exception e) {
            return (vd5);
        }

        return (vd5);

    }
    VotingData setup6() {

        VotingData vd6 = new VotingData();

        // put candidates on the ballot
        try {

            vd6.nominateCandidate("husky");
            vd6.nominateCandidate("husky");
            vd6.nominateCandidate("ziggy");

        } catch (Exception e) {
            return vd6;
        }

        // cast votes

        try {
            // gompei and ziggy both have the same number of points
            vd6.submitVote("gompei", "husky", "ziggy");
            vd6.submitVote("ziggy", "husky", "gompei");
            vd6.submitVote("ziggy", "husky", "gompei");



        } catch (Exception e) {
            return vd6;
        }

        return vd6;

    }


    // Tests on elections

    // Most first winner
    @Test
    public void testMostFirstWinner_BasicWinner() {
        assertEquals ("gompei", this.setup1().pickWinnerMostFirstChoice());
    }
    @Test
    public void testMostFirstWinner_Runoff() {
        assertEquals ("*Requires Runoff Poll*", this.setup2().pickWinnerMostFirstChoice());
    }
    @Test
    public void testMostFirstWinner_ClearWinner() {
        assertEquals ("gompei", this.setup3().pickWinnerMostFirstChoice());
    }



    // Most agreeable
    @Test
    public void testMostAgreeable() {
        assertEquals ("gompei", this.setup1().pickWinnerMostAgreeable());
    }
    @Test
    public void testMostAgreeable_Tie() {
        assertEquals ("gompei", this.setup2().pickWinnerMostAgreeable());
    }
    @Test
    public void testMostAgreeable_HighVoteCount() {
        assertEquals ("husky", this.setup3().pickWinnerMostAgreeable());
    }



    // Exceptions

    //Testing CandidateNotFoundException Exception in submitVotes
    @Test(expected = CandidateNotFoundException.class)
    public void testSubmitVotes_CandidateNotFound() throws CandidateNotFoundException, CandidateChosenMoreThanOnceException
    {
        setup4().submitVote("karish", "husky", "gompei");
    }

    //Testing CandidateChosenMoreThanOnce in submitVotes
    @Test(expected = CandidateChosenMoreThanOnceException.class)
    public void testSubmitVotes_CandidateChosenMoreThanOnce() throws CandidateNotFoundException, CandidateChosenMoreThanOnceException
    {
        setup5().submitVote("husky", "husky", "gompei");
    }

    //Testing RedundantCandidateException in nominateCandidate
    @Test(expected = RedundantCandidateException.class)
    public void nominateCandidates_Redundant() throws RedundantCandidateException
    {
        setup6().nominateCandidate("husky");
        setup6().nominateCandidate("husky");

    }

    //Testing RedundantCandidateException in nominateCandidate
    @Test(expected = RedundantCandidateException.class)
    public void nominateCandidates_Redundant_NewNames() throws RedundantCandidateException
    {
        setup6().nominateCandidate("karish");
        setup6().nominateCandidate("husky");

    }



}
