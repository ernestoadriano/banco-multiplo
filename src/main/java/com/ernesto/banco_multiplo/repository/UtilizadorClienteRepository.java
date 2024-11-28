package com.ernesto.banco_multiplo.repository;

import com.ernesto.banco_multiplo.model.UtilizadorCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilizadorClienteRepository extends JpaRepository<UtilizadorCliente, Long> {
}
