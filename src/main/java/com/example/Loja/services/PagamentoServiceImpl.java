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
    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Override
    public List<Pagamento> findAll() {
        return pagamentoRepository.findAll();
    }

    @Override
    public Pagamento findById(Long id) {
        Optional<Pagamento> Pagamento = pagamentoRepository.findById(id);
        return Pagamento.get();
    }

    @Override
    public void save(Pagamento Pagamento) {
        pagamentoRepository.save(Pagamento);
    }

    @Override
    public void delete(Long id) {
        pagamentoRepository.deleteById(id);
    }

    @Override
    public Pagamento update(Long id, Pagamento pagamento) {
        Pagamento entidade = pagamentoRepository.getReferenceById(id);
        updateDados(entidade, pagamento);
        return pagamentoRepository.save(entidade);
    }

    public void updateDados(Pagamento entidade, Pagamento pagamento){
        entidade.setMomento(pagamento.getMomento());
    }

}
