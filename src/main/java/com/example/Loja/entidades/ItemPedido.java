package com.example.Loja.entidades;

import com.example.Loja.entidades.primaryKeys.ItemPedidoPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class ItemPedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private ItemPedidoPK id = new ItemPedidoPK();
    private Double preco;
    private int quantidade;

    public ItemPedido() {}

    public ItemPedido(Pedido pedido, Produto produto,Double preco, int quantidade) {
        id.setPedido(pedido);
        id.setProduto(produto);
        this.preco = preco;
        this.quantidade = quantidade;
    }
    /*
        colocamos o JsonIgnore porque, ao chamar um pedido com um getPedido, o pedido chamava outro itemPedido
        que chamava outro getPedido e assim continuava sem parar.
     */
    @JsonIgnore
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
