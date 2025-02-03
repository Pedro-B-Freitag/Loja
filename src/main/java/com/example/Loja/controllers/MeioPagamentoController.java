package com.example.Loja.controllers;

import com.example.Loja.entidades.MeioPagamento;
import com.example.Loja.services.MeioPagamentoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/meiosPagamento")
public class MeioPagamentoController {
    
    @Autowired
    private MeioPagamentoServiceImpl meioPagamentoService;

    @GetMapping
    public List<MeioPagamento> listar() {
        return meioPagamentoService.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MeioPagamento> buscarPorId(@PathVariable Long id) {
        Optional<MeioPagamento> meioPagamento = Optional.ofNullable(meioPagamentoService.findById(id));
        return ResponseEntity.ok().body(meioPagamento.get());
    }

    @PostMapping
    public ResponseEntity<MeioPagamento> salvar(@RequestBody MeioPagamento meioPagamento) {
        meioPagamentoService.save(meioPagamento);
        return ResponseEntity.ok().body(meioPagamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        meioPagamentoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MeioPagamento> atualizar(@RequestBody MeioPagamento meioPagamento,
                                                   @PathVariable Long id) {
        meioPagamento = meioPagamentoService.update(id,meioPagamento);
        return ResponseEntity.ok().body(meioPagamento);
    }
}
