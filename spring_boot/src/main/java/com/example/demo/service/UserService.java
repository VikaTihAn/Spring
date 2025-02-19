package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isEmpty()) {
            try {
                throw new IllegalAccessException ("Юзера с id " + id + " не существует");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return userOptional;
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public void updateUser(Long id, User newUser) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
            User user1 = user.get();
            user1.setFirstName(newUser.getFirstName());
            user1.setLastName(newUser.getFirstName());
            user1.setEmail(newUser.getEmail());
            userRepository.save(user1);
        }
        else {
            try {
                throw new IllegalAccessException();
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
