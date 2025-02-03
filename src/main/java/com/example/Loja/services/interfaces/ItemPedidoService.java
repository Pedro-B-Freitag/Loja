package com.example.Loja.services.interfaces;

import com.example.Loja.entidades.DTOs.ItemPedidoDTO;
import com.example.Loja.entidades.ItemPedido;
import com.example.Loja.entidades.primaryKeys.ItemPedidoPK;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ItemPedidoService {
    List<ItemPedido> findAll();
    ItemPedido findById(ItemPedidoPK id);
    void save(ItemPedido itemPedido);
    void delete(ItemPedidoPK id);
    ItemPedido converter(ItemPedidoDTO itemPedidoDTO);
}
