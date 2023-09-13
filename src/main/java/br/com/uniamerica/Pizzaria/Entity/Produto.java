package br.com.uniamerica.Pizzaria.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "produtos", schema = "public")
@Getter
@Setter
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Long idProduto;
    @Column(name = "id_pizza")
    private Pizza idPizza;
    @Column(name = "acompanhamentos")
    private String acompanhamentos;

    public Produto() {
    }

    public Produto(Long idProduto, Pizza idPizza, String acompanhamentos) {
        this.idProduto = idProduto;
        this.idPizza = idPizza;
        this.acompanhamentos = acompanhamentos;
    }
}
