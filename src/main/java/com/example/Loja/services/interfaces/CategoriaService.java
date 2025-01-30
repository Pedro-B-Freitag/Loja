package com.example.Loja.services.interfaces;

import com.example.Loja.entidades.Categoria;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CategoriaService {
    List<Categoria> findAll();
    Categoria findById(Long id);
    void save(Categoria categoria);
    void delete(Long id);
}
