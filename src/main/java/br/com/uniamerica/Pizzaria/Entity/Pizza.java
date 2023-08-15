package br.com.uniamerica.Pizzaria.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pizzas", schema = "public")
@Getter
@Setter
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pizza")
    private Long idPizza;
    @Column(name = "sabores")
    private String sabores;
    @Column(name = "tamanho")
    private String tamanho;
    @Column(name = "adicionais")
    private String adicionais;
    @Column(name = "removiveis")
    private String removiveis;

    public Pizza() {
    }

    public Pizza(Long idPizza, String sabores, String tamanho, String adicionais, String removiveis) {
        this.idPizza = idPizza;
        this.sabores = sabores;
        this.tamanho = tamanho;
        this.adicionais = adicionais;
        this.removiveis = removiveis;
    }
}
