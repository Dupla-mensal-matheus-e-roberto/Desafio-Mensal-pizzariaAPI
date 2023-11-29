package br.com.uniamerica.pizzaria.dto;

import br.com.uniamerica.pizzaria.entity.Usuario;
import br.com.uniamerica.pizzaria.entity.Venda;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "Indentificador inválido")
    private Long idFuncionario;
    @NotNull(message = "Nome inválido")
    @NotBlank(message = "campo nome não pode ser vazio")
    private String nome;
    @NotNull(message = "Lista inválida")
    @NotEmpty(message = "Vendas não pode ser vazia")
    private List<Venda> vendas;

}
