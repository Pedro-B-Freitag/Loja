package com.example.Loja.entidades;

import com.example.Loja.entidades.primaryKeys.ItemPedidoPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import java.util.Objects;

@Entity
public class ItemPedido {
    @EmbeddedId
    private ItemPedidoPK id;
    private Double preco;
    private int quantidade;

    public ItemPedido() {}

    public ItemPedido(Pedido pedido, Produto produto,Double preco, int quantidade) {
        id.setPedido(pedido);
        id.setProduto(produto);
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Pedido getPedido() {
        return id.getPedido();
    }

    public void setPedido(Pedido pedido) {
        id.setPedido(pedido);
    }

    public Produto getProduto() {
        return id.getProduto();
    }

    public void setProduto(Produto produto) {
        id.setProduto(produto);
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ItemPedido that = (ItemPedido) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
