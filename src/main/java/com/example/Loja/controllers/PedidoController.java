package com.example.Loja.controllers;

import com.example.Loja.entidades.Pedido;
import com.example.Loja.repositorios.PedidoRepository;
import com.example.Loja.services.PedidoServiceImpl;
import com.example.Loja.services.interfaces.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoServiceImpl pedidoService;

    @GetMapping
    public List<Pedido> listar() {
        return pedidoService.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pedido> buscarPorId(@PathVariable Long id) {
        Optional<Pedido> pedido = Optional.ofNullable(pedidoService.findById(id));
        return ResponseEntity.ok().body(pedido.get());
    }
}
