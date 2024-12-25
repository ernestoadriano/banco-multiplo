package com.ernesto.banco_multiplo.crud.repository;

import com.ernesto.banco_multiplo.crud.model.Cliente;
import com.ernesto.banco_multiplo.crud.model.ContaOrdem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContaOrdemRepository extends JpaRepository<ContaOrdem, Long> {

    Optional<ContaOrdem> findByNumeroConta(String numeroConta);
}
