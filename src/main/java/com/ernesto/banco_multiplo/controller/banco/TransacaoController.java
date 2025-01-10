package com.ernesto.banco_multiplo.controller.banco;

import com.ernesto.banco_multiplo.entity.banco.Transacao;
import com.ernesto.banco_multiplo.service.banco.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banco/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoService service;

    @PostMapping("/transferencia")
    public Transacao transferencia(@RequestBody Transacao transacao) {
        return service.transferencia(transacao);
    }

    @GetMapping("/get")
    public List<Transacao> getAll() {
        return service.getAll();
    }
}
