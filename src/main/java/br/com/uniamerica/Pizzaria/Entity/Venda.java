package br.com.uniamerica.Pizzaria.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "vendas", schema = "public")
@Getter
@Setter
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venda")
    private Long idVenda;
    @Column(name = "tipo_pagamento")
    private String tipoPagamento;
    @Column(name = "id_pedido")
    private Pedido idPedido;
    @Column(name = "tipo_entrega")
    private String tipoEntrega;
    @Column(name = "id_funcionario")
    private Funcionario idFuncionario;

    public Venda() {
    }

    public Venda(Long idVenda, String tipoPagamento, Pedido idPedido, String tipoEntrega, Funcionario idFuncionario) {
        this.idVenda = idVenda;
        this.tipoPagamento = tipoPagamento;
        this.idPedido = idPedido;
        this.tipoEntrega = tipoEntrega;
        this.idFuncionario = idFuncionario;
    }

}
