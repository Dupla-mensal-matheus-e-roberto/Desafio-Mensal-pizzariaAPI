package br.com.uniamerica.Pizzaria.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_funcionario")
    private Long id_funcionario;

    @Getter @Setter
    @Column(name="nome")
    private String nome;

    @Column(name="id_usuario")
    private Long id_usuario;

    public Usuario(){}

    public Usuario(Long id_funcionario, String nome, Long id_usuario) {
        this.id_funcionario = id_funcionario;
        this.nome = nome;
        this.id_usuario = id_usuario;
    }
}
