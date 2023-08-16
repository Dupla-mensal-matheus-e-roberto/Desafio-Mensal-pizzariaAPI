package br.com.uniamerica.Pizzaria.DTO;


public class VendaDTO{
    private Long idVenda;
    private String tipoPagamento;
    private Long idPedido;
    private String tipoEntrega;
    private Long idFuncionario;

    public VendaDTO() {
    }

    public VendaDTO(Long idVenda, String tipoPagamento, Long idPedido, String tipoEntrega, Long idFuncionario) {
        this.idVenda = idVenda;
        this.tipoPagamento = tipoPagamento;
        this.idPedido = idPedido;
        this.tipoEntrega = tipoEntrega;
        this.idFuncionario = idFuncionario;
    }
}
