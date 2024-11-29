package com.ernesto.banco_multiplo.controller;

import com.ernesto.banco_multiplo.model.UtilizadorCliente;
import com.ernesto.banco_multiplo.service.UtilizadorClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/utilizador_cliente")
public class UtilizadorClienteController {

    @Autowired
    private UtilizadorClienteService utilizadorClienteService;

    @GetMapping("/getAll")
    public List<UtilizadorCliente> getAll() {
        return utilizadorClienteService.getAll();
    }

    @GetMapping("/get/{id}")
    public UtilizadorCliente getById(@PathVariable("id") Long id) {
        return utilizadorClienteService.getById(id);
    }

    @PostMapping("/insert")
    public List<UtilizadorCliente> insert(@RequestBody UtilizadorCliente utilizadorCliente) {
        return utilizadorClienteService.insert(utilizadorCliente);
    }

    @PostMapping("/update")
    public List<UtilizadorCliente> update(@RequestBody UtilizadorCliente utilizadorCliente) {
        return utilizadorClienteService.update(utilizadorCliente);
    }

    @DeleteMapping("/delete/{id}")
    public List<UtilizadorCliente> delete(@PathVariable("id") Long id) {
        return utilizadorClienteService.delete(id);
    }
}
