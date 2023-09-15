package br.com.uniamerica.Pizzaria.DTO;

import br.com.uniamerica.Pizzaria.Entity.Usuario;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuncionarioDTO {
    private Long id_funcionario;
    private String nome;
    private Usuario id_usuario;
    public FuncionarioDTO(){}

    public FuncionarioDTO(Long id_funcionario, String nome, Usuario id_usuario) {
        this.id_funcionario = id_funcionario;
        this.nome = nome;
        this.id_usuario = id_usuario;
    }
}
