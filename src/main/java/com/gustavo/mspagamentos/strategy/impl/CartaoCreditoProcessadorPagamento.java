package com.gustavo.mspagamentos.strategy.impl;

import com.gustavo.mspagamentos.model.Pagamento;
import com.gustavo.mspagamentos.model.StatusPagamento;
import com.gustavo.mspagamentos.model.TipoPagamento;
import com.gustavo.mspagamentos.strategy.ProcessadorPagamento;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CartaoCreditoProcessadorPagamento implements ProcessadorPagamento {

    @Override
    public TipoPagamento tipo() {
        return TipoPagamento.CARTAO_CREDITO;
    }

    @Override
    public Pagamento processar(Pagamento pagamento) {
        pagamento.setStatus(StatusPagamento.APROVADO);
        pagamento.setDataConfirmacao(LocalDateTime.now());
        pagamento.setDetalhes("Pagamento aprovado no cartão de crédito.");
        return pagamento;
    }
}
