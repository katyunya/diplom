package com.wp.service;

import com.wp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        com.wp.domain.User myUser = userRepository.findByLogin(s);
        String role = "";
        if(myUser.getPost().getName().equals("Администратор"))
            role = "ROLE_ADMIN";
        if(myUser.getPost().getName().equals(("Старший преподаватель")))
            role = "ROLE_USER";
        return new User(myUser.getLogin(),myUser.getPassword(), AuthorityUtils.createAuthorityList(role));
    }
}
