package com.gustavo.mspagamentos.repository;

import com.gustavo.mspagamentos.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

    List<Pagamento> findByPedidoId(Long pedidoId);
}
