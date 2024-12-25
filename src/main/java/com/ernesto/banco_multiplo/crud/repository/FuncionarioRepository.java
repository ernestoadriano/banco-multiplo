package com.ernesto.banco_multiplo.crud.repository;

import com.ernesto.banco_multiplo.crud.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    Optional<Funcionario> findByNome(String nome);
}
