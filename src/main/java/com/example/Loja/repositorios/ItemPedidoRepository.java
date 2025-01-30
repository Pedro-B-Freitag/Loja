package com.example.Loja.repositorios;

import com.example.Loja.entidades.ItemPedido;
import com.example.Loja.entidades.primaryKeys.ItemPedidoPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, ItemPedidoPK> {
}
