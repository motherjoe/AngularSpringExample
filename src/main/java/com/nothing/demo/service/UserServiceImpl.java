package com.nothing.demo.service;

import com.nothing.demo.dao.UserRepository;
import com.nothing.demo.domain.User;
import java.util.List;
import java.util.Optional;
import javax.xml.ws.ServiceMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository dao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    @Modifying
    public void createUser(User u) {
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        dao.save(u);
    }

    @Override
    public User findUser(long id) {
        Optional<User> user = dao.findById(id);
        if (user.isPresent()) return user.get();
        else return null;
    }

    @Override
    public User findUser(String username) {
        return dao.findByUsername(username);
    }

    @Override
    public Iterable<User> allUsers() {
        return dao.findAll();
    }
}
