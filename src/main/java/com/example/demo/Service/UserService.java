package com.example.demo.Service;

import com.example.demo.Model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    User findUserByEmail(String Email);

    User registerUser(User user);

    User updateUser(long id, User newUSer);

    User findUserById(long id);

    User saveUser(User user);

    ResponseEntity deleteUser(long id);

    List<User> getUsers();

    User getUserLogged();
}
