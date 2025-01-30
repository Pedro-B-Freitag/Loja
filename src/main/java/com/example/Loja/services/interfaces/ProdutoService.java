package com.example.Loja.services.interfaces;

import com.example.Loja.entidades.Produto;

import java.util.List;

public interface ProdutoService {
    List<Produto> findAll();
    Produto findById(Long id);
    void save(Produto produto);
    void delete(Long id);
}
