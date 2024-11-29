package com.ernesto.banco_multiplo.controller;


import com.ernesto.banco_multiplo.model.UtilizadorFuncionario;
import com.ernesto.banco_multiplo.service.UtilizadorFuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/utilizador_funcionario")
public class UtilizadorFuncionarioController {

    @Autowired
    private UtilizadorFuncionarioService utilizadorFuncionarioService;

    @GetMapping("/getAll")
    public List<UtilizadorFuncionario> getAll() {
        return utilizadorFuncionarioService.getAll();
    }

    @GetMapping("/get/{id}")
    public UtilizadorFuncionario getById(@PathVariable("id") Long id) {
        return utilizadorFuncionarioService.getById(id);
    }

    @PostMapping("/insert")
    public List<UtilizadorFuncionario> insert(@RequestBody UtilizadorFuncionario utilizadorFuncionario) {
        return utilizadorFuncionarioService.insert(utilizadorFuncionario);
    }

    @PostMapping("/update")
    public List<UtilizadorFuncionario> update(@RequestBody UtilizadorFuncionario utilizadorFuncionario) {
        return utilizadorFuncionarioService.update(utilizadorFuncionario);
    }

    @DeleteMapping("/delete/{id}")
    public List<UtilizadorFuncionario> delete(@PathVariable("id") Long id) {
        return utilizadorFuncionarioService.delete(id);
    }
}
