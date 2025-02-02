package com.example.Loja.services.interfaces;

import com.example.Loja.entidades.Produto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProdutoService {
    List<Produto> findAll();
    Produto findById(Long id);
    void save(Produto produto);
    void delete(Long id);
    Produto update(Long id,Produto produto);
}
