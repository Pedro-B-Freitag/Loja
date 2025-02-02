package com.example.Loja.services.interfaces;

import com.example.Loja.entidades.Pedido;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PedidoService {
    List<Pedido> findAll();
    Pedido findById(Long id);
    void save(Pedido pedido);
    void delete(Long id);
    Pedido update(Long id, Pedido pedido);
}
