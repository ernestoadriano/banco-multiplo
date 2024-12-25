package com.ernesto.banco_multiplo.crud.controller;

import com.ernesto.banco_multiplo.crud.model.Cliente;
import com.ernesto.banco_multiplo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/banco/v1/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/insert")
    public Cliente insert(@RequestBody Cliente cliente) {
        return clienteService.insert(cliente);
    }

    @PutMapping("/update")
    public Cliente update(@RequestBody Cliente cliente) {
        return clienteService.update(cliente);
    }

    @GetMapping("/get")
    public List<Cliente> getAll() {
        return clienteService.getAll();
    }

    @GetMapping("/get/{id}")
    public Cliente getById(@PathVariable("id") Long id) {
        return clienteService.getById(id);
    }
    @GetMapping("/get/nome")
    public Cliente getByNome(@RequestParam("nome") String nome) {
        return clienteService.getByNome(nome);
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        return clienteService.delete(id);
    }
}
