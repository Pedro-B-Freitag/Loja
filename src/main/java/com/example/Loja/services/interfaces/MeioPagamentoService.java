package com.example.Loja.services.interfaces;

import com.example.Loja.entidades.MeioPagamento;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MeioPagamentoService {
    List<MeioPagamento> findAll();
    MeioPagamento findById(Long id);
    void save(MeioPagamento meioPagamento);
    void delete(Long id);
    MeioPagamento update(Long id, MeioPagamento meioPagamento);
}
