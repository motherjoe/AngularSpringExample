package com.nothing.demo.service;

import com.nothing.demo.domain.User;
import java.util.List;

public interface UserService {

    void createUser(User u);
    User findUser(long id);
    User findUser(String username);
    Iterable<User> allUsers();
}
