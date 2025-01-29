package com.example.Loja.entidades;

import jakarta.persistence.*;

import java.time.Instant;
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
}
