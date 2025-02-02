package com.example.Loja.services;

import com.example.Loja.entidades.Produto;
import com.example.Loja.repositorios.ProdutoRepository;
import com.example.Loja.services.interfaces.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
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

    @Override
    public Produto update(Long id, Produto produto) {
        Produto entidade = produtoRepository.getReferenceById(id);
        updateDados(entidade, produto);
        return produtoRepository.save(entidade);
    }

    public void updateDados(Produto entidade, Produto produto){
        entidade.setNome(produto.getNome());
        entidade.setCategoria(produto.getCategoria());
        entidade.setValor(produto.getValor());
    }
}

