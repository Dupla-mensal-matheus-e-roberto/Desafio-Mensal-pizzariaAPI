package br.com.uniamerica.pizzaria.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vendas", schema = "public")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venda")
    private Long idVenda;
    @Column(name = "tipo_pagamento")
    private String tipoPagamento;
    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;
    @Column(name = "tipo_entrega")
    private String tipoEntrega;
    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;
    @Column(name = "valor_total")
    private Float valorTotal;
}
