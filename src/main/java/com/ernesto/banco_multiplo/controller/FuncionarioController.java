package com.ernesto.banco_multiplo.controller;

import com.ernesto.banco_multiplo.model.Funcionario;
import com.ernesto.banco_multiplo.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/getAll")
    public List<Funcionario> getAll() {
        return funcionarioService.getAll();
    }

    @GetMapping("get/{id}")
    public Funcionario getById(@PathVariable("id") Long id) {
        return funcionarioService.getById(id);
    }

    @PostMapping("/insert")
    public List<Funcionario> insert(@RequestBody Funcionario funcionario) {
        return funcionarioService.insert(funcionario);
    }

    @PutMapping("/update")
    public List<Funcionario> update(@RequestBody Funcionario funcionario) {
        return funcionarioService.update(funcionario);
    }

    @DeleteMapping("/delete/{id}")
    public List<Funcionario> delete(@PathVariable("id") Long id) {
        return funcionarioService.delete(id);
    }
}
