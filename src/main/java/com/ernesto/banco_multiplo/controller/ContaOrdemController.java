package com.ernesto.banco_multiplo.controller;

import com.ernesto.banco_multiplo.model.ContaOrdem;
import com.ernesto.banco_multiplo.service.ContaOrdemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/conta_ordem")
public class ContaOrdemController {

    @Autowired
    private ContaOrdemService contaOrdemService;

    @GetMapping("/getAll")
    public List<ContaOrdem> getAll() {
        return contaOrdemService.getAll();
    }

    @GetMapping("/get/{id}")
    public ContaOrdem getById(@PathVariable("id") Long id) {
        return contaOrdemService.getById(id);
    }

    @PostMapping("/insert")
    public List<ContaOrdem> insert(@RequestBody ContaOrdem contaOrdem) {
        return contaOrdemService.insert(contaOrdem);
    }

    @PutMapping("/update")
    public List<ContaOrdem> update(@RequestBody ContaOrdem contaOrdem) {
        return contaOrdemService.update(contaOrdem);
    }

    @DeleteMapping("/delete/{id}")
    public List<ContaOrdem> delete(@PathVariable("id") Long id) {
        return contaOrdemService.delete(id);
    }
}
