package com.example.Loja.entidades;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant momento;
    private String status;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;


    @OneToMany(mappedBy = "id.pedido")
    private Set<ItemPedido> itens = new HashSet<>();

    public Pedido() {}

    public Pedido(Long id, Instant momento, String status, Usuario usuario) {
        this.id = id;
        this.momento = momento;
        this.status = status;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMomento() {
        return momento;
    }

    public void setMomento(Instant momento) {
        this.momento = momento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Set<ItemPedido> getItens() {
        return itens;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
