package com.ernesto.banco_multiplo.repository;

import com.ernesto.banco_multiplo.model.UtilizadorFuncionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilizadorFuncionarioRepository extends JpaRepository<UtilizadorFuncionario, Long> {
}
