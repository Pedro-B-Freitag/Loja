package com.example.Loja.entidades.DTOs;

public class PagamentoDTO {
    private Long idPedido;
    private Long idMeioPagamento;

    public PagamentoDTO() {}

    public PagamentoDTO(Long idMeioPagamento, Long idPedido) {
        this.idMeioPagamento = idMeioPagamento;
        this.idPedido = idPedido;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdMeioPagamento() {
        return idMeioPagamento;
    }

    public void setIdMeioPagamento(Long idMeioPagamento) {
        this.idMeioPagamento = idMeioPagamento;
    }
}
