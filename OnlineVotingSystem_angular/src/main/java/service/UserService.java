package service;

import model.User;
import repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    // Constructor to inject the repository
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Method to find a user by their username
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Method to save or update a user in the database
    public void persist(User user) {
        // You can use userRepository.save() to persist the user
        userRepository.save(user);
    }
}
