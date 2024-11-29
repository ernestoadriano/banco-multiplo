package com.ernesto.banco_multiplo.service;

import com.ernesto.banco_multiplo.model.UtilizadorCliente;
import com.ernesto.banco_multiplo.repository.UtilizadorClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilizadorClienteService {

    @Autowired
    private UtilizadorClienteRepository utilizadorClienteRepository;

    public List<UtilizadorCliente> getAll() {
        return utilizadorClienteRepository.findAll();
    }

    public UtilizadorCliente getById(Long id) {
        return utilizadorClienteRepository.findById(id).get();
    }

    public List<UtilizadorCliente> insert(UtilizadorCliente utilizadorCliente) {
        utilizadorClienteRepository.saveAndFlush(utilizadorCliente);
        return utilizadorClienteRepository.findAll();
    }

    public List<UtilizadorCliente> update(UtilizadorCliente utilizadorCliente) {
        utilizadorClienteRepository.saveAndFlush(utilizadorCliente);
        return utilizadorClienteRepository.findAll();
    }

    public List<UtilizadorCliente> delete(Long id) {
        UtilizadorCliente utilizadorCliente = utilizadorClienteRepository.findById(id).get();
        utilizadorClienteRepository.delete(utilizadorCliente);
        return utilizadorClienteRepository.findAll();
    }
}
