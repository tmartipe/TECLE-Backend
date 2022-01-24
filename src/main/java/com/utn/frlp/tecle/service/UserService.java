package com.utn.frlp.tecle.service;

import com.utn.frlp.tecle.dto.UserDto;
import com.utn.frlp.tecle.entity.User;

import java.util.Set;

public interface UserService {

    User createUser(UserDto request);

    Set<User> getAll();

}
