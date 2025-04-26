package repository;


import model.Vote;
import model.User;
import model.Election;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface VoteRepository extends JpaRepository<Vote, Long> {
    boolean existsByVoterAndElection(User voter, Election election);
    Optional<Vote> findByVoterAndElection(User voter, Election election);
    List<Vote> findByElectionId(Long electionId);
}

