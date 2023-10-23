package br.com.uniamerica.pizzaria.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @ManyToMany
    @JoinTable(name = "produto_pizza",
            joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "pizza_id"))
    private List<Pizza> pizzas;
    @Column(name = "acompanhamentos")
    private String acompanhamentos;
    @Column(name = "preco")
    private Float preco;
    @ManyToMany(mappedBy = "produtos")
    @JsonIgnore
    private List<Pedido> pedido;
}
