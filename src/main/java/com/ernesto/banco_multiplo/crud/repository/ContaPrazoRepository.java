package com.ernesto.banco_multiplo.crud.repository;

import com.ernesto.banco_multiplo.crud.model.ContaPrazo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContaPrazoRepository extends JpaRepository<ContaPrazo, Long> {

    Optional<ContaPrazo> findByNumeroConta(String numeroConta);
}
