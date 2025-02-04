package com.example.Loja.controllers;

import com.example.Loja.entidades.Pedido;
import com.example.Loja.entidades.Usuario;
import com.example.Loja.entidades.enums.StatusPedido;
import com.example.Loja.services.PedidoServiceImpl;
import com.example.Loja.services.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoServiceImpl pedidoService;
    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;

    @GetMapping
    public List<Pedido> listar() {
        return pedidoService.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pedido> buscarPorId(@PathVariable Long id) {
        Optional<Pedido> pedido = Optional.ofNullable(pedidoService.findById(id));
        return ResponseEntity.ok().body(pedido.get());
    }
    @GetMapping(value="/usuario/{idUsuario}")
    public List<Pedido> buscarPorIdUsuario(@PathVariable Long idUsuario) {
        return pedidoService.findByUsuarioId(idUsuario);
    }

    @PostMapping("/{idUsuario}")
    public ResponseEntity<Pedido> salvar(@PathVariable Long idUsuario) {
        Usuario usuario = usuarioServiceImpl.findById(idUsuario);
        Pedido pedido = new Pedido(null, Instant.now(), StatusPedido.ESPERANDO_PAGAMENTO, usuario);
        pedidoService.save(pedido);
        return ResponseEntity.ok().body(pedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        pedidoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> atualizar(@RequestBody Pedido pedido,
                                             @PathVariable Long id) {
        pedido = pedidoService.update(id,pedido);
        return ResponseEntity.ok().body(pedido);
    }
}
