package com.example.Loja.services;

import com.example.Loja.entidades.Categoria;
import com.example.Loja.repositorios.CategoriaRepository;
import com.example.Loja.services.interfaces.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria findById(Long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.get();
    }

    @Override
    public void save(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    @Override
    public void delete(Long id) {
        categoriaRepository.deleteById(id);
    }
}
