package com.ernesto.banco_multiplo.repository;

import com.ernesto.banco_multiplo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByNome(String nome);
}
