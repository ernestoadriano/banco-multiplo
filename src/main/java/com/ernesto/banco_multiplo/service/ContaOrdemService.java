package com.ernesto.banco_multiplo.service;

import com.ernesto.banco_multiplo.crud.model.ContaOrdem;
import com.ernesto.banco_multiplo.crud.repository.ContaOrdemRepository;
import com.ernesto.banco_multiplo.util.GeradorConta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@Service
public class ContaOrdemService {

    @Autowired
    private ContaOrdemRepository contaOrdemRepository;


    public List<ContaOrdem> getAll() {
        return contaOrdemRepository.findAll();
    }

    public ContaOrdem getById(Long id) {
        return contaOrdemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conta não encontrado!"));
    }

    public ContaOrdem getByNumeroConta(String numeroConta) {
        return contaOrdemRepository.findByNumeroConta(numeroConta)
                .orElseThrow(() -> new RuntimeException("Conta não encontrada!"));
    }

    public ContaOrdem insert(ContaOrdem contaOrdem) {
        String numeroConta = GeradorConta.gerar();
        contaOrdem.setNumeroConta(numeroConta);
        contaOrdem.setDataAbertura(new Date());
        return contaOrdemRepository.saveAndFlush(contaOrdem);
    }

    public ContaOrdem update(ContaOrdem contaOrdem) {
        return contaOrdemRepository.saveAndFlush(contaOrdem);
    }

    public String delete(Long id) {
        ContaOrdem contaOrdem = getById(id);
        contaOrdemRepository.delete(contaOrdem);
        return "Conta apagada com sucesso!";
    }
}
