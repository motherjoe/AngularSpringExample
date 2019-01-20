package com.nothing.demo.security.token;

import java.util.Collections;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.omg.CORBA.Principal;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {
    @RequestMapping("/token")
    public Map<String,String> token(HttpSession session) {
        return Collections.singletonMap("token", session.getId());
    }

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

}
