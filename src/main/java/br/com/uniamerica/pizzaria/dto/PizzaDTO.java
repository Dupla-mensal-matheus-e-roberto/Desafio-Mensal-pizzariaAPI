package br.com.uniamerica.pizzaria.dto;

import br.com.uniamerica.pizzaria.entity.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PizzaDTO {
    @NotNull(message = "Indentificador inválido")
    private Long idPizza;
    @NotNull(message = "sabores inválido")
    @NotBlank(message = "Campo sabores não pode ser vazio")
    private String sabores;
    @NotNull(message = "tamanho inválido")
    @NotBlank(message = "Campo tamanho não pode ser vazio")
    private String tamanho;
    @NotNull(message = "adicionais inválidos")
    @NotBlank(message = "Campo adicionais não pode ser vazio")
    private String adicionais;
    @NotNull(message = "removiveis inválidos")
    @NotBlank(message = "Campo removiveis não pode ser vazio")
    private String removiveis;
    @NotNull(message = "produto inválido")
    private Produto produto;
}