package service;

import model.*;
import repository.VoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteService {

    private final VoteRepository voteRepository;

    public VoteService(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    public boolean hasVoted(User voter, Election election) {
        return voteRepository.existsByVoterAndElection(voter, election);
    }

    public Vote castVote(User voter, Election election, Candidate candidate) {
        if (hasVoted(voter, election)) {
            throw new RuntimeException("You have already voted in this election.");
        }

        Vote vote = Vote.builder()
                .voter(voter)
                .election(election)
                .candidate(candidate)
                .build();

        return voteRepository.save(vote);
    }

    public List<Vote> getVotesByElection(Long electionId) {
        return voteRepository.findByElectionId(electionId);
    }
}
