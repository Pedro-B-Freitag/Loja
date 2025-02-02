package com.example.Loja.services.interfaces;

import com.example.Loja.entidades.Pagamento;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PagamentoService {
    List<Pagamento> findAll();
    Pagamento findById(Long id);
    void save(Pagamento pagamento);
    void delete(Long id);
    Pagamento update(Long id,Pagamento pagamento);
}
