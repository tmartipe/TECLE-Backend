package com.utn.frlp.tecle.repository;

import com.utn.frlp.tecle.entity.ConfirmationToken;
import com.utn.frlp.tecle.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long> {

    Optional<ConfirmationToken> findByToken(String token);

    Set<ConfirmationToken> findAllByUser(User user);

}
