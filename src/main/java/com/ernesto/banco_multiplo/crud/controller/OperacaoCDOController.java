package com.ernesto.banco_multiplo.crud.controller;

import com.ernesto.banco_multiplo.dto.ContaOrdemDTO;
import com.ernesto.banco_multiplo.service.OperacoesCDOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/banco/v1/operacao/conta/ordem")
public class OperacaoCDOController {

    @Autowired
    private OperacoesCDOService operacoesCDOService;

    @PostMapping("/transferencia")
    public String transferencia(@RequestBody ContaOrdemDTO contaOrdemDTO) {
        return operacoesCDOService.transferencia(contaOrdemDTO);
    }

    @PostMapping("/deposito")
    public String desposito(@RequestBody ContaOrdemDTO contaOrdemDTO) {
        return operacoesCDOService.deposito(contaOrdemDTO);
    }

    @PostMapping("/levantamento")
    public String levantamento(@RequestBody ContaOrdemDTO contaOrdemDTO) {
        return operacoesCDOService.levantamento(contaOrdemDTO);
    }
}
