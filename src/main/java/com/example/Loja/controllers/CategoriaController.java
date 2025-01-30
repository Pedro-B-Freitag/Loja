package com.example.Loja.controllers;

import com.example.Loja.entidades.Categoria;
import com.example.Loja.repositorios.CategoriaRepository;
import com.example.Loja.services.interfaces.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> listar() {
        return categoriaService.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Categoria>> buscar(@PathVariable Long id) {
        Optional<Categoria> categoria = Optional.ofNullable(categoriaService.findById(id));
        return ResponseEntity.ok().body(categoria);
    }
}
