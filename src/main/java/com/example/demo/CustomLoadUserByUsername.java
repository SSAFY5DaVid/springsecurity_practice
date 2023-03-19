package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomLoadUserByUsername implements UserDetailsService {

    @Autowired
    ClientService clientService;

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        clientDAO user = clientService.findUserById(loginId);
        if(user == null) throw new UsernameNotFoundException("Not Found User");
        return user;
    }

}