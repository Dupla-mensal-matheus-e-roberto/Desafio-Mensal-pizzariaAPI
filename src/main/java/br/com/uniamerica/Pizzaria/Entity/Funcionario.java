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
    private Long id_funcionario;

    @Getter @Setter
    @Column(name = "nome")
    private String nome;

    @Column(name = "id_usuario")
    private Long id_usuario;

    public Funcionario(){}

    public Funcionario(Long id_funcionario, String nome, Long id_usuario) {
        this.id_funcionario = id_funcionario;
        this.nome = nome;
        this.id_usuario = id_usuario;
    }

    public Long getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(Long id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }
}
