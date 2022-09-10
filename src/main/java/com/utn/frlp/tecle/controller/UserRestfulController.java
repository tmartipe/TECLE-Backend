package com.utn.frlp.tecle.controller;

import com.utn.frlp.tecle.entity.User;
import com.utn.frlp.tecle.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping(value = "api/users")
public class UserRestfulController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<Set<User>> getAll(){
        return ResponseEntity.ok(userService.getAll());
    }



}
