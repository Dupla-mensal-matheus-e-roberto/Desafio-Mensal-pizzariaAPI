package br.com.uniamerica.Pizzaria.DTO;

import br.com.uniamerica.Pizzaria.Entity.Pizza;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDTO{
    private Long idProduto;
    private Pizza idPizza;
    private String acompanhamentos;

    public ProdutoDTO() {
    }

    public ProdutoDTO(Long idProduto, Pizza idPizza, String acompanhamentos) {
        this.idProduto = idProduto;
        this.idPizza = idPizza;
        this.acompanhamentos = acompanhamentos;
    }
}
