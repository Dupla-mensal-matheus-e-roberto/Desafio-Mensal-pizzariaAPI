package br.com.uniamerica.pizzaria.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "produtos", schema = "public")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Long idProduto;
    @OneToOne(mappedBy = "produto")
    private Pizza idPizza;
    @Column(name = "acompanhamentos")
    private String acompanhamentos;
    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;
}
