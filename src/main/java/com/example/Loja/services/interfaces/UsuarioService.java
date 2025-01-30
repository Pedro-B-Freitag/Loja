package com.example.Loja.services.interfaces;

import com.example.Loja.entidades.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UsuarioService {
    List<Usuario> findAll();
    Usuario findById(Long id);
    void save(Usuario usuario);
    void delete(Long id);
}