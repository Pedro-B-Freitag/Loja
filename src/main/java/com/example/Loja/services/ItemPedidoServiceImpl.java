package com.example.Loja.services;

import com.example.Loja.entidades.DTOs.ItemPedidoDTO;
import com.example.Loja.entidades.ItemPedido;
import com.example.Loja.entidades.Pedido;
import com.example.Loja.entidades.Produto;
import com.example.Loja.entidades.primaryKeys.ItemPedidoPK;
import com.example.Loja.repositorios.ItemPedidoRepository;
import com.example.Loja.repositorios.PedidoRepository;
import com.example.Loja.repositorios.ProdutoRepository;
import com.example.Loja.services.interfaces.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemPedidoServiceImpl implements ItemPedidoService {
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

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

    @Override
    public ItemPedido converter(ItemPedidoDTO itemPedidoDTO) {
        Optional<Pedido> pedido = pedidoRepository.findById(itemPedidoDTO.getIdPedido());
        Optional<Produto> produto = produtoRepository.findById(itemPedidoDTO.getIdProduto());
        Double preco = produto.get().getValor();
        return new ItemPedido(pedido.get(),produto.get(),preco, itemPedidoDTO.getQuantidade());
    }
}
