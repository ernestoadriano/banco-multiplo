package com.ernesto.banco_multiplo.service;


import com.ernesto.banco_multiplo.model.Funcionario;
import com.ernesto.banco_multiplo.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> getAll() {
        return funcionarioRepository.findAll();
    }

    public Funcionario getById(Long id) {
        return funcionarioRepository.findById(id).get();
    }

    public List<Funcionario> insert(Funcionario funcionario) {
        funcionario.setData_registo(new Date());
        funcionarioRepository.saveAndFlush(funcionario);
        return funcionarioRepository.findAll();
    }

    public List<Funcionario> update(Funcionario funcionario) {
        Funcionario f = funcionarioRepository.findById(funcionario.getId()).get();
        funcionario.setData_registo(f.getData_registo());
        funcionarioRepository.saveAndFlush(funcionario);
        return funcionarioRepository.findAll();
    }

    public List<Funcionario> delete(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id).get();
        funcionarioRepository.delete(funcionario);
        return funcionarioRepository.findAll();
    }
}
