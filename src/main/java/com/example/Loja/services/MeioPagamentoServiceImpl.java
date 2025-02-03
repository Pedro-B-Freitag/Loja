package com.example.Loja.services;

import com.example.Loja.entidades.MeioPagamento;
import com.example.Loja.repositorios.MeioPagamentoRepository;
import com.example.Loja.services.interfaces.MeioPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MeioPagamentoServiceImpl implements MeioPagamentoService {
    @Autowired
    private MeioPagamentoRepository meioPagamentoRepository;

    @Override
    public List<MeioPagamento> findAll() {
        return meioPagamentoRepository.findAll();
    }

    @Override
    public MeioPagamento findById(Long id) {
        Optional<MeioPagamento> MeioPagamento = meioPagamentoRepository.findById(id);
        return MeioPagamento.get();
    }

    @Override
    public void save(MeioPagamento pedido) {

        meioPagamentoRepository.save(pedido);
    }

    @Override
    public void delete(Long id) {
        meioPagamentoRepository.deleteById(id);
    }

    @Override
    public MeioPagamento update(Long id, MeioPagamento pedido) {
        MeioPagamento entidade = meioPagamentoRepository.getReferenceById(id);
        updateDados(entidade, pedido);
        return meioPagamentoRepository.save(entidade);
    }

    public void updateDados(MeioPagamento entidade, MeioPagamento meioPagamento) {
        entidade.setDescricao(meioPagamento.getDescricao());
    }
}
