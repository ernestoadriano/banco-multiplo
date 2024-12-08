package com.ernesto.banco_multiplo.controller;

import com.ernesto.banco_multiplo.model.ContaOrdem;
import com.ernesto.banco_multiplo.request.TransferenciaRequest;
import com.ernesto.banco_multiplo.service.OperacoesCDOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/operacoes/")
public class OperacoesCDOController {

    @Autowired
    private OperacoesCDOService operacoesCDOService;

    @PutMapping("/transferir")
    public ContaOrdem transferir(@RequestBody TransferenciaRequest request) {
        return operacoesCDOService.transferir(request.getContaOrigem(), request.getContaDestino(), request.getValor());
    }
}
