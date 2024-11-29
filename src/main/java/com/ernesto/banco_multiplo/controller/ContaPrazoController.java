package com.ernesto.banco_multiplo.controller;

import com.ernesto.banco_multiplo.model.ContaPrazo;
import com.ernesto.banco_multiplo.service.ContaPrazoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/conta_prazo")
public class ContaPrazoController {

    @Autowired
    private ContaPrazoService contaPrazoService;

    @GetMapping("/getAll")
    public List<ContaPrazo> getAll() {
        return contaPrazoService.getAll();
    }

    @GetMapping("get/{id}")
    public ContaPrazo getById(@PathVariable("id") Long id) {
        return contaPrazoService.getById(id);
    }

    @PostMapping("/insert")
    public List<ContaPrazo> insert(@RequestBody ContaPrazo contaPrazo) {
        return contaPrazoService.insert(contaPrazo);
    }

    @PutMapping("/update")
    public List<ContaPrazo> update(@RequestBody ContaPrazo contaPrazo) {
        return contaPrazoService.update(contaPrazo);
    }

    @DeleteMapping("/delete/{id}")
    public List<ContaPrazo> delete(@PathVariable("id") Long id) {
        return contaPrazoService.delete(id);
    }
}
