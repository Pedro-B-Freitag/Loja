package com.example.Loja.repositorios;

import com.example.Loja.entidades.MeioPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeioPagamentoRepository extends JpaRepository<MeioPagamento, Long> {

}
