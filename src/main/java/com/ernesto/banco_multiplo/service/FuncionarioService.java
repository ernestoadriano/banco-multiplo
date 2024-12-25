package com.ernesto.banco_multiplo.service;

import com.ernesto.banco_multiplo.crud.model.Funcionario;
import com.ernesto.banco_multiplo.crud.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> getAll() {
        return funcionarioRepository.findAll();
    }

    public Funcionario getById(Long id) {
        return funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado!"));
    }

    public Funcionario getByNome(String nome) {
        return funcionarioRepository.findByNome(nome)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado!"));
    }

    public Funcionario insert(Funcionario funcionario) {
        return funcionarioRepository.saveAndFlush(funcionario);
    }

    public Funcionario update(Funcionario funcionario) {
        return funcionarioRepository.saveAndFlush(funcionario);
    }

    public String delete(Long id) {
        Funcionario funcionario = getById(id);
        funcionarioRepository.delete(funcionario);
        return "Funcionário Apagado!";
    }
}
