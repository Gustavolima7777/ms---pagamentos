package com.gustavo.mspagamentos.controller;

import com.gustavo.mspagamentos.dto.PagamentoRequestDTO;
import com.gustavo.mspagamentos.dto.PagamentoResponseDTO;
import com.gustavo.mspagamentos.service.PagamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    private final PagamentoService pagamentoService;

    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @PostMapping
    public ResponseEntity<PagamentoResponseDTO> criar(@RequestBody PagamentoRequestDTO dto) {
        PagamentoResponseDTO pagamento = pagamentoService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(pagamento);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagamentoResponseDTO> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(pagamentoService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<PagamentoResponseDTO>> listar() {
        return ResponseEntity.ok(pagamentoService.listarTodos());
    }

    @GetMapping("/pedido/{pedidoId}")
    public ResponseEntity<List<PagamentoResponseDTO>> listarPorPedido(@PathVariable Long pedidoId) {
        return ResponseEntity.ok(pagamentoService.listarPorPedido(pedidoId));
    }
}
