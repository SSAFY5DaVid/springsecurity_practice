package com.example.demo;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClientMapper {
    List<clientDAO> clientList();

    clientDAO getClient(String user_id);

    int insertClient(clientDAO dao);
}
