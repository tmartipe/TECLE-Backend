package com.utn.frlp.tecle.controller;

import com.utn.frlp.tecle.dto.UserRequest;
import com.utn.frlp.tecle.entity.User;
import com.utn.frlp.tecle.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping(value = "api/users")
public class UserRestfulController {

    private final UserService userService;

    @PostMapping("/")
    public ResponseEntity<User> createUser(final @RequestBody UserRequest request){
        return ResponseEntity.ok(userService.createUser(request));
    }

}
