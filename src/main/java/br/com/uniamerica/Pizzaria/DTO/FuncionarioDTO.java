package br.com.uniamerica.Pizzaria.DTO;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

public class FuncionarioDTO {

    private int id_funcionario;

    @Getter @Setter
    private String nome;

    private int id_usuario;

    public FuncionarioDTO(){}

    public FuncionarioDTO(int id_funcionario, String nome, int id_usuario) {
        this.id_funcionario = id_funcionario;
        this.nome = nome;
        this.id_usuario = id_usuario;
    }

}
