package com.ernesto.banco_multiplo.repository.banco;

import com.ernesto.banco_multiplo.entity.banco.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {

    Optional<Cliente> findByNumBi(String numBi);
}
