package service;

import model.Election;
import repository.ElectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectionService {

    private final ElectionRepository electionRepository;

    public ElectionService(ElectionRepository electionRepository) {
        this.electionRepository = electionRepository;
    }

    public Election save(Election election) {
        return electionRepository.save(election);
    }

    public List<Election> findAll() {
        return electionRepository.findAll();
    }

    public Election getById(Long id) {
        return electionRepository.findById(id).orElseThrow();
    }
}
