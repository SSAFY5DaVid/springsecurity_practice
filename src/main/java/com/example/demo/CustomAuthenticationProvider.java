package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private CustomLoadUserByUsername customLoadUserByUsername;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        clientDAO user = (clientDAO) customLoadUserByUsername.loadUserByUsername(authentication.getName().toString());
        String reqPassword = authentication.getCredentials().toString();
        if(!passwordEncoder.matches(reqPassword, user.getPassword())) {
            new BadCredentialsException("Not Found User");
        } else {
            System.out.println("로그인");
            return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        };

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }

}
