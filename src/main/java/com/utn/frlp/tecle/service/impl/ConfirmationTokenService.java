package com.utn.frlp.tecle.service.impl;

import com.utn.frlp.tecle.entity.ConfirmationToken;
import com.utn.frlp.tecle.repository.ConfirmationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {

    private final ConfirmationTokenRepository repository;

    public void saveConfirmationToken(ConfirmationToken token){
        repository.save(token);
    }

    public Optional<ConfirmationToken> getToken(String token){
        return repository.findByToken(token);
    }

    public void setConfirmedAt(String token){
        ConfirmationToken confirmationToken = repository.findByToken(token).get();
        confirmationToken.setConfirmedAt(LocalDateTime.now());
        repository.save(confirmationToken);
    }

}
