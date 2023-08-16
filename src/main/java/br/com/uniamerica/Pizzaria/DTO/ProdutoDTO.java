package br.com.uniamerica.Pizzaria.DTO;


public class ProdutoDTO{
    private Long idProduto;
    private Long idPizza;
    private String acompanhamentos;

    public ProdutoDTO() {
    }

    public ProdutoDTO(Long idProduto, Long idPizza, String acompanhamentos) {
        this.idProduto = idProduto;
        this.idPizza = idPizza;
        this.acompanhamentos = acompanhamentos;
    }
}
