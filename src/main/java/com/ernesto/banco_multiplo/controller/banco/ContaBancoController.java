package com.ernesto.banco_multiplo.controller.banco;

import com.ernesto.banco_multiplo.entity.banco.ContaBanco;
import com.ernesto.banco_multiplo.service.banco.ContaBancoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banco/conta")
public class ContaBancoController {

    @Autowired
    private ContaBancoService contaBancoService;

    @GetMapping("/get")
    public List<ContaBanco> getAll() {
        return contaBancoService.getAll();
    }

    @GetMapping("/get/{id}")
    public ContaBanco getByNumeroConta(@PathVariable("id") String numeroConta) {
        return contaBancoService.getByNumeroConta(numeroConta);
    }

    @PostMapping("/insert/{id_cliente}")
    public ContaBanco insert(@RequestBody ContaBanco contaBanco, @PathVariable("id_cliente") String idCliente) {
        return contaBancoService.insert(contaBanco, idCliente);
    }

    @PutMapping("/update/{id}")
    public ContaBanco update(@PathVariable("id") String numeroConta, @RequestBody ContaBanco contaBanco) {
        return contaBancoService.update(numeroConta, contaBanco);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") String numeroConta) {
        return contaBancoService.delete(numeroConta);
    }
}
