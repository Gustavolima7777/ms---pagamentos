package com.gustavo.mspagamentos.service;

import com.gustavo.mspagamentos.dto.PagamentoRequestDTO;
import com.gustavo.mspagamentos.dto.PagamentoResponseDTO;

import java.util.List;

public interface PagamentoService {

    PagamentoResponseDTO criar(PagamentoRequestDTO dto);

    PagamentoResponseDTO buscarPorId(Long id);

    List<PagamentoResponseDTO> listarTodos();

    List<PagamentoResponseDTO> listarPorPedido(Long pedidoId);
}
