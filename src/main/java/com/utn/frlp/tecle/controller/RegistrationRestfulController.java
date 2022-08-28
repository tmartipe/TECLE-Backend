package com.utn.frlp.tecle.controller;

import com.utn.frlp.tecle.dto.BaseDto;
import com.utn.frlp.tecle.dto.MessageResponse;
import com.utn.frlp.tecle.dto.NewCodeRequest;
import com.utn.frlp.tecle.dto.RegistrationRequest;
import com.utn.frlp.tecle.service.UserService;
import com.utn.frlp.tecle.service.impl.RegistrationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping(value = "api/registration")
public class RegistrationRestfulController {

    private final RegistrationService registrationService;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<BaseDto<Object>> registerUser(final @RequestBody RegistrationRequest request){
        return ResponseEntity.ok(registrationService.registerUser(request));
    }

    @GetMapping(path="/confirm")
    public ResponseEntity<MessageResponse> confirmUser(@RequestParam("token")String token) {
        return ResponseEntity.ok(registrationService.confirmToken(token));
    }

    @PostMapping(path="/new-code")
    public ResponseEntity<MessageResponse> getNewCodeForEmail(final @RequestBody NewCodeRequest request){
        return ResponseEntity.ok(registrationService.getNewTokenFor(request));
    }


    @GetMapping("/refresh-token")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        userService.refreshToken(request,response);
    }
}
