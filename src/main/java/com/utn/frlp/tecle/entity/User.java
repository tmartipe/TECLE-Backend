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
public class User implements Comparable<User> {

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
        return this.getDni().compareTo(o.getDni());
    }
}
