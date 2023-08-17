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
    private int id_funcionario;

    @Getter @Setter
    @Column(name="nome")
    private String nome;

    @Column(name="id_usuario")
    private int id_usuario;
}
