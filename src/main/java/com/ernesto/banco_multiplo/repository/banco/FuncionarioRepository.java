package com.ernesto.banco_multiplo.repository.banco;

import com.ernesto.banco_multiplo.entity.banco.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*
 * @author: Ernesto Adriano
 * */
@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, String> {

    Optional<Funcionario> findByNumBi(String numBi);
}
