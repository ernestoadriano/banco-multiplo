package com.ernesto.banco_multiplo.repository;

import com.ernesto.banco_multiplo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
