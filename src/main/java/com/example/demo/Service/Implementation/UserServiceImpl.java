package com.example.demo.Service.Implementation;

import com.example.demo.Model.Role;
import com.example.demo.Model.User;
import com.example.demo.Repository.RoleRepo;
import com.example.demo.Repository.UserRepo;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepository;
    @Autowired
    private RoleRepo roleRepository;

    @Override
    public User findUserByEmail(String Email) {
        return userRepository.findByEmail(Email);
    }

    @Override
    public User registerUser(User user) {
        return null;
    }

    @Override
    public User updateUser(long id, User newUSer) {
        return null;
    }

    @Override
    public User findUserById(long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User userInBase = optionalUser.get();
            return userInBase;
        } else throw new NoSuchElementException("User not found with id = " + id);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public ResponseEntity deleteUser(long id) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserLogged() {
        return null;
    }
}
