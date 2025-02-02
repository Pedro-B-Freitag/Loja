package com.example.Loja.services;

import com.example.Loja.entidades.Categoria;
import com.example.Loja.entidades.ItemPedido;
import com.example.Loja.entidades.primaryKeys.ItemPedidoPK;
import com.example.Loja.repositorios.CategoriaRepository;
import com.example.Loja.repositorios.ItemPedidoRepository;
import com.example.Loja.services.interfaces.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ItemPedidoServiceImpl implements ItemPedidoService {
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Override
    public List<ItemPedido> findAll() {
        return itemPedidoRepository.findAll();
    }

    @Override
    public ItemPedido findById(ItemPedidoPK id) {
        Optional<ItemPedido> itemPedido = itemPedidoRepository.findById(id);
        return itemPedido.get();
    }

    @Override
    public void save(ItemPedido itemPedido) {
        itemPedidoRepository.save(itemPedido);
    }

    @Override
    public void delete(ItemPedidoPK id) {
        itemPedidoRepository.deleteById(id);
    }
}
