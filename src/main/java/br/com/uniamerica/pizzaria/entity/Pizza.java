package br.com.uniamerica.pizzaria.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pizzas", schema = "public")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    @OneToOne
    @JoinColumn(name = "id_pizza")
    private Produto produto;
}
