package com.ernesto.banco_multiplo.service;

import com.ernesto.banco_multiplo.model.ContaPrazo;
import com.ernesto.banco_multiplo.repository.ContaPrazoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ContaPrazoService {

    @Autowired
    private ContaPrazoRepository contaPrazoRepository;

    public List<ContaPrazo> getAll() {
        return contaPrazoRepository.findAll();
    }

    public ContaPrazo getById(Long id) {
        return contaPrazoRepository.findById(id).get();
    }

    public List<ContaPrazo> insert(ContaPrazo contaPrazo) {
        contaPrazo.setData_abertura(new Date());
        contaPrazoRepository.saveAndFlush(contaPrazo);
        return getAll();
    }

    public List<ContaPrazo> update(ContaPrazo contaPrazo) {
        contaPrazoRepository.saveAndFlush(contaPrazo);
        return getAll();
    }

    public List<ContaPrazo> delete(Long id) {
        ContaPrazo contaPrazo = contaPrazoRepository.findById(id).get();
        contaPrazoRepository.delete(contaPrazo);
        return getAll();
    }
}
