package com.example.Loja.services;

import com.example.Loja.entidades.Pedido;
import com.example.Loja.services.interfaces.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private com.example.Loja.repositorios.PedidoRepository PedidoRepository;

    @Override
    public List<Pedido> findAll() {
        return PedidoRepository.findAll();
    }

    @Override
    public Pedido findById(Long id) {
        Optional<Pedido> Pedido = PedidoRepository.findById(id);
        return Pedido.get();
    }

    @Override
    public void save(Pedido Pedido) {
        PedidoRepository.save(Pedido);
    }

    @Override
    public void delete(Long id) {
        PedidoRepository.deleteById(id);
    }
}
