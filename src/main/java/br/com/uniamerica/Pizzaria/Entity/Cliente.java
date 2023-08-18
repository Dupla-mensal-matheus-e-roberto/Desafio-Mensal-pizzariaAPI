package br.com.uniamerica.Pizzaria.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clientes", schema = "public")
public class Cliente {
    @Id
    @Getter
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

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Cliente(Long id_cliente, String nome, String endereco, Long id_usuario) {
        this.id_cliente = id_cliente;
        this.nome = nome;
        this.endereco = endereco;
        this.id_usuario = id_usuario;
    }
}
