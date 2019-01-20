package com.nothing.demo.controller;

import com.nothing.demo.dao.UserRepository;
import com.nothing.demo.domain.User;
import com.nothing.demo.service.UserService;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/signup")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("")
    public String create(){
        logger.debug("Create get made");
        return "home";
    }

    @GetMapping("encode/{rawpwd}")
    @ResponseBody
    public String encode(@PathVariable("rawpwd") String password){
        return passwordEncoder.encode(password);
    }

    @PostMapping("")
    @Transactional
    public String create(@Valid User u){
        userService.createUser(u);
        return "home";
    }
}
