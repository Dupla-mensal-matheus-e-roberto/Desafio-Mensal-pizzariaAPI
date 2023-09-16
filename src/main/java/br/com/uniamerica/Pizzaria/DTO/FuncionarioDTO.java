package br.com.uniamerica.Pizzaria.DTO;

import br.com.uniamerica.Pizzaria.Entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioDTO {
    private Long id_funcionario;
    private String nome;
    private Usuario id_usuario;

}
