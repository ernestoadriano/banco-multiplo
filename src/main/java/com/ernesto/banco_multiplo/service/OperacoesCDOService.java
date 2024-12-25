package com.ernesto.banco_multiplo.service;

import com.ernesto.banco_multiplo.crud.enums.TipoOperacao;
import com.ernesto.banco_multiplo.crud.model.ContaOrdem;
import com.ernesto.banco_multiplo.crud.model.OperacaoCDO;
import com.ernesto.banco_multiplo.crud.repository.OperacaoCDORepository;
import com.ernesto.banco_multiplo.dto.ContaOrdemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OperacoesCDOService {

    @Autowired
    private OperacaoCDORepository operacaoCDORepository;
    @Autowired
    private ContaOrdemService contaOrdemService;
    //Tanto funcionário como o cliente podem fazer esta operação
    public String transferencia(ContaOrdemDTO contaOrdemDTO) {
        ContaOrdem contaOrigem = contaOrdemService.getByNumeroConta(contaOrdemDTO.getNumeroConta());
        ContaOrdem contaDestino = contaOrdemService.getByNumeroConta(contaOrdemDTO.getNrContaDestino());
        if (contaOrdemDTO.getValor() > 0) {
            if (contaOrigem.getSaldo() > contaOrdemDTO.getValor()) {
                //Faz a transfêrencia
                contaOrigem.setSaldo(contaOrigem.getSaldo() - contaOrdemDTO.getValor());
                contaDestino.setSaldo(contaDestino.getSaldo() + contaOrdemDTO.getValor());
                //Cria operação
                OperacaoCDO operacaoCDO = new OperacaoCDO();
                operacaoCDO.setContaOrigem(contaOrigem);
                operacaoCDO.setContaDestino(contaDestino);
                operacaoCDO.setMontanteMovimentado(contaOrdemDTO.getValor());
                TipoOperacao tipoOperacao = TipoOperacao.TRANSFERENCIA;
                operacaoCDO.setTipoOperacao(tipoOperacao);
                operacaoCDO.setDataOperacao(new Date());
                //Salva as alterações
                contaOrdemService.update(contaOrigem);
                contaOrdemService.update(contaDestino);
                //Grava a operação
                operacaoCDORepository.saveAndFlush(operacaoCDO);
                return "Transfêrencia feita com sucesso.";
            } else {
                throw new RuntimeException("Saldo insuficiente!");
            }
        } else {
            throw new RuntimeException("Valor inválido!");
        }
    }
    //O funcionário do banco fazem isto
    public String deposito(ContaOrdemDTO dto) {
        ContaOrdem contaOrigem = contaOrdemService.getByNumeroConta(dto.getNumeroConta());
        if (dto.getValor() > 0) {
            contaOrigem.setSaldo(contaOrigem.getSaldo() + dto.getValor());
            OperacaoCDO operacaoCDO = new OperacaoCDO();
            operacaoCDO.setDataOperacao(new Date());
            operacaoCDO.setMontanteMovimentado(dto.getValor());
            operacaoCDO.setContaOrigem(contaOrigem);
            operacaoCDO.setTipoOperacao(TipoOperacao.DEPOSITO);
            contaOrdemService.update(contaOrigem);
            operacaoCDORepository.saveAndFlush(operacaoCDO);
            return "Deposito feito com sucesso!";
        } else {
            throw new RuntimeException("Valor inválido!");
        }
    }

    public String levantamento(ContaOrdemDTO dto) {
        ContaOrdem contaOrdem = contaOrdemService.getByNumeroConta(dto.getNumeroConta());
        if (dto.getValor() > 0) {
            if (contaOrdem.getSaldo() > dto.getValor()) {
                contaOrdem.setSaldo(contaOrdem.getSaldo() - dto.getValor());
                OperacaoCDO operacaoCDO = new OperacaoCDO();
                operacaoCDO.setDataOperacao(new Date());
                operacaoCDO.setMontanteMovimentado(dto.getValor());
                operacaoCDO.setContaOrigem(contaOrdem);
                operacaoCDO.setTipoOperacao(TipoOperacao.LEVANTAMENTO);
                contaOrdemService.update(contaOrdem);
                operacaoCDORepository.saveAndFlush(operacaoCDO);
                return "Levantamento no valor de " + dto.getValor() + " MTN feito com sucesso!";
            } else {
                throw new RuntimeException("Saldo insuficiente!");
            }
        } else {
            throw new RuntimeException("Valor inválido!");
        }
    }
}
