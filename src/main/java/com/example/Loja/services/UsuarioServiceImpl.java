package com.example.Loja.services;

import com.example.Loja.entidades.Usuario;
import com.example.Loja.repositorios.UsuarioRepository;
import com.example.Loja.services.interfaces.UsuarioService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private com.example.Loja.repositorios.UsuarioRepository UsuarioRepository;
    @Autowired
    private com.example.Loja.repositorios.UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario findById(Long id) {
        Optional<Usuario> Usuario = usuarioRepository.findById(id);
        return Usuario.get();
    }

    @Override
    public void save(Usuario Usuario) {
        usuarioRepository.save(Usuario);
    }

    @Override
    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario update(Long id, Usuario usuario) {
        Usuario entidade = usuarioRepository.getReferenceById(id);
        updateDados(entidade, usuario);
        return usuarioRepository.save(entidade);
    }

    private void updateDados(Usuario entidade,Usuario usuario) {
        entidade.setNome(usuario.getNome());
        entidade.setEmail(usuario.getEmail());
        entidade.setTelefone(usuario.getTelefone());
    }
}
