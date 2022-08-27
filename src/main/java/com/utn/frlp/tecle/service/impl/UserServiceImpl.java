package com.utn.frlp.tecle.service.impl;

import com.utn.frlp.tecle.dto.RegistrationRequest;
import com.utn.frlp.tecle.entity.ConfirmationToken;
import com.utn.frlp.tecle.entity.User;
import com.utn.frlp.tecle.exception.BadRequestException;
import com.utn.frlp.tecle.repository.UserRepository;
import com.utn.frlp.tecle.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.utn.frlp.tecle.constants.UserConstants.USER_NOT_REGISTERED;
import static com.utn.frlp.tecle.util.EntityUtil.buildUser;
import static com.utn.frlp.tecle.util.TecleUtil.generateRandomAlphanumericToken;
import static com.utn.frlp.tecle.util.TecleUtil.generateTokenForUser;
import static java.util.Optional.ofNullable;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public User registerUser(RegistrationRequest request) {
        ofNullable(request).orElseThrow(() -> new BadRequestException("Parameter is mandatory"));
        User user = buildUser(request);

        userRepository.save(user);

        return user;
    }

    @Override
    public Set<User> getAll() {
        return new TreeSet<>(userRepository.findAll());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario con email "+username+" no fue encontrado"));

        Collection<SimpleGrantedAuthority> authorities = Collections.singleton(new SimpleGrantedAuthority(user.getAppUserRole().name()));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    public String signUpUser(User user){
        boolean userExist = userRepository
                .findByEmail(user.getEmail())
                .isPresent();
        if(userExist)
            throw new BadRequestException("Usuario ya registrado con email "+user.getEmail());

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());

        user.setPassword(encodedPassword);

        userRepository.save(user);

        ConfirmationToken confirmationToken = generateTokenForUser(user);

        confirmationTokenService.saveConfirmationToken(confirmationToken);

        return confirmationToken.getToken();
    }

    @Override
    public void enableUser(User user) {
        user.setEnabled(true);
        userRepository.save(user);
    }

    @Override
    public boolean userHasToken(User user) {
        confirmationTokenService.getConfirmationTokenByUser(user);
        return true;
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new BadRequestException(USER_NOT_REGISTERED));
    }


}
