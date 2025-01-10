package com.ernesto.banco_multiplo.controller.banco;

import com.ernesto.banco_multiplo.entity.banco.Funcionario;
import com.ernesto.banco_multiplo.service.banco.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
 * @author: Ernesto Adriano
 * */
@RestController
@RequestMapping("/banco/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @GetMapping("/get")
    public List<Funcionario> getAll() {
        return service.getAll();
    }

    @GetMapping("get/{bi}")
    public Funcionario getByNumBi(@PathVariable("bi") String bi) {
        return service.getByNumBi(bi);
    }

    @PostMapping("/insert")
    public Funcionario insert(@RequestBody Funcionario funcionario) {
        return service.insert(funcionario);
    }

    @PutMapping("update/{id}")
    public Funcionario update(@PathVariable("id") String id, @RequestBody Funcionario funcionario) {
        return service.update(id, funcionario);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}

