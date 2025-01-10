package com.ernesto.banco_multiplo.repository.banco;

import com.ernesto.banco_multiplo.entity.banco.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, String> {
}
