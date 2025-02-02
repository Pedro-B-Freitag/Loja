package com.example.Loja.config;

import com.example.Loja.entidades.*;
import com.example.Loja.entidades.enums.StatusPedido;
import com.example.Loja.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Override
    public void run(String... args) throws Exception {

        // Criação das categorias
        Categoria cat1 = new Categoria(null, "Eletrônicos");
        Categoria cat2 = new Categoria(null, "Livros");
        Categoria cat3 = new Categoria(null, "Computadores");

        // Criação dos produtos
        Produto p1 = new Produto(null, "O Senhor dos Anéis", 90.5);
        Produto p2 = new Produto(null, "Smart TV", 2190.0);
        Produto p3 = new Produto(null, "Macbook Pro", 1250.0);
        Produto p4 = new Produto(null, "PC Gamer", 1200.0);
        Produto p5 = new Produto(null, "Rails for Dummies", 100.99);

        // Salvando categorias e produtos
        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        // Associando produtos às categorias
        p1.setCategoria(cat2);
        p2.setCategoria(cat1);
        p3.setCategoria(cat3);
        p4.setCategoria(cat3);
        p5.setCategoria(cat2);

        // Salvando as associações
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        // Criação dos usuários
        Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com",  "123456", "988888888");
        Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com",  "123456", "977777777");

        // Criação dos pedidos
        Pedido ped1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), StatusPedido.PAGO, u1);
        Pedido ped2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), StatusPedido.ESPERANDO_PAGAMENTO, u2);
        Pedido ped3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), StatusPedido.ESPERANDO_PAGAMENTO, u1);

        // Salvando usuários e pedidos
        usuarioRepository.saveAll(Arrays.asList(u1, u2));
        pedidoRepository.saveAll(Arrays.asList(ped1, ped2, ped3));

        // Criação dos itens de pedido
        ItemPedido ip1 = new ItemPedido(ped1, p1, p1.getValor(), 2);
        ItemPedido ip2 = new ItemPedido(ped1, p3, p3.getValor(), 1);
        ItemPedido ip3 = new ItemPedido(ped2, p3, p3.getValor(), 2);
        ItemPedido ip4 = new ItemPedido(ped3, p5, p5.getValor(), 2);

        // Salvando os itens de pedido
        itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3, ip4));

        // Criação do pagamento
        Pagamento pag1 = new Pagamento(null, Instant.parse("2019-06-20T21:53:07Z"), ped1);
        ped1.setPagamento(pag1);

        // Salvando o pedido com pagamento
        pedidoRepository.save(ped1);

        Pagamento pag2 = new Pagamento(null, Instant.now(), ped2);
        ped2.setPagamento(pag2);
        pedidoRepository.save(ped2);
    }
}
