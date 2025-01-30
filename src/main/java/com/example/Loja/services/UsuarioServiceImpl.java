package com.example.Loja.services;

import com.example.Loja.entidades.Usuario;
import com.example.Loja.services.interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private com.example.Loja.repositorios.UsuarioRepository UsuarioRepository;

    @Override
    public List<Usuario> findAll() {
        return UsuarioRepository.findAll();
    }

    @Override
    public Usuario findById(Long id) {
        Optional<Usuario> Usuario = UsuarioRepository.findById(id);
        return Usuario.get();
    }

    @Override
    public void save(Usuario Usuario) {
        UsuarioRepository.save(Usuario);
    }

    @Override
    public void delete(Long id) {
        UsuarioRepository.deleteById(id);
    }
}
