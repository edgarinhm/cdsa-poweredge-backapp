package cds.poweredge.usermanageer.services;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cds.poweredge.usermanageer.models.User;
import cds.poweredge.usermanageer.repositories.UserRepository;
import cds.poweredge.usermanageer.exceptions.NotFoundException;

@Service
@Transactional

public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User by id " + id + " was not found"));
    }

    public List<User> findUsersByName(String name) {
        return userRepository.findBynombre(name);
    }

    public void deleteUser(Long id){
        
        userRepository.deleteById(id);
    }

    public Boolean existsByName(User user){
        return userRepository.existsBynombre(user.getName());
    }

    public Boolean existsById(Long id){
        return userRepository.existsById(id);
    }
    
}
