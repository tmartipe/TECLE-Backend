package com.utn.frlp.tecle.security.config;

import com.utn.frlp.tecle.entity.SecurityUser;
import com.utn.frlp.tecle.entity.User;
import com.utn.frlp.tecle.security.PasswordEncoder;
import com.utn.frlp.tecle.service.UserService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class TecleUsernamePwdAuthenticationProvider implements AuthenticationProvider {

    private UserService userService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String pwd = authentication.getCredentials().toString();
        SecurityUser user = new SecurityUser(userService.getUserByEmail(username));
        if(bCryptPasswordEncoder.matches(pwd, user.getPassword())) {
            return new UsernamePasswordAuthenticationToken(username, pwd,
                    getGrantedAuthorities(user.getAuthorities()));
        }
        throw new BadCredentialsException("Contraseña invalida.");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }

    private List<GrantedAuthority> getGrantedAuthorities(Collection<? extends GrantedAuthority> authorities) {
        return new ArrayList<>(authorities);
    }
}
