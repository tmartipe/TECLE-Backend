package com.utn.frlp.tecle.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.utn.frlp.tecle.dto.BaseDto;
import com.utn.frlp.tecle.dto.RegistrationRequest;
import com.utn.frlp.tecle.entity.User;
import com.utn.frlp.tecle.service.UserService;
import com.utn.frlp.tecle.service.impl.RegistrationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

import static com.utn.frlp.tecle.constants.RegistrationConstants.TOKEN_CANNOT_BE_VALIDATED;
import static com.utn.frlp.tecle.util.TecleUtil.getTokenAlgorithm;
import static java.util.Arrays.stream;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

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
