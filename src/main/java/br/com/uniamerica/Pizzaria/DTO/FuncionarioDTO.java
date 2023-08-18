package br.com.uniamerica.Pizzaria.DTO;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

public class FuncionarioDTO {

    private Long id_funcionario;

    @Getter @Setter
    private String nome;

    private Long id_usuario;

    public FuncionarioDTO(){}

    public FuncionarioDTO(Long id_funcionario, String nome, Long id_usuario) {
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
