package com.gustavo.mspagamentos.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long pedidoId;
    private BigDecimal valor;

    private LocalDateTime dataCriacao = LocalDateTime.now();
    private LocalDateTime dataConfirmacao;

    @Enumerated(EnumType.STRING)
    private StatusPagamento status = StatusPagamento.PENDENTE;

    @Enumerated(EnumType.STRING)
    private TipoPagamento tipoPagamento;

    private String detalhes;
}
