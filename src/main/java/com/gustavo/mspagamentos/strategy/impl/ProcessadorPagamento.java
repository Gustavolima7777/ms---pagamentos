package com.gustavo.mspagamentos.strategy;

import com.gustavo.mspagamentos.model.Pagamento;
import com.gustavo.mspagamentos.model.TipoPagamento;

public interface ProcessadorPagamento {

    TipoPagamento tipo();

    Pagamento processar(Pagamento pagamento);
}
