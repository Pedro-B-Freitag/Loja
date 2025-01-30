package com.example.Loja.services.interfaces;

import com.example.Loja.entidades.Pagamento;

import java.util.List;

public interface PagamentoService {
    List<Pagamento> findAll();
    Pagamento findById(Long id);
    void save(Pagamento pagamento);
    void delete(Long id);
}
