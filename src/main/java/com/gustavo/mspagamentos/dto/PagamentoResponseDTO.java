package com.gustavo.mspagamentos.dto;

import com.gustavo.mspagamentos.model.Pagamento;
import com.gustavo.mspagamentos.model.StatusPagamento;
import com.gustavo.mspagamentos.model.TipoPagamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PagamentoResponseDTO(
        Long id,
        Long pedidoId,
        BigDecimal valor,
        StatusPagamento status,
        TipoPagamento tipoPagamento,
        LocalDateTime dataCriacao,
        LocalDateTime dataConfirmacao,
        String detalhes
) {
    public static PagamentoResponseDTO fromEntity(Pagamento p) {
        return new PagamentoResponseDTO(
                p.getId(),
                p.getPedidoId(),
                p.getValor(),
                p.getStatus(),
                p.getTipoPagamento(),
                p.getDataCriacao(),
                p.getDataConfirmacao(),
                p.getDetalhes()
        );
    }
}
