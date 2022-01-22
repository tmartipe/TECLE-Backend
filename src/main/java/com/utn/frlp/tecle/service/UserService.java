package com.utn.frlp.tecle.service;

import com.utn.frlp.tecle.dto.UserRequest;
import com.utn.frlp.tecle.entity.User;

public interface UserService {

    User createUser(UserRequest request);

}
