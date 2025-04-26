package service;

import model.Candidate;
import repository.CandidateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {

    private final CandidateRepository candidateRepository;

    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public Candidate save(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    public List<Candidate> getByElectionId(Long electionId) {
        return candidateRepository.findByElectionId(electionId);
    }
}
