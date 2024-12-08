package com.ernesto.banco_multiplo.service;

import com.ernesto.banco_multiplo.model.ContaOrdem;
import com.ernesto.banco_multiplo.repository.ContaOrdemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return contaOrdemRepository.findById(id).get();
    }

    public List<ContaOrdem> insert(ContaOrdem contaOrdem) {
        contaOrdem.setData_abertura(new Date());
        contaOrdemRepository.saveAndFlush(contaOrdem);
        return getAll();
    }

    public List<ContaOrdem> update(ContaOrdem contaOrdem) {
        contaOrdemRepository.saveAndFlush(contaOrdem);
        return getAll();
    }

    public List<ContaOrdem> delete(Long id) {
        ContaOrdem contaOrdem = contaOrdemRepository.findById(id).get();
        contaOrdemRepository.delete(contaOrdem);
        return getAll();
    }
}
