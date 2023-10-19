package br.com.uniamerica.pizzaria.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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
    private Pizza pizza;
    @Column(name = "acompanhamentos")
    private String acompanhamentos;
    @ManyToMany(mappedBy = "produtos")
    private List<Pedido> pedido;
}
