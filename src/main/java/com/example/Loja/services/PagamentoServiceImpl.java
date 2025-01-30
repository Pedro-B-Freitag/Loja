package com.example.Loja.services;

import com.example.Loja.entidades.Pagamento;
import com.example.Loja.repositorios.PagamentoRepository;
import com.example.Loja.services.interfaces.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PagamentoServiceImpl implements PagamentoService {

    @Autowired
    private PagamentoRepository PagamentoRepository;

    @Override
    public List<Pagamento> findAll() {
        return PagamentoRepository.findAll();
    }

    @Override
    public Pagamento findById(Long id) {
        Optional<Pagamento> Pagamento = PagamentoRepository.findById(id);
        return Pagamento.get();
    }

    @Override
    public void save(Pagamento Pagamento) {
        PagamentoRepository.save(Pagamento);
    }

    @Override
    public void delete(Long id) {
        PagamentoRepository.deleteById(id);
    }
    
}
