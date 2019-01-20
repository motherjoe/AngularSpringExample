package com.nothing.demo.security;

import com.nothing.demo.dao.UserRepository;
import com.nothing.demo.domain.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    //get user from the database, via Hibernate
    @Autowired
    private UserRepository userDao;

@Transactional(readOnly = true)
@Override
    public UserDetails loadUserByUsername(final String username)
            throws UsernameNotFoundException {
//CUSTOM USER HERE vvv
        User user = userDao.findByUsername(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
//                buildUserAuthority(user.getUserRole());
//if you're implementing UserDetails you wouldn't need to call this method and instead return the User as it is
        //return buildUserForAuthentication(user, authorities);
        return buildUserForAuthentication(user, authorities);

    }

    // Converts user to spring.springframework.security.core.userdetails.User
    private org.springframework.security.core.userdetails.User buildUserForAuthentication(User user,
                                                                                          List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                user.isActive(), true, true, true, authorities);
    }

//    private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
//
//        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
//
//        // add user's authorities
//        for (UserRole userRole : userRoles) {
//            setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
//        }
//
//        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
//
//        return Result;
//    }

}
