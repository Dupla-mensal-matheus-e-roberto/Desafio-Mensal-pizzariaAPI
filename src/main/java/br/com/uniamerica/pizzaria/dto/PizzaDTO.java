package br.com.uniamerica.pizzaria.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PizzaDTO {
    private Long idPizza;
    private String sabores;
    private String tamanho;
    private String adicionais;
    private String removiveis;
}