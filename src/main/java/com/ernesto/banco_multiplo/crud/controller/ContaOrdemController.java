package com.ernesto.banco_multiplo.crud.controller;

import com.ernesto.banco_multiplo.crud.model.ContaOrdem;
import com.ernesto.banco_multiplo.service.ContaOrdemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banco/v1/conta/ordem")
public class ContaOrdemController {

    @Autowired
    private ContaOrdemService contaOrdemService;

    @GetMapping("/get")
    public List<ContaOrdem> getAll() {
        return contaOrdemService.getAll();
    }

    @GetMapping("/get/numeroConta")
    public ContaOrdem getByNumeroConta(@RequestParam("nr_conta") String numeroConta) {
        return contaOrdemService.getByNumeroConta(numeroConta);
    }

    @GetMapping("/get/{id}")
    public ContaOrdem getById(@PathVariable("id") Long id) {
        return contaOrdemService.getById(id);
    }

    @PostMapping("/insert")
    public ContaOrdem insert(@RequestBody ContaOrdem contaOrdem) {
        return contaOrdemService.insert(contaOrdem);
    }

    @PutMapping("/update")
    public ContaOrdem update(@RequestBody ContaOrdem contaOrdem) {
        return contaOrdemService.update(contaOrdem);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        return contaOrdemService.delete(id);
    }
}
