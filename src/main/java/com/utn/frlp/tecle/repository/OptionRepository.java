package com.utn.frlp.tecle.repository;

import com.utn.frlp.tecle.entity.Choice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepository extends JpaRepository<Choice, Long> {
}
