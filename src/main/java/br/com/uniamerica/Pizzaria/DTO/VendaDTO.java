package br.com.uniamerica.Pizzaria.DTO;

import br.com.uniamerica.Pizzaria.Entity.Funcionario;
import br.com.uniamerica.Pizzaria.Entity.Pedido;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendaDTO{
    private Long idVenda;
    private String tipoPagamento;
    private Pedido idPedido;
    private String tipoEntrega;
    private Funcionario idFuncionario;

    public VendaDTO() {
    }

    public VendaDTO(Long idVenda, String tipoPagamento, Pedido idPedido, String tipoEntrega, Funcionario idFuncionario) {
        this.idVenda = idVenda;
        this.tipoPagamento = tipoPagamento;
        this.idPedido = idPedido;
        this.tipoEntrega = tipoEntrega;
        this.idFuncionario = idFuncionario;
    }
}
