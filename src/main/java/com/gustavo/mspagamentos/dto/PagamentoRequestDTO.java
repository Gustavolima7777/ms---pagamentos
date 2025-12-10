package com.gustavo.mspagamentos.dto;

import com.gustavo.mspagamentos.model.TipoPagamento;

import java.math.BigDecimal;

public record PagamentoRequestDTO(
        Long pedidoId,
        BigDecimal valor,
        TipoPagamento tipoPagamento,
        String detalhes
) {
}
