package com.ernesto.banco_multiplo.crud.controller;

import com.ernesto.banco_multiplo.crud.model.Funcionario;
import com.ernesto.banco_multiplo.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banco/v1/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/get")
    public List<Funcionario> getAll() {
        return funcionarioService.getAll();
    }

    @GetMapping("/get/{id}")
    public Funcionario getById(@PathVariable("id") Long id) {
        return funcionarioService.getById(id);
    }

    @GetMapping("/get/nome")
    public Funcionario getByNome(@RequestParam("nome") String nome) {
        return funcionarioService.getByNome(nome);
    }

    @PostMapping("/insert")
    public Funcionario insert(@RequestBody Funcionario funcionario) {
        return funcionarioService.insert(funcionario);
    }

    @PutMapping("/update")
    public Funcionario update(@RequestBody Funcionario funcionario) {
        return funcionarioService.update(funcionario);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        return funcionarioService.delete(id);
    }
}
