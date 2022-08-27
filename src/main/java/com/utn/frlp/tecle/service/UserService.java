package com.utn.frlp.tecle.service;

import com.utn.frlp.tecle.dto.RegistrationRequest;
import com.utn.frlp.tecle.entity.User;

import java.util.Set;

public interface UserService {

    User registerUser(RegistrationRequest request);

    Set<User> getAll();
    String signUpUser(User user);
    void enableUser(User user);

    boolean userHasToken(User user);

    User getUserByEmail(String email);

}
