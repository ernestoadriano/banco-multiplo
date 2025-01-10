package com.ernesto.banco_multiplo.service.banco;


import com.ernesto.banco_multiplo.entity.banco.Funcionario;
import com.ernesto.banco_multiplo.repository.banco.FuncionarioRepository;
import com.ernesto.banco_multiplo.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Funcionario> getAll() {
        return funcionarioRepository.findAll();
    }

    public Funcionario getByNumBi(String bi) {
        return funcionarioRepository.findByNumBi(bi)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado!"));
    }

    public Funcionario getById(String id) {
        return funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado!"));
    }

    public Funcionario insert(Funcionario funcionario) {
        return funcionarioRepository.saveAndFlush(funcionario);
    }

    public Funcionario update(String id, Funcionario funcionario) {
        Funcionario fun = getById(id);
        if (funcionario.getNomeCompleto() != null)
            fun.setNomeCompleto(funcionario.getNomeCompleto());
        if (funcionario.getDataNascimento() != null)
            fun.setDataNascimento(funcionario.getDataNascimento());
        if (funcionario.getNumBi() != null)
            fun.setNumBi(funcionario.getNumBi());
        if (funcionario.getResidencia() != null)
            fun.setResidencia(funcionario.getResidencia());
        if (funcionario.getTelefone() != null)
            fun.setTelefone(funcionario.getTelefone());
        if (funcionario.getEmail() != null)
            fun.setEmail(funcionario.getEmail());
        if (funcionario.getUser() != null)
            fun.setUser(funcionario.getUser());
        if (funcionario.getFuncao() != null)
            fun.setFuncao(funcionario.getFuncao());

        return funcionarioRepository.saveAndFlush(fun);
    }

    public String delete(String id) {
        Funcionario funcionario = getById(id);
        funcionarioRepository.delete(funcionario);
        return "Funcionário " + funcionario.getNomeCompleto() +" excluído!";
    }
}
