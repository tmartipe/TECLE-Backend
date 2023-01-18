package com.utn.frlp.tecle.security.config;

import com.utn.frlp.tecle.entity.SecurityUser;
import com.utn.frlp.tecle.entity.User;
import com.utn.frlp.tecle.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class TecleUserDetailsService implements UserDetailsService {

    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByEmail(username);
        return new SecurityUser(user);
    }
}
