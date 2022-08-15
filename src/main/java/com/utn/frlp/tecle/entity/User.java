package com.utn.frlp.tecle.entity;

import com.utn.frlp.tecle.enums.AppUserRole;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "USER")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User implements Comparable<User>, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private Long dni;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private Long age;
    private String academicUnit;
    private String telephone;
    private boolean enabled;
    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;

    @Override
    public int compareTo(@NotNull User o) {
        return this.getLastName().compareTo(o.getLastName());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(this.appUserRole.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
