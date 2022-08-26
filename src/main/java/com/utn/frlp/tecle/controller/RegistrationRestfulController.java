package com.utn.frlp.tecle.controller;

import com.utn.frlp.tecle.dto.BaseDto;
import com.utn.frlp.tecle.dto.RegistrationRequest;
import com.utn.frlp.tecle.service.impl.RegistrationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping(value = "api/registration")
public class RegistrationRestfulController {

    private final RegistrationService registrationService;

    @PostMapping
    public ResponseEntity<BaseDto<Object>> registerUser(final @RequestBody RegistrationRequest request){
        return ResponseEntity.ok(registrationService.registerUser(request));
    }

    @GetMapping(path="/confirm")
    public String confirmUser(@RequestParam("token")String token) {
        return registrationService.confirmToken(token);
    }
}
