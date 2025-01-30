package com.example.Loja.services.interfaces;

import com.example.Loja.entidades.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> findAll();
    Usuario findById(Long id);
    void save(Usuario usuario);
    void delete(Long id);
}