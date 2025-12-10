package com.gustavo.mspagamentos.service.impl;

import com.gustavo.mspagamentos.dto.PagamentoRequestDTO;
import com.gustavo.mspagamentos.dto.PagamentoResponseDTO;
import com.gustavo.mspagamentos.model.Pagamento;
import com.gustavo.mspagamentos.repository.PagamentoRepository;
import com.gustavo.mspagamentos.service.PagamentoService;
import com.gustavo.mspagamentos.strategy.ProcessadorPagamento;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PagamentoServiceImpl implements PagamentoService {

    private final PagamentoRepository pagamentoRepository;
    private final List<ProcessadorPagamento> processadores;

    public PagamentoServiceImpl(PagamentoRepository pagamentoRepository,
                                List<ProcessadorPagamento> processadores) {
        this.pagamentoRepository = pagamentoRepository;
        this.processadores = processadores;
    }

    @Override
    @Transactional
    public PagamentoResponseDTO criar(PagamentoRequestDTO dto) {
        Pagamento pagamento = new Pagamento();
        pagamento.setPedidoId(dto.pedidoId());
        pagamento.setValor(dto.valor());
        pagamento.setTipoPagamento(dto.tipoPagamento());
        pagamento.setDetalhes(dto.detalhes());

        ProcessadorPagamento processador = processadores.stream()
                .filter(p -> p.tipo() == dto.tipoPagamento())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Tipo de pagamento não suportado: " + dto.tipoPagamento()));

        pagamento = processador.processar(pagamento);

        Pagamento salvo = pagamentoRepository.save(pagamento);
        return PagamentoResponseDTO.fromEntity(salvo);
    }

    @Override
    public PagamentoResponseDTO buscarPorId(Long id) {
        Pagamento p = pagamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));
        return PagamentoResponseDTO.fromEntity(p);
    }

    @Override
    public List<PagamentoResponseDTO> listarTodos() {
        return pagamentoRepository.findAll().stream()
                .map(PagamentoResponseDTO::fromEntity)
                .toList();
    }

    @Override
    public List<PagamentoResponseDTO> listarPorPedido(Long pedidoId) {
        return pagamentoRepository.findByPedidoId(pedidoId).stream()
                .map(PagamentoResponseDTO::fromEntity)
                .toList();
    }
}
