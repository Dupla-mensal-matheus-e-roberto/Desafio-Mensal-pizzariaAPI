package br.com.uniamerica.Pizzaria.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PizzaDTO {
    private Long idPizza;
    private String sabores;
    private String tamanho;
    private String adicionais;
    private String removiveis;

    public PizzaDTO() {
    }

    public PizzaDTO(Long idPizza, String sabores, String tamanho, String adicionais, String removiveis) {
        this.idPizza = idPizza;
        this.sabores = sabores;
        this.tamanho = tamanho;
        this.adicionais = adicionais;
        this.removiveis = removiveis;
    }
}