package com.nothing.demo.controller;

import com.nothing.demo.dao.BookRepository;
import com.nothing.demo.domain.Book;
import java.util.List;
import org.omg.CORBA.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRepository dao;

    @GetMapping("")
    public List<Book> findAll(@AuthenticationPrincipal UserDetails principal){
        System.out.println(principal);
        return dao.findAllForUser(principal.getUsername());
    }

}
