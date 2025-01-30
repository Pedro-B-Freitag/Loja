package com.example.Loja.services.interfaces;

import com.example.Loja.entidades.Categoria;
import com.example.Loja.entidades.Pedido;

import java.util.List;

public interface PedidoService {
    List<Pedido> findAll();
    Pedido findById(Long id);
    void save(Pedido pedido);
    void delete(Long id);
}
