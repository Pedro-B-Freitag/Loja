package com.example.Loja.services;

import com.example.Loja.entidades.DTOs.PagamentoDTO;
import com.example.Loja.entidades.MeioPagamento;
import com.example.Loja.entidades.Pagamento;
import com.example.Loja.entidades.Pedido;
import com.example.Loja.repositorios.MeioPagamentoRepository;
import com.example.Loja.repositorios.PagamentoRepository;
import com.example.Loja.repositorios.PedidoRepository;
import com.example.Loja.services.interfaces.PagamentoService;
import com.example.Loja.services.interfaces.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
@Service
public class PagamentoServiceImpl implements PagamentoService {

    @Autowired
    private PagamentoRepository PagamentoRepository;
    @Autowired
    private PagamentoRepository pagamentoRepository;
    @Autowired
    private PedidoService pedidoService;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private MeioPagamentoRepository meioPagamentoRepository;

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
    public void save(PagamentoDTO pagamentoDTO) {
        Optional<Pedido> pedido = pedidoRepository.findById(pagamentoDTO.getIdPedido());
        Optional<MeioPagamento> meioPagamento = meioPagamentoRepository.findById(pagamentoDTO.getIdMeioPagamento());
        Pagamento pagamento = new Pagamento(null,Instant.now(),pedido.get(),meioPagamento.get());
        pagamentoRepository.save(pagamento);
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
