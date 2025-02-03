package com.example.Loja.controllers;

import com.example.Loja.entidades.DTOs.PagamentoDTO;
import com.example.Loja.entidades.MeioPagamento;
import com.example.Loja.entidades.Pagamento;
import com.example.Loja.services.PagamentoServiceImpl;
import com.example.Loja.services.interfaces.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoServiceImpl pagamentoService;

    @GetMapping("/{id}")
    public ResponseEntity<Pagamento> buscarPorId(@PathVariable Long id) {
        Optional<Pagamento> pagamento = Optional.ofNullable(pagamentoService.findById(id));
        return ResponseEntity.ok().body(pagamento.get());
    }

    @PostMapping
    public ResponseEntity<PagamentoDTO> salvar(@RequestBody PagamentoDTO pagamentoDTO) {
        pagamentoService.save(pagamentoDTO);
        return ResponseEntity.ok().body(pagamentoDTO);
    }

}
