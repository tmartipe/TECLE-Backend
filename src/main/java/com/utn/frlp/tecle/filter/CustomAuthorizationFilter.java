package com.utn.frlp.tecle.filter;

import com.itsallbinary.simplyregex.SimpleRegex;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthorizationFilter extends OncePerRequestFilter {

    String registrationRegex = SimpleRegex.regex().startingWith().exactString("/api/registration/").then().anyAlphaChar().build();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(request.getServletPath().equals("/api/login") || request.getServletPath().matches(registrationRegex)){
            filterChain.doFilter(request, response);
        }else {

        }
    }
}
