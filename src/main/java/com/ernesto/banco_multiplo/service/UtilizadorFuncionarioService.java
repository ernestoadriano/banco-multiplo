package com.ernesto.banco_multiplo.service;

import com.ernesto.banco_multiplo.model.UtilizadorFuncionario;
import com.ernesto.banco_multiplo.repository.UtilizadorFuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UtilizadorFuncionarioService {

    @Autowired
    private UtilizadorFuncionarioRepository utilizadorFuncionarioRepository;

    public List<UtilizadorFuncionario> getAll() {
        return utilizadorFuncionarioRepository.findAll();
    }

    public UtilizadorFuncionario getById(Long id) {
        return utilizadorFuncionarioRepository.findById(id).get();
    }

    public List<UtilizadorFuncionario> insert(UtilizadorFuncionario utilizadorCliente) {
        utilizadorFuncionarioRepository.saveAndFlush(utilizadorCliente);
        return utilizadorFuncionarioRepository.findAll();
    }

    public List<UtilizadorFuncionario> update(UtilizadorFuncionario utilizadorCliente) {
        utilizadorFuncionarioRepository.saveAndFlush(utilizadorCliente);
        return utilizadorFuncionarioRepository.findAll();
    }

    public List<UtilizadorFuncionario> delete(Long id) {
        UtilizadorFuncionario utilizadorFuncionario = utilizadorFuncionarioRepository.findById(id).get();
        utilizadorFuncionarioRepository.delete(utilizadorFuncionario);
        return utilizadorFuncionarioRepository.findAll();
    }
}
