package br.com.uniamerica.Pizzaria.DTO;

import br.com.uniamerica.Pizzaria.Entity.Pizza;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO{
    private Long idProduto;
    private Pizza idPizza;
    private String acompanhamentos;
}
