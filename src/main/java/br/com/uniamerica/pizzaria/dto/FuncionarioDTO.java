package br.com.uniamerica.pizzaria.dto;

import br.com.uniamerica.pizzaria.entity.Venda;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioDTO {
    private Long idFuncionario;
    private String nome;
    private String login;
    private String senha;
    private List<Venda> vendas;

}
