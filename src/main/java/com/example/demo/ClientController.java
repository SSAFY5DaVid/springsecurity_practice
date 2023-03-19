package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@Slf4j
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/login/success")
    public ResponseEntity notSesstion() {
        log.info("로그인 성공");
        Map<String,Object> map = new HashMap<>();
        map.put("result", 1);
        return new ResponseEntity(map, HttpStatus.OK);
    }

    @GetMapping("/login/fail")
    public ResponseEntity hello() {
        log.info("로그인 실패");
        Map<String,Object> map = new HashMap<>();
        map.put("result", 0);
        return new ResponseEntity(map, HttpStatus.OK);
    }

    @GetMapping("/user")
    public String test(Principal user) {
        return "user만 접근";
    }

    @GetMapping("chek")
    public ResponseEntity<?> getchke() {

        return ResponseEntity.ok().body(clientService.clientMapper.clientList());
    }

    @PostMapping("/registerUser") // login content-type form-data 형식으로 들어오면 됨  
    public ResponseEntity<?> registerUser(@RequestBody Map<String , String> map) {
        System.out.println("들어오냐");
        clientService.registerUserService(map);
        return ResponseEntity.ok().body("등록완료");
    }
}
