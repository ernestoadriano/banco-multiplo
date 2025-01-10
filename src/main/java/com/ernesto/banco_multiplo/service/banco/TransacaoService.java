package com.ernesto.banco_multiplo.service.banco;

/*
 * @author: Ernesto Adriano
 * */
import com.ernesto.banco_multiplo.entity.banco.ContaBanco;
import com.ernesto.banco_multiplo.entity.banco.Transacao;
import com.ernesto.banco_multiplo.entity.enums.TipoConta;
import com.ernesto.banco_multiplo.entity.enums.TipoTransacao;
import com.ernesto.banco_multiplo.exception.InvalidTransactionException;
import com.ernesto.banco_multiplo.repository.banco.ContaBancoRepository;
import com.ernesto.banco_multiplo.repository.banco.TransacaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private ContaBancoRepository contaBancoRepository;

    @Autowired
    private ContaBancoService contaBancoService;

    @Transactional
    public Transacao transferencia(Transacao transacao) {
        validateTrans(transacao);
        transacao.setTipoTransacao(TipoTransacao.TRANSFERENCIA);
        transacao.setDataOperacao(new Date());


        var novaTransacao = transacaoRepository.save(transacao);

        var contaOrigem = contaBancoService.getByNumeroConta(transacao.getContaOrigem().getNumeroConta());
        var contaDestino = contaBancoService.getByNumeroConta(transacao.getContaDestino().getNumeroConta());
        contaBancoRepository.saveAndFlush(contaOrigem.debit(transacao.getMontanteMovimentado()));
        contaBancoRepository.saveAndFlush(contaDestino.credit(transacao.getMontanteMovimentado()));

        return novaTransacao;
    }

    private void validateTrans(Transacao transacao) {
        contaBancoRepository.findById(transacao.getContaDestino().getNumeroConta())
                .map(contaDestino -> contaBancoRepository.findById(transacao.getContaOrigem().getNumeroConta())
                        .map(contaOrigem -> isTransferenciaValid(transacao, contaOrigem) ? transacao : null)
                        .orElseThrow(() -> new InvalidTransactionException("Transação inválida: %s".formatted(transacao))))
                .orElseThrow(() -> new InvalidTransactionException("Transação inválida: %s".formatted(transacao)));

    }



    private boolean isTransferenciaValid(Transacao transacao, ContaBanco contaOrigem) {
        return contaOrigem.getTipoConta().equals(TipoConta.COMUM)
                && contaOrigem.getSaldo().compareTo(transacao.getMontanteMovimentado()) >= 0
                && !contaOrigem.getNumeroConta().equals(transacao.getContaDestino().getNumeroConta());
    }

    @Transactional
    public Transacao deposito(Transacao transacao) {
        validateDeposito(transacao);
        transacao.setTipoTransacao(TipoTransacao.DEPOSITO);
        transacao.setDataOperacao(new Date());
        var novaTransacao = transacaoRepository.save(transacao);
        var contaOrigem = contaBancoService.getByNumeroConta(transacao.getContaOrigem().getNumeroConta());
        contaOrigem.setSaldo(contaOrigem.getSaldo() + transacao.getMontanteMovimentado());
        contaBancoRepository.saveAndFlush(contaOrigem);
        return novaTransacao;
    }

    private void validateDeposito(Transacao transacao) {
        contaBancoRepository.findById(transacao.getContaOrigem().getNumeroConta())
                .map(contaOrigem -> isDepositoValid(transacao, contaOrigem) ? transacao : null)
                .orElseThrow(() -> new RuntimeException("Transação inválida: %s".formatted(transacao)));
    }

    private boolean isDepositoValid(Transacao transacao, ContaBanco contaOrigem) {
        return transacao.getMontanteMovimentado() > 0;
    }

    @Transactional
    public Transacao pagamento(Transacao transacao) {
        validatePagamento(transacao);
        transacao.setTipoTransacao(TipoTransacao.PAGAMENTO);
        transacao.setDataOperacao(new Date());
        var novaTransacao = transacaoRepository.saveAndFlush(transacao);
        var contaOrigem = contaBancoService.getByNumeroConta(transacao.getContaOrigem().getNumeroConta());
        contaOrigem.setSaldo(contaOrigem.getSaldo() - transacao.getMontanteMovimentado());
        var contaDestino = contaBancoService.getByNumeroConta(transacao.getContaDestino().getNumeroConta());
        contaDestino.setSaldo(contaDestino.getSaldo() + transacao.getMontanteMovimentado());
        contaBancoRepository.saveAndFlush(contaOrigem);
        contaBancoRepository.saveAndFlush(contaDestino);
        return novaTransacao;
    }

    private void validatePagamento(Transacao transacao) {
        contaBancoRepository.findById(transacao.getContaDestino().getNumeroConta())
                .map(contaDestino -> contaBancoRepository.findById(transacao.getContaOrigem().getNumeroConta())
                        .map(contaOrigem -> isPagamentoValid(transacao, contaOrigem, contaDestino) ? transacao : null)
                        .orElseThrow(() -> new RuntimeException("Transação inválida!")))
                .orElseThrow(() -> new RuntimeException("Transação inválida!"));
    }

    private boolean isPagamentoValid(Transacao transacao, ContaBanco contaOrigem, ContaBanco contaDestino) {
        return contaOrigem.getTipoConta().equals(TipoConta.COMUM)
                && contaDestino.getTipoConta().equals(TipoConta.LOJISTA)
                && contaOrigem.getSaldo().compareTo(transacao.getMontanteMovimentado()) >= 0;
    }


    public List<Transacao> getAll() {
        return transacaoRepository.findAll();
    }
}
