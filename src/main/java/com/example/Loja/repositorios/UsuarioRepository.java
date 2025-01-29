package com.example.Loja.repositorios;

import com.example.Loja.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
