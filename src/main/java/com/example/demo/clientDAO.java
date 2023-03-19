package com.example.demo;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
public class clientDAO implements UserDetails {
    String ROLE_PREFIX = "ROLE_";

    private int id;
    private String user_id;
    private String pass_word;
    private String role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + role));
        return authorities;
    }

    @Override
    public String getPassword() {
        return pass_word;
    }

    @Override
    public String getUsername() {
        return user_id;
    }

    // 계정 만료 여부(true: 만료되지 않음, false: 만료됨)
    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    // 계정 잠금 여부(true: 계정잠금아님, false: 계정잠금상태)
    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    // 계정 패스워드 만료 여부(true: 만료되지 않음, false: 만료됨)
    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    // 계정 사용가능 여부(true: 사용가능, false: 사용불가능)
    @Override
    public boolean isEnabled() {
        return false;
    }
}
