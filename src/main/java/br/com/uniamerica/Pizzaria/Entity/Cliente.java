package br.com.uniamerica.Pizzaria.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "clientes", schema = "public")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id_cliente;
    @Column(name = "nome")
    private String nome;
    @Column(name = "endereco")
    private String endereco;
    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario id_usuario;
    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;
}
