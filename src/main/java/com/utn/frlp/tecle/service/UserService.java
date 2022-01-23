package com.utn.frlp.tecle.service;

import com.utn.frlp.tecle.dto.UserDto;
import com.utn.frlp.tecle.entity.User;

public interface UserService {

    User createUser(UserDto request);

}
