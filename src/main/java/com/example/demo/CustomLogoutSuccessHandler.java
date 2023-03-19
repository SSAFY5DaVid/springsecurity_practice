package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@Component
//@Slf4j
//public class CustomLogoutSuccessHandler {
//    @Override
//    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
//        String session = request.getSession().getId();
//        HttpSession httpSession;
//        httpSession.removeAttribute(session);
//
//
//        //response.sendRedirect(port + "/login");
//    }
//}
