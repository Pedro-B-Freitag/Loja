package com.example.Loja.controllers;

import com.example.Loja.entidades.Produto;
import com.example.Loja.repositorios.ProdutoRepository;
import com.example.Loja.services.interfaces.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;
    
    @GetMapping
    public List<Produto> listar() {
        return produtoService.findAll();
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity <Produto> buscar(@PathVariable Long id) {
        Optional<Produto> produto = Optional.ofNullable(produtoService.findById(id));
        return ResponseEntity.ok().body(produto.get());
    }
}
