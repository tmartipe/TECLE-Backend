package com.utn.frlp.tecle.service.impl;

import com.utn.frlp.tecle.entity.ConfirmationToken;
import com.utn.frlp.tecle.entity.User;
import com.utn.frlp.tecle.exception.BadRequestException;
import com.utn.frlp.tecle.repository.ConfirmationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

import static com.utn.frlp.tecle.constants.RegistrationConstants.TOKEN_NOT_FOUND;
import static com.utn.frlp.tecle.constants.RegistrationConstants.USER_HAS_NO_TOKEN;

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
        ConfirmationToken confirmationToken = getConfirmationTokenByToken(token);
        confirmationToken.setConfirmedAt(LocalDateTime.now());
        repository.save(confirmationToken);
    }

    public ConfirmationToken getConfirmationTokenByToken(String token){
        return repository.findByToken(token).orElseThrow(() -> new BadRequestException(TOKEN_NOT_FOUND));
    }

    public Set<ConfirmationToken> getConfirmationTokenByUser(User user){
        Set<ConfirmationToken> tokens = repository.findAllByUser(user);
        if(tokens.isEmpty())
            throw new BadRequestException(USER_HAS_NO_TOKEN);
        return tokens;
    }

    private void expireAll(Set<ConfirmationToken> tokens){
        for(ConfirmationToken token : tokens){
            token.setExpiresAt(LocalDateTime.now());
        }
        repository.saveAll(tokens);
    }

    public void expireAllTokensForUser(User user){
        expireAll(getConfirmationTokenByUser(user));
    }

}
