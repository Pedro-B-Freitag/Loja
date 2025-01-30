package com.example.Loja.services;

import com.example.Loja.entidades.Produto;
import com.example.Loja.repositorios.ProdutoRepository;
import com.example.Loja.services.interfaces.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProdutoServiceImpl implements ProdutoService{

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }
    @Override
    public Produto findById(Long id){
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.get();
    }
    @Override
    public void save(Produto produto){
        produtoRepository.save(produto);
    }
    @Override
    public void delete(Long id){
        produtoRepository.deleteById(id);
    }
}
