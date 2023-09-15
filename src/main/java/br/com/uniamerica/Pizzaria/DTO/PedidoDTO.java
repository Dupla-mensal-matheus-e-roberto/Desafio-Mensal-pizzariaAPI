package br.com.uniamerica.Pizzaria.DTO;

import br.com.uniamerica.Pizzaria.Entity.Cliente;
import br.com.uniamerica.Pizzaria.Entity.Produto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PedidoDTO{
    private Long idPedido;
    private LocalDateTime dataDoPedido;
    private String status;
    private Cliente idCliente;
    private Produto idProduto;

    public PedidoDTO() {
    }

    public PedidoDTO(Long idPedido, LocalDateTime dataDoPedido, String status, Cliente idCliente, Produto idProduto) {
        this.idPedido = idPedido;
        this.dataDoPedido = dataDoPedido;
        this.status = status;
        this.idCliente = idCliente;
        this.idProduto = idProduto;
    }
}
