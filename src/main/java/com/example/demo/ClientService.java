package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ClientService {

    ClientMapper clientMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ClientService(ClientMapper clientMapper) {
        super();
        this.clientMapper = clientMapper;
    }

    public clientDAO findUserById(String user_id) {
        return clientMapper.getClient(user_id);
    }

    public void registerUserService(Map<String , String > map) {
        clientDAO clientDAO = new clientDAO();
        clientDAO.setUser_id(map.get("user_id"));
        clientDAO.setRole(map.get("role"));
        clientDAO.getAuthorities();

        clientDAO.setPass_word(passwordEncoder.encode(map.get("pass_word")));

        clientMapper.insertClient(clientDAO);
    }
}
