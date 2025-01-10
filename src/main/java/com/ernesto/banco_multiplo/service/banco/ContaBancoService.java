package com.ernesto.banco_multiplo.service.banco;

import com.ernesto.banco_multiplo.entity.banco.Cliente;
import com.ernesto.banco_multiplo.entity.banco.ContaBanco;
import com.ernesto.banco_multiplo.exception.BalanceNotValidException;
import com.ernesto.banco_multiplo.exception.NotFoundAccountException;
import com.ernesto.banco_multiplo.repository.banco.ContaBancoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/*
 * @author: Ernesto Adriano
 * */
@Service
public class ContaBancoService {

    @Autowired
    private ContaBancoRepository contaBancoRepository;

    @Autowired
    private ClienteService clienteService;

    public List<ContaBanco> getAll() {
        return contaBancoRepository.findAll();
    }

    public ContaBanco getByNumeroConta(String numeroConta) {
        return contaBancoRepository.findById(numeroConta)
                .orElseThrow(() -> new NotFoundAccountException("Conta não encontrada!"));
    }

    public ContaBanco insert(ContaBanco contaBanco, String idCliente) {
        Cliente cl = clienteService.getById(idCliente);
        String numeroConta = "";
        ContaBanco banco = null;
        contaBanco.setCliente(cl);
        contaBanco.setDataAbertura(new Date());
        if (contaBanco.getSaldo() < 500)
            throw new BalanceNotValidException("Saldo inicial inválido!");

        return contaBancoRepository.saveAndFlush(contaBanco);
    }

    public ContaBanco update(String numeroConta, ContaBanco contaBanco) {
        ContaBanco co = getByNumeroConta(numeroConta);

        if (contaBanco.getSaldo() != null)
            co.setSaldo(contaBanco.getSaldo());
        if (contaBanco.getCliente() != null)
            co.setCliente(contaBanco.getCliente());

        return contaBancoRepository.saveAndFlush(co);

    }

    public String delete(String numeroConta) {
        ContaBanco contaBanco = getByNumeroConta(numeroConta);
        contaBancoRepository.delete(contaBanco);
        return "Conta excluída com sucesso!";
    }
}
