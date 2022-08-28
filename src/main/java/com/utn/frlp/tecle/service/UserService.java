package com.utn.frlp.tecle.service;

import com.utn.frlp.tecle.dto.RegistrationRequest;
import com.utn.frlp.tecle.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

public interface UserService {

    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
    User registerUser(RegistrationRequest request);

    Set<User> getAll();
    String signUpUser(User user);
    void enableUser(User user);

    boolean userHasToken(User user);

    User getUserByEmail(String email);

}
