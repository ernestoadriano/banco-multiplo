package com.ernesto.banco_multiplo.controller.banco;

import com.ernesto.banco_multiplo.entity.banco.Cliente;
import com.ernesto.banco_multiplo.service.banco.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/*
 * @author: Ernesto Adriano
 * */
@RestController
@RequestMapping("/banco/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping("/get")
    public List<Cliente> getAll() {
        return service.getAll();
    }

    @GetMapping("/get/{bi}")
    public Cliente getByNumBi(@PathVariable("bi") String bi) {
        return service.getBynumBi(bi);
    }

    @PostMapping("/insert")
    public Cliente insert(@RequestBody Cliente cliente) {
        return service.insert(cliente);
    }

    @PutMapping("/update/{id}")
    public Cliente update(@PathVariable("id") String id, @RequestBody Cliente cliente) {
        return service.update(id, cliente);
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
