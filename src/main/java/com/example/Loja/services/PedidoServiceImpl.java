package com.example.Loja.services;

import com.example.Loja.entidades.Categoria;
import com.example.Loja.entidades.Pagamento;
import com.example.Loja.entidades.Pedido;
import com.example.Loja.repositorios.CategoriaRepository;
import com.example.Loja.repositorios.UsuarioRepository;
import com.example.Loja.services.interfaces.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private com.example.Loja.repositorios.PedidoRepository PedidoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private com.example.Loja.repositorios.PedidoRepository pedidoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Pedido> findAll() {
        return PedidoRepository.findAll();
    }

    @Override
    public Pedido findById(Long id) {
        Optional<Pedido> Pedido = pedidoRepository.findById(id);
        return Pedido.get();
    }

    @Override
    public void save(Pedido Pedido) {
        pedidoRepository.save(Pedido);
    }

    @Override
    public void delete(Long id) {
        pedidoRepository.deleteById(id);
    }

    @Override
    public Pedido update(Long id, Pedido pedido) {
        Pedido entidade = pedidoRepository.getReferenceById(id);
        updateDados(entidade, pedido);
        return pedidoRepository.save(entidade);
    }

    public void updateDados(Pedido entidade, Pedido pedido){
        entidade.setStatus(pedido.getStatus());
        entidade.setPagamento(pedido.getPagamento());
    }


}
