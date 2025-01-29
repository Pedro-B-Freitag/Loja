package com.example.Loja.repositorios;

import com.example.Loja.entidades.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
