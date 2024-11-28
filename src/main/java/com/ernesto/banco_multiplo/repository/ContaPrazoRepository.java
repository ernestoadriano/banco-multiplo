package com.ernesto.banco_multiplo.repository;

import com.ernesto.banco_multiplo.model.ContaPrazo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaPrazoRepository extends JpaRepository<ContaPrazo, Long> {
}
