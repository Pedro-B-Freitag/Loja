package com.example.Loja.services.interfaces;

import com.example.Loja.entidades.ItemPedido;
import com.example.Loja.entidades.primaryKeys.ItemPedidoPK;

import java.util.List;

public interface ItemPedidoService {
    List<ItemPedido> findAll();
    ItemPedido findById(ItemPedidoPK id);
    void save(ItemPedido itemPedido);
    void delete(ItemPedido id);
}
