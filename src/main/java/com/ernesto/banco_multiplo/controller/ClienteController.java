package com.ernesto.banco_multiplo.controller;

import com.ernesto.banco_multiplo.model.Cliente;
import com.ernesto.banco_multiplo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/getAll")
    public List<Cliente> getAll() {
        return clienteService.getAll();
    }

    @GetMapping("get/{id}")
    public Cliente getById(@PathVariable("id") Long id) {
        return clienteService.getById(id);
    }

    @PostMapping("/insert")
    public List<Cliente> insert(@RequestBody Cliente cliente) {
        return clienteService.insert(cliente);
    }

    @PutMapping("/update")
    public List<Cliente> update(@RequestBody Cliente cliente) {
        return clienteService.update(cliente);
    }

    @DeleteMapping("/delete/{id}")
    public List<Cliente> delete(@PathVariable("id") Long id) {
        return clienteService.delete(id);
    }
}
