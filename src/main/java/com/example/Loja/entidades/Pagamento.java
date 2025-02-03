package com.example.Loja.entidades;

import com.example.Loja.entidades.enums.StatusPedido;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
public class Pagamento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant momento;

    @JsonIgnore
    @OneToOne
    @MapsId
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "meio_pagamento_id")
    private MeioPagamento meioPagamento;

    public Pagamento() {}

    public Pagamento(Long id, Instant momento, Pedido pedido, MeioPagamento meioPagamento) {
        this.id = id;
        this.momento = momento;
        this.pedido = pedido;
        this.pedido.setStatus(StatusPedido.PAGO);
        this.meioPagamento = meioPagamento;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Instant getMomento() {
        return momento;
    }

    public void setMomento(Instant momento) {
        this.momento = momento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MeioPagamento getMeioPagamento() {
        return meioPagamento;
    }

    public void setMeioPagamento(MeioPagamento meioPagamento) {
        this.meioPagamento = meioPagamento;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(id, pagamento.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
