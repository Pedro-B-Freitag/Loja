package com.example.Loja.controllers;

import com.example.Loja.entidades.Categoria;
import com.example.Loja.services.CategoriaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaServiceImpl categoriaService;

    @GetMapping
    public List<Categoria> listar() {
        return categoriaService.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Categoria>> buscar(@PathVariable Long id) {
        Optional<Categoria> categoria = Optional.ofNullable(categoriaService.findById(id));
        return ResponseEntity.ok().body(categoria);
    }

    @PostMapping
    public ResponseEntity<Categoria> salvar(@RequestBody Categoria categoria) {
        categoriaService.save(categoria);
        return ResponseEntity.ok().body(categoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizar(@RequestBody Categoria categoria,
                                             @PathVariable Long id) {
        categoria = categoriaService.update(id,categoria);
        return ResponseEntity.ok().body(categoria);
    }
}
