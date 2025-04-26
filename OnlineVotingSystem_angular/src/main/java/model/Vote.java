package model;

import jakarta.persistence.*;

@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"voter_id", "election_id"})
})
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "voter_id")
    private User voter;

    @ManyToOne
    @JoinColumn(name = "election_id")
    private Election election;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    // Default constructor
    public Vote() {
    }

    // Constructor with parameters
    public Vote(Long id, User voter, Election election, Candidate candidate) {
        this.id = id;
        this.voter = voter;
        this.election = election;
        this.candidate = candidate;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getVoter() {
        return voter;
    }

    public void setVoter(User voter) {
        this.voter = voter;
    }

    public Election getElection() {
        return election;
    }

    public void setElection(Election election) {
        this.election = election;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    // Builder pattern
    public static class VoteBuilder {
        private Long id;
        private User voter;
        private Election election;
        private Candidate candidate;

        public VoteBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public VoteBuilder voter(User voter) {
            this.voter = voter;
            return this;
        }

        public VoteBuilder election(Election election) {
            this.election = election;
            return this;
        }

        public VoteBuilder candidate(Candidate candidate) {
            this.candidate = candidate;
            return this;
        }

        public Vote build() {
            return new Vote(id, voter, election, candidate);
        }
    }

    // Builder method to start the builder pattern
    public static VoteBuilder builder() {
        return new VoteBuilder();
    }

    @Override
    public String toString() {
        return "Vote [id=" + id + ", voter=" + voter + ", election=" + election + ", candidate=" + candidate + "]";
    }
}
