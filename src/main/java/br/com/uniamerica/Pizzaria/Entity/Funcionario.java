package br.com.uniamerica.Pizzaria.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "funcionarios")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_funcionario")
    private int id_funcionario;

    @Getter @Setter
    @Column(name = "nome")
    private String nome;

    @Column(name = "id_usuario")
    private int id_usuario;

    public Funcionario(){}

    public Funcionario(int id_funcionario, String nome, int id_usuario) {
        this.id_funcionario = id_funcionario;
        this.nome = nome;
        this.id_usuario = id_usuario;
    }
}
