package com.example.Loja.controllers;

import com.example.Loja.entidades.Produto;
import com.example.Loja.services.ProdutoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoServiceImpl produtoService;
    
    @GetMapping
    public List<Produto> listar() {
        return produtoService.findAll();
    }

    @GetMapping("/order")
    public List<Produto> listarOrdenado() {
        return produtoService.findAllInOrder();
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity <Produto> buscar(@PathVariable Long id) {
        Optional<Produto> produto = Optional.ofNullable(produtoService.findById(id));
        return ResponseEntity.ok().body(produto.get());
    }

    @PostMapping
    public ResponseEntity<Produto> salvar(@RequestBody Produto produto) {
        produtoService.save(produto);
        return ResponseEntity.ok().body(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@RequestBody Produto produto,
                                            @PathVariable Long id) {
        produto = produtoService.update(id,produto);
        return ResponseEntity.ok().body(produto);
    }
}
