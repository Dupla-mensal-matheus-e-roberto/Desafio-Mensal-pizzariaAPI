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
    private int id_cliente;

    @Getter @Setter
    @Column(name = "nome")
    private String nome;

    @Getter @Setter
    @Column(name = "endereco")
    private String endereco;

    @Column(name = "id_usuario")
    private int id_usuario;

    public Cliente(){}

    public Cliente(int id_cliente, String nome, String endereco, int id_usuario) {
        this.id_cliente = id_cliente;
        this.nome = nome;
        this.endereco = endereco;
        this.id_usuario = id_usuario;
    }
}
