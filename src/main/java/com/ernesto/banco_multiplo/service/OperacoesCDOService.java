package com.ernesto.banco_multiplo.service;

import com.ernesto.banco_multiplo.model.ContaOrdem;
import com.ernesto.banco_multiplo.repository.ContaOrdemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperacoesCDOService {

    @Autowired
    private ContaOrdemRepository contaOrdemRepository;

    public ContaOrdem transferir(Long contaOrigem, Long contaDestino, Double valor) {
        ContaOrdem origem = contaOrdemRepository.findById(contaOrigem)
                .orElseThrow(() -> new IllegalArgumentException("Conta de origem não encontrada!"));
        ContaOrdem destino = contaOrdemRepository.findById(contaDestino)
                .orElseThrow(() -> new IllegalArgumentException("Conta de destino não encontrada!"));
        if (valor < 0) {
            throw new IllegalArgumentException("Valor inválido!");
        }

        if (origem.getSaldo() <= valor) {
            throw new IllegalArgumentException("Saldo insuficiente!");
        }
        origem.setSaldo(origem.getSaldo() - valor);
        destino.setSaldo(destino.getSaldo() + valor);
        contaOrdemRepository.saveAndFlush(origem);
        contaOrdemRepository.saveAndFlush(destino);
        return origem;
    }
}
