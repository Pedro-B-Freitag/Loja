package com.example.Loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.Loja.entidades.DTOs.ItemPedidoDTO;
import com.example.Loja.entidades.ItemPedido;
import com.example.Loja.entidades.Pedido;
import com.example.Loja.services.ItemPedidoServiceImpl;
import com.example.Loja.services.PedidoServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/itensPedidos")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoServiceImpl itemPedidoService;

    @Autowired
    private PedidoServiceImpl pedidoServiceImpl;

    @GetMapping
    public List<ItemPedido> listar() {
        return itemPedidoService.findAll();
    }

    @GetMapping(value = "/{idPedido}")
    public ResponseEntity<Set<ItemPedido>> buscar(@PathVariable Long idPedido) {
        Pedido pedido = pedidoServiceImpl.findById(idPedido);
        Set<ItemPedido> itensPedido = pedido.getItens();
        return ResponseEntity.ok().body(itensPedido);
    }

    @PostMapping
    public ResponseEntity<ItemPedido> salvar(@RequestBody ItemPedidoDTO itemPedidoDTO) {
        ItemPedido itemPedido = itemPedidoService.converter(itemPedidoDTO);
        itemPedidoService.save(itemPedido);
        return ResponseEntity.ok().body(itemPedido);
    }
}
