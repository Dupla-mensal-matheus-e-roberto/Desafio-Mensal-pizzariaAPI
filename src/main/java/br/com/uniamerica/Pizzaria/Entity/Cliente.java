package br.com.uniamerica.Pizzaria.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clientes", schema = "public")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cliente")
    private Long id_cliente;

    @Getter @Setter
    @Column(name = "nome")
    private String nome;

    @Getter @Setter
    @Column(name = "endereco")
    private String endereco;

    @Column(name = "id_usuario")
    private Long id_usuario;

    public Cliente(){}

    public Cliente(Long id_cliente, String nome, String endereco, Long id_usuario) {
        this.id_cliente = id_cliente;
        this.nome = nome;
        this.endereco = endereco;
        this.id_usuario = id_usuario;
    }
}
