package com.ernesto.banco_multiplo.repository;

import com.ernesto.banco_multiplo.model.ContaOrdem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaOrdemRepository extends JpaRepository<ContaOrdem, Long>{
}
