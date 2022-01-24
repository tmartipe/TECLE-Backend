package com.utn.frlp.tecle.service.impl;

import com.utn.frlp.tecle.dto.UserDto;
import com.utn.frlp.tecle.entity.User;
import com.utn.frlp.tecle.exception.BadRequestException;
import com.utn.frlp.tecle.repository.UserRepository;
import com.utn.frlp.tecle.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static com.utn.frlp.tecle.util.EntityUtil.buildUser;
import static java.util.Optional.ofNullable;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(UserDto request) {
        ofNullable(request).orElseThrow(() -> new BadRequestException("Parameter is mandatory"));

        User user = buildUser(request);

        userRepository.save(user);

        return user;
    }

    @Override
    public Set<User> getAll() {
        return new TreeSet<>(userRepository.findAll());
    }
}
